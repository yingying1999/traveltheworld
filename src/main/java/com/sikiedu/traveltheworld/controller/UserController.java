package com.sikiedu.traveltheworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sikiedu.traveltheworld.domain.User;
import com.sikiedu.traveltheworld.repository.UserRepository;
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/index.action")
	public ModelAndView index()
	{
		return new ModelAndView("/index.html");
	}
	@RequestMapping("/user/register.action")
	public ModelAndView register(User user)
	{
		userRepository.save(user);
		return new ModelAndView("redirect:/index.action");
	}
	@RequestMapping("/user/login.action")
	public ModelAndView login(User user)
	{
		User loginUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(loginUser == null)
		{
			return new ModelAndView("redirect:/index.action");
		}
		else
		{
			return new ModelAndView("/search.html");
		}
	}
}