package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entities.Car;
import entities.CarBooking;
import entities.Passenger;

@Local
public interface CarBookingServicesLocal {

	Boolean addBooking(CarBooking carBooking);

	Boolean updateBooking(CarBooking carBooking);

	Boolean deleteBooking(CarBooking carBooking);

	CarBooking findBookingByCarIdAndPassengerId(Integer idPassenger,
			Integer idCar);

	List<CarBooking> findAllBookings();

	List<CarBooking> findAllBookingsByPassengerId(Integer passengerId);

	List<CarBooking> findAllBookingsByCarId(Integer carId);

	Boolean rentCar(Car car, Passenger passenger, Date startDate, Date endDate);

	float priceOfRent(Car car, Date startDate, Date endDate);

}
