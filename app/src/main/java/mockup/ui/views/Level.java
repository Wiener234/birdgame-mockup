package mockup.ui.views;


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

import mockup.ui.components.CustomButton;

public class Level extends JPanel{
    public Level(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        

        CustomButton level1 = new CustomButton();
        CustomButton level2 = new CustomButton();
        CustomButton level3 = new CustomButton();
        CustomButton back = new CustomButton("<--");
        try {
            BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource("pol.png"));
            level1 = new CustomButton(img);
            level2 = new CustomButton(img);
            level3 = new CustomButton(img);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        c.insets = new Insets(50, 50, 50, 50);
        c.gridy=1;
        c.gridx = 1;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(level1,c);
        c.gridy=1;
        c.gridx = 2;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(level2,c);
        c.gridy=1;
        c.gridx = 3;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(level3,c);
        c.insets = new Insets(10,10,10,10);
        c.weightx = .5;
        c.weighty = .5;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridy=0;
        c.gridx = 0;
        add(back, c);
       
        
    }
}
