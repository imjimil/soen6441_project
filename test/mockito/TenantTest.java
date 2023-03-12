package mockito;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import model.Tenant;

class TenantTest {

	@Test
	void testCreateTenant() {

		ArrayList<Object> tenantData = new ArrayList<Object>();
		tenantData.add("Anitha");
		tenantData.add("51423425");
		tenantData.add("ani@gmail.com");

		// Create a mock Tenant object
		Tenant testTenant = Mockito.mock(Tenant.class);

		// Create a Tenant object
		Tenant tenantObj = new Tenant("Anitha","51423425","ani@gmail.com",null,null);
		Mockito.when(testTenant.create(tenantData)).thenReturn(tenantObj);
		// Call the create an Tenant method with the mock Tenant object
		Tenant newTenant = new Tenant().create(tenantData);

		// Verify the create method with Tenant object (Mock object)
		assertEquals(newTenant.getTenantName(), tenantObj.getTenantName());

	}
	@Test
	void testDisplayTenant() {
		// Create a mock Apartment object
		Tenant tenantObj = Mockito.mock(Tenant.class);
		Mockito.when(tenantObj.display()).thenReturn("tenantName: Anitha, tenantPhone: 51423425, tenantEmail: ani@gmail.com, leases: [], interestedUnits: []");

		Tenant newTenant = new Tenant("Anitha","51423425","ani@gmail.com", null, null);
		String[] outputArr = newTenant.display().split(",");
		String[] newOutputArr = Arrays.copyOfRange(outputArr, 1, outputArr.length);
		String output = String.join(",", newOutputArr).trim();
		assertEquals(output, tenantObj.display());
	}
}