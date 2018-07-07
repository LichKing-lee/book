package com.yong.book.login;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginUserController {
	@RequestMapping("/")
	public String login(@AuthenticationPrincipal LoginUserDetails loginUserDetails, Model model) {
		model.addAttribute("userId", loginUserDetails.getUsername());
		return "index";
	}
}
