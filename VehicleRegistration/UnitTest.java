package VehicleRegistration;

import java.util.ArrayList;

public class UnitTest {
    private static final ArrayList<Owner> owners = new ArrayList<>();
    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        owners.add(new PrivateOwner("Jamie Harold", "1 Macquarie St", "0411 111 111", 1001, "20/01/2000"));
        owners.add(new CorporateOwner("Jamal Abdul", "1 Ferris Cl", "0422 222 222", 123456789));

        for (Owner o : owners) {
            System.out.println(o);
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}
