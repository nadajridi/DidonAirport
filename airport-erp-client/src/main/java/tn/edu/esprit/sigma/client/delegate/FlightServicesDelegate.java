package tn.edu.esprit.sigma.client.delegate;

import java.util.List;

import services.interfaces.FlightServicesRemote;
import tn.edu.esprit.sigma.client.locator.ServiceLocator;
import entities.Flight;

public class FlightServicesDelegate {
	
	private static final String jndi="airport-erp/FlightServices!services.interfaces.FlightServicesRemote";
	private static FlightServicesRemote getProxy()
	{
		return (FlightServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
public static	Boolean doAddFlight (Flight flight)
	{
		return getProxy().addFlight(flight);
	}
public static	Boolean doUpdateFlight (Flight flight)
	{
		return getProxy().updateFlight(flight);
	}
public static	Boolean doDeleteFlight (Flight flight)
	{
		return getProxy().deleteFlight(flight);
	}
public static	Flight doFindFlightById (Integer idFlight)
	{
		return getProxy().findFlightById(idFlight);
	}
public static	List<Flight> doFindAllFlights()
	{
		return getProxy().findAllFlights();
	}
public static	List<Flight> doFindAllFlightsByPassengerId(Integer idPassenger)
	{
		return getProxy().findAllFlightsByPassengerId(idPassenger);
	}

}
