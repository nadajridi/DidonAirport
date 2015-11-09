package tn.edu.esprit.sigma.client.delegate;

import java.util.List;

import services.interfaces.CarServicesRemote;
import tn.edu.esprit.sigma.client.locator.ServiceLocator;
import entities.Car;

public class CarServicesDelegate {

	private static final String jndi = "airport-erp/CarServices!services.interfaces.CarServicesRemote";

	private static CarServicesRemote getProxy() {
		return (CarServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean doAddCar(Car car) {
		return getProxy().addCar(car);
	}

	public static Boolean doUpdateCar(Car car) {
		return getProxy().updateCar(car);
	}

	public static Boolean doDeleteCar(Car car) {
		return getProxy().deleteCar(car);
	}

	public static Car doFindCarById(Integer id) {
		return getProxy().findCarById(id);
	}

	public static List<Car> doFindAllCars() {
		return getProxy().findAllCars();
	}

	public static List<Car> doFindAllCarsByPassengerId(Integer idPassenger) {
		return getProxy().findAllCarsByPassengerId(idPassenger);
	}

	public static List<Car> doFindAllCarsByCarRentalAgencyId(
			Integer carRentalAgencyId) {
		return getProxy().findAllCarsByCarRentalAgencyId(carRentalAgencyId);
	}

}
