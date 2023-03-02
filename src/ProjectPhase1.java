import controller.Controller;
import model.Apartment;
import model.Property;
import view.PropertyView;

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
        Controller controller = new Controller(view, propertyModel);
        controller.mainFunction();
	}
	
}
