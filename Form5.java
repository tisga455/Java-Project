package book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form5 extends JFrame implements ActionListener {
    JRadioButton fictionRadioButton, poetryRadioButton, romanceRadioButton;
    JButton listButton, cancelButton, exchangeButton;
    JLayeredPane layeredPane;
    JPanel panel;
    ButtonGroup bookGroup;
    JLabel imageLabel;

    private String firstName, lastName, phone, address;

    public Form5(String firstName, String lastName, String phone, String address) {
        super("Select Books");

        
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;

        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 400));

        ImageIcon imageIcon = new ImageIcon("D:\\java project\\WhatsApp Image 2025-01-24 at 17.45.07_515c39bc.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 600, 400);
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 400);

        fictionRadioButton = new JRadioButton("Fiction");
        fictionRadioButton.setBounds(20, 70, 100, 25);
        panel.add(fictionRadioButton);

        poetryRadioButton = new JRadioButton("Poetry");
        poetryRadioButton.setBounds(20, 100, 100, 25);
        panel.add(poetryRadioButton);

        romanceRadioButton = new JRadioButton("Romance");
        romanceRadioButton.setBounds(20, 130, 100, 25);
        panel.add(romanceRadioButton);

        bookGroup = new ButtonGroup();
        bookGroup.add(fictionRadioButton);
        bookGroup.add(poetryRadioButton);
        bookGroup.add(romanceRadioButton);

        listButton = new JButton("List of Books");
        listButton.setBounds(40, 170, 150, 25);
        listButton.addActionListener(this);
        panel.add(listButton);

        exchangeButton = new JButton("Exchange Books");
        exchangeButton.setBounds(200, 170, 150, 25);
        exchangeButton.addActionListener(this);
        panel.add(exchangeButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(160, 220, 100, 25);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
        this.add(layeredPane);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == listButton || ae.getSource() == exchangeButton) {
            
            if (!fictionRadioButton.isSelected() && !poetryRadioButton.isSelected() && !romanceRadioButton.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select at least one book option.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
        }

        if (ae.getSource() == listButton) {
            if (fictionRadioButton.isSelected()) {
                new Form7(); 
            } else if (romanceRadioButton.isSelected()) {
                new Form8(); 
            } else if (poetryRadioButton.isSelected()) {
                new Form9();
            }
        } else if (ae.getSource() == exchangeButton) {
            new Form10(firstName, lastName, phone, address); 
            this.dispose(); 
        } else if (ae.getSource() == cancelButton) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        
        new Form5("Muskan", "Mim", "1234567890", "Dhaka");
    }
}
