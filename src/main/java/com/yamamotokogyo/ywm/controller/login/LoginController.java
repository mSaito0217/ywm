package com.yamamotokogyo.ywm.controller.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yamamotokogyo.ywm.controller.service.users.UserPrincipal;

/**
 * ログインに関する処理を行うコントローラ
 */
@Controller
public class LoginController {

 @GetMapping("/login")
 public String login() {
	 System.out.println("ログイン画面を表示します。");
     return "login"; 
 }
 
 @GetMapping("/")
 public String redirectToIndex() {
     Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 現在のユーザーの認証情報を取得します
     if (authentication != null && authentication.isAuthenticated()) { 
    	 // ユーザーがログインしている場合
    	 System.out.println("ログイン済みにつき、トップ画面に遷移します。");
    	 return "redirect:/top"; 
     }
     return "redirect:/login"; 
 }
 
 @GetMapping("/top")
 public ModelAndView top() {
	 // 画面に渡す値を設定
	 ModelAndView mav = new ModelAndView(); 
	 
	 // ログイン情報を取得
	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	 UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();	 
	 
	 if (userInfo != null ) {
		 // ユーザ情報が取得できた場合はトップ画面に遷移
		 mav.addObject("name", userInfo.getUser().getLastName() +" "+ userInfo.getUser().getFirstName());
		 mav.setViewName("top");
		 return mav; 
	 }
	 // ユーザ情報が取得できなかった場合はログイン画面に遷移
	 mav.setViewName("error");
	 System.err.println("ユーザ情報の取得に失敗しました。");
     return mav; 
 }
}
