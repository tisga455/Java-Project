package book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form10 extends JFrame implements ActionListener {
    JButton fictionButton, poetryButton, romButton, backButton; 
    JPanel panel;
    JLabel imageLabel, dayLabel;
    JTextField dayField;
    JLayeredPane layeredPane;
    String firstName, lastName, phone, address;

    public Form10(String firstName, String lastName, String phone, String address) {
        super("Exchange Book Options");

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;

        this.setSize(559, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(559, 400));

        ImageIcon imageIcon = new ImageIcon("D:\\java project\\WhatsApp Image 2025-01-24 at 17.45.06_ea9e9e1f.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 559, 400);
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 559, 400);

        JLabel exchangeLabel = new JLabel("<html>Select a type of book to Exchange:</html>");
        exchangeLabel.setBounds(200, 60, 600, 30);
        panel.add(exchangeLabel);

        fictionButton = new JButton("Fiction - OtherBooks - 3tk");
        fictionButton.setBounds(80, 120, 400, 30);
        fictionButton.addActionListener(this);
        panel.add(fictionButton);

        poetryButton = new JButton("Poetry - OtherBooks - 4tk");
        poetryButton.setBounds(80, 170, 400, 30);
        poetryButton.addActionListener(this);
        panel.add(poetryButton);

        romButton = new JButton("Romance - OtherBooks - 5tk");
        romButton.setBounds(80, 220, 400, 30);
        romButton.addActionListener(this);
        panel.add(romButton);

        
        dayLabel = new JLabel("Enter number of days:");
        dayLabel.setBounds(80, 270, 200, 30);
        panel.add(dayLabel);

        dayField = new JTextField();
        dayField.setBounds(250, 270, 100, 30);
        panel.add(dayField);

        
        backButton = new JButton("Back");
        backButton.setBounds(179, 310, 200, 30);
        backButton.addActionListener(this); 
        panel.add(backButton);

        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
        this.add(layeredPane);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String bookExchange = "";
        int costPerDay = 0;

        
        if (ae.getSource() == fictionButton) {
            bookExchange = "Fiction - OtherBooks";
            costPerDay = 3;
        } else if (ae.getSource() == poetryButton) {
            bookExchange = "Poetry - OtherBooks";
            costPerDay = 4;
        } else if (ae.getSource() == romButton) {
            bookExchange = "Romance - OtherBookst";
            costPerDay = 5;
        } else if (ae.getSource() == backButton) {
            
            new Form5(firstName, lastName, phone, address);
            this.dispose();
            return; 
        }

        try {
            int days = Integer.parseInt(dayField.getText());
            int totalCost = costPerDay * days;

            
            new Form13(firstName, lastName, phone, address, bookExchange, totalCost);
            this.dispose(); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number of days.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        
        String firstName = "Muskan";  
        String lastName = "Mim";     
        String phone = "1234567890"; 
        String address = "Dhaka"; 
        
        new Form10(firstName, lastName, phone, address); 
    }
}
