package client.service.create;

import java.util.ArrayList;
import java.util.List;

public class PersonCreateServiceProxiesPool {
	
	private static final int SIZE = 5;
	
	private static PersonCreateServiceProxiesPool instance;
	
	List<PersonCreateServiceProxy> proxies;
	
	private PersonCreateServiceProxiesPool() {
		proxies = new ArrayList<>(SIZE);
		for (int i=0;i<SIZE;i++) {
			proxies.add(new PersonCreateServiceProxy());
		}
	}
	
	public static PersonCreateServiceProxiesPool getPool() {
		if (instance == null) {
			instance = new PersonCreateServiceProxiesPool();
		}
		return instance;
	}
	
	public synchronized PersonCreateServiceProxy getProxy() {
		PersonCreateServiceProxy result = null;
		
		for (PersonCreateServiceProxy proxyFromList : proxies) {
			if (proxyFromList.isFree) {
				proxyFromList.isFree = false;
				result = proxyFromList;
			}
		}
		
		return result;
	}

	public synchronized boolean returnProxy(PersonCreateServiceProxy proxy) {
		boolean isOk = false;
		
		for (PersonCreateServiceProxy proxyFromList : proxies) {
			if (proxy.equals(proxyFromList) && proxyFromList.isFree==false) {
				proxyFromList.isFree = true;
				isOk = true;
				break;
			}
		}
		
		return isOk;
	}
	
}
