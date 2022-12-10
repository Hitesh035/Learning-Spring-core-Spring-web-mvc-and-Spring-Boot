package com.hitesh.springbootcarwale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.springbootcarwale.appconstants.AppConstants;
import com.hitesh.springbootcarwale.dto.BookDTO;
import com.hitesh.springbootcarwale.entity.Brand;
import com.hitesh.springbootcarwale.entity.Model;
import com.hitesh.springbootcarwale.entity.OrderDetails;
import com.hitesh.springbootcarwale.service.CarService;

@RestController
@RequestMapping(value =  AppConstants.CONTROLLER_URL)
public class MasterController {

	@Autowired
	private CarService carService;
	
	@PostMapping(value =  AppConstants.SAVE_BRAND_DETAILS)
	public void saveBrand(@RequestBody Brand brand) {
		
		carService.saveBrand(brand);
	}
	
	@GetMapping(value = AppConstants.GET_ALL_BRAND_DETAILS)
	public @ResponseBody List<Brand> getAllBrandDetails(){
		
		return carService.getAllBrandDetails();
	}
	
	@PostMapping(value =  AppConstants.SAVE_ALL_MODEL_DETAILS)
	public void saveAllModels(@RequestBody List<Model> list) {
		
		carService.saveAllModels(list); 
	}
	
	@PostMapping(value =  AppConstants.SAVE_MODEL_DETAILS)
	public void saveModel(@RequestBody Model model) {
		
		carService.saveModel(model);
	}
	
	@GetMapping(value = AppConstants.GET_ALL_MODEL_DETAILS)
	public @ResponseBody List<Model> getAllModelDetails(){
		
		return carService.getAllModelDetails();
	}
	
	@PostMapping(value =  AppConstants.BOOK_ORDER)
	public void bookOrder(@RequestBody BookDTO bookDTO ) {
		
		carService.saveOrder(bookDTO);
	}
	
	@PostMapping (value = AppConstants.DELIVER_ORDER)
	public void deliverOrder(OrderDetails orderDetails){
		
		 try {
			 carService.updateOrder(orderDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
