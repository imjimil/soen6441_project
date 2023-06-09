import java.util.ArrayList;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Property;
import view.AppBase;
import view.Property.InterestInUnitView;
import view.Property.PropertyTypeView;
import view.Rental.*;
import view.Property.DisplayPropertyView;
import view.Tenant.AddTenantView;
import view.Tenant.DisplayPotentialTenantsView;
import view.Tenant.DisplayTenantView;

/**
 * Project Phase 2
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
 * 
 */

public class ProjectPhase2 extends Application implements AppBase {
	 @Override // Override the start method in the Application class
	  public void start(Stage primaryStage) {
	    Pane pane = new Pane();
	    // Hold four buttons in an HBox
	    Button btnAddProperty = new Button("Add a property");
	    Button btnAddTenant = new Button("Add a tenant");
	    Button btnRentUnit = new Button("Rent a unit");
	    Button btnDisplayTenants = new Button("Display tenants");
	    HBox hBoxLine1 = new HBox(btnAddProperty, btnAddTenant, btnRentUnit, btnDisplayTenants);
	    hBoxLine1.setSpacing(20);
	    hBoxLine1.setPadding(new Insets(35, 12, 15, 12));
	    hBoxLine1.setAlignment(Pos.CENTER);
		// Line 2
		 Button btnDisplayProperties = new Button("Display properties");
		 Button btnVacantUnits = new Button("Display vacant units");
		 Button btnRentedUnits = new Button("Display rented units");
		 Button btnIsPaidRentUnits = new Button("Display paid/not paid rent units");
		 HBox hBoxLine2 = new HBox(btnDisplayProperties, btnVacantUnits, btnRentedUnits, btnIsPaidRentUnits);
		 hBoxLine2.setSpacing(20);
		 hBoxLine2.setPadding(new Insets(0, 12, 15, 12));
		 hBoxLine2.setAlignment(Pos.CENTER);
		 // Line 3
		 Button btnExpressInterest = new Button("Express an interest in a unit");
		 Button btnPotentialTenants = new Button("Display potential tenants and their units");
		 Button btnEndingLeases = new Button("Display leases that will be ending");
		 Button btnAllLeases = new Button("Display all leases");
		 HBox hBoxLine3 = new HBox(btnExpressInterest, btnPotentialTenants, btnEndingLeases, btnAllLeases);
		 hBoxLine3.setSpacing(20);
		 hBoxLine3.setPadding(new Insets(0, 12, 40, 12));
		 hBoxLine3.setAlignment(Pos.CENTER);
	    
	    BorderPane borderPane = new BorderPane(pane);
	    borderPane.setTop(hBoxLine1);
	    borderPane.setCenter(hBoxLine2);
		borderPane.setBottom(hBoxLine3);
	    // Create and register the handler
	    btnAddProperty.setOnAction(e -> {
			PropertyTypeView propertyTypeView = new PropertyTypeView();
			try {
				propertyTypeView.start(primaryStage);
				propertyController.setPreScene(btnAddProperty.getScene());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    });

		 btnAddTenant.setOnAction(e -> {
			 AddTenantView tenantView = new AddTenantView();
			 try {
				 tenantView.start(primaryStage);
				 tenantController.setPreScene(btnAddTenant.getScene());
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 }
		 });


		 btnRentUnit.setOnAction(e -> {
			AddRentalView rentalView = new AddRentalView();
			try {
				rentalView.start(primaryStage);
				rentalController.setPreScene(btnRentUnit.getScene());
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		});

		btnVacantUnits.setOnAction(e -> {
			DisplaySpecificProperty displayVacentProperty = new DisplaySpecificProperty();
			try {
				displayVacentProperty.start(primaryStage);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		});

		btnRentedUnits.setOnAction(e -> {
			//utilizing same function to generate different views.
			DisplaySpecificProperty displayRentedProperty = new DisplaySpecificProperty();
			ArrayList<Property> properties = propertyController.getProperties();
			try {
				displayRentedProperty.displayVacantProperty(primaryStage, properties, 1, 0);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		});

		 btnDisplayTenants.setOnAction(actionEvent -> {
			 DisplayTenantView displayTntView = new DisplayTenantView();
			 try {
				 displayTntView.start(primaryStage);
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 }
		 } );

		 btnDisplayProperties.setOnAction(actionEvent -> {
			 DisplayPropertyView displayPropertyView = new DisplayPropertyView();
			 try {
				 displayPropertyView.start(primaryStage);
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 }
		 });

		 btnIsPaidRentUnits.setOnAction(actionEvent -> {
			 DisplayRentPaidLeases displayRentPaidorNo = new DisplayRentPaidLeases();
			 try {
				 displayRentPaidorNo.start(primaryStage);
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 }
		 });

		 btnEndingLeases.setOnAction(actionEvent -> {
			 DisplayEndingLeases displayEndLs = new DisplayEndingLeases();
			 try {
				 displayEndLs.start(primaryStage);
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 }
		 });

		 btnAllLeases.setOnAction(actionEvent -> {
			DisplayLeases displayLease = new DisplayLeases();
			try {
				displayLease.start(primaryStage);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		 btnExpressInterest.setOnAction(actionEvent -> {
			 InterestInUnitView interestInUnitView = new InterestInUnitView();
			 try {
				 propertyController.setPreScene(btnExpressInterest.getScene());
				 interestInUnitView.start(primaryStage);
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 }
		 });

		 btnPotentialTenants.setOnAction(actionEvent -> {
			 DisplayPotentialTenantsView potentialTenantsView = new DisplayPotentialTenantsView();
			 try {
				 tenantController.setPreScene(btnPotentialTenants.getScene());
				 potentialTenantsView.start(primaryStage);
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 }
		 });


		 // Create a scene and place it in the stage
	    Scene scene = new Scene(borderPane, 800, 350);
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
