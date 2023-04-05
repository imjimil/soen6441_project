package view.Tenant;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Tenant;
import view.AppBase;

import java.util.ArrayList;

public class DisplayTenantView extends Application implements AppBase {

    public void displayTenants(Stage primaryStage, ArrayList<Tenant> tenants) {
    
        if (tenants.size() > 0) {
            VBox tenantsVBox = new VBox();
            tenantsVBox.setSpacing(10);
    
            for (int i = 0; i < tenants.size(); i++) {
                Tenant t = tenants.get(i);
    
                Label lblTenantNumber = new Label("Tenant " + (i + 1) + ":");
                lblTenantNumber.setFont(new Font(20));
                Label lblTenantName = new Label("Name: " + t.getTenantName());
                Label lblTenantPhone = new Label("Phone: " + t.getTenantPhone());
                Label lblTenantEmail = new Label("Email: " + t.getTenantEmail());
    
                VBox tenantInfoVBox = new VBox(lblTenantNumber, lblTenantName, lblTenantPhone, lblTenantEmail);
                tenantInfoVBox.setSpacing(5);
                tenantInfoVBox.setPadding(new Insets(10));
    
                tenantsVBox.getChildren().add(tenantInfoVBox);
            }
    
            ScrollPane scrollPane = new ScrollPane(tenantsVBox);
    
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
            Scene tenantScene = new Scene(borderPropertyPane, 550, 550);
            primaryStage.setTitle("All tenants"); // Set title
            primaryStage.setScene(tenantScene);
        }
    }
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Tenant> tenants = tenantController.getTenants();
        displayTenants(primaryStage, tenants);
    }
}
