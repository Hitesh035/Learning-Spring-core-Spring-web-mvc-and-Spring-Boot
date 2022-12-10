package com.hitesh.springwebv2.dto;

import java.io.Serializable;

public class TicketDto implements Serializable{

	
	
	private long theaterId;
	private long movieId;
	private String showTime;
	private long noOfTickets;
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
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public long getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(long noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	@Override
	public String toString() {
		return "TicketDto [theaterId=" + theaterId + ", movieId=" + movieId + ", showTime=" + showTime
				+ ", noOfTickets=" + noOfTickets + "]";
	}
	

}
