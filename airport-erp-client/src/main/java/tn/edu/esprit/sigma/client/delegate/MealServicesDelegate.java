package tn.edu.esprit.sigma.client.delegate;

import java.util.List;

import services.interfaces.MealServicesRemote;
import tn.edu.esprit.sigma.client.locator.ServiceLocator;
import entities.Meal;
import entities.Passenger;
import entities.Provider;

public class MealServicesDelegate {
	
	private static final String jndi="airport-erp/MealServices!services.interfaces.MealServicesRemote";
	private static MealServicesRemote getProxy()
	{
		return (MealServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
public static	Boolean doAddMeal (Meal meal)
	{
		return getProxy().addMeal(meal);
	}
public static	Boolean doUpdateMeal (Meal meal)
	{
		return getProxy().updateMeal(meal);
	}
public static	Boolean doDeleteMeal (Meal meal)
	{
		return getProxy().deleteMeal(meal);
	}
public static	Meal doFindMealById (Integer idMeal)
	{
		return getProxy().findMealById(idMeal);
	}
public static	List<Meal> doFindAllMeals()
	{
		return getProxy().findAllMeals();
	}
public static	List<Meal> doFindAllMealsBoughtByPassenger(Passenger passenger)
	{
		return getProxy().findAllMealsBoughtByPassenger(passenger);
	}
public static	List<Meal> doFindAllMealsAddedByProvider(Provider provider)
	{
		return getProxy().findAllMealsAddedByProvider(provider);
	}

}
