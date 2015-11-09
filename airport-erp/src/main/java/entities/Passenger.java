package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Passenger
 *
 */
@Entity
@Table(name = "t_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "function")
@DiscriminatorValue(value = "passenger")
public class Passenger implements Serializable {

	private Integer id;
	private String lastName;
	private String firstName;
	private String sexe;
	private Date birthDate;
	private Number phoneNumber;
	private String email;
	private String password;
	private static final long serialVersionUID = 1L;

	private List<Ticket> tickets;
	private List<Meal> meals;
	private List<CarBooking> carBookings;

	public Passenger() {
		super();
	}

	public Passenger(String lastName, String firstName, String sexe,
			Date birthDate, Number phoneNumber, String email, String password) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.sexe = sexe;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Column(name = "birth_date")
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "phone_number")
	public Number getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Number phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "passenger", cascade = CascadeType.MERGE)
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public void linkTicketsToThisPassenger(List<Ticket> tickets) {
		this.tickets = tickets;
		for (Ticket t : tickets) {
			t.setPassenger(this);
		}
	}

	@OneToMany(mappedBy = "passenger", cascade = CascadeType.MERGE)
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public void linkMealsToThisPassenger(List<Meal> meals) {
		this.meals = meals;
		for (Meal m : meals) {
			m.setPassenger(this);
		}
	}

	@OneToMany(mappedBy = "passenger", cascade = CascadeType.MERGE)
	public List<CarBooking> getCarBookings() {
		return carBookings;
	}

	public void setCarBookings(List<CarBooking> carBookings) {
		this.carBookings = carBookings;
	}

	public void linkCarBookingsToThisPassenger(List<CarBooking> carBookings) {
		this.carBookings = carBookings;
		for (CarBooking b : carBookings) {
			b.setPassenger(this);
		}
	}

}
