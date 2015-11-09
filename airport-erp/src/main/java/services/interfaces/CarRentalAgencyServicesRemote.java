package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.CarRentalAgency;

@Remote
public interface CarRentalAgencyServicesRemote {
	
	Boolean addCarRentalAgency (CarRentalAgency agency);
	Boolean updateCarRentalAgency (CarRentalAgency agency);
	Boolean deleteCarRentalAgency (CarRentalAgency agency);
	CarRentalAgency findCarRentalAgencyById (Integer id);
	List<CarRentalAgency> findAllCarRentalAgencies();

}
