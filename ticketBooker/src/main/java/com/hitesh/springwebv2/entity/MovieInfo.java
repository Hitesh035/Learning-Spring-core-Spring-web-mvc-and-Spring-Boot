package com.hitesh.springwebv2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hitesh.springwebv2.constants.AppConstants;

@Entity
@Table(name = AppConstants.MOVIE_DETAILS)
public class MovieInfo {
	
	@Id
	@Column(name = "movie_id")
	@GenericGenerator(name = "movieIdGenerator", strategy = "increment")
	@GeneratedValue(generator = "movieIdGenerator")
	private long movieId;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Column(name = "actor_name")
	private String actorName;
	
	@Column(name = "actress_name")
	private String actressName;
	
	@Column(name = "release_date")
	private String releaseDate;
	@Column(name = "rating")
	private double rating;
	@Column(name = "budget")
	private double budget;
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActressName() {
		return actressName;
	}
	public void setActressName(String actressName) {
		this.actressName = actressName;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return "MovieInfo [movieId=" + movieId + ", movieName=" + movieName + ", actorName=" + actorName
				+ ", actressName=" + actressName + ", releaseDate=" + releaseDate + ", rating=" + rating + ", budget="
				+ budget + "]";
	}
	
}
