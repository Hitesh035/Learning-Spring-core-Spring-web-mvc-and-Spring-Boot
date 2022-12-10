package com.hitesh.springwebv2.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitesh.springwebv2.dto.TicketDto;
import com.hitesh.springwebv2.entity.MovieInfo;
import com.hitesh.springwebv2.entity.MovieSchedules;
import com.hitesh.springwebv2.entity.TheaterInfo;
import com.hitesh.springwebv2.entity.TicketsBooked;
import com.hitesh.springwebv2.repository.MovieInfoRepository;
import com.hitesh.springwebv2.repository.MovieSchedulesRepository;
import com.hitesh.springwebv2.repository.TheaterInfoRepository;
import com.hitesh.springwebv2.repository.TicketsBookedRepository;
import com.hitesh.springwebv2.util.ArrayListToString;

@Service
public class TicketBookingService {

	@Autowired
	private TicketsBookedRepository ticketsBookedRepository;
	@Autowired
	private TheaterInfoRepository theaterInfoRepository;
	@Autowired
	private MovieInfoRepository movieInfoRepository;
	@Autowired
	private MovieSchedulesRepository movieSchedulesRepository;

	public TicketsBooked bookTicket(TicketDto ticketDto) throws Exception {

		List<MovieSchedules> list = movieSchedulesRepository.findMovieScheduleByTheaterId(ticketDto.getTheaterId());

		MovieSchedules finalSchedule = new MovieSchedules();
		if (list.isEmpty())
			throw new Exception("Schedule doesn't exist");

		Iterator<MovieSchedules> itr = list.iterator();
		boolean movieIdAvailable = false;
		while (itr.hasNext()) {
			finalSchedule = itr.next();
			if (finalSchedule.getMovieId() == ticketDto.getMovieId() && finalSchedule.getShowTimings().equals(ticketDto.getShowTime()) && finalSchedule.getTotalTickets() >= ticketDto.getNoOfTickets() ) {

				movieIdAvailable = true;

				break;
			}
		}

		if (!movieIdAvailable)
			throw new Exception("Schedule doesn't exist");

		if (!finalSchedule.getShowTimings().equals(ticketDto.getShowTime()))
			throw new Exception("Show timing not available");

		if (finalSchedule.getTotalTickets() < ticketDto.getNoOfTickets())
			throw new Exception("Sufficient seats not available");

		TicketsBooked newTicket = new TicketsBooked();
		newTicket.setMovieId(ticketDto.getMovieId());
		newTicket.setNoOfTickets(ticketDto.getNoOfTickets());
		newTicket.setTheaterId(ticketDto.getTheaterId());
		newTicket.setShowtime(ticketDto.getShowTime());
		newTicket.setStatus("CONFIRMED");
		newTicket.setBookedTime(new SimpleDateFormat().format(new Timestamp(System.currentTimeMillis())));
		newTicket.setTotalPrice(finalSchedule.getPrice() * ticketDto.getNoOfTickets());

		ticketsBookedRepository.saveTicketDetails(newTicket);
		movieSchedulesRepository.updateSeatsByMovieScheduleId(finalSchedule.getScheduleId(), finalSchedule.getTotalTickets()-ticketDto.getNoOfTickets());
		return newTicket;

	}

//	public void bookTicket(TicketDto ticketDto) throws Exception {
//
//		List<MovieSchedules> list = movieSchedulesRepository
//				.findMovieScheduleByMovieIdAndTheaterId(ticketDto.getMovieId(), ticketDto.getTheaterId());
//
//		MovieSchedules finalSchedule = new MovieSchedules();
//		if (list.isEmpty())
//			throw new Exception("Schedule doesn't exist");
//
//		Iterator<MovieSchedules> itr = list.iterator();
//		while (itr.hasNext()) {
//			if (itr.next().getShowTimings().equals(ticketDto.getShowTime())) {
//				finalSchedule = itr.next();
//				break;
//			}
//
//		}
//
//		if (finalSchedule.getTotalTickets() < ticketDto.getNoOfTickets())
//			throw new Exception("Sufficient seats not available");
//
//		TicketsBooked newTicket = new TicketsBooked();
//		newTicket.setMovieId(ticketDto.getMovieId());
//		newTicket.setNoOfTickets(ticketDto.getNoOfTickets());
//		newTicket.setTheaterId(ticketDto.getTheaterId());
//		newTicket.setShowtime(ticketDto.getShowTime());
//		newTicket.setStatus("CONFIRMED");
//		newTicket.setBookedTime(new SimpleDateFormat().format(new Timestamp(System.currentTimeMillis())));
//		newTicket.setTotalPrice(finalSchedule.getPrice() * ticketDto.getNoOfTickets());
//
//		ticketsBookedRepository.saveTicketDetails(newTicket);
//
//		
//
//	}

	public void addTheaterDetails(TheaterInfo theaterInfo) {
		theaterInfoRepository.addTheaterDetails(theaterInfo);

	}

	public void createMovieSchedule(MovieSchedules movieSchedules) {

		movieSchedulesRepository.createMovieSchedule(movieSchedules);

	}

	public void addMovie(MovieInfo movieInfo) {

		movieInfoRepository.addMovie(movieInfo);
	}
}
