package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Meal;
import entities.Passenger;
import entities.Provider;

@Local
public interface MealServicesLocal {
	
	Boolean addMeal (Meal meal);
	Boolean updateMeal (Meal meal);
	Boolean deleteMeal (Meal meal);
	Meal findMealById (Integer id);
	List<Meal> findAllMeals();
	List<Meal> findAllMealsBoughtByPassenger(Passenger passenger);
	List<Meal> findAllMealsAddedByProvider(Provider provider);

}
