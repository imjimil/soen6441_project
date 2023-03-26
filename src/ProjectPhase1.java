import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.PropertyView;
import javafx.scene.layout.Pane;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
 * 
 */

public class ProjectPhase1 extends Application {
	 @Override // Override the start method in the Application class
	  public void start(Stage primaryStage) {
//	    Text text = new Text(40, 40, "Programming is fun");
	    Pane pane = new Pane();
	    
	    // Hold four buttons in an HBox
	    Button btnAddProperty = new Button("Add a property");
	    Button btnAddTenant = new Button("Add a tenant");
	    Button btnRentUnit = new Button("Rent a unit");
	    Button btnDisplayTenants = new Button("Display tenants");
	    HBox hBox = new HBox(btnAddProperty, btnAddTenant, btnRentUnit, btnDisplayTenants);
	    hBox.setSpacing(25);
	    hBox.setPadding(new Insets(35, 12, 15, 12));

	    
	    hBox.setAlignment(Pos.CENTER);
	    
	    BorderPane borderPane = new BorderPane(pane);
	    borderPane.setTop(hBox);
	    
	    // Create and register the handler
	    btnAddProperty.setOnAction(e -> {
	    	Pane addPropertyPane = new Pane();
		    
		    // Hold buttons in an HBox
		    Button btnAddApartment = new Button("Add an apartment");
		    Button btnAddCondo = new Button("Add a condo");
		    Button btnAddHouse = new Button("Add a house");
		    HBox hBoxProperty = new HBox(btnAddApartment, btnAddCondo, btnAddHouse);
		    hBoxProperty.setSpacing(25);
		    hBoxProperty.setPadding(new Insets(95, 12, 15, 12));
		    hBoxProperty.setAlignment(Pos.CENTER);
		    
		    BorderPane borderPropertyPane = new BorderPane(addPropertyPane);
		    borderPropertyPane.setTop(hBoxProperty);
		    Scene propertyScene = new Scene(borderPropertyPane, 500, 350);
		    Stage stageTwo = new Stage();
		    stageTwo.setTitle("Add a property"); // Set title
		    stageTwo.setScene(propertyScene); // Place the scene in the stage
		    stageTwo.show(); // Display the stage
		    
		    btnAddApartment.setOnAction(eventA -> {
		    	PropertyView p = new PropertyView();
		    	try {
		    		Stage stageThree = new Stage();
					p.start(stageThree);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    });
	    });

	    btnAddTenant.setOnAction(new EventHandler<ActionEvent>() {
	      @Override // Override the handle method
	      public void handle(ActionEvent e) {
	      }
	    });
	    
	    btnRentUnit.setOnAction(new EventHandler<ActionEvent>() {
	      @Override // Override the handle method
	      public void handle(ActionEvent e) {
	      }
	    });
	    
	    btnDisplayTenants.setOnAction(new EventHandler<ActionEvent>() {
	      @Override // Override the handle method
	      public void handle(ActionEvent e) {
	      }
	    });

	    // Create a scene and place it in the stage
	    Scene scene = new Scene(borderPane, 500, 350);
	    primaryStage.setTitle("Project Phase 2 Demo"); // Set title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	  }
	
	public static void main(String[] args) {
//		PropertyView view = new PropertyView();
//		Property propertyModel = new Apartment();
//
//		Tenant tenantModel = new Tenant();
//		TenantView tenantView = new TenantView(tenantModel);
//		RentalView rentalView = new RentalView();
//		Controller controller = new Controller(view, tenantView, rentalView, propertyModel, tenantModel);
//		controller.mainFunction();
		launch(args);
	}
}
