import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame implements ActionListener {

    private JPanel contentPane;
    private JFrame frame;
    private AddressBook currentBook;
    private List<AddressBook> addressBookList;
    private JList<AddressBook> addresses;
    DefaultListModel<AddressBook> bookModel;

    public MainFrame(){

        addressBookList = new ArrayList<>();
        //DEBUG
        AddressBook test = new AddressBook();
        BuddyInfo testguy = new BuddyInfo();
        test.addBuddy(testguy);
        addressBookList.add(test);

        frame = new JFrame("AddressBook");
        frame.setSize(new Dimension(500,500));
        // the frame is not visible until we set it to be so

        contentPane = new JPanel();
        contentPane.setSize(new Dimension(400,300));
        contentPane.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu addressControlMenu = new JMenu("Address");
        menuBar.add(addressControlMenu);

        JMenuItem item;

        item = new JMenuItem("Create Address Book");
        item.addActionListener(this);
        item.setActionCommand("create");
        addressControlMenu.add(item);

        item = new JMenuItem("Add Buddy");
        item.addActionListener(this);
        item.setActionCommand("add");
        addressControlMenu.add(item);

        item = new JMenuItem("Remove Buddy");
        item.addActionListener(this);
        item.setActionCommand("remove");
        addressControlMenu.add(item);

        frame.add(contentPane);

        displayAddressBooks();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void displayAddressBooks(){
        System.out.println("Displaying Address Books");
        bookModel = new DefaultListModel<>();
        for(AddressBook book: addressBookList){
            //System.out.println("Adding book");
            bookModel.addElement(book);
        }
        addresses = new JList<>(bookModel);
        addresses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contentPane.add(addresses);
        frame.revalidate();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        if(command.equals("create")){
            AddressBook createdBook = new AddressBook();
            addressBookList.add(createdBook);
            bookModel.addElement(createdBook);
            frame.revalidate();
        } else if(command.equals("add")){
            int bookSelected = addresses.getSelectedIndex();
            if(bookSelected != -1) {
                currentBook = addresses.getSelectedValue();
                String name = JOptionPane.showInputDialog(frame, "Name of buddy:");
                if (name != null) {
                    String address = JOptionPane.showInputDialog(frame, "Address of buddy:");
                    if (address != null) {
                        String phoneNumber = JOptionPane.showInputDialog(frame, "Phone Number of buddy:");
                        if (phoneNumber != null) {
                            currentBook.addBuddy(new BuddyInfo(name, address, phoneNumber));
                            frame.revalidate();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame,"An address book must be selected!");
            }
            frame.revalidate();

        } else if(command.equals("remove")){
            int bookSelected = addresses.getSelectedIndex();
            if(bookSelected != -1) {
                currentBook = addresses.getSelectedValue();
                String indexString = JOptionPane.showInputDialog(frame, "Index of buddy to remove:");
                if (indexString != null) {
                    int index = Integer.parseInt(indexString);
                    if(!currentBook.removeBuddy(index)){
                        JOptionPane.showMessageDialog(frame,"Buddy index invalid!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame,"An address book must be selected!");
            }
            frame.revalidate();
        }
    }

    public static void main(String[] args){
        //Creates buddyInfo object for testing
        new MainFrame();
    }

}
