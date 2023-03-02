package view;

import java.util.ArrayList;

import model.Property;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 * PropertyView class
 */
public class PropertyView {
	public void displayProperty(ArrayList<Property> properties) {
		for (int i = 0; i < properties.size(); i++) {
			if(properties.get(i).toString() != null) {
				System.out.println(i+1 + ". " + properties.get(i).display());
			}
		}
    }
}
