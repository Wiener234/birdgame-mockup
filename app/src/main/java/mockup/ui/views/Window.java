package mockup.ui.views;
import javax.swing.*;

public class Window extends JFrame {
    Menu menu = new Menu(this);
	public Window(){
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

