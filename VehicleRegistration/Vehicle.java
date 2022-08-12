package VehicleRegistration;

public abstract class Vehicle {
    private String plateNumber;
    private String make;
    private String model;
    private int year;
    private boolean isPrivate;
    private int ownerId;
    private int ownerABN;

    public Vehicle() {
        this("Plate number not provided", "Make not provided", "Model not provided", 1900, true, 0, 0);
    }

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
