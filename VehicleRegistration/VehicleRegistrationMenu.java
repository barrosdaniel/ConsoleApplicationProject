package VehicleRegistration;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleRegistrationMenu {

    private final int ENTER_OWNER = 1;
    private final int ENTER_VEHICLE = 2;
    private final int SEARCH_OWNER = 3;
    private final int SEARCH_VEHICLE = 4;
    private final int EXIT = 5;
    private final ArrayList<Owner> owners = new ArrayList<>();
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    // TODO -- declare any further constants

    private boolean isStringNumeric(String str) {
	    for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
		        return false;
            }
        }
	    return true;
    }
    
    private int getMenuItem() {
        Scanner inputMenuChoice = new Scanner(System.in);
        
        System.out.println("\nPlease select from the following");
        System.out.println(ENTER_OWNER + ". Enter owner details");
        System.out.println(ENTER_VEHICLE  + ". Enter vehicle details");
        System.out.println(SEARCH_OWNER + ". Search owner");
        System.out.println(SEARCH_VEHICLE + ". Search vehicle");
        System.out.println(EXIT + ". Exit the application");
        System.out.print("\nEnter choice==> ");

        String choice = inputMenuChoice.nextLine();

	    while (choice.equals("") || !isStringNumeric(choice)) {
            System.out.println("Error - Menu selection name cannot be blank and must be numeric");
	        System.out.print("Enter choice==> ");
	        choice = inputMenuChoice.nextLine();
	    }
	    return Integer.parseInt(choice);
    }
    
    private void processOrders() {
        int choice = getMenuItem();
	
        while (choice != EXIT) {
     	    switch (choice) {
                case ENTER_OWNER:
                	enterOwnerRecord();
                    break;
		        case ENTER_VEHICLE:
			        enterVehicleRecord();
			        break;
		        case SEARCH_OWNER:
                    searchOwner();
			        break;
		        case SEARCH_VEHICLE:
			        searchVehicle();
			        break;
		        default:
			        System.out.println("ERROR - Choice not recognised");
            }
            choice = getMenuItem();
    	}
    }
         
    private void enterOwnerRecord() {
        // Read in the owner details
        String ownerType = getOwnerType();
        int id;
        String dob;
        int abn;
        String name;
        String address;
        String phoneNumber;
        if (ownerType.equalsIgnoreCase("p")) {
            id = getOwnerID();
            dob = getOwnerDOB();
        } else if (ownerType.equalsIgnoreCase("c")) {
            abn = getOwnerABN();
        }
        name = getOwnerName();
        address = getOwnerAddress();
        phoneNumber = getOwnerPhoneNumber();
        // TODO -- Create a Owner object and add it to the ArrayList
        // TODO -- Display owner information
    }

    private String getOwnerType() {
        System.out.print("\nPlease enter the type of the owner (press p for " +
                "private, press c for corporate): ");
        return input.nextLine();
    }

    private int getOwnerID() {
        System.out.print("Please enter owner ID: ");
        return input.nextInt();
    }

    private String getOwnerDOB() {
        input.nextLine(); // Avoid Java String after int input bug
        System.out.print("Please enter owner date of birth: ");
        return input.nextLine();
    }

    private int getOwnerABN() {
        System.out.print("Please enter owner ABN: ");
        return input.nextInt();
    }

    private String getOwnerName() {
        System.out.print("Please enter owner name: ");
        return input.nextLine();
    }

    private String getOwnerAddress() {
        System.out.print("Please enter owner address: ");
        return input.nextLine();
    }

    private String getOwnerPhoneNumber() {
        System.out.print("Please enter phone number: ");
        return input.nextLine();
    }
    
    private void enterVehicleRecord() {
	    // TODO -- read in the vehicle details
        // TODO -- Create a Vehicle object and add it to the ArrayList
        // TODO -- Display vehicle information
    }

    private void searchOwner() {
        // TODO -- read the search key
		// TODO -- loop though the current entries in the ArrayList to search for the search key 
        // Looping can be done in another method and called from here
		// TODO -- display the found item or report it has not been found  
    }

    private void searchVehicle() {
        // TODO -- read the search key
		// TODO -- loop though the current entries in the ArrayList to search for the search key
         // Looping can be done in another method and called from here
		// TODO -- display the found item or report it has not been found
    }

    public static void main(String[] args) {
        VehicleRegistrationMenu app = new VehicleRegistrationMenu();
        System.out.println("Welcome to the TMR Vehicle Registration System");
	    app.processOrders();
    }
}
