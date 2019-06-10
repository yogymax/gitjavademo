package com.scp.java.hibernate.integration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "spring_hbm_product")
public class ProductInfo {
	@Id
	private int prodId;
	private String prodName;
	private double prodPrice;
	private String prodVendor;
	@Override
	public String toString() {
		System.out.println("inside tostring method...!");
		return "\n [prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodVendor="
				+ prodVendor + "]";
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdVendor() {
		return prodVendor;
	}
	public void setProdVendor(String prodVendor) {
		this.prodVendor = prodVendor;
	}
	public ProductInfo(int prodId, String prodName, double prodPrice, String prodVendor) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodVendor = prodVendor;
	}
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
