package VehicleRegistration;

public class LightVehicle extends Vehicle {
    private int numberOfSeats;

    public LightVehicle() {
        this("Plate number not provided", "Make not provided", "Model not " +
                "provided", 1900, true, 0, 0, 0);
    }

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
