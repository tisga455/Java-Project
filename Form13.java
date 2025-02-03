package book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form13 extends JFrame implements ActionListener {
    JLabel paymentLabel, methodLabel;
    JRadioButton bkashButton, nagadButton, rocketButton;
    ButtonGroup paymentGroup;
    JButton confirmButton;
    String firstName, lastName, phone, address, bookExchange;
    int totalCost;
    JLayeredPane layeredPane;
    JPanel panel;
    JLabel imageLabel;

    public Form13(String firstName, String lastName, String phone, String address, String bookExchange, int totalCost) {
        super("Payment Confirmation");

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.bookExchange = bookExchange;
        this.totalCost = totalCost;

        this.setSize(600, 477);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 477));

        
        ImageIcon imageIcon = new ImageIcon("D:\\java project\\WhatsApp Image 2025-01-24 at 17.45.07_b8e54f00.jpg");
        if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            imageLabel = new JLabel(imageIcon);
        } else {
            System.out.println("Image not found or failed to load.");
            imageLabel = new JLabel("Image not found.");
        }
        imageLabel.setBounds(0, 0, 600, 477);
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 477);

        paymentLabel = new JLabel("<html>Total Cost for " + bookExchange + ": " + totalCost + " tk</html>");
        paymentLabel.setBounds(20, 20, 400, 30);
        //paymentLabel.setForeground(Color.black);
        panel.add(paymentLabel);

        methodLabel = new JLabel("Select Payment Method:");
        methodLabel.setBounds(20, 70, 200, 30);
        //methodLabel.setForeground(Color.black);  // Changed to white for visibility
        panel.add(methodLabel);

        
        bkashButton = new JRadioButton("bKash");
        nagadButton = new JRadioButton("Nagad");
        rocketButton = new JRadioButton("Rocket");
        
        bkashButton.setBounds(20, 120, 100, 30);
        nagadButton.setBounds(140, 120, 100, 30);
        rocketButton.setBounds(260, 120, 100, 30);

        
        paymentGroup = new ButtonGroup();
        paymentGroup.add(bkashButton);
        paymentGroup.add(nagadButton);
        paymentGroup.add(rocketButton);

       
        panel.add(bkashButton);
        panel.add(nagadButton);
        panel.add(rocketButton);

        
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(20, 170, 100, 30);
        confirmButton.addActionListener(this);
        panel.add(confirmButton);

        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
        this.add(layeredPane); 
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String selectedPayment = "";

        
        if (bkashButton.isSelected()) {
            selectedPayment = "bKash";
        } else if (nagadButton.isSelected()) {
            selectedPayment = "Nagad";
        } else if (rocketButton.isSelected()) {
            selectedPayment = "Rocket";
        } else {
           
            JOptionPane.showMessageDialog(this, "Please select a payment method", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        new Form11(firstName, lastName, phone, address, bookExchange, selectedPayment, totalCost);
        this.dispose(); 
    }

    public static void main(String[] args) {
        
        new Form13("Muskan", "Mim", "1234567890", "Dhaka", "Book", 5000);
    }
}
