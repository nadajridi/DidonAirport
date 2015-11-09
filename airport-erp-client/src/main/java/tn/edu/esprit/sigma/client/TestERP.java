package tn.edu.esprit.sigma.client;

import java.util.Date;
import java.util.List;

import tn.edu.esprit.sigma.client.delegate.CarBookingServicesDelegate;
import tn.edu.esprit.sigma.client.delegate.CarRentalAgencyServicesDelegate;
import tn.edu.esprit.sigma.client.delegate.CarServicesDelegate;
import tn.edu.esprit.sigma.client.delegate.FlightServicesDelegate;
import tn.edu.esprit.sigma.client.delegate.PassengerServicesDelegate;
import tn.edu.esprit.sigma.client.delegate.TicketServicesDelegate;
import utilities.DateParser;
import entities.Car;
import entities.CarCategory;
import entities.CarRentalAgency;
import entities.CarState;
import entities.Flight;
import entities.FlightCategory;
import entities.Passenger;

public class TestERP {

	static Passenger passenger, passenger2;
	static Flight flight;
	static Car car, car2;
	static CarRentalAgency carRentalAgency;
	static Date date1 = DateParser.convertStringToDate("15/11/2015");
	static Date date2 = DateParser.convertStringToDate("26/11/2015");

	public static void main(String[] args) {

		passenger = PassengerServicesDelegate.doFindPassengerById(1);
//		System.out.println(passenger.getFirstName());
//		flight = FlightServicesDelegate.doFindFlightById(1);
//		System.out.println(flight.getDestination());
		car = CarServicesDelegate.doFindCarById(1);
//		System.out.println(car.getDescription());
//		carRentalAgency = CarRentalAgencyServicesDelegate.doFindCarRentalAgencyByEmail(1);
//		System.out.println(carRentalAgency.getEmail());
//		
//		TicketServicesDelegate.doBookTicketBis(passenger.getId(), flight.getId(), FlightCategory.VIP);
		CarBookingServicesDelegate.doRentCar(car, passenger, date1, date2);
		
//		car2= new Car("98TUN1301", "Clio", CarCategory.CLASSIC, CarState.AVAILABLE, "bon état", 65, carRentalAgency);
//		CarServicesDelegate.doAddCar(car2);
		
		
		
	}

}
