package com.hitesh.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.springweb.constants.AppConstants;
import com.hitesh.springweb.dto.RegisterDto;
import com.hitesh.springweb.entity.Register;
import com.hitesh.springweb.service.RegisterService;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = AppConstants.FORWARD_SLASH)
public class RegisterRestController {

	@Autowired
	private RegisterService registerService;

	@GetMapping(value = AppConstants.GET_REGISTERED_DETAILS)
	@ResponseBody
	public List<Register> getRegisteredDetails() {
		return registerService.findAll();
	}

	@PostMapping(value = AppConstants.SEND_DTO)
	
	public void sendRegisterDto(@RequestBody RegisterDto registerDto) {
		registerService.processRegisterDetails(registerDto);

	}
	
	@GetMapping(value = AppConstants.FIND_BY_NAME)
	public @ResponseBody Register findByName(@RequestHeader ("name") String name) {
		//@RequestHeader or @PathVariable can be used to receive data from URL
		
		System.out.println(name);
		
		return registerService.findByName(name);
		
	}
}
