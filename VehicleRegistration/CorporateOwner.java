package VehicleRegistration;

public class CorporateOwner extends Owner {
    private int abn;

    public CorporateOwner() {
        this("Name not supplied", "Address not supplied", "Phone number not supplied", 0);
    }

    public CorporateOwner(String name, String address, String phoneNumber, int abn) {
        super(name, address, phoneNumber);
        setAbn(abn);
    }

    public int getAbn() {
        return abn;
    }

    public void setAbn(int abn) {
        this.abn = abn;
    }

    @Override
    public String toString() {
        return String.format("CorporateOwner {Name: %s, Address: %s, Phone number: %s, ABN: %d}", getName(), getAddress(), getPhoneNumber(), getAbn());
    }
}
