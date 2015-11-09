package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Provider;

@Remote
public interface ProviderServicesRemote {
	
	Boolean addProvider (Provider provider);
	Boolean updateProvider (Provider provider);
	Boolean deleteProvider (Provider provider);
	Provider findProviderById (Integer idProvider);
	List<Provider> findAllProviders();

}
