package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Car;

@Local
public interface CarServicesLocal {

	Boolean addCar(Car car);

	Boolean updateCar(Car car);

	Boolean deleteCar(Car car);

	Car findCarById(Integer id);

	List<Car> findAllCars();

	List<Car> findAllCarsByPassengerId(Integer idPassenger);

	List<Car> findAllCarsByCarRentalAgencyId(Integer carRentalAgencyId);
}
