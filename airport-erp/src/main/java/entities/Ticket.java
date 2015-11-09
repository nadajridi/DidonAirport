package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity
@Table(name = "t_ticket")
public class Ticket implements Serializable {

	private TicketID ticketID;
	private float price;
	private FlightCategory flightCategory;
	private Passenger passenger;
	private Flight flight;
	private static final long serialVersionUID = 1L;

	public Ticket() {
		super();
	}

	public Ticket(Passenger passenger, Flight flight,
			FlightCategory flightCategory) {
		this.ticketID = new TicketID(passenger.getId(), flight.getId());
		this.price = flight.getPriceMap().get(flightCategory);
		this.flightCategory = flightCategory;
		this.passenger = passenger;
		this.flight = flight;
	}

	@EmbeddedId
	public TicketID getTicketID() {
		return this.ticketID;
	}

	public void setTicketID(TicketID ticketID) {
		this.ticketID = ticketID;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@ManyToOne
	@JoinColumn(name = "idPassenger", referencedColumnName = "id", updatable = false, insertable = false)
	public Passenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@ManyToOne
	@JoinColumn(name = "idFlight", referencedColumnName = "id", updatable = false, insertable = false)
	public Flight getFlight() {
		return this.flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public FlightCategory getFlightCategory() {
		return flightCategory;
	}

	public void setFlightCategory(FlightCategory flightCategory) {
		this.flightCategory = flightCategory;
	}

}
