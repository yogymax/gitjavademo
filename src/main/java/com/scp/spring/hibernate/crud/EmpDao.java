package com.scp.spring.hibernate.crud;

import java.util.List;

public interface EmpDao {

	public boolean insertEmp(EmpEntity entity);
	public EmpEntity fetchEmp(int empId);
	public List<EmpEntity> fetchAllEmps();
	public List<EmpEntity> deleteEmp(int empId);
	public EmpEntity updateEmp(EmpEntity entity);
	
}


