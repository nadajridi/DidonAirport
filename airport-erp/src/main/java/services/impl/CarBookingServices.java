package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Car;
import entities.CarBooking;
import entities.CarState;
import entities.Passenger;
import services.interfaces.CarBookingServicesLocal;
import services.interfaces.CarBookingServicesRemote;
import services.interfaces.CarServicesLocal;
import services.interfaces.PassengerServicesLocal;

/**
 * Session Bean implementation class CarBookingServices
 */
@Stateless
public class CarBookingServices implements CarBookingServicesRemote, CarBookingServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private PassengerServicesLocal passengerServicesLocal;
	@EJB
	private CarServicesLocal carServicesLocal;
	@EJB
	private CarBookingServicesLocal carBookingServicesLocal;
    /**
     * Default constructor. 
     */
    public CarBookingServices() {
    }

	@Override
	public Boolean addBooking(CarBooking carBooking) {
		Boolean b = false;
		try {
			entityManager.persist(carBooking);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateBooking(CarBooking carBooking) {
		Boolean b = false;
		try {
			entityManager.merge(carBooking);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteBooking(CarBooking carBooking) {
		Boolean b = false;
		Passenger passenger = carBooking.getPassenger();
		Car car = carBooking.getCar();
		try {
			carBooking = findBookingByCarIdAndPassengerId(passenger.getId(), car.getId());
			entityManager.remove(carBooking);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public CarBooking findBookingByCarIdAndPassengerId(Integer idPassenger,
			Integer idCar) {
		Passenger passenger = passengerServicesLocal
				.findPassengerById(idPassenger);
		Car car = carServicesLocal.findCarById(idCar);
		String jpql = "select b from CarBooking b where b.passenger=:param1 and b.car=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", passenger).setParameter("param2", car);
		Object result = query.getSingleResult();
		return (CarBooking) result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarBooking> findAllBookings() {
		String jpql = "select b from CarBooking b";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarBooking> findAllBookingsByPassengerId(Integer passengerId) {
		Passenger passenger = passengerServicesLocal
				.findPassengerById(passengerId);
		String jpql = "select b from CarBooking b where b.passenger=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", passenger);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarBooking> findAllBookingsByCarId(Integer carId) {
		Car car = carServicesLocal.findCarById(carId);
		String jpql = "select b from CarBooking b where b.car=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", car);
		return query.getResultList();
	}

	@Override
	public Boolean rentCar(Car car, Passenger passenger, Date startDate,
			Date endDate) {
		Boolean result = false;
		float priceOfRent = carBookingServicesLocal.priceOfRent(car, startDate, endDate);
		Date today = new java.util.Date();
		if (startDate.compareTo(today) < 0)
			result = false;
		else{
			CarBooking carBooking = new CarBooking(car, passenger, startDate, endDate, priceOfRent);
			car.setState(CarState.RENTED);
			entityManager.persist(carBooking);
			result = true;
		}
		return result;
		
	}

	@Override
	public float priceOfRent(Car car, Date startDate, Date endDate) {
		float price;
		long period;
		period = endDate.getTime() - startDate.getTime();
		period = period / 1000 / 60 / 60 / 24;
		price = period * car.getPrice();
		return price;
	}

}
