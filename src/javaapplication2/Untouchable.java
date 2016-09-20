package javaapplication2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */

public class Untouchable extends Entity {

    /**
     * Default constructor
     */
    public BufferedImage icon;
    public Untouchable() {
        this.speed = 20;
    }
    
     @Override
    public void draw(Graphics2D g2d)
    {
        
         g2d.setColor(Color.BLACK);
    
         g2d.setStroke(new BasicStroke(5));
        g2d.drawRect((int)this.position.x, (int)this.position.y, 64, 64);
        g2d.drawString("Untouchable", (int)this.position.x + 5, (int)this.position.y - 20);
        g2d.drawString(this.s.getName(), (int)this.position.x + 35, (int)this.position.y + 80);
     
      g2d.drawImage(icon, (int)this.position.x + 10,(int)this.position.y + 10,40,40,null);  
    }

}