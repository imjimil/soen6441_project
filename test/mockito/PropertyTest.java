package mockito;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import model.Apartment;
import model.Condo;
import model.House;

class PropertyTest {
	
	@Test
	void testCreateApartment() {
		ArrayList<Object> propertyData = new ArrayList<Object>();
		propertyData.add(2);
		propertyData.add(3);
		propertyData.add(100f);
		propertyData.add("Hochelaga");
		propertyData.add("Montreal");
		propertyData.add("H1W");
		propertyData.add("A1");
		propertyData.add(10);
		
		// Create a mock Apartment object
        Apartment apartment = Mockito.mock(Apartment.class);
        // Create an Apartment object
        Apartment apartmentObj = new Apartment("A1", 10, 2, 3, 100f, "Hochelaga", "Montreal", "H1W");
        Mockito.when(apartment.create(propertyData)).thenReturn(apartmentObj);
        // Call the create an apartment method
        Apartment newApartment = new Apartment().create(propertyData);
        // Verify that the createApartment method with Apartment object (Mock object)
        assertEquals(newApartment.getAptNo(), apartmentObj.getAptNo());
	}
	
	@Test
	void testCreateCondo() {
		ArrayList<Object> propertyData = new ArrayList<Object>();
		propertyData.add(1);
		propertyData.add(4);
		propertyData.add(300f);
		propertyData.add("Airdrie");
		propertyData.add("Toronto");
		propertyData.add("L4L");
		propertyData.add(200);
		propertyData.add(10);
		
		// Create a mock Condo object
        Condo condo = Mockito.mock(Condo.class);
        // Create a Condo object
        Condo apartmentObj = new Condo(200, 10, 1, 4, 300f, "Airdrie", "Toronto", "L4L");
        Mockito.when(condo.create(propertyData)).thenReturn(apartmentObj);
        // Call the create a condo method
        Condo newCondo = new Condo().create(propertyData);
        // Verify the createCondo method with Condo object (Mock object)
        assertEquals(newCondo.getUnitNo(), apartmentObj.getUnitNo());
	}
	
	@Test
	void testCreateHouse() {
		ArrayList<Object> propertyData = new ArrayList<Object>();
		propertyData.add(5);
		propertyData.add(6);
		propertyData.add(400f);
		propertyData.add("StMichel");
		propertyData.add("Vancouver");
		propertyData.add("B7U");
		propertyData.add(230);
		
		// Create a mock House object
		House apartment = Mockito.mock(House.class);
        // Create an House object
		House apartmentObj = new House(230, 5, 6, 400f, "StMichel", "Vancouver", "B7U");
        Mockito.when(apartment.create(propertyData)).thenReturn(apartmentObj);
        // Call the create a House method
        House newApartment = new House().create(propertyData);
        // Verify the createHouse method with House object (Mock object)
        assertEquals(newApartment.getStreetNo(), apartmentObj.getStreetNo());
	}

	@Test
	void testPrintProperty() {
		// Create a mock Apartment object
        Apartment apartment = Mockito.mock(Apartment.class);
        Mockito.when(apartment.display()).thenReturn("Civic Address:A1, Apt No: 30, No.BedRoom: 2, No.BathRoom: 4, squareFootage: 100.0, StreetName: Jarry, City: Edmonton, postalCode: K1L, Owner- null, status- true");
        Apartment newApartment = new Apartment("A1", 30, 2, 4, 100f, "Jarry", "Edmonton", "K1L");
        String[] outputArr = newApartment.display().split(",");
        String[] newOutputArr = Arrays.copyOfRange(outputArr, 2, outputArr.length);
        String output = String.join(",", newOutputArr).trim();
        assertEquals(output, apartment.display());
	}
}