package model;

import utility.PropertyType;

public abstract class PropertyFactory {
	public static Property createProperty(PropertyType propertyType) {
		switch (propertyType) {
		case APARTMENT:
			return new Apartment();
			
		case CONDO:
			return new Condo();
			
		case HOUSE:
			return new House();
		}
		
		return null;
	}
}
