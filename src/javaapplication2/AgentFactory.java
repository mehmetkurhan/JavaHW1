package javaapplication2;
import java.util.*;

/**
 * 
 */
public class AgentFactory extends EntityFactory {

    /**
     * Default constructor
     */
    public AgentFactory() {
    }
    
    public Entity createEntity()
    {
        Agent a = new Agent();
        a.stepFactory = new AgentStepStrategyFactory();
        a.s = a.stepFactory.createStrategy();
        return a;
    }

}