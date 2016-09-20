package javaapplication2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class RecentlyDeceived extends Terrorist {

    /**
     * Default constructor
     */
    public RecentlyDeceived() {
    }

    /**
     * @param e
     */
    public void ReentlyDeceived(Environment e) {
        // TODO implement here
    }

    /**
     * @param g2d 
     * @return
     */
    public void draw(Graphics2D g2d) {
        // TODO implement here
        
          g2d.setColor(Color.GREEN);
   
         float dash[] = { 10.0f };
    g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        g2d.drawOval((int)this.position.x - 64, (int)this.position.y - 64, 128, 128);
        g2d.drawString("Terrorist", (int)this.position.x - 32 , (int)this.position.y - 70);
        g2d.drawString(this.s.getName(), (int)this.position.x, (int)this.position.y + 80);
      g2d.drawImage(icon, (int)this.position.x - 20,(int)this.position.y - 20,40,40,null);
       g2d.drawString(this.s.numberOfTurns + "", (int)this.position.x, (int)this.position.y + 90);
    
    
    }

}