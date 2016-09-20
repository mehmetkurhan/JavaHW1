package javaapplication2;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.imageio.ImageIO;

/**
 * 
 */
public class Agent extends Entity {

    /**
     * Default constructor
     */
    public BufferedImage icon;
    public Agent() {
        this.speed = 10;
    }
    
    @Override 
    public void draw(Graphics2D g2d)
    {
        
        g2d.setColor(Color.BLUE);
   
         float dash[] = { 10.0f };
        g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        g2d.drawOval((int)this.position.x - 32, (int)this.position.y - 32, 64, 64);
        g2d.drawString("Agent", (int)this.position.x - 5, (int)this.position.y - 42);
        g2d.drawString(this.s.getName(), (int)this.position.x, (int)this.position.y + 42);
       g2d.drawString(this.s.numberOfTurns + "", (int)this.position.x, (int)this.position.y + 52);
      g2d.drawImage(icon, (int)this.position.x - 20,(int)this.position.y - 20,40,40,null); 
   
    }

}