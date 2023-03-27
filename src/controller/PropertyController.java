package controller;

import model.Apartment;
import model.Property;
import model.PropertyFactory;
import utility.PropertyType;
import view.PropertyView;

import java.util.ArrayList;
import java.util.Map;

public class PropertyController {
    ArrayList<Property> properties = new ArrayList<>();
    private PropertyView propertyView;
    private Property propertyModel;
    public PropertyController() {
        propertyView = new PropertyView();
        propertyModel = new Apartment();
    }
    public void addNewProperty() {
        Map<String, ArrayList<Object>> inputPropertyData = propertyView.getPropertyInfo();
        for (Map.Entry<String, ArrayList<Object>> pair : inputPropertyData.entrySet()) {
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
    }

}
