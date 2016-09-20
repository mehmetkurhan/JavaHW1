package javaapplication2;
import java.util.*;

/**
 * 
 */
public class StandStill extends StepStrategy {

    /**
     * Default constructor
     */
    public StandStill() {
       super();
       this.name = "SS";
    }

    /**
     * @param ...
     */
    public void StandStill() {
        
    }
    
    public String getName()
    {
        return name;
    }
    @Override
    public void step(Entity e,double deltaTime)
    {
        super.step(e, deltaTime);
    }

}