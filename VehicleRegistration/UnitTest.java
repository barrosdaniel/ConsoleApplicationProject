package VehicleRegistration;

import java.util.ArrayList;

/**
 * Internal Class providing unit testing for the Owner and Vehicles classes
 * and subclasses.
 *
 * @author Daniel Barros - Student ID: 12184305
 * Updated: 15/08/2022
 */
public class UnitTest {
    private static final ArrayList<Owner> owners = new ArrayList<>();
    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        owners.add(new PrivateOwner("Jamie Harold", "1 Macquarie St", "0411 111 111", 1001, "20/01/2000"));
        owners.add(new CorporateOwner("Jamal Abdul", "1 Ferris Cl", "0422 222 222", 123456789));
        vehicles.add(new LightVehicle("1XS789", "Fromyota", "SUV-2", 2020,
                true, 98764321, 1512357895, 7));
        vehicles.add(new HeavyVehicle("1XL123", "Toto", "T-5000", 2020,
                false, 555999333, 1234567891, 5000));

        for (Owner o : owners) {
            System.out.println(o);
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}
