package VehicleRegistration;

/**
 * Concrete class that provides corporate owners' member variables
 * and behaviours.
 *
 * @author Daniel Barros - Student ID: 12184305
 * Updated: 15/08/2022
 */
public class CorporateOwner extends Owner {
    private int abn;

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
