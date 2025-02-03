package book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form7 extends JFrame implements ActionListener {
    JButton closeButton;
    JPanel panel;
    JLayeredPane layeredPane;
    JLabel imageLabel;

    public Form7() {
        super("Fictional Books");

        this.setSize(650, 420); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 

        
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(650, 400));

        
        ImageIcon imageIcon = new ImageIcon("D:\\java project\\WhatsApp Image 2025-01-24 at 17.45.07_6c3da043.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 650, 400); // Set the image dimensions

        
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null); 
        panel.setBounds(0, 0, 650, 400); 
		
        
        JLabel infoLabel = new JLabel("List of Fictional Books!");
        infoLabel.setBounds(20, -10, 600, 100);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        panel.add(infoLabel);

        
        JTextArea list = new JTextArea();
        list.setText("Available books:\n\n"
            + "1. Pride and Prejudice by (Jane Austen).\n"
            + "2. The Great Gatsby by (F. Scott Fitzgerald).\n"
            + "3. Jane Eyre by (Charlotte Brontë).\n"
            + "4. 1984 by (George Orwell).\n"
            + "5. The Catcher in the Rye by (J. D. Salinger).\n"
            + "6. The Life Impossible by (Matt Haig).\n"
            + "7. To Kill a Mockingbird by (Harper Lee).\n"
            + "8. Catch-22 by (Joseph Heller).\n"
            + "9. Brave New World by (Aldous Huxley).\n"
            + "10. The Book Thief by (Markus Zusak).");
        list.setBounds(20, 130, 600, 200);
        list.setLineWrap(true);
        list.setWrapStyleWord(true);
        list.setBackground(new Color(0, 0, 0, 0));
        list.setEditable(false); 
        panel.add(list);

        
        closeButton = new JButton("Close");
        closeButton.setBounds(250, 340, 150, 30); 
        closeButton.setBackground(Color.WHITE); 
        closeButton.addActionListener(this);
        panel.add(closeButton);

        
        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER); 

        
        this.add(layeredPane);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        this.dispose(); 
    }

    public static void main(String[] args) {
        new Form7(); 
    }
}
