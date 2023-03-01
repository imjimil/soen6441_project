import controller.Controller;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 */
public class ProjectPhase1 {
	
	private Controller controller;
	
	public ProjectPhase1() {
		controller = new Controller();
	}

	public static void main(String[] args) {
		ProjectPhase1 main = new ProjectPhase1();
		main.demo();
	}
	
	public void demo() {
		controller.mainFunction();
	}

}
