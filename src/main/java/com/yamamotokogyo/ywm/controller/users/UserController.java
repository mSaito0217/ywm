package com.yamamotokogyo.ywm.controller.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yamamotokogyo.ywm.config.CommonVariable;
import com.yamamotokogyo.ywm.controller.repository.users.UserDaoImpl;
import com.yamamotokogyo.ywm.controller.service.role.RoleService;
import com.yamamotokogyo.ywm.controller.service.users.UserPrincipal;
import com.yamamotokogyo.ywm.controller.service.users.UserService;
import com.yamamotokogyo.ywm.model.role.Role;
import com.yamamotokogyo.ywm.model.users.User;
import com.yamamotokogyo.ywm.model.users.UserDto;
import com.yamamotokogyo.ywm.model.users.UserSearchDto;

/**
 * ユーザ管理に関する処理を行うコントローラのController
 */
@Controller // このクラスがWebコントローラーであることを示します
public class UserController {

	// Spring が自動的に UserService の実装を注入します
	@Autowired
	private UserService userService;

	@Autowired
	private UserDaoImpl userDaoImpl;

	@Autowired
	private RoleService roleService;
	
	/**
	 * ユーザ登録画面の処理(GET)
	 * @return
	 */
	@GetMapping("/userRegister")
	public ModelAndView registerForm() {
		ModelAndView mav = new ModelAndView();

		// ログイン情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();

		if (userInfo != null) {
			// ユーザ情報が取得できた場合は名前をセット
			mav.addObject("name", userInfo.getUser().getLastName() + " " + userInfo.getUser().getFirstName());
		}

		// ユーザ登録画面に遷移
		mav.addObject("user", new UserDto());
		mav.setViewName("userRegister");
		return mav;
	}

	/**
	 * ユーザ登録画面の処理(POST)
	 * @return
	 */
	@PostMapping("/userRegister")
	public ModelAndView register(@ModelAttribute UserDto userDto) {
		// 画面返却用のオブジェクト生成
		ModelAndView mav = new ModelAndView();

		// ユーザIDで既存のユーザーの存在チェック
		User existing = userService.findByUserId(userDto.getUserId());
		if (existing != null) {
			// ユーザーが既に存在する場合 再度登録画面を表示
			mav.setViewName("userRegister");
			// ユーザ登録エラーのメッセージを返却
			mav.addObject("msg", CommonVariable.MSG_01);
			return mav;
		}
		// ユーザーが存在しない場合、新しいユーザーを保存
		// 現在ログイン中のユーザ情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();

		if (userInfo != null) {
			// ユーザ情報が取得できた場合は名前をセット
			mav.addObject("name", userInfo.getUser().getLastName() + " " + userInfo.getUser().getFirstName());
		}

		// ユーザ登録処理
		String error = userService.save(userDto, authentication);

		if (error != CommonVariable.MSG_00) {
			//エラーメッセージがあった場合は登録エラーとして再度登録画面を表示
			mav.setViewName("userRegister");
			// ユーザ登録エラーのメッセージを返却
			mav.addObject("errorMsg", error);
			return mav;
		}

		// 登録情報を表示するユーザ参照画面に遷移
		mav.addObject("user", userDto);
		mav.addObject("msg", CommonVariable.MSG_00);
		mav.setViewName("userRef");
		return mav;
	}

	/**
	 * ユーザ検索画面の処理（GET）
	 * @return
	 */
	@GetMapping("/userSearch")
	public ModelAndView userSearchForm(@ModelAttribute UserSearchDto userSearchDto) {
		// 画面に返却するオブジェクトを生成
		ModelAndView mav = new ModelAndView();
		// ログイン情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();

		if (userInfo != null) {
			// ユーザ情報が取得できた場合は名前をセット
			mav.addObject("name", userInfo.getUser().getLastName() + " " + userInfo.getUser().getFirstName());
		}

		if (userSearchDto.getViewType() == null) {
			// 初期表示処理
			// 表示する権限を取得
			List<Role> role =  roleService.findAll();
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = null;
	        try {
	            jsonStr = mapper.writeValueAsString(role);
	        } catch (JsonProcessingException e) {
	            throw new RuntimeException(e);
	        }

			// 検索実行用の箱を渡す
			mav.addObject("role", jsonStr);
			mav.addObject("userSearchDto", new UserSearchDto());
			mav.setViewName("userSearch");
			return mav;
		}

		// 検索実行時処理
		List<User> users = null;

		if (userSearchDto.getUserId().isBlank() &&
				userSearchDto.getFirstName().isBlank() &&
				userSearchDto.getFirstNameKana().isBlank() &&
				userSearchDto.getLastName().isBlank() &&
				userSearchDto.getLastNameKana().isBlank() &&
				userSearchDto.getRoleAdmin() == 0 &&
				userSearchDto.getRoleEmployee() == 0 &&
				userSearchDto.getRoleContract() == 0 &&
				userSearchDto.getValid() == 0) {
			// 全件検索
			users = userService.findAll();
		} else {
			// 部分検索
			users = userDaoImpl.search(userSearchDto);
		}

		mav.addObject("userSearchDto", new UserSearchDto()); // 次の検索実行用の入れ物

		if (users.isEmpty()) {
			// ユーザ情報が1件も取得できなかった場合
			mav.addObject("msg", CommonVariable.MSG_02);
		} else {
			mav.addObject("users", users);
		}

		mav.setViewName("userSearch");
		return mav;
	}

