package controller;

import javafx.scene.Scene;
import model.Apartment;
import model.Property;
import model.PropertyFactory;
import model.Tenant;
import utility.PropertyType;
import view.Property.PropertyTypeView;

import java.util.ArrayList;
import java.util.Map;

public class PropertyController {
    ArrayList<Property> properties = new ArrayList<>();
    private PropertyTypeView propertyTypeView;
    private Property propertyModel;
    private Tenant tenantModel;
    private Scene preScene;
    public PropertyController() {
        propertyTypeView = new PropertyTypeView();
        propertyModel = new Apartment();
        tenantModel = new Tenant();
    }
    public void setPreScene(Scene preScene) {
        this.preScene = preScene;
    }
    public Scene getPreScene() {
        return this.preScene;
    }

    public Tenant getTenantModel() {
        return this.tenantModel;
    }
    public ArrayList<Property> getProperties() {
        return this.properties;
    }
    public boolean addNewProperty(Map<String, ArrayList<Object>> result) {
        Boolean isSuccess = true;
        if(!result.isEmpty()) {
            for (Map.Entry<String, ArrayList<Object>> pair : result.entrySet()) {
                if("A".equals(pair.getKey())) {
                    propertyModel = PropertyFactory.createProperty(PropertyType.APARTMENT);
                    properties.add(propertyModel.create(pair.getValue()));
                } else if ("C".equals(pair.getKey())) {
                    propertyModel = PropertyFactory.createProperty(PropertyType.CONDO);
                    properties.add(propertyModel.create(pair.getValue()));
                } else if ("H".equals(pair.getKey())) {
                    propertyModel = PropertyFactory.createProperty(PropertyType.HOUSE);
                    properties.add(propertyModel.create(pair.getValue()));
                }
            }
        } else {
            isSuccess = false;
        }

        return  isSuccess;
    }

    public boolean interestedInAUnit(String interestedData, ArrayList<Tenant> tenants) {
        boolean isSuccess = true;
        if(!interestedData.isEmpty()) {
            tenantModel.interestedInAUnit(interestedData, tenants, this.properties);
        } else {
            isSuccess = false;
        }

        return isSuccess;
    }
}
