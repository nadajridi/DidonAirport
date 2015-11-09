package services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.CarRentalAgencyServicesLocal;
import services.interfaces.CarServicesLocal;
import services.interfaces.CarServicesRemote;
import services.interfaces.PassengerServicesLocal;
import entities.Car;
import entities.CarRentalAgency;
import entities.Passenger;

/**
 * Session Bean implementation class CarServices
 */
@Stateless
public class CarServices implements CarServicesRemote, CarServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private PassengerServicesLocal passengerServicesLocal;
	@EJB
	private CarRentalAgencyServicesLocal carRentalAgencyServicesLocal;

	/**
	 * Default constructor.
	 */
	public CarServices() {
	}

	@Override
	public Boolean addCar(Car car) {
		Boolean b = false;
		try {
			entityManager.persist(car);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateCar(Car car) {
		Boolean b = false;
		try {
			entityManager.merge(car);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteCar(Car car) {
		Boolean b = false;
		try {
			car = findCarById(car.getId());
			entityManager.remove(car);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Car findCarById(Integer id) {
		return entityManager.find(Car.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> findAllCars() {
		String jpql = "select c from Car c";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> findAllCarsByPassengerId(Integer idPassenger) {
		Passenger passenger = passengerServicesLocal
				.findPassengerById(idPassenger);
		String jpql = "select c from Car c  where :param member of c.passengers";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", passenger);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> findAllCarsByCarRentalAgencyId(Integer carRentalAgencyId) {
		CarRentalAgency agency = carRentalAgencyServicesLocal
				.findCarRentalAgencyById(carRentalAgencyId);
		String jpql = "select c from Car c where c.agency=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", agency);
		return query.getResultList();
	}

}
