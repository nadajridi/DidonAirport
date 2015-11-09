package services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Flight;
import entities.Passenger;
import services.interfaces.FlightServicesLocal;
import services.interfaces.FlightServicesRemote;
import services.interfaces.PassengerServicesLocal;

/**
 * Session Bean implementation class FlightServices
 */
@Stateless
public class FlightServices implements FlightServicesRemote, FlightServicesLocal {

	
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private PassengerServicesLocal passengerServicesLocal;
	
	
    /**
     * Default constructor. 
     */
    public FlightServices() {}

	@Override
	public Boolean addFlight(Flight flight) {
		Boolean b = false;
		try {
			entityManager.persist(flight);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateFlight(Flight flight) {
		Boolean b = false;
		try {
			entityManager.merge(flight);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteFlight(Flight flight) {
		Boolean b = false;
		try {
			flight = findFlightById(flight.getId());
			entityManager.remove(flight);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Flight findFlightById(Integer id) {
		return entityManager.find(Flight.class, id);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findAllFlights() {

		String jpql = "select f from Flight f";
		Query query =entityManager.createQuery(jpql);
		return  query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findAllFlightsByPassengerId(Integer idPassenger) {
		Passenger passenger=passengerServicesLocal.findPassengerById(idPassenger);
		String jpql = "select f from Flight f join f.tickets t where t.passenger=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", passenger);
		return query.getResultList();
	}

	

	



}
