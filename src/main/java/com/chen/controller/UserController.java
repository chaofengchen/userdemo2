package com.chen.controller;

import com.chen.pojo.User;
import com.chen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/user/getUserById")
	@ResponseBody
	public User getUserById(@RequestParam Long id){
		System.out.println("hello user");
		User u = userRepository.findOne(id);
		System.out.println(userRepository);
		System.out.println(u);
		return u;
	}
	
	@RequestMapping(value="/user/findUserByName")
	@ResponseBody
	public User findUserByName(@RequestParam String name){
		System.out.println("hello user");
		User u = userRepository.findUserByName(name);
		System.out.println(u);
		return u;
	}

	@RequestMapping(value="/user/add", method = RequestMethod.POST)
	@ResponseBody
	public void addUser(@RequestBody User user){
		System.out.println(user);
		userRepository.save(user);
		System.out.println("success");
//		return user;
	}
}
