package controller;

import javafx.scene.Scene;
import model.Lease;

public class RentalController {
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
