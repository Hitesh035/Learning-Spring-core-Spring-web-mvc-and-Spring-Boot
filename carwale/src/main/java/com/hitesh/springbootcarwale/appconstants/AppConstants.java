package com.hitesh.springbootcarwale.appconstants;

public class AppConstants {
	
	public static final String CONTROLLER_URL = "/";
	
	public static final String BRAND_TABLE_NAME = "brand_table";
	public static final String MODEL_TABLE_NAME = "model_table";
	public static final String ORDER_DETAILS_TABLE_NAME = "order_details_table";
	
	public static final String SAVE_BRAND_DETAILS = "/saveBrand";
	public static final String GET_ALL_BRAND_DETAILS = "/getAllBrandDetails";
	
	public static final String SAVE_ALL_MODEL_DETAILS = "/saveAllModels";
	public static final String SAVE_MODEL_DETAILS = "/saveModel";
	public static final String GET_ALL_MODEL_DETAILS = "/getAllModelDetails";
	public static final String GET_ALL_MODEL_DETAILS_BY_BRAND_ID = "/getAllModelDetailsByBrandId/{brandId}";
	
	
	public static final String BOOK_ORDER = "/bookOrder";
	public static final String DELIVER_ORDER = "/deliverOrder";
	
	
	public static final String CAR_SOLD_DETAILS = "/getCarSoldDetails";
	public static final String CARS_SOLD_DETAILS = "/getCarsSoldDetails";
}
