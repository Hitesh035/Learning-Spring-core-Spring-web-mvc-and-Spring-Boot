package com.hitesh.springbootcarwale.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.hitesh.springbootcarwale.dto.BookDTO;
import com.hitesh.springbootcarwale.dto.CarSold;
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
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	private OrderDetails orderDetails = new OrderDetails();

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
			
		}
		orderDetails.setPaymentMode(bookDTO.getPaymentMode());
		orderDetails.setModelId(bookDTO.getModelId());
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
	
	public List<CarSold> getCarSoldDetails(){
		String sqlQuery = "select brand_table.name, model_table.id, order_details_table.total_amount_received \r\n"
				+ "from brand_table\r\n"
				+ "join model_table on model_table.brand_id = brand_table.id\r\n"
				+ "join order_details_table on order_details_table.total_amount_received\r\n"
				+ "where order_details_table.model_id = model_table.id\r\n"
				+ "and \r\n"
				+ "order_details_table.delivery_status= 'DELIVERED';";
		List<Map<String, Object>>carSoldList = jdbcTemplate.queryForList(sqlQuery);
		
		return carSoldList.stream().map(data ->{
			CarSold carSold = new CarSold();
			carSold.setBrandName(data.get("name").toString());
			carSold.setModelId(Long.parseLong(data.get("id").toString()));
			carSold.setTotalAmountReceived(Double.parseDouble(data.get("total_amount_received").toString()));
			
			return carSold;
		}).collect(Collectors.toList());
		
		
	}
	
	

}
