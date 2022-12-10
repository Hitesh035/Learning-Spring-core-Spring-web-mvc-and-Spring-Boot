package com.hitesh.springwebv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.springwebv2.constants.AppConstants;
import com.hitesh.springwebv2.dto.TicketDto;
import com.hitesh.springwebv2.entity.MovieInfo;
import com.hitesh.springwebv2.entity.MovieSchedules;
import com.hitesh.springwebv2.entity.TheaterInfo;
import com.hitesh.springwebv2.entity.TicketsBooked;
import com.hitesh.springwebv2.service.TicketBookingService;

@RestController
//@Component
@RequestMapping(value = AppConstants.REQUEST_CONTROLLER_URL)
public class RequestController {

	@Autowired
	private TicketBookingService bookingService;

	
	@PostMapping(value = AppConstants.BOOK_TICKET)
	
	public @ResponseBody TicketsBooked bookTicket(@RequestBody TicketDto ticketDto) {
		try {
			return bookingService.bookTicket(ticketDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@PostMapping(value = AppConstants.ADD_THEATER_DETAILS)
	public void addTheaterDetails(@RequestBody TheaterInfo theaterInfo) {
		bookingService.addTheaterDetails(theaterInfo);

	}

	@PostMapping(value = AppConstants.CREATE_MOVIE_SCHEDULE)
	public void createMovieSchedule(@RequestBody MovieSchedules movieSchedules) {

		bookingService.createMovieSchedule(movieSchedules);

	}

	@PostMapping(value = AppConstants.ADD_MOVIE)
	public void addMovie(@RequestBody MovieInfo movieInfo) {
		bookingService.addMovie(movieInfo);

	}
}
