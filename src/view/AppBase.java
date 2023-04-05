package view;

import controller.PropertyController;
import controller.TenantController;

/**
 * Project Phase 2
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
 *
 */
public interface AppBase {
    PropertyController propertyController = new PropertyController();
    TenantController tenantController = new TenantController();
}
