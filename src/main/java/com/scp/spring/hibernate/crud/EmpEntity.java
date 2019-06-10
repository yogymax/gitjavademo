package com.scp.spring.hibernate.crud;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_info_spring_hbm")
public class EmpEntity {

	@Id
	private int empId;
	private String empName;
	private String empDesig;
	private double empSalry;
	private int empAge;
	
	
	
	
	public EmpEntity(int empId, String empName, String empDesig, double empSalry, int empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesig = empDesig;
		this.empSalry = empSalry;
		this.empAge = empAge;
	}




	@Override
	public String toString() {
		return "EmpEntity [empId=" + empId + ", empName=" + empName + ", empDesig=" + empDesig + ", empSalry="
				+ empSalry + ", empAge=" + empAge + "]";
	}




	public int getEmpId() {
		return empId;
	}




	public void setEmpId(int empId) {
		this.empId = empId;
	}




	public String getEmpName() {
		return empName;
	}




	public void setEmpName(String empName) {
		this.empName = empName;
	}




	public String getEmpDesig() {
		return empDesig;
	}




	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}




	public double getEmpSalry() {
		return empSalry;
	}




	public void setEmpSalry(double empSalry) {
		this.empSalry = empSalry;
	}




	public int getEmpAge() {
		return empAge;
	}




	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}




	public EmpEntity() {
		// TODO Auto-generated constructor stub
	}

}
