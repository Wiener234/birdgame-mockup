package mockup;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Level extends JPanel{
    Level(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        

        CustomButton level1 = new CustomButton();
        CustomButton level2 = new CustomButton();
        CustomButton level3 = new CustomButton();
        try {
            BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource("pol.png"));
            level1 = new CustomButton(img);
            level2 = new CustomButton(img);
            level3 = new CustomButton(img);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        c.insets = new Insets(50, 50, 50, 50);
        add(level1,c);
        add(level2,c);
        add(level3,c);
       
        
    }
}
