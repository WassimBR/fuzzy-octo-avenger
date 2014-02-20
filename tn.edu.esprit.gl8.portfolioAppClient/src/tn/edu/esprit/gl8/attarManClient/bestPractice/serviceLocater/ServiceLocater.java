package tn.edu.esprit.gl8.attarManClient.bestPractice.serviceLocater;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocater {
	private Context context;
	private Map<String, Object> cache;
	private static ServiceLocater instance;

	private ServiceLocater() {
		cache = new HashMap<String, Object>();
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static ServiceLocater getInstance() {
		if (instance == null) {
			instance = new ServiceLocater();
		}
		return instance;
	}

	public Object getProxy(String jndiName) {
		Object proxy = null;
		proxy = cache.get(jndiName);
		if (proxy == null) {

			try {
				proxy = context.lookup(jndiName);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			cache.put(jndiName, proxy);
		}
		return proxy;
	}

}









