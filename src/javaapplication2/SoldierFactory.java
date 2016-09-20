package javaapplication2;
import java.util.*;

/**
 * 
 */
public class SoldierFactory extends EntityFactory {

    /**
     * Default constructor
     */
    public SoldierFactory() {
        
        
    }
     public Entity createEntity()
    {
        Soldier s = new Soldier();
        s.stepFactory = new SoldierStepStrategyFactory();
        s.s = s.stepFactory.createStrategy();
        return s;
    }

}