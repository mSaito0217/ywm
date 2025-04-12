package com.yamamotokogyo.ywm.controller.orders;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yamamotokogyo.ywm.controller.service.users.UserPrincipal;
import com.yamamotokogyo.ywm.model.orders.OrderDto;

/**
 * 注文に関する処理を行うコントローラのController
 */
@Controller
public class OrderController {

	/**
	 * 注文登録画面の処理（GET）
	 * @return
	 */
	@GetMapping("/ordersRegister")
	public ModelAndView registerForm() {
		// 画面に返却するオブジェクトを生成
		ModelAndView mav = new ModelAndView();
		mav.addObject("order", new OrderDto()); // 登録実行用の入れ物
		// ログイン情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userInfo = (UserPrincipal) authentication.getPrincipal();

		if (userInfo != null) {
			// ユーザ情報が取得できた場合は名前をセット
			mav.addObject("name", userInfo.getUser().getLastName() + " " + userInfo.getUser().getFirstName());
		}

		mav.setViewName("ordersRegister");
		return mav;
	}
}
