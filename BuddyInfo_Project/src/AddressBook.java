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
        System.out.println("Address Book");
    }

}
