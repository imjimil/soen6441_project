import java.util.Scanner;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 */
public class ProjectPhase1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("--------------------------");
			System.out.println("1.  Add a property");
			System.out.println("2.  Add a tenant");
			System.out.println("3.  Rent a unit");
			System.out.println("4.  Display tenants");
			System.out.println("5.  Display properties");
			System.out.println("6.  Display vacant units");
			System.out.println("7.  Display rented units");
			System.out.println("8.  Display paid/not paid rent units");
			System.out.println("9.  Express an interest in a unit");
			System.out.println("10. Display all leases");
			System.out.println("11. Display leases that will be ending");
			System.out.println("12. Display potential tenants and their units");
			System.out.println("13. Exit");
			System.out.print("Your choice:");
			int cmd = scanner.nextInt();
			switch (cmd){
			case 1:
				// Add a property
				
				break;
			case 2:
				// Add a tenant
				
				break;
			
			case 3:
				// Rent a unit
				
				break;
			case 4:
				// Display tenants
				
				break;
			case 5:
				// Display properties
				
				break;
			case 6:
				// Display vacant units
				
				break;
			case 7:
				// Display rented units
				
				break;
			case 8:
				// Display paid/not paid rent units
				
				break;
			case 9:
				// Express an interest in a unit
				
				break;
			case 10:
				// Display all leases
				
				break;
			case 11:
				// Display leases that will be ending
				
				break;
			case 12:
				// Display potential tenants and their units
				
				break;
				
			case 13:
				// Exit
				scanner.close();
				System.out.println("Exiting...");
				return;
				
			default:
				System.out.println("Enter right value");
			}
		}
	}

}
