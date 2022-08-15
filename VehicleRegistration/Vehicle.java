package VehicleRegistration;

    /**
     * Abstract class that provides fundamental vehicle member variables
     * and behaviours.
     *
     * @author Daniel Barros - Student ID: 12184305
     * Updated: 15/08/2022
     */
public abstract class Vehicle {
    private String plateNumber;
    private String make;
    private String model;
    private int year;
    private boolean isPrivate;
    private int ownerId;
    private int ownerABN;

    public Vehicle(String plateNumber, String make, String model, int year, boolean isPrivate, int ownerId, int ownerABN) {
        setPlateNumber(plateNumber);
        setMake(make);
        setModel(model);
        setYear(year);
        setPrivate(isPrivate);
        setOwnerId(ownerId);
        setOwnerABN(ownerABN);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerABN() {
        return ownerABN;
    }

    public void setOwnerABN(int ownerABN) {
        this.ownerABN = ownerABN;
    }
}
