package tn.edu.esprit.sigma.client.delegate;

import java.util.List;

import services.interfaces.CarRentalAgencyServicesRemote;
import tn.edu.esprit.sigma.client.locator.ServiceLocator;
import entities.CarRentalAgency;

public class CarRentalAgencyServicesDelegate {
	
	private static final String jndi="airport-erp/CarRentalAgencyServices!services.interfaces.CarRentalAgencyServicesRemote";
	private static CarRentalAgencyServicesRemote getProxy()
	{
		return (CarRentalAgencyServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
public static	Boolean doAddCarRentalAgency (CarRentalAgency agency)
	{
		return getProxy().addCarRentalAgency(agency);
	}
public static	Boolean doUpdateCarRentalAgency (CarRentalAgency agency)
	{
		return getProxy().updateCarRentalAgency(agency);
	}
public static	Boolean doDeleteCarRentalAgency (CarRentalAgency agency)
	{
		return getProxy().deleteCarRentalAgency(agency);
	}
public static	CarRentalAgency doFindCarRentalAgencyByID (Integer id)
	{
		return getProxy().findCarRentalAgencyById(id);
	}
public static	List<CarRentalAgency> doFindAllCarRentalAgencies()
	{
		return getProxy().findAllCarRentalAgencies();
	}

}
