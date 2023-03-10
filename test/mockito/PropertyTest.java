package mockito;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import model.Apartment;

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

        // Create a Apartment object
        Apartment apartmentObj = new Apartment();
        
        // Call the create an apartment method with the mock Apartment object
        Apartment newApartment = apartmentObj.create(propertyData);

        // Verify that the createApartment method returned the not null object
        assertNotNull(newApartment);
	}

}