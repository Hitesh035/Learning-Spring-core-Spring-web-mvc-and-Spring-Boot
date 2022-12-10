package com.hitesh.springwebv2.repository;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hitesh.springwebv2.entity.MovieInfo;
import com.hitesh.springwebv2.entity.TheaterInfo;

@Repository
public class MovieInfoRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addMovie(MovieInfo movieInfo) {
		Session session = sessionFactory.openSession();
		try {

			org.hibernate.Transaction transaction = session.beginTransaction();

			session.save(movieInfo);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}

	}

	public List<MovieInfo> listAllMovieInfo() {

		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "FROM MovieInfo";
			Query<MovieInfo> query = session.createQuery(hqlQuery);

			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Collections.emptyList();

	}

	public MovieInfo findMovieByMovieId(long id) {

		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "SELECT * FROM MovieInfo WHERE movieId =:id";

			Query<MovieInfo> query = session.createQuery(hqlQuery);
			query.setParameter("id", id);

			return query.uniqueResult();
		} catch (Exception e) {
			System.out.println("Movie with the provided ID doesn't exist.");
		} finally {
			session.close();
		}
		return null;

	}
}
