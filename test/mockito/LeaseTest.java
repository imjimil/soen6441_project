package mockito;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import model.Apartment;
import model.Condo;
import model.House;
import model.Lease;

class LeaseTest {

	@Test
	void testDisplayLease() {
		// Create a mock Lease object
		Lease lease = Mockito.mock(Lease.class);
		Mockito.when(lease.display()).thenReturn("Start Date- Sun Dec 12 00:00:00 EST 2021, End Date- Mon Nov 13 00:00:00 EST 2023, Rent- 1200.0, Rent paid- true");
		Calendar startDate = Calendar.getInstance();
        startDate.set(2021, 12 - 1, 12);
        startDate.set(Calendar.HOUR_OF_DAY, 0);
        startDate.set(Calendar.MINUTE, 0);
        startDate.set(Calendar.SECOND, 0);
        startDate.set(Calendar.MILLISECOND, 0);
        
        Calendar endDate = Calendar.getInstance();
        endDate.set(2023, 11 - 1, 13);
        endDate.set(Calendar.HOUR_OF_DAY, 0);
        endDate.set(Calendar.MINUTE, 0);
        endDate.set(Calendar.SECOND, 0);
        endDate.set(Calendar.MILLISECOND, 0);
		
        Lease newLease = new Lease(1, startDate.getTime(), endDate.getTime(), 1200f, true, null, null);
        
        String[] outputArr = newLease.display().split(",");
        String[] newOutputArr = Arrays.copyOfRange(outputArr, 0, outputArr.length);
        String output = String.join(",", newOutputArr).trim();
        assertEquals(output, newLease.display());
	}
	
}