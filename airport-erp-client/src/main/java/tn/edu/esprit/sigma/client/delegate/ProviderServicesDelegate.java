package tn.edu.esprit.sigma.client.delegate;

import java.util.List;

import services.interfaces.ProviderServicesRemote;
import tn.edu.esprit.sigma.client.locator.ServiceLocator;
import entities.Provider;

public class ProviderServicesDelegate {
	
	private static final String jndi="airport-erp/ProviderServices!services.interfaces.ProviderServicesRemote";
	private static ProviderServicesRemote getProxy()
	{
		return (ProviderServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
public static	Boolean doAddProvider (Provider provider)
	{
		return getProxy().addProvider(provider);
	}
public static	Boolean doUpdateProvider (Provider provider)
	{
		return getProxy().updateProvider(provider);
	}
public static	Boolean doDeleteProvider (Provider provider)
	{
		return getProxy().deleteProvider(provider);
	}
public static	Provider doFindProviderById (Integer idProvider)
	{
		return getProxy().findProviderById(idProvider);
	}
public static	List<Provider> doFindAllProviders()
	{
		return getProxy().findAllProviders();
	}

}
