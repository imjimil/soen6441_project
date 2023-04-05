package controller;

import javafx.scene.Scene;
import model.Apartment;
import model.Property;
import model.PropertyFactory;
import model.Tenant;
import utility.PropertyType;
import view.Property.PropertyTypeView;
import view.TenantView;

import java.util.ArrayList;
import java.util.Map;

public class TenantController {
    ArrayList<Tenant> tenants = new ArrayList<>();
    private TenantView tenantView;
    private Tenant tenantModel;
    private Scene preScene;
    public TenantController() {
        //tenantView = new TenantView();
        tenantModel = new Tenant();
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
