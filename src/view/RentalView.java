package view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Property;
import model.Tenant;
import view.Property.PropertyTypeView;

public class RentalView {
    public RentalView() {

    }
    
    Scanner scanner = new Scanner(System.in);

    public static Date getDateFromUser(Scanner input) {
        try{
            System.out.print("Enter day: ");
            int day = input.nextInt();

            System.out.print("Enter month: ");
            int month = input.nextInt();

            System.out.print("Enter year: ");
            int year = input.nextInt();

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            return calendar.getTime();
        }catch(Exception e){
            System.out.println("An error occurred,please try again");
            return null;
        }
	}

    public ArrayList<Object> askBasicInfo(ArrayList<Property> properties, PropertyTypeView propertyTypeView, ArrayList<Tenant> tenants) {

        ArrayList<Object> savedInfo = new ArrayList<>();
        try{
        System.out.println("Here's the vacant properties.");
        if (properties.size() > 0) {
            propertyTypeView.displayVacantProperty(properties);
        }
        System.out.println();
        System.out.println("Please enter property ID you want to rent.");

        int selectedPropertyID = scanner.nextInt();

        System.out.println();
        System.out.println("Now select which tenant is buying the property.");

        if (tenants.size() > 0) {
            for (int i = 0; i < tenants.size(); i++) {
                if (tenants.get(i).toString() != null) {
                    System.out.println((i + 1) + ". " + tenants.get(i).display());
                }
            }
        } else {
            System.out.println("No tenants found.");
        }

        System.out.println("Enter ID of the Tenant");
        int selectedTenantID = scanner.nextInt();

        System.out.println("Now enter the start date of lease.");
				
        Date startDate = getDateFromUser(scanner);
        savedInfo.add(startDate);

        System.out.println();
        System.out.println("Now enter the ending date of the lease.");
        Date endDate = getDateFromUser(scanner);
        savedInfo.add(endDate);

        System.out.println("Enter the total rent.");
        int rent = scanner.nextInt();
        savedInfo.add(rent);

        scanner.nextLine();
        System.out.println("Is rent paid? (Y/N)");
        String rentPaid = scanner.nextLine();
        boolean choice = true;
        if(rentPaid.equals("Y")) {
            choice = true;
            savedInfo.add(choice);
        }
        else {
            choice = false;
            savedInfo.add(choice);
        }

        ArrayList<Object> userInput = new ArrayList<>();
        userInput.add(savedInfo);
        userInput.add(selectedPropertyID);
        userInput.add(selectedTenantID);
        
        return userInput;
        }catch(Exception e){
            System.out.println("An error occurred,please try again!!!");
            return null;
        }
    }

}
