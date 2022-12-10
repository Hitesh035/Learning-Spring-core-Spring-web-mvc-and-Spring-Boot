package com.hitesh.springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.springweb.constants.AppConstants;
import com.hitesh.springweb.service.RegisterService;

@RestController
@RequestMapping(value =  AppConstants.FORWARD_SLASH)
public class AuthenticationController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value = AppConstants.LOGIN)
	public void logIn() {
		
	}
}
