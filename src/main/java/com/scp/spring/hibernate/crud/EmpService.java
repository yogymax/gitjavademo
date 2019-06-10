package com.scp.spring.hibernate.crud;

import java.util.List;

/**
 * @author Yogesh
 * This is a Contract for emp Service
 * @version  1.0
 */
public interface EmpService {
	
	public boolean addEmp(EmpBean bean);
	public EmpBean getEmp(int empId);
	public List<EmpBean> getAllEmps();
	public List<EmpBean> removeEmp(int empId);
	public EmpBean modifyEmp(EmpBean bean);
	
	
	
}
