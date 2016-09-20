package javaapplication2;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public abstract class Entity {

    /**
     * Default constructor
     */
    public int diameterMin;
    public int diameterMax;
    Graphics2D g2d;
    public Entity() {
       position = new Position();
    }

    /**
     * 
     */
    
    public StepStrategy s;
    public StepStrategyFactory stepFactory;
    public Color color;

    /**
     * 
     */
    public String name;

    /**
     * 
     */
    public double speed;

    /**
     * 
     */
    public Position position;


    /**
     * @param deltaTime 
     * @return
     */
    public void step(double deltaTime) {
        // TODO implement here
        this.s.step(this, deltaTime);
        this.name = "";
     
    }

    /**
     * @param g2d 
     * @return
     */
    public void draw(Graphics2D g2d) {
        // TODO implement here
       
    }

}