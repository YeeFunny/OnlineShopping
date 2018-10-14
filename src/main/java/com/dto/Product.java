package com.dto;

import java.util.List;

public class Product {

	private Integer productId;
	private String productName;
	private Integer categoryId;
	private List<Specifics> specificsList;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public List<Specifics> getSpecificsList() {
		return specificsList;
	}

	public void setSpecificsList(List<Specifics> specificsList) {
		this.specificsList = specificsList;
	}

}
