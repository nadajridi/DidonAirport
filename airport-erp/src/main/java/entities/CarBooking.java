package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CarBooking
 *
 */
@Entity
@Table(name = "t_car_booking")
public class CarBooking implements Serializable {

	private CarBookingId carBookingId;
	private Date startDate;
	private Date endDate;
	private float priceOfRent;
	private Passenger passenger;
	private Car car;
	private static final long serialVersionUID = 1L;

	public CarBooking() {
		super();
	}

	public CarBooking(Car car, Passenger passenger, Date startDate,
			Date endDate, float priceOfRent) {
		super();
		this.carBookingId = new CarBookingId(car.getId(), passenger.getId());
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceOfRent = priceOfRent;
		this.car = car;
		this.passenger = passenger;
	}

	@EmbeddedId
	public CarBookingId getCarBookingId() {
		return this.carBookingId;
	}

	public void setCarBookingId(CarBookingId carBookingId) {
		this.carBookingId = carBookingId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getPriceOfRent() {
		return this.priceOfRent;
	}

	public void setPriceOfRent(float priceOfRent) {
		this.priceOfRent = priceOfRent;
	}

	@ManyToOne
	@JoinColumn(name = "idPassenger", referencedColumnName = "id", updatable = false, insertable = false)
	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@ManyToOne
	@JoinColumn(name = "idCar", referencedColumnName = "id", updatable = false, insertable = false)
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
