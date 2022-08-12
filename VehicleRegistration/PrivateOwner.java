package VehicleRegistration;

public class PrivateOwner extends Owner {
    private int id;
    private String dateOfBirth;

    public PrivateOwner() {
        this("Name not supplied", "Address not supplied", "Phone number not supplied", 0, "DOB not provided");
    }

    public PrivateOwner(String name, String address, String phoneNumber, int id, String dateOfBirth) {
        super(name, address, phoneNumber);
        setId(id);
        setDateOfBirth(dateOfBirth);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("PrivateOwner {Name: %s, Address: %s, Phone number: %s, ID: %d, DOB: %s}", getName(), getAddress(), getPhoneNumber(), getId(), getDateOfBirth());
    }
}
