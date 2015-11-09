package services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.FlightServicesLocal;
import services.interfaces.PassengerServicesLocal;
import services.interfaces.TicketServicesLocal;
import services.interfaces.TicketServicesRemote;
import entities.Flight;
import entities.FlightCategory;
import entities.Passenger;
import entities.Ticket;

/**
 * Session Bean implementation class TicketServices
 */
@Stateless
public class TicketServices implements TicketServicesRemote,
		TicketServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private PassengerServicesLocal passengerServicesLocal;
	@EJB
	private FlightServicesLocal flightServicesLocal;
	@EJB
	private TicketServicesLocal ticketServicesLocal;

	/**
	 * Default constructor.
	 */
	public TicketServices() {
	}

	@Override
	public Boolean addTicket(Ticket ticket) {
		Boolean b = false;
		try {
			entityManager.persist(ticket);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateTicket(Ticket ticket) {
		Boolean b = false;
		try {
			entityManager.merge(ticket);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteTicket(Ticket ticket) {
		Boolean b = false;
		Passenger passenger = ticket.getPassenger();
		Flight flight = ticket.getFlight();
		try {
			ticket = findTicketByFlightIdAndPassengerId(passenger.getId(),
					flight.getId());
			entityManager.remove(ticket);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAllTickets() {

		String jpql = "select t from Ticket t";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAllTicketsByPassengerId(Integer passengerId) {
		Passenger passenger = passengerServicesLocal
				.findPassengerById(passengerId);
		String jpql = "select t from Ticket t where t.passenger=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", passenger);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAllTicketsByFlightId(Integer flightId) {
		Flight flight = flightServicesLocal.findFlightById(flightId);
		String jpql = "select t from Ticket t where t.flight=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", flight);
		return query.getResultList();
	}

	@Override
	public Boolean bookTicketBis(Integer idPassenger, Integer idFlight,
			FlightCategory flightCategory) {
		Boolean b = false;
		Passenger passenger = passengerServicesLocal
				.findPassengerById(idPassenger);
		Flight flight = flightServicesLocal.findFlightById(idFlight);

		if (flight.getFreePlacesMap().get(flightCategory) > 0) {
			Ticket ticket = new Ticket(passenger, flight, flightCategory);
			entityManager.persist(ticket);

			flight.getFreePlacesMap().put(flightCategory,
					flight.getFreePlacesMap().get(flightCategory) - 1);
			b = true;

		} else {
			System.out.println("not enough places ...");
		}

		return b;
	}

	@Override
	public Ticket findTicketByFlightIdAndPassengerId(Integer idPassenger,
			Integer idFlight) {
		Passenger passenger = passengerServicesLocal
				.findPassengerById(idPassenger);
		Flight flight = flightServicesLocal.findFlightById(idFlight);
		String jpql = "select t from Ticket t where t.passenger=:param1 and t.flight=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", passenger).setParameter("param2", flight);
		Object result = query.getSingleResult();
		return (Ticket) result;
	}

}