	/**
	 * ユーザ参照画面の処理(GET)
	 * @return
	 */
	@GetMapping("/userRef")
	public ModelAndView userRefForm(@RequestParam(required = false) String userId) {
		// 画面に返却するオブジェクトを生成
		ModelAndView mav = new ModelAndView();
		// ログイン情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();

		if (userInfo != null) {
			// ユーザ情報が取得できた場合は名前をセット
			mav.addObject("name", userInfo.getUser().getLastName() + " " + userInfo.getUser().getFirstName());
		}

		// ユーザIDで既存のユーザーの存在チェック
		User existing = userService.findByUserId(userId);
		// ユーザ参照画面に遷移
		mav.addObject("user", existing);
		mav.setViewName("userRef");
		return mav;
	}

	/**
	 * ユーザ編集画面の処理(GET)
	 * @return
	 */
	@GetMapping("/userEdit")
	public ModelAndView userEditForm(@RequestParam(required = false) String userId) {
		// 画面に返却するオブジェクトを生成
		ModelAndView mav = new ModelAndView();
		// ログイン情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();

		if (userInfo != null) {
			// ユーザ情報が取得できた場合は名前をセット
			mav.addObject("name", userInfo.getUser().getLastName() + " " + userInfo.getUser().getFirstName());
		} else {
			// ユーザIDが空の場合は検索画面に遷移
			mav.setViewName("userSearch");
			return mav;
		}

		// ユーザ情報を取得
		User user = userService.findByUserId(userId);
		mav.addObject("user", user);
		// ユーザ編集画面に遷移
		mav.setViewName("userEdit");
		return mav;
	}

	/**
	 * ユーザ編集画面の処理(POST)
	 * @return
	 */
	@PostMapping("/userEdit")
	public ModelAndView edit(@ModelAttribute UserDto userDto) {
		// 画面返却用のオブジェクト生成
		ModelAndView mav = new ModelAndView();

		// ユーザIDで既存のユーザーの存在チェック
		// TODO ユーザIDを画面から加工されても大丈夫なようにする必要がある
		User oldUser = userService.findByUserId(userDto.getUserId());
		
		if (oldUser == null) {
			// IDが変更されてデータ取得できなかった場合 登録エラーとして再度更新画面を表示
			mav.setViewName("userEdit");
			mav.addObject("user", userDto);
			// ユーザ登録エラーのメッセージを返却
			mav.addObject("errorMsg", CommonVariable.ERROR_MSG_02);
			return mav;
		}
		
		// 現在ログイン中のユーザ情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();
		if (userInfo != null) {
			// ユーザ情報が取得できた場合は名前をセット
			mav.addObject("name", userInfo.getUser().getLastName() + " " + userInfo.getUser().getFirstName());
		}

		// ユーザ更新処理
		Map<String, User> updateResult = userService.update(oldUser,userDto, authentication);
		String msg = updateResult.keySet().stream().collect(Collectors.toCollection(ArrayList::new)).get(0);
		
		if (msg != CommonVariable.MSG_00) {
		//エラーメッセージがあった場合は登録エラーとして再度更新画面を表示
		mav.setViewName("userEdit");
		mav.addObject("user", userDto);
		// ユーザ登録エラーのメッセージを返却
		mav.addObject("errorMsg", msg);
		return mav;
		}

		// 登録情報を表示するユーザ参照画面に遷移
		mav.addObject("user", updateResult.get(msg));
		mav.addObject("msg", CommonVariable.MSG_03);
		mav.setViewName("userRef");
		return mav;
	}
	

}