package com.fibaday2.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	private String productName;

	private double salesPrice;

	public Product() {
		super();
	}

	public Product(long productId, String productName, double salesPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

}