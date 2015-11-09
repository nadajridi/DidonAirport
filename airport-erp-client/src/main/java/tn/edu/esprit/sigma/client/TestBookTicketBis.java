package tn.edu.esprit.sigma.client;

import tn.edu.esprit.sigma.client.delegate.TicketServicesDelegate;
import entities.FlightCategory;

public class TestBookTicketBis {

	public static void main(String[] args) {
		firstPassengerBooking();
		secondPassengerBooking();
		thirdPassengerBooking();

	}

	public static void firstPassengerBooking() {
		System.out.println(TicketServicesDelegate.doBookTicketBis(1, 1,
				FlightCategory.ECONOMY));
	}

	public static void secondPassengerBooking() {
		System.out.println(TicketServicesDelegate.doBookTicketBis(2, 1,
				FlightCategory.ECONOMY));
	}

	public static void thirdPassengerBooking() {
		System.out.println(TicketServicesDelegate.doBookTicketBis(3, 1,
				FlightCategory.ECONOMY));
	}
}
