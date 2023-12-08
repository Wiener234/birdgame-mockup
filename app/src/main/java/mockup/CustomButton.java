package mockup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

public class CustomButton extends JComponent implements MouseListener {

    private int WIDTH = 120;
    private int HEIGHT = 80;
    private int MAX_WIDTH;
    private int MAX_HEIGHT;
    private int MIN_WIDTH = 40;
    private int MIN_HEIGHT = 40;
    private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

    private String text = " ";
    
    public CustomButton(){
        super();
        enableInputMethods(true);
        addMouseListener(this);
    }
    
    public CustomButton(String text){
        super();
        this.text = text;
        enableInputMethods(true);
        addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.WIDTH, this.HEIGHT);
    }
    @Override
    public Dimension getMinimumSize() {
        return new Dimension(this.MIN_WIDTH, this.MIN_HEIGHT);
    }
    @Override
    public Dimension getMaximumSize() {
        return new Dimension(this.MAX_WIDTH, this.MAX_HEIGHT);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0, this.WIDTH, this.HEIGHT);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(this.text, WIDTH/2, HEIGHT/2 + g.getFontMetrics().getHeight());
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        notifyListeners(arg0);

    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    public void addActionListener(ActionListener listener){
        listeners.add(listener);
    }
    
    private void notifyListeners(MouseEvent e)
    {
        ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, new String(), e.getWhen(), e.getModifiers());
        synchronized(listeners)
        {
            for (int i = 0; i < listeners.size(); i++)
            {
                ActionListener tmp = listeners.get(i);
                tmp.actionPerformed(evt);
            }
        }
    }
}
