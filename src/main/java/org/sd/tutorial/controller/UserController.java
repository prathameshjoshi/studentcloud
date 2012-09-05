package org.krams.tutorial.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.krams.tutorial.form.User;
import org.krams.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class UserController {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String listUsers(Map<String, Object> map) {

		logger.debug(" ** listUsers method of UserController Invoked ** ");
		map.put("user", new User());
		map.put("userList", userService.listUser());

		logger.debug(" ** listUsers method of UserController Invoked ** ");

		return "user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			BindingResult result) {

		logger.debug(" ** addUser method of UserController Invoked ** ");
		userService.addUser(user);

		logger.debug(" ** addUser method of UserController Invoked ** ");
		return "user";
	}

	@RequestMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {

		logger.debug(" ** deleteUser method of UserController Invoked ** ");
		userService.removeUser(userId);
		logger.debug(" ** deleteUser method of UserController Invoked ** ");

		return "redirect:/main/index";
	}
}
