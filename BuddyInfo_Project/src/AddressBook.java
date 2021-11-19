import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AddressBook extends DefaultListModel {
    private ArrayList<BuddyInfo> buddies;
    private int id;
    private static int counter = 0;

    public AddressBook(){
        buddies = new ArrayList<BuddyInfo>();
        id = counter;
        counter++;
    }

    public void addBuddy(BuddyInfo buddy){
        buddies.add(buddy);
    }

    public boolean removeBuddy(int target){

        if(target > -1 && target < buddies.size()){
            buddies.remove(target);
            return true;
        }
        return false;
    }

    public ArrayList<BuddyInfo> getBuddies() {
        return buddies;
    }

    @Override
    public String toString() {
        return "AddressBook " + id +
                ": Buddies:" + buddies;
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
