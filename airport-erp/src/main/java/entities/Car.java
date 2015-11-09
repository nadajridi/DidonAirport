package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Car
 *
 */
@Entity
@Table(name = "t_car")
public class Car implements Serializable {

	private Integer id;
	private String registrationNumber;
	private String brand;
	private CarCategory category;
	@Enumerated(EnumType.STRING)
	private CarState state;
	private String description;
	private float price;
	private List<CarBooking> carBookings;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private CarRentalAgency agency;

	public Car() {
		super();
	}

	public Car(String registrationNumber, String brand, CarCategory category,
			CarState state, String description, float price,
			CarRentalAgency agency) {
		super();
		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.category = category;
		this.state = state;
		this.description = description;
		this.price = price;
		this.agency = agency;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public CarCategory getCategory() {
		return category;
	}

	public void setCategory(CarCategory category) {
		this.category = category;
	}

	public CarState getState() {
		return state;
	}

	public void setState(CarState state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "idCarRentalAgency", referencedColumnName = "id", updatable = false, insertable = true)
	public CarRentalAgency getAgency() {
		return agency;
	}

	public void setAgency(CarRentalAgency agency) {
		this.agency = agency;
	}

	@OneToMany(mappedBy = "car", cascade = CascadeType.MERGE)
	public List<CarBooking> getCarBookings() {
		return carBookings;
	}

	public void setCarBookings(List<CarBooking> carBookings) {
		this.carBookings = carBookings;
	}

	public void linkCarBookingsToThisCar(List<CarBooking> carBookings) {
		this.carBookings = carBookings;
		for (CarBooking b : carBookings) {
			b.setCar(this);
		}
	}
}
