package VehicleRegistration;

import java.util.ArrayList;

public class UnitTest {
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        owners.add(new Owner("Jamal Abdul", "1 Spencer St", "0411 111 111"));

        for (Owner o : owners) {
            System.out.println(o);
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}
