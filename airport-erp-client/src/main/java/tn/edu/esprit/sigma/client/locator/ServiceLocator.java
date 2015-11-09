package tn.edu.esprit.sigma.client.locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {

	private static ServiceLocator instance;
	private Context context;
	private Map<String, Object> cache;

	private ServiceLocator() {

		try {
			context = new InitialContext();
			cache = new HashMap<String, Object>();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Object getProxy(String jndi) {

		Object proxy = null;
		proxy = cache.get(jndi);
//		if (proxy != null)
//			return proxy;
//		else
//			try {
//				proxy = context.lookup(jndi);
//				cache.put(jndi, proxy);
//			} catch (NamingException e) {
//			
//				e.printStackTrace();
//			}
		
		if (proxy == null) {
			try {
				proxy = context.lookup(jndi);
				cache.put(jndi, proxy);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return proxy;
	}

	public static ServiceLocator getInstance() {

		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}
}
