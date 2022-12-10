package com.hitesh.springweb.repository;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hitesh.springweb.entity.Register;

//@Component
@Repository
public class RegisterRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void saveRegister(Register register) {
		Session session = sessionFactory.openSession();

		try {
			Transaction beginTransaction = session.beginTransaction();
			session.merge(register);
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println("Unknown Error occured");
		} finally {
			session.close();
		}

	}
	
	public List<Register> getAll(){
		 Session session = sessionFactory.openSession();
		 
		 try {
			 String hql = "FROM Register";
			 
			 Query<Register>  query = session.createQuery(hql);
			 return query.list();
			 
			 
			} catch (Exception e) {
				System.out.println("Unknown Error occured");
			} finally {
				session.close();
			}
		 
		 return Collections.emptyList();
		 
		
	}
	
	public Register findByName(String name) {
		Session session = sessionFactory.openSession();
		 
		 try {
			 String hql = "FROM Register WHERE name =: n";
			 
			 Query<Register>  query = session.createQuery(hql);
			 query.setParameter("n", name);
			 
			 return query.uniqueResult();
			 
			 
			} catch (Exception e) {
				System.out.println("Unknown Error occured");
			} finally {
				session.close();
			}
		 
		 return null;
	}
}
