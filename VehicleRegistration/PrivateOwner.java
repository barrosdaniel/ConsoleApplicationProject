package VehicleRegistration;

/**
 * Concrete class that provides private owners' member variables
 * and behaviours.
 *
 * @author Daniel Barros - Student ID: 12184305
 * Updated: 15/08/2022
 */
public class PrivateOwner extends Owner {
    private int id;
    private String dateOfBirth;

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
