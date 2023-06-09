package view.Rental;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Lease;
import view.AppBase;

import java.util.ArrayList;

public class DisplayRentPaidLeases extends Application implements AppBase {

    public VBox displayRentPaidLeases(Stage primaryStage, ArrayList<Lease> leases, int target) {
        // main menu button
        Button btnMainMenu = new Button("Main Menu");
        HBox hMainMenu = new HBox(btnMainMenu);
        if (leases.size() > 0) {
            VBox leaseVBox = new VBox();
            leaseVBox.setSpacing(10);
    
            for (int i = 0; i < leases.size(); i++) {
                Lease lease = leases.get(i);

                if(leases.get(i).getIsRentPaid() == true) {
                    Label lblLeaseNumber = new Label("Lease Rent Paid :");
                    lblLeaseNumber.setFont(new Font(20));
                    Label lblLeaseID = new Label("ID: " + lease.getLeaseNo());
                    Label lblTenantName = new Label("Tenant Name: " + lease.getTenantInfo().getTenantName());
                    Label lblTenantPhone = new Label("Phone: " + lease.getTenantInfo().getTenantPhone());
                    Label lblStartDate = new Label("Start Date: " + lease.getLeaseStartDate());
                    Label lblEndDate = new Label("End Date: " + lease.getLeaseEndDate());
                    Label lblRent = new Label("Rent: " + lease.getRentAmount());
                    //Label lblIsRentPaid = new Label("Is Rent Paid?: " + lease.getIsRentPaid());
                    Label lblPropertyID = new Label("Property ID: " + lease.getPropertyInfo().getID());

                    VBox tenantInfoVBox = new VBox(lblLeaseNumber, lblLeaseID, lblTenantName, lblTenantPhone,lblPropertyID, lblStartDate, lblEndDate, lblRent);
                    tenantInfoVBox.setSpacing(5);
                    tenantInfoVBox.setPadding(new Insets(10));
                    leaseVBox.getChildren().add(tenantInfoVBox);
                }
                else{
                    Label lblLeaseNumber = new Label("Lease Rent Not Paid :");
                    lblLeaseNumber.setFont(new Font(20));
                    Label lblLeaseID = new Label("ID: " + lease.getLeaseNo());
                    Label lblTenantName = new Label("Tenant Name: " + lease.getTenantInfo().getTenantName());
                    Label lblTenantPhone = new Label("Phone: " + lease.getTenantInfo().getTenantPhone());
                    Label lblStartDate = new Label("Start Date: " + lease.getLeaseStartDate());
                    Label lblEndDate = new Label("End Date: " + lease.getLeaseEndDate());
                    Label lblRent = new Label("Rent: " + lease.getRentAmount());
                    //Label lblIsRentPaid = new Label("Is Rent Paid?: " + lease.getIsRentPaid());
                    Label lblPropertyID = new Label("Property ID: " + lease.getPropertyInfo().getID());

                    VBox tenantInfoVBox = new VBox(lblLeaseNumber, lblLeaseID, lblTenantName, lblTenantPhone,lblPropertyID, lblStartDate, lblEndDate, lblRent);
                    tenantInfoVBox.setSpacing(5);
                    tenantInfoVBox.setPadding(new Insets(10));
                    leaseVBox.getChildren().add(tenantInfoVBox);
                }
            }

            if(target == 1) {
                    
                ScrollPane scrollPane = new ScrollPane(leaseVBox);

                btnMainMenu.setOnAction(event -> {
                    // go back to previous scene
                    primaryStage.setTitle("Project Phase 2 Demo");
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
                primaryStage.setTitle("All Paid/Not Paid leases"); // Set title
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
        displayRentPaidLeases(primaryStage, leases, 1);
    }
}

