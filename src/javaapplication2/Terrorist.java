package javaapplication2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Terrorist extends Entity {

    /**
     * Default constructor
     */
    public BufferedImage icon;
    public BufferedImage brainIcon;
    public BufferedImage bombIcon;
    public Position target;
    public Terrorist() {
        this.speed = 10;
        target = new Position();
    }
   


    /**
     * 
     */
    public void Terrorist() {
        // TODO implement here
    }
    
       @Override
    public void draw(Graphics2D g2d)
    {
         g2d.setColor(Color.RED);
   
         float dash[] = { 10.0f };
    g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));  
        g2d.drawOval((int)this.position.x, (int)this.position.y, 128, 128);  
        g2d.drawString("Terrorist", (int)this.position.x + 32, (int)this.position.y - 16);
        g2d.drawString(this.s.getName(), (int)this.position.x + 70, (int)this.position.y + 160);
      g2d.drawImage(icon, (int)this.position.x + 44,(int)this.position.y + 44,40,40,null);
        g2d.drawString(this.s.numberOfTurns + "", (int)this.position.x + 70, (int)this.position.y + 170);
    }

}