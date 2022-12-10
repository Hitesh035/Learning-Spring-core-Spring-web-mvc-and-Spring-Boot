package com.hitesh.springwebv2.repository;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hitesh.springwebv2.entity.MovieInfo;
import com.hitesh.springwebv2.entity.MovieSchedules;

@Repository
public class MovieSchedulesRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void createMovieSchedule(MovieSchedules movieSchedules) {
		Session session = sessionFactory.openSession();
		try {

			org.hibernate.Transaction transaction = session.beginTransaction();

			session.save(movieSchedules);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}

	}

	public List<MovieSchedules> listAllMovieScheduleInfo() {

		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "FROM MovieSchedules";
			Query<MovieSchedules> query = session.createQuery(hqlQuery);

			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Collections.emptyList();

	}

	public MovieSchedules findMovieScheduleByScheduleId(long id) {

		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "FROM MovieSchedules WHERE scheduleId =:id";

			Query<MovieSchedules> query = session.createQuery(hqlQuery);
			query.setParameter("id", id);

			return query.uniqueResult();
		} catch (Exception e) {
			System.out.println("Movie schedule with the provided ID doesn't exist.");
		} finally {
			session.close();
		}
		return null;

	}
	
	public List<MovieSchedules> findMovieScheduleByTheaterId(long theaterId) {

		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "FROM MovieSchedules WHERE theaterId =:tId";

			Query<MovieSchedules> query = session.createQuery(hqlQuery);
			query.setParameter("tId", theaterId);
			

			return query.list();
		} catch (Exception e) {
			System.out.println("Movie schedule with the provided theater ID doesn't exist.");
		} finally {
			session.close();
		}
		return Collections.emptyList();

	}
	
	public List<MovieSchedules> findMovieScheduleByMovieId(long movieId) {

		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "FROM MovieSchedules WHERE movieID =:mId";

			Query<MovieSchedules> query = session.createQuery(hqlQuery);
			
			query.setParameter("mId", movieId);

			return query.list();
		} catch (Exception e) {
			System.out.println("Movie schedule with the provided ID(s) doesn't exist.");
		} finally {
			session.close();
		}
		return Collections.emptyList();

	}
	
	public List<MovieSchedules> findMovieScheduleByMovieIdAndTheaterId(long movieId, long theaterId) {

		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "FROM MovieSchedules WHERE movieID =:mId AND theaterId=:tId";

			Query<MovieSchedules> query = session.createQuery(hqlQuery);
			
			query.setParameter("mId", movieId);
			query.setParameter("tId", theaterId);

			return query.list();
		} catch (Exception e) {
			System.out.println("Movie schedule with the provided ID(s) doesn't exist.");
		} finally {
			session.close();
		}
		return Collections.emptyList();

	}
	
	public void updateSeatsByMovieScheduleId(long id, long availableTickets) {
		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "UPDATE MovieSchedules SET totalTickets =:tickets WHERE scheduleId =:sId";
			org.hibernate.Transaction transaction = session.beginTransaction();
			Query<MovieSchedules> query = session.createQuery(hqlQuery);
			query.setParameter("tickets", availableTickets);
			query.setParameter("sId", id);
			query.executeUpdate();
			transaction.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
