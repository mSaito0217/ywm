package com.yamamotokogyo.ywm.controller.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.yamamotokogyo.ywm.config.CommonVariable;
import com.yamamotokogyo.ywm.controller.service.role.RoleService;
import com.yamamotokogyo.ywm.controller.service.users.UserPrincipal;
import com.yamamotokogyo.ywm.model.role.Role;
import com.yamamotokogyo.ywm.model.role.RoleSearchDto;
import com.yamamotokogyo.ywm.model.users.UserSearchDto;

/**
 * ロール管理に関する処理を行うコントローラのController
 */
@Controller // このクラスがWebコントローラーであることを示します
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * ロール検索画面の処理（GET）
	 * @return
	 */
	@GetMapping("/roleSearch")
	public ModelAndView roleSearchForm(@ModelAttribute RoleSearchDto roleSearchDto) {
		// 画面に返却するオブジェクトを生成
		ModelAndView mav = new ModelAndView();
		// ログイン情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();

		if (userInfo != null) {
			// ユーザ情報が取得できた場合は名前をセット
			mav.addObject("name", userInfo.getUser().getLastName() + " " + userInfo.getUser().getFirstName());
		}

		if (roleSearchDto.getViewType() == null) {
			// 初期表示処理
			mav.addObject("roleSearchDto", new RoleSearchDto());
			mav.setViewName("roleSearch");
			return mav;
		}

		// 検索実行時処理
		List<Role> role = null;

		if (roleSearchDto.getRoleId().isBlank() &&
				roleSearchDto.getRoleCode().isBlank() &&
				roleSearchDto.getRoleName().isBlank() &&
				roleSearchDto.getMpCreate() == null &&
				roleSearchDto.getMpRead() == null &&
				roleSearchDto.getMpUpdate() == null &&
				roleSearchDto.getMpDelete() == null &&
				roleSearchDto.getValid() == 0) {
			// 全件検索
			role = roleService.findAll();
		} else {
			// 部分検索
			//users = userDaoImpl.search(userSearchDto);
		}

		mav.addObject("roleSearchDto", new UserSearchDto()); // 次の検索実行用の入れ物

		if (role.isEmpty()) {
			// ユーザ情報が1件も取得できなかった場合
			mav.addObject("msg", CommonVariable.MSG_02);
		} else {
			mav.addObject("roles", role);
		}

		mav.setViewName("roleSearch");
		return mav;
	}

}
