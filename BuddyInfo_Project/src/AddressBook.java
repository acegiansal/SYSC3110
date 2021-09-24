import java.util.ArrayList;
import java.util.HashMap;

public class AddressBook {
    private ArrayList<BuddyInfo> buddies;

    public AddressBook(){
        buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy){
        buddies.add(buddy);
    }

    public BuddyInfo removeBuddy(int target){

        if(target > -1 && target < buddies.size()){
            return buddies.remove(target);
        }
        return null;
    }

    public void testMethhod(){
        System.out.println("Hello, testing");
    }

    public static void main(String[] args){
        //Creates buddyInfo object for testing
        System.out.println("Creating buddy: ");
        BuddyInfo buddy = new BuddyInfo("Barlos", "Canadian Tire Centre", "101");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(0);
    }

}
