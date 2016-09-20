package javaapplication2;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class TerroristDecorator extends Terrorist {

    /**
     * Default constructor
     */
    protected Terrorist decoratedTerrorist;
    public TerroristDecorator(Terrorist t) {
        this.decoratedTerrorist = t;
    }


    /**
     * @param t
     */
   
     public void draw(Graphics2D g2d) {
     this.decoratedTerrorist.draw(g2d);
      
      
       
    }

}