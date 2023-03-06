package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Property;
import model.Tenant;
import model.TenantObservable;
import model.TenantObserver;

public class TenantView implements TenantObserver {
	private PropertyView propertyView;
	
	public TenantView(Tenant tenant) {
		tenant.attach(this);
	}
	
	public String interestedInAUnit(ArrayList<Property> properties, ArrayList<Tenant> tenants) {
		Scanner scanner = new Scanner(System.in);
		String result = "";
		// display all properties
		if(properties.size() > 0) {
			this.propertyView.displayProperty(properties);
		}
		// display all tenants
		displayAllTenants(tenants);
		// choose a tenant with his/her interested property
		System.out.println("Enter Tenant ID:");
		int selectedTenantID = scanner.nextInt();
		System.out.println("Enter property ID that you're interested in:");
		int selectedPropertyID = scanner.nextInt();
		result = selectedTenantID + "-" + selectedPropertyID;
		
		return result;
	}
	
	public void displayAllTenants(ArrayList<Tenant> tenants) {
		for (int i = 0; i < tenants.size(); i++) {
			if(tenants.get(i).toString() != null) {
				System.out.println(i+1 + ". " + tenants.get(i).display());
			}
		}
	}

	@Override
	public void update(TenantObservable observable) {
		// TODO Auto-generated method stub
		
	}

}
