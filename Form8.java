package book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form8 extends JFrame implements ActionListener {
    JButton closeButton;
    JPanel panel;
    JLayeredPane layeredPane;
    JLabel imageLabel;

    public Form8() {
        super("Romance Novels");

        this.setSize(650, 420); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 

        
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(650, 400));

        
        ImageIcon imageIcon = new ImageIcon("E:\\JAVA programing\\OOPProject\\c1179485-4734-486c-8e32-0da1752b2b73.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 650, 400); 

        
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        
        panel = new JPanel();
        panel.setOpaque(false); 
        panel.setLayout(null); 
        panel.setBounds(0, 0, 650, 400); 

        
        JLabel infoLabel = new JLabel("List of Romance Novels!");
        infoLabel.setBounds(20, -10, 600, 100);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        panel.add(infoLabel);

        
        JTextArea list = new JTextArea();
        list.setText("Available books:\n\n"
            + "1. The Notebook.\n"
            + "2. Gone with the Wind.\n"
            + "3. Romeo and Juliet.\n"
            + "4. A Walk to Remember.\n"
            + "5. Beautiful Disaster.\n"
            + "6. Gone with the Wind.\n"
            + "7. Me Before You.\n"
            + "8. Get a Life, Chloe Brown.\n"
            + "9. The Fault in Our Stars.\n"
            + "10. An Extraordinary Union.");
        list.setBounds(20, 110, 600, 230);
        list.setLineWrap(true);
        list.setWrapStyleWord(true);
        list.setBackground(new Color(0, 0, 0, 0)); 
        //list.setForeground(Color.WHITE); 
        list.setEditable(false); 
        panel.add(list);

        
        closeButton = new JButton("Close");
        closeButton.setBounds(250, 340, 150, 30); 
        //closeButton.setForeground(Color.BLACK); 
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
        new Form8(); 
    }
}
