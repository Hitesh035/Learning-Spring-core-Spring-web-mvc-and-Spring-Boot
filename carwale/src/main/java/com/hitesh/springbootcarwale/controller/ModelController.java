package com.hitesh.springbootcarwale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.springbootcarwale.appconstants.AppConstants;
import com.hitesh.springbootcarwale.entity.Model;
import com.hitesh.springbootcarwale.service.CarService;

//@RestController
//@RequestMapping(value = AppConstants.CONTROLLER_URL)
public class ModelController {

	@Autowired
	private CarService carService;
	
	@PostMapping(value =  AppConstants.SAVE_ALL_MODEL_DETAILS)
	public void saveAllModels(@RequestBody List<Model> list) {
		
		carService.saveAllModels(list); 
	}
	
	@PostMapping(value =  AppConstants.SAVE_MODEL_DETAILS)
	public void saveModel(@RequestBody Model model) {
		
		carService.saveModel(model);
	}
	
	@GetMapping(value = AppConstants.GET_ALL_MODEL_DETAILS)
	public List<Model> getAllModelDetails(){
		
		return carService.getAllModelDetails();
	}
}
