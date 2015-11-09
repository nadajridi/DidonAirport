package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.CarRentalAgency;

@Local
public interface CarRentalAgencyServicesLocal {
	
	Boolean addCarRentalAgency (CarRentalAgency agency);
	Boolean updateCarRentalAgency (CarRentalAgency agency);
	Boolean deleteCarRentalAgency (CarRentalAgency agency);
	CarRentalAgency findCarRentalAgencyById (Integer id);
	List<CarRentalAgency> findAllCarRentalAgencies();

}
