package com.hitesh.springweb.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitesh.springweb.dto.RegisterDto;
import com.hitesh.springweb.entity.Register;
import com.hitesh.springweb.repository.RegisterRepo;

//@Component
@Service
public class RegisterService {
	
	@Autowired
	private ModelMapper  modelMapper;
	@Autowired
	private RegisterRepo registerRepo;
	
	public void processRegisterDetails(RegisterDto dto) {
		
		Register register = modelMapper.map(dto, Register.class);
		registerRepo.saveRegister(register);
	}
	
	public List<Register> findAll(){
		
		return registerRepo.getAll();
	}
	
	public Register findByName (String name) {
		
		return registerRepo.findByName(name);
	}
}
