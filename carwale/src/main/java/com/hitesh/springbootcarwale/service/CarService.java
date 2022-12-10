package com.hitesh.springbootcarwale.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitesh.springbootcarwale.dto.BookDTO;
import com.hitesh.springbootcarwale.entity.Brand;
import com.hitesh.springbootcarwale.entity.Model;
import com.hitesh.springbootcarwale.entity.OrderDetails;
import com.hitesh.springbootcarwale.repository.BrandRepository;
import com.hitesh.springbootcarwale.repository.ModelRepository;
import com.hitesh.springbootcarwale.repository.OrderDetailsRepository;

@Service
public class CarService {

	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	private OrderDetails orderDetails;

	public void saveBrand(Brand brand) {

		brandRepository.save(brand);
	}

	public List<Brand> getAllBrandDetails() {

		return brandRepository.findAll();

	}

	public void saveAllModels(List<Model> list) {

		modelRepository.saveAll(list);
	}

	public void saveModel(Model model) {

		modelRepository.save(model);
	}

	public List<Model> getAllModelDetails() {

		return modelRepository.findAll();
	}

	public void saveOrder(BookDTO bookDTO) {

		List<OrderDetails> orderList = orderDetailsRepository.findAll();
		if (orderList.isEmpty())
			orderDetails.setId(1);
		else {
			orderDetails.setId(orderList.get(orderList.size() - 1).getId() + 1);
			;
		}
		orderDetails.setPaymentMode(bookDTO.getPaymentMode());
		orderDetails.setBrandId(bookDTO.getBrandId());
		orderDetails.setTotalAmountReceived(bookDTO.getAmountPaid());
		orderDetails.setAdvancePaid(bookDTO.getAdvancePaid());
		orderDetails.setOrderedDate(new SimpleDateFormat().format(new Timestamp(System.currentTimeMillis())));
		orderDetails.setDeliveredDate("NOT DELIVERED");
		orderDetails.setDeliveryStatus("NOT DELIVERED");

		orderDetailsRepository.save(orderDetails);

	}

	public void updateOrder(OrderDetails orderDetails) throws Exception {

		Optional<OrderDetails> updatingDetailsContainer = orderDetailsRepository.findById(orderDetails.getId());
		if (updatingDetailsContainer.isEmpty())
			throw new Exception("Order ID not found");
		OrderDetails toUpdate = updatingDetailsContainer.get();

		OrderDetails updatedOrderDetails = toUpdate;

		orderDetailsRepository.delete(toUpdate);
		updatedOrderDetails.setDeliveryStatus("DELIVERED");
		updatedOrderDetails.setDeliveredDate(new SimpleDateFormat().format(new Timestamp(System.currentTimeMillis())));
		updatedOrderDetails.setTotalAmountReceived(orderDetails.getTotalAmountReceived());
		updatedOrderDetails.setPaymentMode(orderDetails.getPaymentMode());

		orderDetailsRepository.save(updatedOrderDetails);

	}

}
