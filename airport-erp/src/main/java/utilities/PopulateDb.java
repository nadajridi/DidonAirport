package utilities;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import services.interfaces.CarRentalAgencyServicesLocal;
import services.interfaces.CarServicesLocal;
import services.interfaces.FlightServicesLocal;
import services.interfaces.PassengerServicesLocal;
import entities.Car;
import entities.CarCategory;
import entities.CarRentalAgency;
import entities.CarState;
import entities.Flight;
import entities.FlightCategory;
import entities.Passenger;

/**
 * Session Bean implementation class PopulateDb
 */
@Singleton
@LocalBean
@Startup
public class PopulateDb {
	@EJB
	private PassengerServicesLocal passengerServicesLocal;
	@EJB
	private FlightServicesLocal flightServicesLocal;
	@EJB
	private CarServicesLocal carServicesLocal;
	@EJB
	private CarRentalAgencyServicesLocal carRentalAgencyServicesLocal;

	/**
	 * Default constructor.
	 */
	public PopulateDb() {
	}

	@PostConstruct
	public void initDb() {
		Passenger passenger = new Passenger("jridi", "nada", "F",
				DateParser.convertStringToDate("28/12/1991"), 2123,
				"nada@esprit.tn", "nada");
		Passenger passenger2 = new Passenger("Ben Mohamed", "Salah", "M",
				DateParser.convertStringToDate("05/01/1991"), 3214,
				"salah@esprit.tn", "salah");

		Passenger passenger3 = new Passenger("rezgui", "Ali", "M",
				DateParser.convertStringToDate("05/01/2015"), 3658,
				"Ali@esprit.tn", "Ali");

		Map<FlightCategory, Float> priceMap = new HashMap<>();
		priceMap.put(FlightCategory.ECONOMY, 100F);
		priceMap.put(FlightCategory.BUSINESS, 120F);
		priceMap.put(FlightCategory.VIP, 150F);

		Map<FlightCategory, Integer> freePlacesMap = new HashMap<FlightCategory, Integer>();
		freePlacesMap.put(FlightCategory.BUSINESS, 50);
		freePlacesMap.put(FlightCategory.ECONOMY, 100);
		freePlacesMap.put(FlightCategory.VIP, 10);

		Flight flight = new Flight(
				DateParser.convertStringToDate("04/12/2015"),
				DateParser.convertStringToDate("05/12/2015"), "France",
				"Tunisair", priceMap, freePlacesMap);

		CarRentalAgency carRentalAgency = new CarRentalAgency(
				"mycar@gmail.com", "My Car", "Slim Khaskhoussi", 22356254,
				"mycar");
		CarRentalAgency carRentalAgency2 = new CarRentalAgency(
				"bestcar@gmail.com", "Best Car", "Amine Ben Salem", 55682301,
				"bestcar");

		carRentalAgencyServicesLocal.addCarRentalAgency(carRentalAgency);
		carRentalAgencyServicesLocal.addCarRentalAgency(carRentalAgency2);

		Car car = new Car("168TUN205", "BMW", CarCategory.SPORTS,
				CarState.AVAILABLE, "voiture toute neuve", 120, carRentalAgency);
		Car car2 = new Car("120TUN6520", "Clio", CarCategory.ECONOMIC,
				CarState.AVAILABLE, "voiture de consommation basse", 60,
				carRentalAgency2);
		Car car3 = new Car("120TUN3220", "Peugeot", CarCategory.CLASSIC,
				CarState.AVAILABLE, "voiture en bon état", 80, carRentalAgency2);

		passengerServicesLocal.addPassenger(passenger);
		passengerServicesLocal.addPassenger(passenger2);
		passengerServicesLocal.addPassenger(passenger3);

		flightServicesLocal.addFlight(flight);

		carServicesLocal.addCar(car);
		carServicesLocal.addCar(car2);
		carServicesLocal.addCar(car3);

	}
}
