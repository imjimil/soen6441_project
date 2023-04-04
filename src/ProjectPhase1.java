import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Tenant;
import view.AppBase;
import view.Property.PropertyTypeView;
import javafx.scene.layout.Pane;
import view.Property.DisplayPropertyView;
import view.TenantView;

import java.util.ArrayList;

/**
 * Project Phase 2
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
 * 
 */

public class ProjectPhase1 extends Application implements AppBase {
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

	    /*btnAddTenant.setOnAction(new EventHandler<ActionEvent>() {
	      @Override // Override the handle method
	      public void handle(ActionEvent e) {
	      }
	    });*/
		 btnAddTenant.setOnAction(e -> {
					 Tenant tenantModel = new Tenant();
					 TenantView tenantView = new TenantView(tenantModel);
					 ArrayList<Object> tenantData = new ArrayList<Object>();
					 Label statusMessage = new Label();
					 HBox hStatus = new HBox(statusMessage);

					 Text txtTenantName = new Text(80, 80, "TenantName");
					 TextField tfTenantName = new TextField();
					 HBox hTenantName = new HBox(txtTenantName, tfTenantName);

					 Text txtTenantPhone = new Text(80, 80, "Tenant PhoneNo:");
					 TextField tfTenantPhone = new TextField();
					 HBox hTenantPhone = new HBox(txtTenantPhone, tfTenantPhone);

					 Text txtEmailID = new Text(80, 80, "Tenant EmailID:");
					 TextField tfEmailID = new TextField();
					 HBox hEmailID = new HBox(txtEmailID, tfEmailID);

					 Button btnSubmit = new Button("Submit");
					 VBox vBoxProperty = new VBox(hStatus, hTenantName, hTenantPhone, hEmailID, btnSubmit);
					 vBoxProperty.setSpacing(25);
					 vBoxProperty.setPadding(new Insets(95, 12, 15, 12));
					 vBoxProperty.setAlignment(Pos.CENTER);
					 Pane addPropertyPane = new Pane();
					 // Hold buttons in an HBox
					 BorderPane borderPropertyPane = new BorderPane(addPropertyPane);
					 borderPropertyPane.setTop(vBoxProperty);
					 Scene apartmentScene = new Scene(borderPropertyPane, 500, 350);
					 primaryStage.setTitle("Add an Teannat"); // Set title
					 primaryStage.setScene(apartmentScene);

					 btnSubmit.setOnAction(event -> {
						 tenantData.add(tfTenantName.getText());
						 tenantData.add(tfTenantPhone.getText());
						 tenantData.add(tfEmailID.getText());
						 //result.put("A", propertyData);

						 //PropertyController propertyController = new PropertyController();
						 //boolean returnResult = propertyController.addNewProperty(result);
						 //if(returnResult) {
						 statusMessage.setText("Added new Tenant successfully!");
						 statusMessage.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
						 // }
					 });
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

		 btnDisplayProperties.setOnAction(actionEvent -> {
			 DisplayPropertyView displayPropertyView = new DisplayPropertyView();
			 try {
				 displayPropertyView.start(primaryStage);
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
