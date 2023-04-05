package view.Tenant;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import utility.Constant;
import view.AppBase;

import java.util.ArrayList;

public class DisplayTenantView extends Application implements AppBase {
    @Override
    public void start(Stage primaryStage) {
        Label statusMessage = new Label();
        statusMessage.setText(tenantController.getTenants().toString());
        ArrayList<Tenant> tenants = tenantController.getTenants();

        Button btnMainMenu = new Button("Main Menu");
        HBox hMainMenu = new HBox(btnMainMenu);
        btnMainMenu.setOnAction(event -> {
            primaryStage.setTitle("Project Phase 2 Demo");
            primaryStage.setScene(tenantController.getPreScene());
        });

        if(tenants.size() > 0) {
            HBox hTenantName = null;
            HBox hTenantPhone = null;
            HBox hTenantEmail = null;
            Label lblHeader;
            HBox hHeader;
            FlowPane fpanes = new FlowPane();
            VBox vBoxTenant = null;
            ArrayList<VBox> vBoxArray = new ArrayList<>();

            for (int i = 0; i < tenants.size(); i++) {
                lblHeader = new Label();
                lblHeader.setText("Tenants LIST:");
                Text txtTenantName = new Text(180, 180, "Tenant Name: " + ((Tenant) tenants.get(i)).getTenantName());
                txtTenantName.setStyle("-fx-text-fill: red;");
                hTenantName = new HBox(txtTenantName);
                hTenantName.setSpacing(10);

                Text txtTenantPhone = new Text(80, 80, "Tenant Pone: "+((Tenant) tenants.get(i)).getTenantPhone());
                hTenantPhone = new HBox(txtTenantPhone);
                hTenantPhone.setSpacing(10);

                Text txtTenantEmail = new Text(80, 80, "Tenant Email: "+((Tenant) tenants.get(i)).getTenantEmail());
                hTenantEmail = new HBox(txtTenantEmail);
                hTenantEmail.setSpacing(10);

                hHeader = new HBox(lblHeader);
                hHeader.setSpacing(10);
                vBoxTenant = new VBox(hHeader, hTenantName, hTenantPhone, hTenantEmail);

                vBoxTenant.setSpacing(25);
                vBoxTenant.setPadding(new Insets(35, 12, 15, 20));
                vBoxTenant.setAlignment(Pos.CENTER);
                vBoxArray.add(vBoxTenant);
            }
        }
    }
}
