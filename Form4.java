package book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Form4 extends JFrame implements ActionListener {
    JLabel firstNameLabel, lastNameLabel, phoneLabel, emailLabel, passwordLabel, addressLabel, dobLabel, genderLabel, ageLabel, usernameLabel;
    JTextField firstNameField, lastNameField, phoneField, emailField, addressField, dobField, ageField, usernameField;
    JPasswordField passwordField;
    JRadioButton maleButton, femaleButton, othersButton;
    ButtonGroup genderGroup;
    JButton signUpButton, cancelButton;
    JPanel panel;
    Form3 loginForm;
    JLayeredPane layeredPane;
    JLabel imageLabel;

    public Form4(Form3 loginForm) {
        super("Sign Up");
        this.loginForm = loginForm;

        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(900, 600));

        ImageIcon imageIcon = new ImageIcon("D:\\java project\\WhatsApp Image 2025-01-24 at 17.45.06_2212700b.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 900, 600);
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);


        
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(80, 20, 150, 25); 
        panel.add(firstNameLabel);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(80, 60, 150, 25); 
        panel.add(lastNameLabel);

        phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(80, 100, 150, 25); 
        panel.add(phoneLabel);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(80, 140, 150, 25); 
        panel.add(emailLabel);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(80, 220, 150, 25); 
        panel.add(addressLabel);

        dobLabel = new JLabel("Date of Birth (DD/MM/YYYY)");
        dobLabel.setBounds(80, 260, 250, 25); 
        panel.add(dobLabel);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(80, 300, 150, 25); 
        panel.add(ageLabel);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(80, 380, 150, 25); 
        panel.add(genderLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(300, 20, 150, 25);
        panel.add(firstNameField);

        lastNameField = new JTextField();
        lastNameField.setBounds(300, 60, 150, 25);
        panel.add(lastNameField);

        phoneField = new JTextField();
        phoneField.setBounds(300, 100, 150, 25);
        panel.add(phoneField);

        emailField = new JTextField();
        emailField.setBounds(300, 140, 150, 25);
        panel.add(emailField);

        addressField = new JTextField();
        addressField.setBounds(300, 220, 150, 25);
        panel.add(addressField);

        dobField = new JTextField();
        dobField.setBounds(300, 260, 150, 25);
        panel.add(dobField);

        ageField = new JTextField();
        ageField.setBounds(300, 300, 150, 25);
        panel.add(ageField);

       
        maleButton = new JRadioButton("Male");
        maleButton.setBounds(300, 380, 70, 25);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(370, 380, 70, 25);
        othersButton = new JRadioButton("Others");
        othersButton.setBounds(450, 380, 100, 25);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(othersButton);

        panel.add(maleButton);
        panel.add(femaleButton);
        panel.add(othersButton);

        
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(80, 420, 150, 25); 
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(300, 420, 150, 25);
        panel.add(usernameField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(80, 460, 150, 25); 
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(300, 460, 150, 25);
        panel.add(passwordField);

        
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(80, 500, 100, 25);
        signUpButton.addActionListener(this);
        panel.add(signUpButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 500, 100, 25);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
        this.add(layeredPane);
        this.setVisible(true);
    }
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == signUpButton) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String dob = dobField.getText();
        String age = ageField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Others";

        // Validation checks
        if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || dob.isEmpty() || age.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Pattern.matches("[a-zA-Z]+", firstName) || !Pattern.matches("[a-zA-Z]+", lastName)) {
            JOptionPane.showMessageDialog(this, "First and Last Name can only contain letters", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Pattern.matches("\\d+", phone) || phone.length() != 11) {
            JOptionPane.showMessageDialog(this, "Phone number must be 11 digits", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Pattern.matches("\\d+", age)) {
            JOptionPane.showMessageDialog(this, "Age must be a number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!isValidBirthdate(dob)) {
            JOptionPane.showMessageDialog(this, "Invalid Date of Birth format. Use DD.MM.YYYY", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        try {
            File userFile = new File("userData.txt");
            FileWriter writer = new FileWriter(userFile, true); 
            String userData = "First Name: " + firstName + "\n" +
                              "Last Name: " + lastName + "\n" +
                              "Phone: " + phone + "\n" +
                              "Email: " + email + "\n" +
                              "Address: " + address + "\n" +
                              "DOB: " + dob + "\n" +
                              "Age: " + age + "\n" +
                              "Gender: " + gender + "\n" +
                              "Username: " + username + "\n" +
                              "Password: " + password + "\n\n";
            writer.write(userData);
            writer.close();
            JOptionPane.showMessageDialog(this, "Sign Up successful! Please log in now.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

       
        String[] details = new String[]{password, firstName, lastName, phone, address};
        loginForm.addUser(username, password, details);

        this.dispose(); 
        loginForm.setVisible(true); 
    } else if (ae.getSource() == cancelButton) {
        this.dispose(); 
        loginForm.setVisible(true); 
    }
}

	    private boolean isValidBirthdate(String dob) {
        String dobRegex = "^\\d{1,2}\\.\\d{1,2}\\.\\d{4}$";
        return dob.matches(dobRegex);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }

    public static void main(String[] args) {
         new Form4(new Form3());
    }
}
