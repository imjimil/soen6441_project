package view.Tenant;

import controller.TenantController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
            Tenant tenantModel = new Tenant();
            view.TenantView tenantView = new view.TenantView(tenantModel);
            ArrayList<Object> tenantData = new ArrayList<Object>();
           // tenantController.setPreScene(btnAddTenant.getScene());

            Button btnMainMenu = new Button("Main Menu");
            HBox hMainMenu = new HBox(btnMainMenu);
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
            VBox vBoxProperty = new VBox(hMainMenu, hStatus, hTenantName, hTenantPhone, hEmailID, btnSubmit);
            vBoxProperty.setSpacing(25);
            vBoxProperty.setPadding(new Insets(95, 12, 15, 12));
            vBoxProperty.setAlignment(Pos.CENTER);
            Pane addPropertyPane = new Pane();
            // Hold buttons in an HBox
            BorderPane borderPropertyPane = new BorderPane(addPropertyPane);
            borderPropertyPane.setTop(vBoxProperty);
            Scene apartmentScene = new Scene(borderPropertyPane, 500, 350);
            primaryStage.setTitle("Add a New Tenant"); // Set title
            primaryStage.setScene(apartmentScene);

            btnMainMenu.setOnAction(event -> {
                primaryStage.setTitle("Project Phase 2 Demo");
                primaryStage.setScene(tenantController.getPreScene());
            });

            btnSubmit.setOnAction(event -> {
                tenantData.add(tfTenantName.getText());
                tenantData.add(tfTenantPhone.getText());
                tenantData.add(tfEmailID.getText());

                TenantController tenantController = new TenantController();
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
