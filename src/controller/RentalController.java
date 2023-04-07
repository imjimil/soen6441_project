package controller;

import javafx.scene.Scene;
import model.Lease;
import model.Tenant;
import view.RentalView;

import java.util.ArrayList;

public class RentalController {
    ArrayList<Tenant> leases = new ArrayList<>();
    private RentalView rentalView;
    private Lease leaseModel;
    private Scene preScene;
    public RentalController() {
        //tenantView = new TenantView();
        
    }
    public void setPreScene(Scene preScene) {
        this.preScene = preScene;
    }
    public Scene getPreScene() {
        return this.preScene;
    }

}
