package javaapplication2;
import java.util.*;

/**
 * 
 */
public abstract class StepStrategy {

    /**
     * Default constructor
     */
    public int minX;
    public int maxX;
    public int minY;
    public int maxY;
    protected String name;
    Random r = new Random();
    public StepStrategy() {
       
        minX = 0;
        maxX = Display.WIDTH;
        minY = Display.TOP_PANEL_HEIGHT;
        maxY = Display.HEIGHT;
        numberOfTurns = (int)(r.nextDouble() * 30 + 30);
        name = "";
    }

    /**
     * 
     */
    public int numberOfTurns;


    /**
     * @return
     */
    public String getName() {
       return name;
    }

    /**
     * @return
     */
    public void reset()
    {
        this.numberOfTurns = (int)(r.nextDouble() * 30 + 30);
    }
    public boolean isFinished() {
        // TODO implement here
        if(numberOfTurns <= 0)
        {
            return true;
        }
        return false;
    }

    /**
     * @param e 
     * @param deltaTime 
     * @return
     */
    public void step(Entity e, double deltaTime) {
        // TODO implement here
            numberOfTurns--;
    }

}