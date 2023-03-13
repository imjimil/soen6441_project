package model;

import java.util.ArrayList;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
 *
 * IProperty interface
 */
public interface IProperty {
	
	public Property create(ArrayList<Object> data);
	
	public String display();

	public String displayVacant();

	public String displayRented();

}
