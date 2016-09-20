package javaapplication2;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class Citizen extends Entity {

    /**
     * Default constructor
     */
    public Citizen() {
        super();
        this.speed = 10;
     
         Random r = new Random();
        int red =  (int)(r.nextDouble() * 255);
        int green = (int)(r.nextDouble() * 255);
        int blue = (int)(r.nextDouble() * 255);
        this.color = new Color(red,green,blue);
    }
    
    @Override
    public void draw(Graphics2D g2d)
    {
       
        g2d.setColor(this.color);
       g2d.fillOval((int)this.position.x, (int)this.position.y, 10, 10);
        g2d.drawString("Citizen", (int)this.position.x - 10,(int)this.position.y - 2);
        g2d.drawString(this.s.numberOfTurns + "", (int)this.position.x - 10,(int)this.position.y + 30);
        g2d.drawString(this.s.getName(), (int)this.position.x,(int)this.position.y + 20);  
        
       
    }

}