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
        int id = 0;
        String dob = null;
        int abn = 0;
        String name;
        String address;
        String phoneNumber;
        Owner newOwner;
        if (ownerType.equalsIgnoreCase("p")) {
            id = getOwnerID();
            dob = getOwnerDOB();
        } else if (ownerType.equalsIgnoreCase("c")) {
            abn = getOwnerABN();
        }
        name = getOwnerName();
        address = getOwnerAddress();
        phoneNumber = getOwnerPhoneNumber();
        // Create an Owner object and add it to the ArrayList
        if (ownerType.equalsIgnoreCase("p")) {
            newOwner = new PrivateOwner(name, address, phoneNumber, id, dob);
            owners.add(newOwner);
        } else {
            newOwner = new CorporateOwner(name, address, phoneNumber, abn);
            owners.add(newOwner);
        }
        // Display owner information
        displayOwnerInformation(newOwner);
    }

    private String getOwnerType() {
        System.out.print("\nPlease enter the type of the owner (press p for " +
                "private, press c for corporate): ");
        return input.nextLine();
    }

    private int getOwnerID() {
        System.out.print("Please enter owner ID: ");
        int ownerID = Integer.parseInt(input.nextLine());
        for (Owner o : owners) {
            if (o instanceof PrivateOwner) {
                if (((PrivateOwner) o).getId() == ownerID) {
                    System.out.println("ERROR: An owner with this ID already " +
                            "exists. Please try again.");
                    getOwnerID();
                }
            }
        }
        return ownerID;
    }

    private String getOwnerDOB() {
        System.out.print("Please enter owner date of birth: ");
        return input.nextLine();
    }

    private int getOwnerABN() {
        System.out.print("Please enter owner ABN: ");
        int ownerABN = Integer.parseInt(input.nextLine());
        for (Owner o : owners) {
            if (o instanceof CorporateOwner) {
                if (((CorporateOwner) o).getAbn() == ownerABN) {
                    System.out.println("ERROR: An owner with this ABN already" +
                            " exists. Please try again.");
                    getOwnerABN();
                }
            }
        }
        return ownerABN;
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

    private void displayOwnerInformation(Owner newOwner) {
        if (newOwner instanceof PrivateOwner) {
            PrivateOwner privateOwner = (PrivateOwner) newOwner;
            System.out.printf("\n%-12s %-16s %-16s %-32s %-14s","ID",
                "Date of Birth", "Name", "Address", "Phone Number");
            System.out.printf("\n%-12s %-16s %-16s %-32s %-14s\n",
                    privateOwner.getId(), privateOwner.getDateOfBirth(),
                    privateOwner.getName(), privateOwner.getAddress(),
                    privateOwner.getPhoneNumber());
        } else {
            CorporateOwner corporateOwner = (CorporateOwner) newOwner;
            System.out.printf("\n%-16s %-16s %-32s %-14s","ABN",
                    "Name", "Address", "Phone Number");
            System.out.printf("\n%-16s %-16s %-32s %-14s\n",
                    corporateOwner.getAbn(), corporateOwner.getName(), corporateOwner.getAddress(),
                    corporateOwner.getPhoneNumber());
        }
    }
    
    private void enterVehicleRecord() {
	    // Read in the vehicle details
        String vehicleType;
        String plateNumber = null;
        String make;
        String model;
        int year;
        boolean isPrivate;
        int ownerID = 0;
        int ownerABN = 0;
        int numberOfSeats = 0;
        int loadCapacity = 0;
        Vehicle newVehicle;
        vehicleType = getVehicleType();
        if (vehicleType.equalsIgnoreCase("l")) {
            plateNumber = getVehiclePlateNumber();
            numberOfSeats = getVehicleNumberOfSeats();
        } else if (vehicleType.equalsIgnoreCase("h")) {
            plateNumber = getVehiclePlateNumber();
            loadCapacity = getVehicleLoadCapacity();
        }
        make = getVehicleMake();
        model = getVehicleModel();
        year = getVehicleYear();
        if (getOwnerType().equalsIgnoreCase("p")) {
            isPrivate = true;
            System.out.print("Please enter owner ID: ");
            ownerID = Integer.parseInt(input.nextLine());
        } else {
            isPrivate = false;
            System.out.print("Please enter owner ABN: ");
            ownerABN = Integer.parseInt(input.nextLine());
        }

        // Create a Vehicle object and add it to the ArrayList
        if (vehicleType.equalsIgnoreCase("l")) {
            newVehicle = new LightVehicle(plateNumber, make, model, year,
                    isPrivate, ownerID, ownerABN, numberOfSeats);
            vehicles.add(newVehicle);
        } else {
            newVehicle = new HeavyVehicle(plateNumber, make, model, year,
                    isPrivate, ownerID, ownerABN, loadCapacity);
            vehicles.add(newVehicle);
        }
        // Display vehicle information
        displayVehicleInformation(newVehicle);
    }

    private String getVehicleType() {
        System.out.print("\nPlease enter the type of the vehicle (press l " +
                "for light, press h for heavy): ");
        return input.nextLine();
    }

    private String getVehiclePlateNumber() {
        System.out.print("Please enter the vehicle plate number: ");
        String newVehiclePlateNumber = input.nextLine();
        for (Vehicle v : vehicles) {
            if (v.getPlateNumber().equals(newVehiclePlateNumber)) {
                System.out.println("ERROR: A vehicle with this plate number " +
                        "already exists. Please try again.");
                getVehiclePlateNumber();
            }
        }
        return newVehiclePlateNumber;
    }

    private int getVehicleNumberOfSeats() {
        System.out.print("Please enter number of seats: ");
        return Integer.parseInt(input.nextLine());
    }

    private int getVehicleLoadCapacity() {
        System.out.print("Please enter capacity: ");
        return Integer.parseInt(input.nextLine());
    }

    private String getVehicleMake() {
        System.out.print("Please enter the vehicle make: ");
        return input.nextLine();
    }

    private String getVehicleModel() {
        System.out.print("Please enter the vehicle model: ");
        return input.nextLine();
    }

    private int getVehicleYear() {
        System.out.print("Please enter the vehicle year: ");
        return Integer.parseInt(input.nextLine());
    }

    private void displayVehicleInformation(Vehicle newVehicle) {
        String vehicleTypeLabel;
        int ownerIdentifier;
        if (newVehicle.isPrivate()) {
            vehicleTypeLabel = "Private";
            ownerIdentifier = newVehicle.getOwnerId();
        } else {
            vehicleTypeLabel = "Corporate";
            ownerIdentifier = newVehicle.getOwnerABN();
        }

        if (newVehicle instanceof LightVehicle) {
            LightVehicle lightVehicle = (LightVehicle) newVehicle;
            System.out.printf("\n%-14s %-12s %-12s %-12s %-6s %-12s %-12s",
                    "Plate Number", "No of Seats", "Make", "Model", "Year",
                    "OwnerType", "Owner ID/ABN");
            System.out.printf("\n%-14s %-12s %-12s %-12s %-6s %-12s %-12s",
                    lightVehicle.getPlateNumber(),
                    lightVehicle.getNumberOfSeats(), lightVehicle.getMake(),
                    lightVehicle.getModel(), lightVehicle.getYear(),
                    vehicleTypeLabel, ownerIdentifier);
        } else {
            HeavyVehicle heavyVehicle = (HeavyVehicle) newVehicle;
            System.out.printf("\n%-14s %-14s %-12s %-12s %-6s %-12s %-12s",
                    "Plate Number", "Load Capacity", "Make", "Model", "Year",
                    "OwnerType", "Owner ID/ABN");
            System.out.printf("\n%-14s %-14s %-12s %-12s %-6s %-12s %-12s",
                    heavyVehicle.getPlateNumber(),
                    heavyVehicle.getLoadCapacity(), heavyVehicle.getMake(),
                    heavyVehicle.getModel(), heavyVehicle.getYear(),
                    vehicleTypeLabel, ownerIdentifier);
        }
        System.out.println("");
    }

    private void searchOwner() {
        // Read the search key
        String ownerType = getOwnerType();
        int identifier;
        Owner searchedOwner;
        if (ownerType.equalsIgnoreCase("p")) {
            System.out.print("Please enter owner ID: ");
        } else {
            System.out.print("Please enter owner ABN: ");
        }
        identifier = Integer.parseInt(input.nextLine());

		// Loop though the current entries in the ArrayList to search for the search key
        searchedOwner = getSearchedOwner(identifier);

		// Display the found item or report it has not been found
        if (searchedOwner == null) {
            System.out.println("Record not found.");
        } else {
            System.out.println("Record found.");
            displayOwnerInformation(searchedOwner);
        }
    }

    private Owner getSearchedOwner(int identifier) {
        Owner searchedOwner = null;
        for (Owner o : owners) {
            if (o instanceof PrivateOwner) {
                if (((PrivateOwner) o).getId() == identifier) {
                    searchedOwner = o;
                }
            } else {
                if (((CorporateOwner) o).getAbn() == identifier) {
                    searchedOwner = o;
                }
            }
        }
        return searchedOwner;
    }

    private void searchVehicle() {
        String searchedVehiclePlateNumber;
        Vehicle searchedVehicle;
        // Read the search key
        System.out.print("Please enter the vehicle plate number: ");
        searchedVehiclePlateNumber = input.nextLine();

		// Loop though the current entries in the ArrayList to search for the search key
        searchedVehicle = getSearchedVehicle(searchedVehiclePlateNumber);

		// Display the found item or report it has not been found
        if (searchedVehicle == null) {
            System.out.println("Record not found.");
        } else {
            System.out.println("Record found.");
            displayVehicleInformation(searchedVehicle);
        }

    }

    private Vehicle getSearchedVehicle(String searchedVehiclePlateNumber) {
        Vehicle searchedVehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getPlateNumber().equals(searchedVehiclePlateNumber)) {
                searchedVehicle = v;
            }
        }
        return searchedVehicle;
    }

    public static void main(String[] args) {
        VehicleRegistrationMenu app = new VehicleRegistrationMenu();
        System.out.println("Welcome to the TMR Vehicle Registration System");
	    app.processOrders();
        System.out.println("""
                
                Thank you for using the TMR Vehicle Registration System
                Program written by Daniel Barros 12184305""");
    }
}
