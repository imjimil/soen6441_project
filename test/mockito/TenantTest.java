package mockito;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
		Tenant tenantObj = new Tenant();

		// Call the create an Tenant method with the mock Tenant object
		Tenant newTenant = tenantObj.create(tenantData);

		// Verify that the createTenant method returned the not null object
		assertNotNull(newTenant);

	}
}