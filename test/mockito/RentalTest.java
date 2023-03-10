package mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import model.Property;
import model.Tenant;
import view.PropertyView;
import view.RentalView;

//@RunWith(MockitoJUnitRunner.class)
public class RentalTest {
    
    @Mock
    Scanner scannerMock = Mockito.mock(Scanner.class);
    
    @Test
    public void testAskBasicInfo() {
        RentalView rentalView = new RentalView();
        PropertyView propertyViewMock = mock(PropertyView.class);
        ArrayList<Property> properties = new ArrayList<Property>();
        ArrayList<Tenant> tenants = new ArrayList<Tenant>();
        
        // Setup scanner mock to return user input
        when(scannerMock.nextInt()).thenReturn(1, 1);
        when(scannerMock.nextLine()).thenReturn("Y");
        
        // Test asking basic info
        ArrayList<Object> expectedUserInput = new ArrayList<>();
        Date startDate = RentalView.getDateFromUser(scannerMock);
        expectedUserInput.add(startDate);
        Date endDate = RentalView.getDateFromUser(scannerMock);
        expectedUserInput.add(endDate);
        expectedUserInput.add(5000);
        expectedUserInput.add(true);
        ArrayList<Object> userInput = rentalView.askBasicInfo(properties, propertyViewMock, tenants);
        
        // Verify the method displays the correct messages and returns the correct user input
        assertEquals(expectedUserInput, userInput.get(0));
        assertEquals(1, userInput.get(1));
        assertEquals(1, userInput.get(2));
    }
}
