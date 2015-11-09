package tn.edu.esprit.sigma.client;

import tn.edu.esprit.sigma.client.delegate.FlightServicesDelegate;
import entities.Flight;
import entities.FlightCategory;

public class TestFoo {
	public static void main(String[] args) {
		serviceOne();
	}

	public static void serviceOne() {
		Flight flight=FlightServicesDelegate.doFindFlightById(1);
		System.out.println(flight.getFreePlacesMap().get(FlightCategory.BUSINESS));
	}
}
