package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Provider;
import services.interfaces.ProviderServicesLocal;
import services.interfaces.ProviderServicesRemote;

/**
 * Session Bean implementation class ProviderServices
 */
@Stateless
public class ProviderServices implements ProviderServicesRemote, ProviderServicesLocal {

	
	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public ProviderServices() {}

	@Override
	public Boolean addProvider(Provider provider) {
		Boolean b = false;
		try {
			entityManager.persist(provider);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateProvider(Provider provider) {
		Boolean b = false;
		try {
			entityManager.merge(provider);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteProvider(Provider provider) {
		Boolean b = false;
		try {
			provider = findProviderById(provider.getId());
			entityManager.remove(provider);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Provider findProviderById(Integer id) {

		return entityManager.find(Provider.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provider> findAllProviders() {
		String jpql = "select p from Provider p";
		Query query =entityManager.createQuery(jpql);
		return  query.getResultList();
	}

}
