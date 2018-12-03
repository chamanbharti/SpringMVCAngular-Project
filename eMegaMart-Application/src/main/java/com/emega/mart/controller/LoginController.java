package com.emega.mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emega.mart.model.Category;
import com.emega.mart.model.UserLogin;
import com.emega.mart.repository.LoginRepository;

@RestController
public class LoginController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Category login(@RequestBody UserLogin userLogin){
		System.out.println("UserLogin>>"+userLogin);
		UserLogin uLogin=loginRepository.doLogin(userLogin.getUserId(), userLogin.getPassword());
		if(uLogin !=null){
			System.out.println("UserLogin>>>>>>>"+uLogin);
			System.out.println("UserLogin>>>>>"+userLogin);
		}
		return null;
	}
}
