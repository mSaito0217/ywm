package com.yamamotokogyo.ywm.controller.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yamamotokogyo.ywm.controller.config.CommonVariable;
import com.yamamotokogyo.ywm.controller.repository.users.UserDaoImpl;
import com.yamamotokogyo.ywm.controller.service.users.UserService;
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
    
    /**
     * ユーザ登録画面の処理(GET)
     * @return
     */
    @GetMapping("/userRegister")
    public ModelAndView registerForm() {
        ModelAndView mav = new ModelAndView();
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
        if(existing != null){
            // ユーザーが既に存在する場合 再度登録画面を表示
        	mav.setViewName("userRegister");
        	// ユーザ登録エラーのメッセージを返却
        	mav.addObject("msg", CommonVariable.MSG_01);
            return mav; 
        }
        // ユーザーが存在しない場合、新しいユーザーを保存
        // 現在ログイン中のユーザ情報を取得
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // ユーザ登録処理
        String error = userService.save(userDto, authentication);
        
        if(error != CommonVariable.MSG_00) {
        	//エラーメッセージがあった場合は登録エラーとして再度登録画面を表示
        	mav.setViewName("userRegister");
        	// ユーザ登録エラーのメッセージを返却
        	mav.addObject("errorMsg",error);
        	return mav; 
        }
        
        // 登録情報を表示するユーザ参照画面に遷移
        mav.addObject("user", userDto);
        mav.addObject("msg", CommonVariable.MSG_00);
        mav.setViewName("userRef"); 
        return mav ;
    }
    
    
    /**
     * ユーザ検索画面の処理（GET）
     * @return
     */
    @GetMapping("/userSearch") 
    public ModelAndView registerSearchForm(@ModelAttribute UserSearchDto userSearchDto) {
    	// 画面に返却するオブジェクトを生成
    	ModelAndView mav = new ModelAndView();
    	
    	if (userSearchDto.getViewType() == null) {
    		// 初期表示処理
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
    	mav.addObject("users", users);
    	mav.setViewName("userSearch"); 
        return mav; 
    }
    
}