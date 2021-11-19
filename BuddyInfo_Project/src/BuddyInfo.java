import java.util.Objects;

public class BuddyInfo {

    private String name;
    private String address;
    private String phoneNumber;

    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo() {
        name = "Reginald";
        address = "1000 Palladium Dr";
        phoneNumber = "111-222-3333";
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return name.equals(buddyInfo.name) && address.equals(buddyInfo.address) && phoneNumber.equals(buddyInfo.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "{" + name + ", " + phoneNumber + ", " + address + "}";
    }

    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Homer", "111 Street Dr", "123-456-7890");
        System.out.println("Hello " + buddy.getName());
    }
}
