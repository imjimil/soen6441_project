package controller;

import javafx.scene.Scene;
import model.Tenant;

import java.util.ArrayList;
import java.util.Map;

public class TenantController {
    ArrayList<Tenant> tenants = new ArrayList<>();
    private Tenant tenantModel;
    private Scene preScene;
    public TenantController() {
        //tenantView = new TenantView();
        tenantModel = new Tenant();
    }

    public Tenant getTenantModel() {
        return this.tenantModel;
    }

    public void setPreScene(Scene preScene) {
        this.preScene = preScene;
    }
    public Scene getPreScene() {
        return this.preScene;
    }
    public ArrayList<Tenant> getTenants() {
        return this.tenants;
    }

    public boolean addNewTenant(ArrayList<Object> result) {
        Boolean isSuccess = true;
        if(!result.isEmpty()) {
            Tenant tenant = new Tenant();
            Tenant newTenant = tenant.create(result);
            tenants.add(newTenant);
        } else {
            isSuccess = false;
        }
        return  isSuccess;
    }
}
