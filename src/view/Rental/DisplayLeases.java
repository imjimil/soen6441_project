package view.Rental;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Lease;
import view.AppBase;


import java.util.ArrayList;

public class DisplayLeases extends Application implements AppBase {

    public VBox displayLeases(Stage primaryStage, ArrayList<Lease> leases, int target) {
    
        if (leases.size() > 0) {
            VBox leaseVBox = new VBox();
            leaseVBox.setSpacing(10);
    
            for (int i = 0; i < leases.size(); i++) {
                Lease lease = leases.get(i);
    
                Label lblLeaseNumber = new Label("Lease " + (i + 1) + ":");
                lblLeaseNumber.setFont(new Font(20));
                Label lblLeaseID = new Label("ID: " + lease.getLeaseNo());
                Label lblTenantName = new Label("Tenant Name: " + lease.getTenantInfo().getTenantName());
                Label lblTenantPhone = new Label("Phone: " + lease.getTenantInfo().getTenantPhone());
                Label lblStartDate = new Label("Start Date: " + lease.getLeaseStartDate());
                Label lblEndDate = new Label("End Date: " + lease.getLeaseEndDate());
                Label lblRent = new Label("Rent: " + lease.getRentAmount());
                Label lblIsRentPaid = new Label("Is Rent Paid?: " + lease.getIsRentPaid());
                Label lblPropertyID = new Label("Property ID: " + lease.getPropertyInfo().getID());

    
                VBox tenantInfoVBox = new VBox(lblLeaseNumber, lblLeaseID, lblTenantName, lblTenantPhone,lblPropertyID, lblStartDate, lblEndDate, lblRent, lblIsRentPaid);
                tenantInfoVBox.setSpacing(5);
                tenantInfoVBox.setPadding(new Insets(10));
    
                leaseVBox.getChildren().add(tenantInfoVBox);
            }

            if(target == 1) {
                    
                ScrollPane scrollPane = new ScrollPane(leaseVBox);
        
                // main menu button
                Button btnMainMenu = new Button("Main Menu");
                HBox hMainMenu = new HBox(btnMainMenu);
                btnMainMenu.setOnAction(event -> {
                    // go back to previous scene
                    primaryStage.setScene(tenantController.getPreScene());
                });
                Pane pMenu = new Pane();
                hMainMenu.setPadding(new Insets(20));
                pMenu.getChildren().add(hMainMenu);
        
                // Build scene
                BorderPane borderPropertyPane = new BorderPane();
                borderPropertyPane.setCenter(scrollPane);
                borderPropertyPane.setTop(pMenu);
                Scene leaseScene = new Scene(borderPropertyPane, 550, 550);
                primaryStage.setTitle("All leases"); // Set title
                primaryStage.setScene(leaseScene);
            }
            else {
                return leaseVBox;
            }
        } 
        else {
            System.out.println("No lease found.");
        }
        return null;
    }
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Lease> leases = new AddRentalView().getLeases();
        System.out.println(leases.size()); 
        System.out.println(leases);
        displayLeases(primaryStage, leases, 1);
    }
}

