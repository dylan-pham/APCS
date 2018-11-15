import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
 
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class Screen extends JPanel implements ActionListener {
    private Bank c1;
    private Bank c2;
    private Bank c3;
    private JTextField pinInput;
    private JTextField transactionInput;
    private JTextField nameInput;
    private JButton checkPinButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton updateNameButton;
    private JButton logoutButton;
    private BufferedImage background;

    public Screen() {
        setLayout(null);

        try {
            background = ImageIO.read(new File("atm.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        c1 = new Bank("John", 100.99, 1234, 0);
        c2 = new Bank("Jen", 1000.01, 4321, 1);
        c3 = new Bank("Jerry", 50.50, 1111, 2);

        pinInput = new JTextField();
        pinInput.setBounds(50, 135, 100, 25);
        add(pinInput);

        checkPinButton = new JButton("Login");
        checkPinButton.setBounds(50, 170, 100, 25);
        checkPinButton.addActionListener(this);
        add(checkPinButton);

        transactionInput = new JTextField();
        transactionInput.setBounds(50, 240, 250, 25);
        add(transactionInput);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 275, 100, 25);
        depositButton.addActionListener(this);
        add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(200, 275, 100, 25);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        nameInput = new JTextField();
        nameInput.setBounds(50, 345, 100, 25);
        add(nameInput);

        updateNameButton = new JButton("Update");
        updateNameButton.setBounds(50, 380, 100, 25);
        updateNameButton.addActionListener(this);
        add(updateNameButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1025, 25, 100, 25);
        logoutButton.addActionListener(this);
        add(logoutButton);
        
        setFocusable(true);
    }
    public Dimension getPreferredSize() {
        return new Dimension(1145, 916);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, null);

        g.drawString("Name: ", 50, 50);
        g.drawString("Balance: ", 50, 75);

        if ( c1.getName().equals("No access") ) {
            ;
        } else {
            g.drawString("Name: " + c1.getName(), 50, 50);
            g.drawString("Balance: " + c1.getBalance(), 50, 75);
        }

        if ( c2.getName().equals("No access") ) {
            ;
        } else {
            g.drawString("Name: " + c2.getName(), 50, 50);
            g.drawString("Balance: " + c2.getBalance(), 50, 75);
        }

        if ( c3.getName().equals("No access") ) {
            ;
        } else {
            g.drawString("Name: " + c3.getName(), 50, 50);
            g.drawString("Balance: " + c3.getBalance(), 50, 75);
        }
        
        g.drawString("PIN", 50, 125);

        g.drawString("Deposit/Withdraw", 50, 230);

        g.drawString("Update Name", 50, 335);
    }

    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == checkPinButton ) {
            String pinText = pinInput.getText();
            int pin = Integer.parseInt(pinText);
            c1.checkPin(pin);
            c2.checkPin(pin);
            c3.checkPin(pin);
        }

        if ( e.getSource() == depositButton ) {
            String depositText = transactionInput.getText();
            double deposit = Double.parseDouble(depositText);
            c1.deposit(deposit);
            c2.deposit(deposit);
            c3.deposit(deposit);
        }

        if ( e.getSource() == withdrawButton ) {
            String withdrawText = transactionInput.getText();
            Double withdraw = Double.parseDouble(withdrawText);
            c1.withdraw(withdraw);
            c2.withdraw(withdraw);
            c3.withdraw(withdraw);
        }

        if ( e.getSource() == updateNameButton ) {
            String nameText = nameInput.getText();
            c1.updateName(nameText);
            c2.updateName(nameText);
            c3.updateName(nameText);
        }

        if ( e.getSource() == logoutButton ) {
            c1.disableAccess();
            c2.disableAccess();
            c3.disableAccess();
        }
        repaint();
    }
}