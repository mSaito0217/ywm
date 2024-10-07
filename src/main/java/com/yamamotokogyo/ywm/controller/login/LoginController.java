package com.yamamotokogyo.ywm.controller.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
 public String top() {
	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	 System.out.println("トップ画面を表示します。");
     return "top"; 
 }
}
