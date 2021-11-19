import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddressController implements ActionListener, ListSelectionListener {

    private AddressBook currentBook;
    private List<AddressBook> addressBookList;

    public AddressController(){
        addressBookList = new ArrayList<>();
        //DEBUG
        AddressBook test = new AddressBook();
        BuddyInfo testguy = new BuddyInfo();
        test.addBuddy(testguy);
        addressBookList.add(test);
    }

    public AddressBook getCurrentBook() {
        return currentBook;
    }

    public List<AddressBook> getAddressBookList() {
        return addressBookList;
    }

    public void setCurrentBook(AddressBook currentBook) {
        this.currentBook = currentBook;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            //final List<String> selectedValuesList = (JList<AddressBook>)e.getSource().getSelectedValuesList();
            //System.out.println(selectedValuesList);
        }
    }
}
