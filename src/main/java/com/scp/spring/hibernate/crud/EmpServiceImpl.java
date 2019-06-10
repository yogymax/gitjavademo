package com.scp.spring.hibernate.crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceBean")
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDaoImpl empDao;
	
	
	public EmpDaoImpl getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDaoImpl empDao) {
		this.empDao = empDao;
	}

	public boolean addEmp(EmpBean bean) {
		return empDao.insertEmp(convertBeanToEntity(bean));
	}

	private EmpEntity convertBeanToEntity(EmpBean entity) {
		return  new EmpEntity(entity.getEmpId(),entity.getEmpName(),entity.getEmpDesig(),entity.getEmpSalry(),entity.getEmpAge());
	}

	public EmpBean getEmp(int empId) {
		return convertEntityToBean(empDao.fetchEmp(empId));
	}

	private EmpBean convertEntityToBean(EmpEntity entity) {	
			return  new EmpBean(entity.getEmpId(),entity.getEmpName(),entity.getEmpDesig(),entity.getEmpSalry(),entity.getEmpAge());
	}

	public List<EmpBean> getAllEmps() {
		return convertIntoBeans(empDao.fetchAllEmps());
	}

	private List<EmpBean> convertIntoBeans(List<EmpEntity> fetchAllEmps) {
		List<EmpBean> beans = new ArrayList<EmpBean>();
		for (EmpEntity empEntity : fetchAllEmps) {
			beans.add(convertEntityToBean(empEntity));
		}
		return beans;
	}

	public List<EmpBean> removeEmp(int empId) {
		return convertIntoBeans(empDao.deleteEmp(empId));
	}

	public EmpBean modifyEmp(EmpBean bean) {
		return convertEntityToBean(empDao.updateEmp(convertBeanToEntity(bean)));
	}


}
