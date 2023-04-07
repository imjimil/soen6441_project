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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;

public class DisplayEndingLeases extends Application implements AppBase {

    public VBox displayEndingLeases(Stage primaryStage, ArrayList<Lease> leases, int target) {

        LocalDateTime now = LocalDateTime.now();

        LocalDate startThisMonth = LocalDate.of(now.getYear(), now.getMonth(), 1);
        LocalDate endThisMonth = startThisMonth.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate startNextMonth = startThisMonth.plusMonths(1);
        LocalDate endNextMonth = startNextMonth.with(TemporalAdjusters.lastDayOfMonth());
    
        if (leases.size() > 0) {
            VBox leaseVBox = new VBox();
            leaseVBox.setSpacing(10);
    
            for (int i = 0; i < leases.size(); i++) {
                Lease lease = leases.get(i);

                Date endDate = lease.getLeaseEndDate();
                LocalDateTime endDateTime = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                if ((endDateTime.isAfter(startThisMonth.atStartOfDay()) && endDateTime.isBefore(endThisMonth.plusDays(1).atStartOfDay())) ||
                        (endDateTime.isAfter(startNextMonth.atStartOfDay()) && endDateTime.isBefore(endNextMonth.plusDays(1).atStartOfDay()))) {
                    //System.out.println(obj.display());


                    Label lblLeaseNumber = new Label("Lease Ending " + (i + 1) + ":");
                    lblLeaseNumber.setFont(new Font(20));
                    Label lblLeaseID = new Label("ID: " + lease.getLeaseNo());
                    Label lblTenantName = new Label("Tenant Name: " + lease.getTenantInfo().getTenantName());
                    Label lblTenantPhone = new Label("Phone: " + lease.getTenantInfo().getTenantPhone());
                    Label lblStartDate = new Label("Start Date: " + lease.getLeaseStartDate());
                    Label lblEndDate = new Label("End Date: " + lease.getLeaseEndDate());
                    Label lblRent = new Label("Rent: " + lease.getRentAmount());
                    Label lblIsRentPaid = new Label("Is Rent Paid?: " + lease.getIsRentPaid());
                    Label lblPropertyID = new Label("Property ID: " + lease.getPropertyInfo().getID());


                    VBox tenantInfoVBox = new VBox(lblLeaseNumber, lblLeaseID, lblTenantName, lblTenantPhone, lblPropertyID, lblStartDate, lblEndDate, lblRent, lblIsRentPaid);
                    tenantInfoVBox.setSpacing(5);
                    tenantInfoVBox.setPadding(new Insets(10));

                    leaseVBox.getChildren().add(tenantInfoVBox);
                }
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
                borderPropertyPane.setTop(scrollPane);
                borderPropertyPane.setBottom(pMenu);
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
        displayEndingLeases(primaryStage, leases, 1);
    }
}

