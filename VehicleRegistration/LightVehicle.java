package VehicleRegistration;

/**
 * Concrete class that provides light vehicles' member variables
 * and behaviours.
 *
 * @author Daniel Barros - Student ID: 12184305
 * Updated: 15/08/2022
 */
public class LightVehicle extends Vehicle {
    private int numberOfSeats;

    public LightVehicle(String plateNumber, String make, String model, int year,
                        boolean isPrivate, int ownerId, int ownerABN,
                        int numberOfSeats) {
        super(plateNumber, make, model, year, isPrivate, ownerId, ownerABN);
        setNumberOfSeats(numberOfSeats);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return String.format("LightVehicle {Plate number: %s, Make: %s, " +
                "Model: %s, Year: %d, Private: %b, Owner ID: %d, Owner ABN: " +
                "%d, Number of Seats: %d}", getPlateNumber(), getMake(),
                getModel(), getYear(), isPrivate(), getOwnerId(),
                getOwnerABN(), getNumberOfSeats());
    }
}
