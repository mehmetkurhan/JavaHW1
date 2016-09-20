package javaapplication2;
import java.util.*;

/**
 * 
 */
public class CitizenFactory extends EntityFactory {

    /**
     * Default constructor
     */
    public CitizenFactory() {
    }
    
    public Entity createEntity()
    {
     
        Citizen c = new Citizen();
        c.stepFactory = new CitizenStepStrategyFactory();
        c.s = c.stepFactory.createStrategy();
        return c;
    }

}