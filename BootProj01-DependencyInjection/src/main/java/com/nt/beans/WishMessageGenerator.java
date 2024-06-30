package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired // Field level injection
	private LocalDateTime date;

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-param constructor");
	}

	// business method
	public String generateWishMessage(String user) {
		// get current hour of the day
		int hour = date.getHour(); // gives 24 hrs format
		// generate wish message
		if (hour < 12)
			return "Good Morning " + user;
		else if (hour < 16)
			return "Good Afternoon " + user;
		else if (hour < 20)
			return "Good Evening " + user;
		else
			return "Good Night " + user;
	}
}
