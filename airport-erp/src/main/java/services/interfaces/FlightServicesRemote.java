package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Flight;

@Remote
public interface FlightServicesRemote {
	
	Boolean addFlight (Flight flight);
	Boolean updateFlight (Flight flight);
	Boolean deleteFlight (Flight flight);
	Flight findFlightById (Integer id);
	List<Flight> findAllFlights();
	List<Flight> findAllFlightsByPassengerId(Integer idPassenger);
	

	

}
