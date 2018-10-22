package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.Login;
import com.dto.User;
import com.dto.UserRole;
import com.exception.DatabaseException;
import com.service.LoginService;
import com.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginRegisterController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/userLogin.do", method=RequestMethod.POST)
	public String login(@ModelAttribute @Validated(Login.LoginValidation.class) Login login
			, BindingResult bindingResult, RedirectAttributes ra) {
		login.setRole(UserRole.USER);
		login = loginService.getLogin(login);
		if (bindingResult.hasErrors() || login == null) {
			ra.addFlashAttribute("invalid", "Invalid email or password.");
			return "redirect:login";
		}
		return "redirect:test";
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String register(@ModelAttribute @Validated(Login.RegisterValidation.class) Login login
			, BindingResult bindingResult, RedirectAttributes ra) throws DatabaseException {
		if (bindingResult.hasErrors()) {
			ra.addFlashAttribute("invalid", "Invalid email or password.");
			return "redirect:register";
		}
		login = loginService.addLogin(login);
		User user = new User();
		userService.addUser(user);
		return "redirect:test";
	}
	
}
