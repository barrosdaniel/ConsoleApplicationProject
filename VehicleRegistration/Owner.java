package VehicleRegistration;

public class Owner {
    private String name;
    private String address;
    private  String phoneNumber;

    public Owner() {
        this("Name not supplied", "Address not supplied", "Phone number not supplied");
    }

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

    @Override
    public String toString() {
        return String.format("Owner {Name: %s, Address: %s, Phone number: %s}\n", getName(), getAddress(), getPhoneNumber());
    }
}
