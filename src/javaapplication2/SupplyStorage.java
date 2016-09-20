package javaapplication2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.util.*;
import javafx.scene.shape.Circle;

/**
 * 
 */
public class SupplyStorage extends Entity {

    /**
     * Default constructor
     */
    public SupplyStorage() {
    }
    @Override
    public void draw(Graphics2D g2d)
    {
        
      
        int posx = (int) this.position.x;
        int posy = (int) this.position.y;
      
      
     
      
        g2d.setColor(new Color(255,0,0,64));
        g2d.setStroke(new BasicStroke(5));
        
       
        g2d.drawOval(posx, posy, 60, 60);
        g2d.fillOval(posx, posy, 60, 60);  
        g2d.setColor(Color.BLUE);
        g2d.drawString("Strorage", posx + 5, posy + 35);   
    }

}