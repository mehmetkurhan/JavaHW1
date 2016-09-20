package javaapplication2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * 
 */
public class Display extends JPanel {

    /**
     * Default constructor
     */
    public static final int WIDTH = 1024;
    public static final int HEIGHT =700;
    public static final int TOP_PANEL_HEIGHT = 100;
    private BufferedImage trImage;
    private Environment env;
    public Display(Environment env){
        this.env = env;
        this.setBackground(Color.WHITE);
    }


    /**
     * @return
     */
    public Dimension getPreferredSize() {
        // TODO implement here
        Dimension d = new Dimension();
        d.setSize(WIDTH, HEIGHT);
        return d;
    }

    /**
     * @param g
     */
   // @Override
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(env.map, 0, TOP_PANEL_HEIGHT, WIDTH, HEIGHT, null);
    
        g2d.drawLine(0, TOP_PANEL_HEIGHT, WIDTH, TOP_PANEL_HEIGHT);
        g2d.setColor(Color.MAGENTA);
        g2d.drawString("Death Toll  :", 20, 20);
        g2d.setColor(Color.CYAN);
        g2d.drawString("Citizens    :" + env.deadCitizens, 20, 50);
        g2d.setColor(Color.GREEN);
        g2d.drawString("Soldiers    :" + env.deadSoldiers, 20, 80);
        g2d.setColor(Color.BLUE);
        g2d.drawString("Agents      :" + env.deadAgents, 320, 50);
        g2d.setColor(Color.RED);
        g2d.drawString("Terrorists:" + env.deadTerrorists, 320, 80);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Step              :" + env.steps, 620, 20);
        g2d.setColor(Color.RED);
        g2d.drawString("Caught by agents  :" + env.caughtByAgents, 620, 50);
        g2d.drawString("Caught by soldiers:" + env.caughtBySoldiers, 620, 80);
        g2d.drawImage(env.icon, 920, 20, 64, 64, this);
        synchronized(env)
        {
        for(Entity e: env.entities)
        {
            e.draw(g2d);
        }
        }

    }  
  
   

}