package VehicleRegistration;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Initialises and controls the flow of the Vehicle Registration application
 * and processes menu choices.
 *
 * @author Daniel Barros - Student ID: 12184305
 * Updated: 15/08/2022
 */
public class VehicleRegistrationMenu {
    // TODO 2: Add data validation loops
    // TODO 3: Write javadocs for methods
    // TODO 4: Merge to CQU Class Github repo
    // TODO 5: Write report with testing results, how long it took to develop,
    //  and any problems encountered

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
            id = getOwnerID(true);
            dob = getOwnerDOB();
        } else if (ownerType.equalsIgnoreCase("c")) {
            abn = getOwnerABN(true);
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
        String ownerType;
        boolean ownerIsValid;
        do {
            System.out.print("\nPlease enter the type of the owner (press p for " +
                    "private, press c for corporate): ");
            ownerType = input.nextLine();
            if (!ownerType.equalsIgnoreCase("p") && !ownerType.equalsIgnoreCase("c")) {
                System.out.println("Invalid entry. Please try again.");
                ownerIsValid = false;
            } else {
                ownerIsValid = true;
            }
        } while (!ownerIsValid);
        return ownerType;
    }

    private int getOwnerID(boolean checkExistingID) {
        int ownerID = 0;
        boolean idIsValid;
        do {
            try {
                System.out.print("Please enter owner ID: ");
                ownerID = Integer.parseInt(input.nextLine());
                if (ownerID <= 0) {
                    System.out.println("ERROR: Invalid entry. Owner ID must be a " +
                            "numerical positive value. Please try again.");
                    idIsValid = false;
                } else {
                    idIsValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid entry. Owner ID must be " +
                        "a numerical positive value. Please try again.");
                idIsValid = false;
            }
        } while (!idIsValid);
        if (checkExistingID) {
            for (Owner o : owners) {
                if (o instanceof PrivateOwner) {
                    if (((PrivateOwner) o).getId() == ownerID) {
                        System.out.println("ERROR: An owner with this ID already " +
                                "exists. Please try again.");
                        getOwnerID(true);
                    }
                }
            }
        }
        return ownerID;
    }

    private String getOwnerDOB() {
        String ownerDOB;
        boolean isDOBValid;
        do {
            System.out.print("Please enter owner date of birth: ");
            ownerDOB = input.nextLine();
            if (ownerDOB.equals("")) {
                System.out.println("ERROR: Date of Birth must be entered. " +
                        "Please try again.");
                isDOBValid = false;
            } else {
                isDOBValid = true;
            }
        } while (!isDOBValid);
        return ownerDOB;
    }

    private int getOwnerABN(boolean checkExistingABN) {
        int ownerABN = 0;
        boolean isABNValid;
        do {
            try {
                System.out.print("Please enter owner ABN: ");
                ownerABN = Integer.parseInt(input.nextLine());
                if (ownerABN <= 0) {
                    System.out.println("ERROR: Invalid entry. Owner ABN must " +
                            "be a numerical positive value. Please try again.");
                    isABNValid = false;
                } else {
                    isABNValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid entry. Owner ABN must " +
                        "be a numerical positive value. Please try again.");
                isABNValid = false;
            }
        } while (!isABNValid);
        if (checkExistingABN){
            for (Owner o : owners) {
                if (o instanceof CorporateOwner) {
                    if (((CorporateOwner) o).getAbn() == ownerABN) {
                        System.out.println("ERROR: An owner with this ABN already" +
                                " exists. Please try again.");
                        getOwnerABN(true);
                    }
                }
            }
        }
        return ownerABN;
    }

    private String getOwnerName() {
        String ownerName;
        boolean isNameValid;
        do {
            System.out.print("Please enter owner name: ");
            ownerName = input.nextLine();
            if (ownerName.equals("")) {
                System.out.println("ERROR: Name must be entered. " +
                        "Please try again.");
                isNameValid = false;
            } else {
                isNameValid = true;
            }
        } while (!isNameValid);
        return ownerName;
    }

    private String getOwnerAddress() {
        String ownerAddress;
        boolean isAddressValid;
        do {
            System.out.print("Please enter owner address: ");
            ownerAddress = input.nextLine();
            if (ownerAddress.equals("")) {
                System.out.println("ERROR: Address must be entered. " +
                        "Please try again.");
                isAddressValid = false;
            } else {
                isAddressValid = true;
            }
        } while (!isAddressValid);
        return ownerAddress;
    }

    private String getOwnerPhoneNumber() {
        String ownerPhoneNumber;
        boolean isPhoneNumberValid;
        do {
            System.out.print("Please enter owner phone number: ");
            ownerPhoneNumber = input.nextLine();
            if (ownerPhoneNumber.equals("")) {
                System.out.println("ERROR: Phone Number must be entered. " +
                        "Please try again.");
                isPhoneNumberValid = false;
            } else {
                isPhoneNumberValid = true;
            }
        } while (!isPhoneNumberValid);
        return ownerPhoneNumber;
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
            ownerID = getOwnerID(false);
        } else {
            isPrivate = false;
            ownerABN = getOwnerABN(false);
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
        String vehicleType;
        boolean isTypeValid;
        do {
            System.out.print("\nPlease enter the type of the vehicle (press l " +
                    "for light, press h for heavy): ");
            vehicleType = input.nextLine();
            if (!vehicleType.equalsIgnoreCase("l") && !vehicleType.equalsIgnoreCase("h")) {
                System.out.println("Invalid entry. Please try again.");
                isTypeValid = false;
            } else {
                isTypeValid = true;
            }
        } while (!isTypeValid);
        return vehicleType;
    }

    private String getVehiclePlateNumber() {
        String newVehiclePlateNumber;
        boolean isPlateNumberValid;
        do {
            System.out.print("Please enter the vehicle plate number: ");
            newVehiclePlateNumber = input.nextLine();
            if (newVehiclePlateNumber.equals("")) {
                System.out.println("ERROR: Vehicle plate number must be " +
                        "entered. Please try again.");
                isPlateNumberValid = false;
            } else {
                isPlateNumberValid = true;
            }
        } while (!isPlateNumberValid);
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
        int vehicleNumberOfSeats = 0;
        boolean isNumberOfSeatsValid;
        do {
            try {
                System.out.print("Please enter the vehicle number of seats: ");
                vehicleNumberOfSeats = Integer.parseInt(input.nextLine());
                if (vehicleNumberOfSeats <= 0) {
                    System.out.println("ERROR: Invalid entry. Number of seats " +
                            "must be a numerical positive value. Please try again" +
                            ".");
                    isNumberOfSeatsValid = false;
                } else {
                    isNumberOfSeatsValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid entry. Number of seats " +
                        "must be a numerical positive value. Please try again" +
                        ".");
                isNumberOfSeatsValid = false;
            }
        } while (!isNumberOfSeatsValid);
        return vehicleNumberOfSeats;
    }

    private int getVehicleLoadCapacity() {
        int vehicleLoadCapacity = 0;
        boolean isVehicleLoadCapacityValid;
        do {
            try {
                System.out.print("Please enter the vehicle capacity: ");
                vehicleLoadCapacity = Integer.parseInt(input.nextLine());
                if (vehicleLoadCapacity <= 0) {
                    System.out.println("ERROR: Invalid entry. Number of seats " +
                            "must be a numerical positive value. Please try again" +
                            ".");
                    isVehicleLoadCapacityValid = false;
                } else {
                    isVehicleLoadCapacityValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid entry. Load Capacity must be a numerical positive value. Please try again.");
                isVehicleLoadCapacityValid = false;
            }
        } while (!isVehicleLoadCapacityValid);
        return vehicleLoadCapacity;
    }

    private String getVehicleMake() {
        String vehicleMake;
        boolean isVehicleMakeValid;
        do {
            System.out.print("Please enter the vehicle make: ");
            vehicleMake = input.nextLine();
            if (vehicleMake.equals("")) {
                System.out.println("ERROR: Vehicle make must be entered. Please try again.");
                isVehicleMakeValid = false;
            } else {
                isVehicleMakeValid = true;
            }
        } while (!isVehicleMakeValid);
        return vehicleMake;
    }

    private String getVehicleModel() {
        String vehicleModel;
        boolean isVehicleModelValid;
        do {
            System.out.print("Please enter the vehicle model: ");
            vehicleModel = input.nextLine();
            if (vehicleModel.equals("")) {
                System.out.println("ERROR: Vehicle model must be entered. Please try again.");
                isVehicleModelValid = false;
            } else {
                isVehicleModelValid = true;
            }
        } while (!isVehicleModelValid);
        return vehicleModel;
    }

    private int getVehicleYear() {
        int vehicleYear = 0;
        boolean isVehicleYearValid;
        do {
            try {
                System.out.print("Please enter the vehicle year: ");
                vehicleYear = Integer.parseInt(input.nextLine());
                if (vehicleYear < 1890) {
                    System.out.println("ERROR: Invalid entry. Vehicle year " +
                            "must be at least 1890. Please try again.");
                    isVehicleYearValid = false;
                } else {
                    isVehicleYearValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid entry. Vehicle year must " +
                        "be a numerical positive value at least 1890. Please " +
                        "try again.");
                isVehicleYearValid = false;
            }
        } while (!isVehicleYearValid);
        return vehicleYear;
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
            System.out.printf("\n%-14s %-12s %-12s %-12s %-6s %-12s %-12s\n",
                    lightVehicle.getPlateNumber(),
                    lightVehicle.getNumberOfSeats(), lightVehicle.getMake(),
                    lightVehicle.getModel(), lightVehicle.getYear(),
                    vehicleTypeLabel, ownerIdentifier);
        } else {
            HeavyVehicle heavyVehicle = (HeavyVehicle) newVehicle;
            System.out.printf("\n%-14s %-14s %-12s %-12s %-6s %-12s %-12s",
                    "Plate Number", "Load Capacity", "Make", "Model", "Year",
                    "OwnerType", "Owner ID/ABN");
            System.out.printf("\n%-14s %-14s %-12s %-12s %-6s %-12s %-12s\n",
                    heavyVehicle.getPlateNumber(),
                    heavyVehicle.getLoadCapacity(), heavyVehicle.getMake(),
                    heavyVehicle.getModel(), heavyVehicle.getYear(),
                    vehicleTypeLabel, ownerIdentifier);
        }
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
            if (v.getPlateNumber().equalsIgnoreCase(searchedVehiclePlateNumber)) {
                searchedVehicle = v;
            }
        }
        return searchedVehicle;
    }

    private void displayWelcomeMessage() {
        System.out.println("Welcome to the TMR Vehicle Registration System");
    }

    private void displayExitMessage() {
        System.out.println("""
                
                Thank you for using the TMR Vehicle Registration System
                Program written by Daniel Barros 12184305""");
    }

    public static void main(String[] args) {
        VehicleRegistrationMenu app = new VehicleRegistrationMenu();
        app.displayWelcomeMessage();
	    app.processOrders();
        app.displayExitMessage();
    }
}
