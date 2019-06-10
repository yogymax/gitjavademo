package com.scp.spring.hibernate.crud;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("repoBean")
public class EmpDaoImpl implements EmpDao {
	
	@Qualifier("mysqlBean")
	@Autowired
	SessionFactory sfactory;
	
	public SessionFactory getSfactory() {
		return sfactory;
	}

	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}

	public boolean insertEmp(EmpEntity entity) {
		Session session=null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			Integer id = (Integer) session.save(entity);
			return id>0;
		}catch(Exception e) {
			System.out.println("problem in insert");
			return false;
		}finally {
			closeResources(session,tr);
		}
	}

	private void closeResources(Session session, Transaction tr) {
		if(session!=null) {
			if(tr!=null) {
				session.flush();
				tr.commit();
			}
			session.close();
		}
		
	}

	public EmpEntity fetchEmp(int empId) {
		Session session=null;
		try {
			session = sfactory.openSession();
			return session.get(EmpEntity.class,empId);
		}catch(Exception e) {
			System.out.println("problem in fetch");
			return null;
		}finally {
			closeResources(session,null);
		}
	}

	public List<EmpEntity> fetchAllEmps() {
		Session session=null;
		try {
			session = sfactory.openSession();
			return session.createCriteria(EmpEntity.class).list();
		}catch(Exception e) {
			System.out.println("problem in fetch all");
			return null;
		}finally {
			closeResources(session,null);
		}
	}

	public List<EmpEntity> deleteEmp(int empId) {
		Session session=null;
		Transaction tr = null;
		EmpEntity dbEntity = fetchEmp(empId);
		if (dbEntity!=null) {
			try {
				session = sfactory.openSession();
				tr = session.beginTransaction();
				session.delete(dbEntity);
			}catch(Exception e) {
				System.out.println("problem in insert");
			}finally {
				closeResources(session,tr);
			}
		}
		return fetchAllEmps();
	}

	public EmpEntity updateEmp(EmpEntity entity) {
		Session session=null;
		Transaction tr = null;
		EmpEntity dbEntity = fetchEmp(entity.getEmpId());
		if (dbEntity!=null) {
			try {
				session = sfactory.openSession();
				tr = session.beginTransaction();
				dbEntity.setEmpAge(entity.getEmpAge());
				dbEntity.setEmpDesig(entity.getEmpDesig());
				dbEntity.setEmpName(entity.getEmpName());
				dbEntity.setEmpSalry(entity.getEmpSalry());
				return (EmpEntity) session.merge(dbEntity);
			}catch(Exception e) {
				System.out.println("problem in update");
			}finally {
				closeResources(session,tr);
			}
		}
		return null;
	
	}

}
