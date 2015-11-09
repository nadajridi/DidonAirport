package tn.edu.esprit.sigma.client;

import tn.edu.esprit.sigma.client.delegate.FlightServicesDelegate;
import entities.Flight;
import entities.FlightCategory;

public class TestFreePlacesByFlightCategory {

	public static void main(String[] args) {
		Flight flight = FlightServicesDelegate.doFindFlightById(1);
		System.out.println("free places in  BUSINESS: "
				+ flight.getFreePlacesMap().get(FlightCategory.BUSINESS));
		System.out.println("free places in  ECONOMY: "
				+ flight.getFreePlacesMap().get(FlightCategory.ECONOMY));
		System.out.println("free places in  VIP: "
				+ flight.getFreePlacesMap().get(FlightCategory.VIP));

	}

}
