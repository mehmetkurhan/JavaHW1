package javaapplication2;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class Exploded extends TerroristDecorator {

    /**
     * Default constructor
     */
    public int stepCounter = 20;
    public List<Entity> killed;
    public Exploded(Terrorist t) {
        super(t);
        killed = new ArrayList<Entity>();
          this.stepFactory = t.stepFactory;
        this.position = t.position;
        t.s = new StandStill();
        this.target = t.target;
        this.s = new StandStill();
        this.brainIcon = t.brainIcon;
        this.bombIcon = t.bombIcon;
    }

    /**
     * @param t
     */
    public void Exploded(Terrorist t) {
        // TODO implement here
        this.position.x = this.decoratedTerrorist.position.x;
        this.position.y = this.decoratedTerrorist.position.y;
        this.s = new StandStill();
    }

    /**
     * @param g2d 
     * @return
     */
    public void draw(Graphics2D g2d) {
        // TODO implement here
  
       this.decoratedTerrorist.draw(g2d);
       float cons = (float)stepCounter / 20;
       int color = (int)( cons * 255);
        g2d.setColor(new Color(255,0,0,color));
       g2d.fillOval((int)this.position.x - 64, (int)this.position.y - 64, 128, 128);  
      g2d.drawString(this.s.getName(), (int)this.position.x, (int)this.position.y + 80);
     
       
    }

}