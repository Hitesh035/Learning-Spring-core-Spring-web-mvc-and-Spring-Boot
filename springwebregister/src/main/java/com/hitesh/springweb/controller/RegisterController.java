package com.hitesh.springweb.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hitesh.springweb.constants.AppConstants;
import com.hitesh.springweb.dto.RegisterDto;
import com.hitesh.springweb.service.RegisterService;

//@Component
@ResponseBody
@Controller
@RequestMapping(value = AppConstants.FORWARD_SLASH)
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	public RegisterController() {
		
		System.out.println(this.getClass().getSimpleName()+ " object created");
	}
	
	@RequestMapping(value = AppConstants.SAVE_REGISTER_DETAILS)
	@ResponseBody
	public ModelAndView saveRegisterDetails(RegisterDto registerDto) {
		
		
		System.out.println(registerDto);
		registerService.processRegisterDetails(registerDto);
		
		
		return new ModelAndView("index.jsp");
	}
}
