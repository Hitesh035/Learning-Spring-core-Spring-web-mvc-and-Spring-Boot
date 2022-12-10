package com.hitesh.springbootcarwale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.springbootcarwale.appconstants.AppConstants;
import com.hitesh.springbootcarwale.entity.Brand;
import com.hitesh.springbootcarwale.service.CarService;

//@RestController
//@RequestMapping(value =  AppConstants.CONTROLLER_URL)
public class BrandController {

	@Autowired
	private CarService carService;
	
	@PostMapping(value =  AppConstants.SAVE_BRAND_DETAILS)
	public void saveBrand(@RequestBody Brand brand) {
		
		carService.saveBrand(brand);
	}
	
	@GetMapping(value = AppConstants.GET_ALL_BRAND_DETAILS)
	public List<Brand> getAllBrandDetails(){
		
		return carService.getAllBrandDetails();
	}
	
}
