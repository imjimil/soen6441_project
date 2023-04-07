package view.Tenant;

import controller.TenantController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Tenant;
import view.AppBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddTenantView extends Application implements AppBase {
    @Override
    public void start(Stage primaryStage) {
        {
            ArrayList<Object> tenantData = new ArrayList<Object>();

            Button btnMainMenu = new Button("Main Menu");
            HBox hMainMenu = new HBox(btnMainMenu);
            Label statusMessage = new Label();
            HBox hStatus = new HBox(statusMessage);

            Label lblTenantName = new Label("Tenant Name:");
            lblTenantName.setPadding(new Insets(0,10,0,0));
            TextField tfTenantName = new TextField();
            HBox hTenantName = new HBox(lblTenantName, tfTenantName);

            Label lblTenantPhone = new Label("Tenant PhoneNo:");
            lblTenantPhone.setPadding(new Insets(0,10,0,0));
            TextField tfTenantPhone = new TextField();
            HBox hTenantPhone = new HBox(lblTenantPhone, tfTenantPhone);

            Label lblEmailID = new Label("Tenant Email Address:");
            lblEmailID.setPadding(new Insets(0,10,0,0));
            TextField tfEmailID = new TextField();
            HBox hEmailID = new HBox(lblEmailID, tfEmailID);

            Button btnSubmit = new Button("Submit");
            VBox vBoxProperty = new VBox(hMainMenu, hStatus, hTenantName, hTenantPhone, hEmailID, btnSubmit);
            vBoxProperty.setSpacing(25);
            vBoxProperty.setPadding(new Insets(95, 12, 15, 12));
            vBoxProperty.setAlignment(Pos.CENTER);
            Pane addPropertyPane = new Pane();
            // Hold buttons in an HBox
            BorderPane borderPropertyPane = new BorderPane(addPropertyPane);
            borderPropertyPane.setTop(vBoxProperty);
            Scene apartmentScene = new Scene(borderPropertyPane, 500, 550);
            primaryStage.setTitle("Add a New Tenant"); // Set title
            primaryStage.setScene(apartmentScene);

            ScrollPane scrollPane = new ScrollPane(vBoxProperty);
            scrollPane.setMaxWidth(Double.MAX_VALUE);
            scrollPane.setMaxHeight(Double.MAX_VALUE);
            scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
            borderPropertyPane.setCenter(scrollPane);

            btnMainMenu.setOnAction(event -> {
                primaryStage.setTitle("Project Phase 2 Demo");
                primaryStage.setScene(tenantController.getPreScene());
            });

            btnSubmit.setOnAction(event -> {
                tenantData.add(tfTenantName.getText());
                tenantData.add(tfTenantPhone.getText());
                tenantData.add(tfEmailID.getText());

                boolean returnResult = tenantController.addNewTenant(tenantData);
                if(returnResult) {
                    //statusMessage.setText(tenantData.toString());
                    statusMessage.setText("Added new Tenant successfully!");
                    statusMessage.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
                }
            });
        }
    }
}
