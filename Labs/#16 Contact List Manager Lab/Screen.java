import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class Screen extends JPanel implements ActionListener {
    private Contact[] contactList;

    private JButton searchFirstName;
    private JButton searchLastName;
    private JButton searchUsername;
    private JButton searchEmailDomainName;
    private JButton searchEmailDomainExtension;
    private JButton addContact;

    private JTextField searchInput;
    private JTextPane allContactsPane;
    private JTextPane resultsPane;
    private JTextArea addContactExample;

    private int nextOpenContactListSpot;

    public Screen() {
        this.setLayout(null);

        contactList = new Contact[10];
        contactList[0] = new Contact("John", "Smith", "john.smith@mvla.net");
        contactList[1] = new Contact("Jen", "Doe", "jendoe@gmail.com");
        contactList[2] = new Contact("Ben", "Burman", "bburman@yahoo.com");
        contactList[3] = new Contact("Mohammed", "Sanchez", "mosanchez@aol.net");
        contactList[4] = new Contact("Mesut", "Bellerin", "mbell@godaddy.com");
        contactList[5] = new Contact();
        contactList[6] = new Contact();
        contactList[7] = new Contact();
        contactList[8] = new Contact();
        contactList[9] = new Contact();

        allContactsPane = new JTextPane();
        allContactsPane.setBounds(10, 240, 380, 300);
        this.add(allContactsPane);

        String allContactsStr = "";
        for ( Contact each : contactList ) {
            allContactsStr += each.toString();
        }
        allContactsPane.setText(allContactsStr);

        searchFirstName = new JButton("Search First Name");
        searchFirstName.setBounds(10, 50, 200, 30);
        searchFirstName.addActionListener(this);
        this.add(searchFirstName);

        searchLastName = new JButton("Search Last Name");
        searchLastName.setBounds(10, 80, 200, 30);
        searchLastName.addActionListener(this);
        this.add(searchLastName);

        searchUsername = new JButton("Search Username");
        searchUsername.setBounds(10, 110, 200, 30);
        searchUsername.addActionListener(this);
        this.add(searchUsername);

        searchEmailDomainName = new JButton("Search Domain Name");
        searchEmailDomainName.setBounds(10, 140, 200, 30);
        searchEmailDomainName.addActionListener(this);
        this.add(searchEmailDomainName);

        searchEmailDomainExtension = new JButton("Search Domain Extension");
        searchEmailDomainExtension.setBounds(10, 170, 200, 30);
        searchEmailDomainExtension.addActionListener(this);
        this.add(searchEmailDomainExtension);

        addContact = new JButton("Add Contact");
        addContact.setBounds(10, 200, 200, 30);
        addContact.addActionListener(this);
        this.add(addContact);

        addContactExample = new JTextArea("ex. John,Smith,johnsmith@gmail.com");
        addContactExample.setBounds(220, 205, 205, 20);
        this.add(addContactExample);

        searchInput = new JTextField();
        searchInput.setBounds(240, 50, 100, 30);
        this.add(searchInput);

        resultsPane = new JTextPane();
        resultsPane.setBounds(400, 240, 380, 300);
        this.add(resultsPane);

        nextOpenContactListSpot = 5;

        this.setFocusable(true);    
    }

    public void addContact() {
        try {
            String newContactInfo = searchInput.getText();
            String firstName = newContactInfo.substring(0, newContactInfo.indexOf(","));
            String lastName = newContactInfo.substring(newContactInfo.indexOf(",") + 1, newContactInfo.lastIndexOf(","));
            String email = newContactInfo.substring(newContactInfo.lastIndexOf(",") + 1);
            contactList[nextOpenContactListSpot] = new Contact(firstName, lastName, email);
            nextOpenContactListSpot++;
        } catch (Exception e) {
            resultsPane.setText("Please enter information with correct format");
            if ( nextOpenContactListSpot >= 9 ) {
                resultsPane.setText("Maximum contacts reached");
            }
        }

        // updating allContactsPane
        String allContactsStr = "";
        for ( Contact each : contactList ) {
            allContactsStr += each.toString();
        }
        allContactsPane.setText(allContactsStr);
    }
     
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
  
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
 
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == searchFirstName ) {
            String searchResult = searchInput.getText();

            String results = "";
            for ( Contact each : contactList ) {
                if ( each.getFirstName().equals(searchResult) ) {
                    results += each.toString();
                }
            }

            resultsPane.setText(results);
        }

        if ( e.getSource() == searchLastName ) {
            String searchResult = searchInput.getText();

            String results = "";
            for ( Contact each : contactList ) {
                if ( each.getLastName().equals(searchResult) ) {
                    results += each.toString();
                }
            }

            resultsPane.setText(results);
        }

        if ( e.getSource() == searchUsername ) {
            String searchResult = searchInput.getText();

            String results = "";
            for ( Contact each : contactList ) {
                if ( each.getEmailUsername().equals(searchResult) ) {
                    results += each.toString();
                }
            }

            resultsPane.setText(results);
        }

        if ( e.getSource() == searchEmailDomainName ) {
            String searchResult = searchInput.getText();

            String results = "";
            for ( Contact each : contactList ) {
                if ( each.getEmailDomainName().equals(searchResult) ) {
                    results += each.toString();
                }
            }

            resultsPane.setText(results);
        }

        if ( e.getSource() == searchEmailDomainExtension ) {
            String searchResult = searchInput.getText();

            String results = "";
            for ( Contact each : contactList ) {
                if ( each.getEmailDomainExtension().equals(searchResult) ) {
                    results += each.toString();
                }
            }

            resultsPane.setText(results);
        }

        if ( e.getSource() == addContact ) {
            addContact();
        }
    }
}