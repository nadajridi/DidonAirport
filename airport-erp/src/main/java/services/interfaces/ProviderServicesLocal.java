package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Provider;

@Local
public interface ProviderServicesLocal {
	
	Boolean addProvider (Provider provider);
	Boolean updateProvider (Provider provider);
	Boolean deleteProvider (Provider provider);
	Provider findProviderById (Integer idProvider);
	List<Provider> findAllProviders();

}
