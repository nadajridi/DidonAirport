package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Meal;
import entities.Passenger;
import entities.Provider;
import services.interfaces.MealServicesLocal;
import services.interfaces.MealServicesRemote;

/**
 * Session Bean implementation class MealServices
 */
@Stateless
public class MealServices implements MealServicesRemote, MealServicesLocal {

	
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public MealServices() { }

	@Override
	public Boolean addMeal(Meal meal) {
		Boolean b = false;
		try {
			entityManager.persist(meal);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateMeal(Meal meal) {
		Boolean b = false;
		try {
			entityManager.merge(meal);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteMeal(Meal meal) {
		Boolean b = false;
		try {
			meal = findMealById(meal.getId());
			entityManager.remove(meal);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Meal findMealById(Integer id) {
		return entityManager.find(Meal.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meal> findAllMeals() {

		String jpql = "select m from Meal m";
		Query query =entityManager.createQuery(jpql);
		return  query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meal> findAllMealsBoughtByPassenger(Passenger passenger) {
		String jpql = "select m from Meal m where m.passenger=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", passenger);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meal> findAllMealsAddedByProvider(Provider provider) {
		String jpql = "select m from Meal m where m.provider=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", provider);
		return query.getResultList();
	}

}
