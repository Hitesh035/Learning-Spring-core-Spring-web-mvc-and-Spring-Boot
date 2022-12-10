package com.hitesh.springfirst.controller;
import org.springframework.stereotype.*;

@Component
public class RegisterController {
	
	public RegisterController() {
		
		System.out.println(this.getClass().getSimpleName()+ " object created");
	}
}
