package com.dto;

import java.util.List;

public class Sku {

	private Integer skuId;
	private Integer productId;
	private List<Specifics> specificsList;
	private Float price;
	private Integer stock;

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public List<Specifics> getSpecificsList() {
		return specificsList;
	}

	public void setSpecificsList(List<Specifics> specificsList) {
		this.specificsList = specificsList;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
