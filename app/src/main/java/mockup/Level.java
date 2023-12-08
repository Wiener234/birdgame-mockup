package mockup;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Level extends JPanel{
    Level(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        

        // JButton level1 = new JButton();
        JButton level2 = new JButton();
        JButton level3 = new JButton();
        CustomButton level1 = new CustomButton();
        try {
            Image img = ImageIO.read(getClass().getClassLoader().getResource("pol.jpeg"));
            img = img.getScaledInstance(300,200, Image.SCALE_SMOOTH);
            // level1.setIcon(new ImageIcon(img));
            // level1.setBackground(Color.WHITE);
            level2.setIcon(new ImageIcon(img));
            level2.setBackground(Color.WHITE);
            level3.setIcon(new ImageIcon(img));
            level3.setBackground(Color.WHITE);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        c.insets = new Insets(50, 50, 50, 50);
        // c.ipadx = 40;
        // c.ipady = 120;

        
        add(level1,c);
        add(level2,c);
        add(level3,c);
       
        
    }
}
