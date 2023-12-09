package mockup;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Menu extends JPanel{
    protected Window window;
    protected Level level;
    Menu(Window window, Level level){
        this.window = window;
        this.level = level;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        

        // CustomButton buttonlevel = new CustomButton("Level");
        CustomButton buttonlevel = new CustomButton("Level");
        buttonlevel.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // leave it be until level and game are implemented
                // cause thats how game(loop) and level setup should be done
                // Level1 level1 = new Level1();
                // Game game = new Game(level1);
                window.navTo(level);

            } 
        });
        CustomButton manuel = new CustomButton("Manuel");
        CustomButton highscore = new CustomButton("Highscore");
        CustomButton credits = new CustomButton("Credits");
        CustomButton sound = new CustomButton("Sound");
        CustomButton music = new CustomButton("Music");
        CustomButton logout = new CustomButton("Logout");
        try {
            BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource("sound.png"));
            music = new CustomButton(img);
            sound = new CustomButton(img);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        c.insets = new Insets(5, 100, 5, 5);
        c.fill = GridBagConstraints.RELATIVE;
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(buttonlevel, c);
        c.gridx = 0;
        c.gridy = 3;
        add(manuel, c);
        c.gridx = 0;
        c.gridy = 4;
        add(highscore, c);
        c.gridx = 0;
        c.gridy = 5;
        add(credits, c);
        c.anchor = GridBagConstraints.SOUTHEAST;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 6;
        add(logout, c);
        c.weighty = 0;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.gridx = 1;
        c.gridy = 0;
        add(sound, c);
        c.weighty = .75;
        c.gridx = 1;
        c.gridy = 1;
        add(music, c);
        
    }
}
