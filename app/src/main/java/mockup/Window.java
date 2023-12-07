package mockup;
import javax.swing.*;

public class Window extends JFrame {
    Level level = new Level();
    Menu menu = new Menu(this, level);
	Window(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
        setResizable(false);
        setTitle("Bird Game");
		
		
		setContentPane(menu);
        setVisible(true);
	}

    public void navTo(JPanel panel){
        this.setContentPane(panel);
        this.repaint();
        this.revalidate();
    }

	
}

