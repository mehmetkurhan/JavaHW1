package javaapplication2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Soldier extends Entity {

    /**
     * Default constructor
     */
    public BufferedImage icon;
    public Soldier() {
        this.speed = 20;
    }
    
    @Override
    public void draw(Graphics2D g2d)
    {
        
         g2d.setColor(Color.BLUE);
   
         float dash[] = { 10.0f };
    g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        g2d.drawOval((int)this.position.x, (int)this.position.y, 64, 64);
        g2d.drawString("Soldier", (int)this.position.x + 5, (int)this.position.y - 15);
        g2d.drawString(this.s.getName(), (int)this.position.x + 30, (int)this.position.y + 80);
     
      g2d.drawImage(icon, (int)this.position.x + 10,(int)this.position.y + 10,40,40,null);  
    }

}