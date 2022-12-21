package com.hitesh.springbootcarwale.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.springbootcarwale.appconstants.AppConstants;
import com.hitesh.springbootcarwale.dto.BookDTO;
import com.hitesh.springbootcarwale.dto.CarSold;
import com.hitesh.springbootcarwale.dto.CarsSold;
import com.hitesh.springbootcarwale.entity.Brand;
import com.hitesh.springbootcarwale.entity.Model;
import com.hitesh.springbootcarwale.entity.OrderDetails;
import com.hitesh.springbootcarwale.service.CarService;

@RestController
@RequestMapping(value = AppConstants.CONTROLLER_URL)
public class MasterController {

	@Autowired
	private CarService carService;

	@PostMapping(value = AppConstants.SAVE_BRAND_DETAILS)
	public void saveBrand(@RequestBody Brand brand) {

		carService.saveBrand(brand);
	}

	@GetMapping(value = AppConstants.GET_ALL_BRAND_DETAILS)
	public @ResponseBody List<Brand> getAllBrandDetails() {

		return carService.getAllBrandDetails();
	}

	@PostMapping(value = AppConstants.SAVE_ALL_MODEL_DETAILS)
	public void saveAllModels(@RequestBody List<Model> list) {

		carService.saveAllModels(list);
	}

	@PostMapping(value = AppConstants.SAVE_MODEL_DETAILS)
	public void saveModel(@RequestBody Model model) {

		carService.saveModel(model);
	}

	@GetMapping(value = AppConstants.GET_ALL_MODEL_DETAILS)
	public @ResponseBody List<Model> getAllModelDetails() {

		return carService.getAllModelDetails();
	}

	@GetMapping(value = AppConstants.GET_ALL_MODEL_DETAILS_BY_BRAND_ID)
	public @ResponseBody List<Model> getAllModelDetailsByBrandId(@RequestHeader("brandId") long brandId) {

		List<Model> fromRepository = carService.getAllModelDetails();
		List<Model> toReturn = new ArrayList<>();

		Iterator<Model> itr = fromRepository.iterator();
		while (itr.hasNext()) {
			Model model = itr.next();
			if (model.getBrandId() == brandId) {
				toReturn.add(model);
			}
		}
		return toReturn;

	}

	@PostMapping(value = AppConstants.BOOK_ORDER)
	public void bookOrder(@RequestBody BookDTO bookDTO) {

		carService.saveOrder(bookDTO);
	}

	@PostMapping(value = AppConstants.DELIVER_ORDER)
	public void deliverOrder(@RequestBody OrderDetails orderDetails) {

		try {
			carService.updateOrder(orderDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = AppConstants.CAR_SOLD_DETAILS)
	public @ResponseBody List<CarSold> getCarSoldDetails() {

		return carService.getCarSoldDetails();

	}

	@GetMapping(value = AppConstants.CARS_SOLD_DETAILS)
	public @ResponseBody List<CarsSold> getCarsSoldDetails() {

		List<CarSold> carSoldList = carService.getCarSoldDetails();
		List<CarsSold> carsSoldList = new ArrayList<>();
		Map<Long, Long> unitsSoldMap = new LinkedHashMap<>();
		Map<Long, Double> amountReceivedMap = new LinkedHashMap<>();
		Map<Long, String> brandNameMap = new LinkedHashMap<>();
		for (CarSold carSold : carSoldList) {
			if (unitsSoldMap.containsKey(carSold.getModelId()) && amountReceivedMap.containsKey(carSold.getModelId())
					&& brandNameMap.containsKey(carSold.getModelId())) {
				unitsSoldMap.put(carSold.getModelId(), unitsSoldMap.get(carSold.getModelId()) + 1);
				amountReceivedMap.put(carSold.getModelId(),
						amountReceivedMap.get(carSold.getModelId()) + carSold.getTotalAmountReceived());
			} else {
				unitsSoldMap.put(carSold.getModelId(), 1L);
				amountReceivedMap.put(carSold.getModelId(), carSold.getTotalAmountReceived());
				brandNameMap.put(carSold.getModelId(), carSold.getBrandName());
			}

		}

		Set<Long> keySet = unitsSoldMap.keySet();
		Iterator<Long> itr = keySet.iterator();
		while (itr.hasNext()) {
			CarsSold carsSold = new CarsSold();
			long index = itr.next();
			carsSold.setBrandName(brandNameMap.get(index));
			carsSold.setModelId(index);
			carsSold.setTotalAmountReceived(amountReceivedMap.get(index));
			carsSold.setTotalUnitsSold(unitsSoldMap.get(index));
			carsSoldList.add(carsSold);
		}
		return carsSoldList;

	}

}
