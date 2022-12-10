package com.hitesh.springwebv2.repository;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hitesh.springwebv2.entity.TheaterInfo;

@Repository
public class TheaterInfoRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTheaterDetails(TheaterInfo theaterInfo) {
		Session session = sessionFactory.openSession();
		try {

			org.hibernate.Transaction transaction = session.beginTransaction();

			session.save(theaterInfo);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}

	}

	public List<TheaterInfo> listAllTheaterInfo() {

		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "FROM TheaterInfo";
			Query<TheaterInfo> query = session.createQuery(hqlQuery);

			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Collections.emptyList();

	}

	public TheaterInfo findTheaterByTheaterId(long id) {

		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "SELECT * FROM TheaterInfo WHERE theaterId =:id";

			Query<TheaterInfo> query = session.createQuery(hqlQuery);
			query.setParameter("id", id);

			return query.uniqueResult();
		} catch (Exception e) {
			System.out.println("Theater with the provided ID doesn't exist.");
		} finally {
			session.close();
		}
		return null;

	}
}
