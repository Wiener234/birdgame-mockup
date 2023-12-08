package mockup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

public class CustomButton extends JComponent implements MouseListener {

    private int WIDTH = 120;
    private int HEIGHT = 60;
    private int MAX_WIDTH;
    private int MAX_HEIGHT;
    private int MIN_WIDTH = 40;
    private int MIN_HEIGHT = 40;
    private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

    private Font font = new Font("TimesRoman", Font.BOLD, 20);

    private boolean mouseEntered = false;


    private String text = "";
    
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
        Graphics2D antiAlias = (Graphics2D)g;
        antiAlias.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);

        
        //draw outer part (trick: fill full button and draw inner parte above)
        if(mouseEntered){
            g.setColor(new Color(00,00,00,00));
        }else{
            g.setColor(Color.GRAY);
        }
        g.fillRoundRect(0,0, WIDTH, HEIGHT, 50,100);
        if(mouseEntered){
            g.setColor(Color.GREEN.darker().darker());
        }else{
            g.setColor(Color.GREEN.darker());
        }
        g.fillRoundRect(0,0, this.WIDTH-1, this.HEIGHT-5, 50, 100);
        g.setColor(Color.GREEN.darker());
        //inner part
        g.fillRoundRect(1,5, WIDTH-1, HEIGHT-10, 50, 100);
        g.setColor(Color.BLACK);
        //Border
        g.drawRoundRect(0,0, this.WIDTH-1, this.HEIGHT-5, 50, 100);
        //Text
        g.setFont(font);
        g.drawString(this.text, 
                WIDTH/2 - g.getFontMetrics(font).stringWidth(this.text)/2, 
                HEIGHT/2 + g.getFontMetrics(font).getHeight()/4);

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        mouseEntered = false;
        repaint();

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        notifyListeners(arg0);

    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        mouseEntered = true;
        repaint();

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
