package tn.edu.esprit.sigma.client.delegate;

import java.util.List;

import services.interfaces.TicketServicesRemote;
import tn.edu.esprit.sigma.client.locator.ServiceLocator;
import entities.FlightCategory;
import entities.Ticket;

public class TicketServicesDelegate {

	private static final String jndi = "airport-erp/TicketServices!services.interfaces.TicketServicesRemote";

	private static TicketServicesRemote getProxy() {
		return (TicketServicesRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}

	public static Boolean doAddTicket(Ticket ticket) {
		return getProxy().addTicket(ticket);
	}

	public static Boolean doUpdateTicket(Ticket ticket) {
		return getProxy().updateTicket(ticket);
	}

	public static Boolean doDeleteTicket(Ticket ticket) {
		return getProxy().deleteTicket(ticket);
	}

	public static Ticket doFindTicketByFlightIdAndPassengerIdd(
			Integer idPassenger, Integer idFlight) {
		return getProxy().findTicketByFlightIdAndPassengerId(idPassenger,
				idFlight);
	}

	public static List<Ticket> doFindAllTickets() {
		return getProxy().findAllTickets();
	}

	public static List<Ticket> doFindAllTicketsByPassengerId(Integer passengerId) {
		return getProxy().findAllTicketsByPassengerId(passengerId);
	}

	public static List<Ticket> doFindAllTicketsByFlightId(Integer flightId) {
		return getProxy().findAllTicketsByFlightId(flightId);
	}

	public static Boolean doBookTicketBis(Integer idPassenger,
			Integer idFlight, FlightCategory flightCategory) {
		return getProxy().bookTicketBis(idPassenger, idFlight, flightCategory);

	}

}
