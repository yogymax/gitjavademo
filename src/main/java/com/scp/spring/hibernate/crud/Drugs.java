package com.scp.spring.hibernate.crud;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "boot_drug_repr_info")
public class Drugs {

	@Id
	private int drugId;
	private String drugType;
	private String drugName;
	private double drugPrice;
	
	@ManyToOne
	private MedicalRepresentative listOfRepresentatives;
	
	
	
	
	
	
	public Drugs(int drugId, String drugType, String drugName, double drugPrice,
			MedicalRepresentative listOfRepresentatives) {
		super();
		this.drugId = drugId;
		this.drugType = drugType;
		this.drugName = drugName;
		this.drugPrice = drugPrice;
		this.listOfRepresentatives = listOfRepresentatives;
	}






	public int getDrugId() {
		return drugId;
	}






	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}






	public String getDrugType() {
		return drugType;
	}






	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}






	public String getDrugName() {
		return drugName;
	}






	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}






	public double getDrugPrice() {
		return drugPrice;
	}






	public void setDrugPrice(double drugPrice) {
		this.drugPrice = drugPrice;
	}






	public MedicalRepresentative getListOfRepresentatives() {
		return listOfRepresentatives;
	}






	public void setListOfRepresentatives(MedicalRepresentative listOfRepresentatives) {
		this.listOfRepresentatives = listOfRepresentatives;
	}






	@Override
	public String toString() {
		return "Drugs [drugId=" + drugId + ", drugType=" + drugType + ", drugName=" + drugName + ", drugPrice="
				+ drugPrice + ", listOfRepresentatives=" + listOfRepresentatives + "]";
	}






	public Drugs() {
		// TODO Auto-generated constructor stub
	}

}
