package javaapplication2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.util.*;

/**
 * 
 */
public class Camp extends Entity {

    /**
     * Default constructor
     */
    public Camp() {
    }
    
    @Override
    public void draw(Graphics2D g2d)
    {
        
        g2d.setColor(new Color(0,255,0,64));
   
        
        g2d.setStroke(new BasicStroke(5));
        g2d.drawOval((int)this.position.x, (int)this.position.y, 40, 40);
        g2d.fillOval((int)this.position.x, (int)this.position.y, 40, 40);   
        g2d.setColor(Color.BLUE);
        g2d.drawString("Camp", (int)this.position.x, (int)this.position.y + 25);  
        
    }

}