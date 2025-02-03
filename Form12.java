package book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form12 extends JFrame implements ActionListener {
    JLabel receiptLabel, nameLabel, phoneLabel, addressLabel, bookExchangeLabel;
    JButton repurchaseButton, exitButton, confirmButton;
    JPanel panel;
    String firstName, lastName, phone, address, bookExchange, totalCost, selectedPayment;
    JLayeredPane layeredPane;
    JLabel imageLabel;

    public Form12(String firstName, String lastName, String phone, String address, String bookExchange, String totalCost, String selectedPayment) {
        super("Receipt");

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.bookExchange = bookExchange;
        this.totalCost = totalCost;
        this.selectedPayment = selectedPayment;

        this.setSize(747, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(747, 500));

        ImageIcon imageIcon = new ImageIcon("D:\\java project\\WhatsApp Image 2025-01-24 at 17.45.06_9a81e32c.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 747, 500);
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 747, 500);

        receiptLabel = new JLabel("<html><b>Congratulations, your purchase has succeeded!</b></html>");
        receiptLabel.setBounds(100, 20, 400, 30);
        panel.add(receiptLabel);

        nameLabel = new JLabel("Name: " + firstName + " " + lastName);
        nameLabel.setBounds(50, 70, 400, 30);
        panel.add(nameLabel);

        phoneLabel = new JLabel("Phone Number: " + phone);
        phoneLabel.setBounds(50, 110, 400, 30);
        panel.add(phoneLabel);

        addressLabel = new JLabel("Address: " + address);
        addressLabel.setBounds(50, 150, 400, 30);
        panel.add(addressLabel);

        bookExchangeLabel = new JLabel("Book Exchange: " + bookExchange + " - " + totalCost + " taka paid with " + selectedPayment);
        bookExchangeLabel.setBounds(50, 190, 400, 30);
        panel.add(bookExchangeLabel);

        
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(100, 250, 120, 30);
        confirmButton.addActionListener(this);
        panel.add(confirmButton);

        repurchaseButton = new JButton("Repurchase");
        repurchaseButton.setBounds(100, 300, 120, 30);
        repurchaseButton.addActionListener(this);
        panel.add(repurchaseButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(250, 300, 120, 30);
        exitButton.addActionListener(this);
        panel.add(exitButton);

        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
        this.add(layeredPane); 
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == confirmButton) {
            
            JOptionPane.showMessageDialog(this, "Congratulations You Have Exchanged your Book Successfully.\nTo Repurchase Again Click Repurchase Button.");
        } else if (ae.getSource() == repurchaseButton) {
            
            new Form10(firstName, lastName, phone, address);
            this.dispose(); 
        } else if (ae.getSource() == exitButton) {
            
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        
        String firstName = "Muskan";
        String lastName = "Mim";
        String phone = "1234567890";
        String address = "Dhaka";
        String bookExchange = "Book";
        String totalCost = "5000";
        String selectedPayment = "bKash";
        
        new Form12(firstName, lastName, phone, address, bookExchange, totalCost, selectedPayment);
    }
}
