package javaapplication2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class BrainWashed extends TerroristDecorator {

    /**
     * Default constructor
     */
    
    public BufferedImage brainIcon;
    public BrainWashed(Terrorist t) {
        super(t);
        this.stepFactory = t.stepFactory;
        this.position = t.position;
        this.s = new MoveRandom();
        this.brainIcon = t.brainIcon;
        this.bombIcon = t.bombIcon;
    }

    /**
     * @param t
     */


    /**
     * @param g2d 
     * @return
     */
    @Override
    public void step(double deltaTime)
    {
        super.step(deltaTime);
    }
    @Override
    public void draw(Graphics2D g2d) {
      //super.draw(g2d);
  
      this.decoratedTerrorist.draw(g2d);
      g2d.setColor(Color.RED);
      float [] dash = { 10f };
      g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
      BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
      g2d.drawOval((int)this.position.x - 64, (int)this.position.y - 64, 128, 128);
      g2d.drawImage(brainIcon, (int)this.position.x - 40,(int)this.position.y - 10,20,20,null);
      g2d.drawString(this.s.getName(), (int)this.position.x, (int)this.position.y + 80);
      g2d.drawString(this.s.numberOfTurns + "", (int)this.position.x, (int)this.position.y + 90);
      
       
    }

}