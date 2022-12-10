package com.hitesh.springfirst;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"new-spring-web.xml");

		BookTicket bookTicket = classPathXmlApplicationContext.getBean(BookTicket.class);

		bookTicket.bookingConfirmation();

		System.out.println(bookTicket);
	}
}
