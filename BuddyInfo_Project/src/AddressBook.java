import java.util.ArrayList;
import java.util.HashMap;

public class AddressBook {
    private ArrayList<BuddyInfo> buddies;

    public void addBuddy(BuddyInfo buddy){
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy){
        buddies.remove(buddy);
    }

    public static void main(String[] args){
        BuddyInfo buddy = new BuddyInfo("Barlos", "Canadian Tire Centre", "101");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy);
    }

}
