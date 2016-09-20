package javaapplication2;
import java.util.*;

/**
 * 
 */
public class TerroristFactory extends EntityFactory {

    /**
     * Default constructor
     */
    public TerroristFactory() {
    }
    
 public Entity createEntity()
    {
             RecentlyDeceived t = new RecentlyDeceived();
             t.stepFactory = new TerroristStepStrategyFactory();
             t.s = t.stepFactory.createStrategy();
             return t;
 
    }

}