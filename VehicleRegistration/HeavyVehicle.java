package VehicleRegistration;

/**
 * Concrete class that provides heavy vehicles' member variables
 * and behaviours.
 *
 * @author Daniel Barros - Student ID: 12184305
 * Updated: 15/08/2022
 */
public class HeavyVehicle extends Vehicle {
    private int loadCapacity;

    public HeavyVehicle() {
        this("Plate number not provided", "Make not provided", "Model not " +
                "provided", 1900, false, 0, 0, 0);
    }

    public HeavyVehicle(String plateNumber, String make, String model, int year,
                        boolean isPrivate, int ownerId, int ownerABN,
                        int loadCapacity) {
        super(plateNumber, make, model, year, isPrivate, ownerId, ownerABN);
        setLoadCapacity(loadCapacity);
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return String.format("HeavyVehicle {Plate number: %s, Make: %s, " +
                        "Model: %s, Year: %d, Private: %b, Owner ID: %d, Owner ABN: " +
                        "%d, Load Capacity: %d}", getPlateNumber(), getMake(),
                getModel(), getYear(), isPrivate(), getOwnerId(),
                getOwnerABN(), getLoadCapacity());
    }
}
