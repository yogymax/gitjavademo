package com.scp.java;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

public class Product implements BeanNameAware {

	private int productId;
	private String productName;
	private double productPrice;

	private Vendor productVendor;
	

	public void myMethodd() {
		System.out.println("inside my method --Destroy");
	}
	
	public void myMethod() {
		System.out.println("inside my method -- initit");
	}
	
	
	static {
		System.out.println("product class loaded..into memory");
	}
	
	public Product(int productId, String productName, double productPrice, Vendor productVendor) {
		super();
		System.out.println("inside product constructor -- args");
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productVendor = productVendor;
	}






	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productVendor=" + productVendor + "]";
	}






	public int getProductId() {
		return productId;
	}






	public void setProductId(int productId) {
		System.out.println("inside product set id");
		this.productId = productId;
	}






	public String getProductName() {
		return productName;
	}






	public void setProductName(String productName) {
		this.productName = productName;
	}






	public double getProductPrice() {
		return productPrice;
	}






	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}






	public Vendor getProductVendor() {
		return productVendor;
	}






	public void setProductVendor(Vendor productVendor) {
		this.productVendor = productVendor;
	}






	private Product() {
		System.out.println("inside product constructor -- no arg");
	}






	public void setBeanName(String name) {
		System.out.println("inside set beanname");
		
	}

}




class Vendor{
	private int vendorId;
	private String vendorName;
	
	static {
		System.out.println("vendor loaded into memory");
	}
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		System.out.println("inside vendor setid");
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	@Override
	public String toString() {
		return "\n [vendorId=" + vendorId + ", vendorName=" + vendorName + "]";
	}
	public Vendor(int vendorId, String vendorName) {
		super();
		System.out.println("vendor args constructor....int str");
		this.vendorId = vendorId;
		this.vendorName = vendorName;
	}
	
	public Vendor(String vendorame,String venorId) {
		super();
		System.out.println("vendor args constructor....str int");
		//this.vendorId = vendorId;
	}
	
	public Vendor() {
		super();
		System.out.println("vendor -- no arg constructor");
	}
	
	
	
	
}