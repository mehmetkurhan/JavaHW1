package javaapplication2;
import java.util.*;

/**
 * 
 */
public class Position {

    /**
     * Default constructor
     */
    public Position() {
    }

    /**
     * 
     */
    public double x;

    /**
     * 
     */
    public double y;

    /**
     * 
     */
    public void Position() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void normalize() {
       this.x = x / length();
       this.y = y / length();
      
    }
    public double length()
    {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * @param other 
     * @return
     */
    public double distanceTo(Position other) {
        return Math.sqrt(Math.pow(this.x - other.x,2) +Math.pow(this.y - other.y,2));
      
    }
   

}