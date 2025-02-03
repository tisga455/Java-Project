package book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form9 extends JFrame implements ActionListener {
    JButton closeButton;
    JPanel panel;
    JLayeredPane layeredPane;
    JLabel imageLabel;

    public Form9() {
        super("Poetry Books");

        this.setSize(650, 420); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 

       
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(650, 400));

        
        ImageIcon imageIcon = new ImageIcon("D:\\java project\\WhatsApp Image 2025-01-24 at 17.45.07_6c3da043.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 650, 400);  

        
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        
        panel = new JPanel();
        panel.setOpaque(false); 
        panel.setLayout(null); 
        panel.setBounds(0, 0, 650, 400); 

        
        JLabel infoLabel = new JLabel("List of Poetry Books!");
        infoLabel.setBounds(20, -10, 600, 100);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        panel.add(infoLabel);

       
        JTextArea list = new JTextArea();
        list.setText("Available books:\n\n"
            + "1. The complete poems by (Emily Dickinson).\n"
            + "2. The Collected Poems by (Sylvia Plath).\n"
            + "3. The Sun and Her Flowers by (Rupi Kaur).\n"
            + "4. Howl and Other Poems by (Allen Ginsberg).\n"
            + "5. And Still I Rise by (Maya Angelou).\n"
            + "6. The Waste Land by (T. S. Eliot).\n"
            + "7. Modern Poetry: Poems by (Diane Seuss).\n"
            + "8. Pillow Thoughts by (Courtney Peppernell).\n"
            + "9. Book of Longing by (Leonard Cohen).\n"
            + "10. Shakespeare's Sonnets by (William Shakespeare).");
        list.setBounds(20, 110, 600, 230);
        list.setLineWrap(true);
        list.setWrapStyleWord(true);
        list.setBackground(new Color(0, 0, 0, 0)); 
        list.setEditable(false); 
        panel.add(list);

        
        closeButton = new JButton("Close");
        closeButton.setBounds(250, 340, 150, 30); 
        closeButton.setForeground(Color.BLACK); 
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
        new Form9(); 
    }
}
