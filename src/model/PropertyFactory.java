package model;

import utility.Constant;

public class PropertyFactory {
	public Property createProperty(String propertyType) {
		if(propertyType.equalsIgnoreCase(Constant.APARTMENT)) {
			return new Apartment();
		} else if(propertyType.equalsIgnoreCase(Constant.CONDO)) {
			return new Condo();
		} else if(propertyType.equalsIgnoreCase(Constant.HOUSE)) {
			return new House();
		}
		
		return null;
	}
}
