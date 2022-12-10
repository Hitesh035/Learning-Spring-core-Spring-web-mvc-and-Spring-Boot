package com.hitesh.springfirst;

public class BookTicket {

	private String ticketNum;
	private String origin;
	private String dest;

//	public BookTicket() {
//
//		System.out.println(this.getClass().getSimpleName() + " class object created.");
//	}
	
	public BookTicket(String ticketNum, String origin, String dest) {
		super();
		this.ticketNum = ticketNum;
		this.origin = origin;
		this.dest = dest;
		System.out.println(this.getClass().getSimpleName() + " class object created.");
	}

	public void bookingConfirmation() {
		
		System.out.println("Successfull");
	}

	public String getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "BookTicket [ticketNum=" + ticketNum + ", origin=" + origin + ", dest=" + dest + "]";
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

}
