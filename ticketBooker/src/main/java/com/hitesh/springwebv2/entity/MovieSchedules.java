package com.hitesh.springwebv2.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hitesh.springwebv2.constants.AppConstants;
import com.hitesh.springwebv2.util.ArrayListToString;
import com.hitesh.springwebv2.util.TimeFormatValidation;

@Entity
@Table(name = AppConstants.MOVIE_SCHEDULE)
public class MovieSchedules {

	@Id
	@Column(name = "schedule_id")
	@GenericGenerator(name = "scheduleIdGenerator", strategy = "increment")
	@GeneratedValue(generator = "scheduleIdGenerator")
	private long scheduleId;

	@Column(name = "theater_id")
	private long theaterId;

	@Column(name = "movie_id")
	private long movieId;

	@Column(name = "show_timings")
	private String showTime;

	@Column(name = "total_tickets")
	private long totalTickets;

	@Column(name = "price")
	private double price;

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getShowTimings() {
		return showTime;
	}

	public void setShowTimings(String time) throws Exception {
		if(!TimeFormatValidation.isValidTimeFormat(time)) throw new Exception("Invalid time format");
		
		this.showTime = time;
	}

	public long getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(long totalTickets) {
		this.totalTickets = totalTickets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MovieSchedules [scheduleId=" + scheduleId + ", theaterId=" + theaterId + ", movieId=" + movieId
				+ ", showTimings=" + showTime + ", totalTickets=" + totalTickets + ", price=" + price + "]";
	}

	
}
