package com.hitesh.springbootcarwale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.hitesh.springbootcarwale.appconstants.AppConstants;
import com.hitesh.springbootcarwale.dto.BookDTO;
import com.hitesh.springbootcarwale.entity.OrderDetails;
import com.hitesh.springbootcarwale.service.CarService;

//@RestController
//@RequestMapping(value = AppConstants.CONTROLLER_URL)
public class OrderController {

	@Autowired
	private CarService carService;
	
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
