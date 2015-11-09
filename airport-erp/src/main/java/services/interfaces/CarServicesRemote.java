package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Car;

@Remote
public interface CarServicesRemote {

	Boolean addCar(Car car);

	Boolean updateCar(Car car);

	Boolean deleteCar(Car car);

	Car findCarById(Integer id);

	List<Car> findAllCars();

	List<Car> findAllCarsByPassengerId(Integer idPassenger);

	List<Car> findAllCarsByCarRentalAgencyId(Integer carRentalAgencyId);

}
