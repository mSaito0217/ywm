package com.yamamotokogyo.ywm.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yamamotokogyo.ywm.controller.config.CommonVariable;
import com.yamamotokogyo.ywm.controller.service.users.UserService;
import com.yamamotokogyo.ywm.model.users.User;
import com.yamamotokogyo.ywm.model.users.UserDto;

/**
 * ユーザ管理に関する処理を行うコントローラのController
 */
@Controller // このクラスがWebコントローラーであることを示します
public class userController {

    // Spring が自動的に UserService の実装を注入します
    @Autowired
    private UserService userService;

    
    /**
     * ユーザ登録画面の処理(GET)
     * @return
     */
    @GetMapping("/userRegister")
    public ModelAndView registerForm() {
        ModelAndView mav = new ModelAndView(); 
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
        User existing = userService.findByUserId(userDto.getUserId()); // ユーザIDで既存のユーザーを検索します
        ModelAndView mav = new ModelAndView(); 
        if(existing != null){
            // ユーザーが既に存在する場合の処理
        	mav.setViewName("userRegister");
        	mav.addObject("msg", CommonVariable.MSG_01);
            return mav; // ユーザーが存在するため、再度登録画面を表示します
        }
        userService.save(userDto); // ユーザーが存在しない場合、新しいユーザーを保存します
        mav.addObject("user", userDto);
        mav.addObject("msg", CommonVariable.MSG_00);
        mav.setViewName("userRef"); 
        System.out.println("ユーザ参照画面を表示します。"); 
        
        return mav ;
    }
    
    
    /**
     * ユーザ検索画面の処理（GET）
     * @return
     */
    @GetMapping("/userSearch") 
    public ModelAndView registerSearchForm(String hoge) {
    	ModelAndView mav = new ModelAndView(); 
    	if (hoge == null) {
    		mav.addObject("text", "初期表示"); 
    	} else {
    		mav.addObject("text", "一旦全件検索"); 	
    	}
        mav.setViewName("userSearch"); 
        return mav; 
    }
    
}