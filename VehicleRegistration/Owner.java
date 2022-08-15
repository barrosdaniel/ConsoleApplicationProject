package VehicleRegistration;

/**
 * Abstract class that provides fundamental vehicle owners' member variables
 * and behaviours.
 *
 * @author Daniel Barros - Student ID: 12184305
 * Updated: 15/08/2022
 */
public abstract class Owner {
    private String name;
    private String address;
    private  String phoneNumber;

    public Owner(String name, String address, String phoneNumber) {
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
