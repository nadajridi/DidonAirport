package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CarRentalAgency;
import services.interfaces.CarRentalAgencyServicesLocal;
import services.interfaces.CarRentalAgencyServicesRemote;

/**
 * Session Bean implementation class CarRentalAgencyServices
 */
@Stateless
public class CarRentalAgencyServices implements CarRentalAgencyServicesRemote, CarRentalAgencyServicesLocal {

	
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CarRentalAgencyServices() {}

	@Override
	public Boolean addCarRentalAgency(CarRentalAgency agency) {

		Boolean b = false;
		try {
			entityManager.persist(agency);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateCarRentalAgency(CarRentalAgency agency) {
		Boolean b = false;
		try {
			entityManager.merge(agency);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteCarRentalAgency(CarRentalAgency agency) {
		Boolean b = false;
		try {
			agency = findCarRentalAgencyById(agency.getId());
			entityManager.remove(agency);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public CarRentalAgency findCarRentalAgencyById(Integer id) {
		return entityManager.find(CarRentalAgency.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarRentalAgency> findAllCarRentalAgencies() {
		String jpql = "select ag from CarRentalAgency ag";
		Query query =entityManager.createQuery(jpql);
		return  query.getResultList();
	}

	

}
