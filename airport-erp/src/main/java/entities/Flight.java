package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@Table(name = "t_flight")
public class Flight implements Serializable {

	private Integer id;
	private Date dateDeparture;
	private Date dateArrival;
	private String destination;
	private Map<FlightCategory, Float> priceMap = new HashMap<FlightCategory, Float>();
	private Map<FlightCategory, Integer> freePlacesMap = new HashMap<>();

	private String company;
	private static final long serialVersionUID = 1L;

	private List<Ticket> tickets;

	public Flight() {
		super();
	}

	public Flight(Date dateDeparture, Date dateArrival, String destination,
			String company, Map<FlightCategory, Float> priceMap,
			Map<FlightCategory, Integer> freePlacesMap) {
		super();
		this.dateDeparture = dateDeparture;
		this.dateArrival = dateArrival;
		this.destination = destination;
		this.company = company;
		this.priceMap = priceMap;
		this.freePlacesMap = freePlacesMap;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "date_departure")
	public Date getDateDeparture() {
		return this.dateDeparture;
	}

	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	@Column(name = "date_arrival")
	public Date getDateArrival() {
		return this.dateArrival;
	}

	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@OneToMany(mappedBy = "flight", cascade = CascadeType.MERGE)
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public void linkTicketsToThisFlight(List<Ticket> tickets) {
		this.tickets = tickets;
		for (Ticket t : tickets) {
			t.setFlight(this);
		}
	}

	@ElementCollection(fetch = FetchType.EAGER)
	public Map<FlightCategory, Float> getPriceMap() {
		return priceMap;
	}

	public void setPriceMap(Map<FlightCategory, Float> priceMap) {
		this.priceMap = priceMap;
	}

	@ElementCollection(fetch = FetchType.EAGER)
	public Map<FlightCategory, Integer> getFreePlacesMap() {
		return freePlacesMap;
	}

	public void setFreePlacesMap(Map<FlightCategory, Integer> freePlacesMap) {
		this.freePlacesMap = freePlacesMap;
	}

}
