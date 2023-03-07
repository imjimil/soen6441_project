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
//		if(propertyType.equalsIgnoreCase(Constant.APARTMENT)) {
//			return new Apartment();
//		} else if(propertyType.equalsIgnoreCase(Constant.CONDO)) {
//			return new Condo();
//		} else if(propertyType.equalsIgnoreCase(Constant.HOUSE)) {
//			return new House();
//		}
		
		return null;
	}
}
