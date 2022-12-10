package com.hitesh.springwebv2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hitesh.springwebv2.entity.TicketsBooked;

@Repository
public class TicketsBookedRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveTicketDetails(TicketsBooked ticketsBooked) {
		Session session = sessionFactory.openSession();
		try {

			org.hibernate.Transaction transaction = session.beginTransaction();

			session.save(ticketsBooked);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		
	}
}
