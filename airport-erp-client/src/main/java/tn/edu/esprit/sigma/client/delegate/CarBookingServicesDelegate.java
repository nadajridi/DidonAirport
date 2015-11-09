package tn.edu.esprit.sigma.client.delegate;

import java.util.Date;
import java.util.List;

import services.interfaces.CarBookingServicesRemote;
import tn.edu.esprit.sigma.client.locator.ServiceLocator;
import entities.Car;
import entities.CarBooking;
import entities.Passenger;

public class CarBookingServicesDelegate {

	private static final String jndi = "airport-erp/CarBookingServices!services.interfaces.CarBookingServicesRemote";

	private static CarBookingServicesRemote getProxy() {
		return (CarBookingServicesRemote) ServiceLocator.getInstance()
				.getProxy(jndi);
	}

	public static Boolean doAddBooking(CarBooking carBooking) {
		return getProxy().addBooking(carBooking);
	}

	public static Boolean doUpdateBooking(CarBooking carBooking) {
		return getProxy().updateBooking(carBooking);
	}

	public static Boolean doDeleteBooking(CarBooking carBooking) {
		return getProxy().deleteBooking(carBooking);
	}

	public static CarBooking doFindBookingByCarIdAndPassengerId(
			Integer idPassenger, Integer idCar) {
		return getProxy().findBookingByCarIdAndPassengerId(idPassenger, idCar);
	}

	public static List<CarBooking> doFindAllBookings() {
		return getProxy().findAllBookings();
	}

	public static List<CarBooking> doFindAllBookingsByPassengerId(
			Integer passengerId) {
		return getProxy().findAllBookingsByPassengerId(passengerId);
	}

	public static List<CarBooking> doFindAllBookingsByCarId(Integer carId) {
		return getProxy().findAllBookingsByCarId(carId);
	}

	public static Boolean doRentCar(Car car, Passenger passenger,
			Date startDate, Date endDate) {
		return getProxy().rentCar(car, passenger, startDate, endDate);
	}

	public static float doPriceOfRent(Car car, Date startDate, Date endDate) {
		return getProxy().priceOfRent(car, startDate, endDate);
	}

}
