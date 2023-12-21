package mockup.ui.views;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import mockup.ui.components.CustomButton;

public class Level extends JPanel{
    public Level(Window window, Menu menu){
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
        back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // leave it be until level and game are implemented
                // cause thats how game(loop) and level setup should be done
                // Level1 level1 = new Level1();
                // Game game = new Game(level1);
                window.navTo(menu);

            } 
        });

        c.insets = new Insets(0, 0, 0, 0);
        c.gridy=1;
        c.gridx = 1;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.ipady = 75;
        add(level1,c);
        c.gridy=1;
        c.gridx = 2;
        c.anchor = GridBagConstraints.NORTH;
        add(level2,c);
        c.gridy=1;
        c.gridx = 3;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(level3,c);
        c.ipady = 0;
        c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridy=0;
        c.gridx = 1;
        add(back, c);
       
        
    }
}
