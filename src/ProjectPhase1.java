import controller.Controller;
import model.Apartment;
import model.Property;
import model.Tenant;
import view.PropertyView;
import view.TenantView;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 */
public class ProjectPhase1 {
	
	public static void main(String[] args) {
		PropertyView view = new PropertyView();
		Property propertyModel = new Apartment();
		
		Tenant tenantModel = new Tenant();
		TenantView tenantView = new TenantView(tenantModel);
        Controller controller = new Controller(view, tenantView, propertyModel, tenantModel);
        controller.mainFunction();
	}
	
}
