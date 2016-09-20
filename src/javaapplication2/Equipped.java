package javaapplication2;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class Equipped extends TerroristDecorator {

    /**
     * Default constructor
     */
    public Equipped(Terrorist t) {
        super(t);
        this.stepFactory = t.stepFactory;
        this.position = t.position;
        this.s = t.s;
        this.brainIcon = t.brainIcon;
        this.bombIcon = t.bombIcon;
    }

    /**
     * @param t
     */
    public void Equipped(Terrorist t) {
        // TODO implement here
        this.s = this.stepFactory.createStrategy();
    }

    /**
     * @param g2d 
     * @return
     */
    public void draw(Graphics2D g2d) {
        // TODO implement here
        
        this.decoratedTerrorist.draw(g2d);
        g2d.drawImage(bombIcon, (int)this.position.x + 32,(int)this.position.y ,20,20,null);
        g2d.drawString(this.s.numberOfTurns + "", (int)this.position.x, (int)this.position.y + 90);
        g2d.drawString(this.s.getName(), (int)this.position.x, (int)this.position.y + 80);
      // g2d.drawOval( (int)this.position.x,(int)this.position.y,30,30);
      //  System.out.println("Equipped13");  
      
    }

}