package com.hitesh.springwebv2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hitesh.springwebv2.constants.AppConstants;

@Entity
@Table(name = AppConstants.TICKETS_BOOKED)
public class TicketsBooked {
	
	@Id
	@Column(name = "ticket_id")
	@GenericGenerator(name = "ticketIdGenerator", strategy = "increment")
	@GeneratedValue(generator = "ticketIdGenerator")
	private long ticketId;
	
	@Column(name = "theater_id")
	private long theaterId;
	
	@Column(name = "movie_id")
	private long movieId;
	
	@Column(name = "showtime")
	private String showtime;
	
	@Column(name = "booked_time")
	private String bookedTime;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "no_of_tickets")
	private long noOfTickets ;

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
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

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getBookedTime() {
		return bookedTime;
	}

	public void setBookedTime(String bookedTime) {
		this.bookedTime = bookedTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(long noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	@Override
	public String toString() {
		return "TicketsBooked [ticketId=" + ticketId + ", theaterId=" + theaterId + ", movieId=" + movieId
				+ ", showtime=" + showtime + ", bookedTime=" + bookedTime + ", status=" + status + ", totalPrice="
				+ totalPrice + ", noOfTickets=" + noOfTickets + "]";
	}
	
	
	
	
}
