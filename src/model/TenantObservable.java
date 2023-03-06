package model;

import java.util.ArrayList;
import java.util.List;

public class TenantObservable {
	private List<TenantObserver> observers = new ArrayList<TenantObserver>();
	
	public void attach(TenantObserver observer) {
		this.observers.add(observer);
	}
	
	public void detach(TenantObserver observer) {
		if(!this.observers.isEmpty()) {
			this.observers.remove(observer);	
		}
	}
	
	public void notifyObserver(TenantObservable observable) {
		for(TenantObserver observer: observers) {
			observer.update(observable);
		}
	}
}
