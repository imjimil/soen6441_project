package mockito;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import model.Apartment;
import model.Condo;
import model.House;
import model.Lease;

class LeaseTest {

	@Test
	void testDisplayAllLeases() {
		ArrayList<Lease> leases = new ArrayList<Lease>();
		// Create a mock Lease object
        Lease lease = Mockito.mock(Lease.class);
        Mockito.when(lease.getAllLeases(leases)).thenReturn("");
//        Lease newLease = new Lease(0, null, null, 0, null, null, null)
//        newApartment.setStatus(false);
//        String[] outputArr = newApartment.displayRented().split(",");
//        String[] newOutputArr = Arrays.copyOfRange(outputArr, 2, outputArr.length);
//        String output = String.join(",", newOutputArr).trim();
//        assertEquals(output, apartment.displayRented());
	}
	
}