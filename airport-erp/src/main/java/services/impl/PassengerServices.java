package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.PassengerServicesLocal;
import services.interfaces.PassengerServicesRemote;
import entities.Passenger;

/**
 * Session Bean implementation class PassengerServices
 */
@Stateless
public class PassengerServices implements PassengerServicesRemote,
		PassengerServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PassengerServices() {
	}

	@Override
	public Boolean addPassenger(Passenger passenger) {
		Boolean b = false;
		try {
			entityManager.persist(passenger);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updatePassenger(Passenger passenger) {
		Boolean b = false;
		try {
			entityManager.merge(passenger);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deletePassenger(Passenger passenger) {
		Boolean b = false;
		try {
			passenger = findPassengerById(passenger.getId());
			entityManager.remove(passenger);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Passenger findPassengerById(Integer id) {
		return entityManager.find(Passenger.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Passenger> findAllPassengers() {
		String jpql = "select p from Passenger p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Passenger> findAllPassengersByCarId(Integer carId) {
		String jpql = "select p from Passenger p  where :param member of p.cars";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("n", carId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Passenger> findAllPassengersByFlightId(Integer flightId) {
		String jpql = "select p from Passenger p join p.tickets t where t.idFlight=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", flightId);
		return query.getResultList();
	}

	@Override
	public Passenger authentication(String email, String password) {
		Passenger passenger = null;
		String jpql = "select p from Passenger p where p.email= :param1 and p.password= :param2 ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", email).setParameter("param2", password);
		try {
			passenger = (Passenger) query.getSingleResult();
			System.out.println("le nom est: " + passenger.getFirstName());
		} catch (Exception e) {
			passenger = null;
		}
		return passenger;

	}

}
