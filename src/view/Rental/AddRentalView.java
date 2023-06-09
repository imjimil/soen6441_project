package view.Rental;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import model.Lease;
import model.Property;
import model.Tenant;
import view.AppBase;
import view.Property.DisplayPropertyView;
import view.Property.PropertyTypeView;
import view.Tenant.DisplayTenantView;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

public class AddRentalView extends Application implements AppBase {
    private TextField tfStartDay, tfStartMonth, tfStartYear, tfEndDay, tfEndMonth, tfEndYear;
    VBox tenantBox; 
    VBox propertyBox;
    public static ArrayList<Lease> totalLeases = new ArrayList<>();

    //return all leases
    public ArrayList<Lease> getLeases() {
        return totalLeases;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Lease lease = new Lease();

        Button btnMainMenu = new Button("Main Menu");
        HBox hMainMenu = new HBox(btnMainMenu);
        Label statusMessage = new Label();
        HBox hStatus = new HBox(statusMessage);

        //showing properties
        ArrayList<Property> properties = propertyController.getProperties();
        if(properties.size() > 0) {
            DisplayPropertyView displayPropertyView = new DisplayPropertyView();
            Button btnRefresh = new Button();
            propertyBox = new DisplaySpecificProperty().displayVacantProperty(primaryStage, properties, 0, 1);
        }

        //showing tenants
        ArrayList<Tenant> tenants = tenantController.getTenants();
        if(tenants.size() > 0) {
            DisplayTenantView displayTenantView = new DisplayTenantView();
            tenantBox = displayTenantView.displayTenants(primaryStage, tenants, 0);
        }

        Text txtAppartmentID = new Text(80, 80, "Appartment ID you want to lease: ");
        TextField tfAppartmentID = new TextField();
        HBox hAppartmentID = new HBox(txtAppartmentID, tfAppartmentID);

        Text txtTenantID = new Text(80, 80, "Tenant ID: ");
        TextField tfTenantID = new TextField();
        HBox hTenantID = new HBox(txtTenantID, tfTenantID);

        Text txtStartDate = new Text(80, 80, "Lease Start Date (dd/mm/yyyy): ");
        tfStartDay = new TextField();
        tfStartDay.setPromptText("Day");
        tfStartMonth = new TextField();
        tfStartMonth.setPromptText("Month");
        tfStartYear = new TextField();
        tfStartYear.setPromptText("Year");
        HBox hStartDate = new HBox(txtStartDate, tfStartDay, tfStartMonth, tfStartYear);

        Text txtEndDate = new Text(80, 80, "Lease End Date (dd/mm/yyyy): ");
        tfEndDay = new TextField();
        tfEndDay.setPromptText("Day");
        tfEndMonth = new TextField();
        tfEndMonth.setPromptText("Month");
        tfEndYear = new TextField();
        tfEndYear.setPromptText("Year");
        HBox hEndDate = new HBox(txtEndDate, tfEndDay, tfEndMonth, tfEndYear);

        Text txtTotalRent = new Text(80, 80, "Total Rent: ");
        TextField tfTotalRent = new TextField();
        HBox hTotalRent = new HBox(txtTotalRent, tfTotalRent);

        Text txtRentPaid = new Text(80, 80, "Rent Paid: ");
        CheckBox cbRentPaid = new CheckBox();
        HBox hRentPaid = new HBox(txtRentPaid, cbRentPaid);

        Button btnSubmit = new Button("Submit");

        VBox vBoxProperty = new VBox(hMainMenu, new Separator(), tenantBox, new Separator(), hStatus, hAppartmentID, hTenantID, hStartDate, hEndDate, hTotalRent, hRentPaid, btnSubmit);
        vBoxProperty.getChildren().add(1, propertyBox);
        vBoxProperty.setSpacing(25);
        vBoxProperty.setPadding(new Insets(95, 12, 15, 12));
        vBoxProperty.setAlignment(Pos.CENTER);

        Pane addRentalPane = new Pane();
        BorderPane borderPropertyPane = new BorderPane(addRentalPane);
        borderPropertyPane.setTop(vBoxProperty);  

        Scene rentScene = new Scene(borderPropertyPane, 500, 550);
        primaryStage.setTitle("Rent an Appartment:");
        primaryStage.setScene(rentScene);

        ScrollPane scrollPane = new ScrollPane(vBoxProperty);
        scrollPane.setMaxWidth(Double.MAX_VALUE);
        scrollPane.setMaxHeight(Double.MAX_VALUE);
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        borderPropertyPane.setCenter(scrollPane);

        btnMainMenu.setOnAction(event -> {
            primaryStage.setTitle("Project Phase 2 Demo");
            primaryStage.setScene(rentalController.getPreScene());
        });

        btnSubmit.setOnAction(event -> {
            ArrayList<Object> savedInfo = new ArrayList<>();
            //parse start date
            int startYear = Integer.parseInt(tfStartYear.getText());
            int startMonth = Integer.parseInt(tfStartMonth.getText());
            int startDay = Integer.parseInt(tfStartDay.getText());
            Calendar calendar = Calendar.getInstance();
            calendar.set(startYear, startMonth - 1, startDay);
            Date startDate = calendar.getTime();

            // parse end date
            int endYear = Integer.parseInt(tfEndYear.getText());
            int endMonth = Integer.parseInt(tfEndMonth.getText());
            int endDay = Integer.parseInt(tfEndDay.getText());
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.set(endYear, endMonth - 1, endDay);
            Date endDate = endCalendar.getTime();

            int selectedPropertyID = Integer.parseInt(tfAppartmentID.getText());
            int selectedTenantID = Integer.parseInt(tfTenantID.getText());
            int totalRent = Integer.parseInt(tfTotalRent.getText());
            boolean rentPaid = cbRentPaid.isSelected();

            PropertyTypeView propertyTypeView = new PropertyTypeView();
            Property selectedPropertyObject = propertyTypeView.getObjectByID(selectedPropertyID, properties);
            Tenant tenant = new Tenant();
            Tenant selectedTenantObject = tenant.getObjectByID(selectedTenantID, tenants);

            savedInfo.add(startDate);
            savedInfo.add(endDate);
            savedInfo.add(totalRent);
            savedInfo.add(rentPaid);
            savedInfo.add(selectedTenantObject);
            savedInfo.add(selectedPropertyObject);

            Lease addedLease = lease.create(savedInfo);
            System.out.println(addedLease.display());
            totalLeases.add(addedLease);
            //now add that lease to tenant object field.
            selectedTenantObject.setLeases(addedLease);
            //make property unavailable
            selectedPropertyObject.setStatus(false);
            selectedPropertyObject.setTenent(selectedTenantObject);

            statusMessage.setText("Property Rented!");
            statusMessage.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
        });
    }
    
}
