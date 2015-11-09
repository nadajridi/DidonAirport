package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Passenger;

@Remote
public interface PassengerServicesRemote {

	Boolean addPassenger(Passenger passenger);

	Boolean updatePassenger(Passenger passenger);

	Boolean deletePassenger(Passenger passenger);

	Passenger findPassengerById(Integer id);

	List<Passenger> findAllPassengers();

	List<Passenger> findAllPassengersByCarId(
			Integer carId);

	List<Passenger> findAllPassengersByFlightId(Integer flightId);

	Passenger authentication(String email, String password);

}
