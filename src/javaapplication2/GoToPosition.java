package javaapplication2;
import java.util.*;

/**
 * 
 */
public class GoToPosition extends StepStrategy {

    /**
     * Default constructor
     */
    private boolean assigned = false;
    private double nextX;
    private double nextY;
    public GoToPosition() {
        this.name = "GP";
    }

    /**
     * 
     */
    public Position target;

    /**
     * @param ...
     */
    public void GoToPosition() {
        // TODO implement here
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public void reset()
    {
        super.reset();
        assigned = false;
       
    }
     public void step(Entity e,double deltaTime)
    {
        super.step(e, deltaTime);
        
        target = ((Terrorist)e).target;
        if(! assigned )
                {
                     nextX = (target.x - e.position.x) / this.numberOfTurns;
                    nextY = (target.y - e.position.y) / this.numberOfTurns;
                    assigned = true;
                }
        if(e.position.distanceTo(target) < 5)
        {
            this.numberOfTurns = 0;
        }
        if(numberOfTurns > 0)
        {
      
        if(e.position.x + nextX < maxX && e.position.y + nextY < maxY
                && e.position.x + nextX > minX && e.position.y + nextY > minY)
        {
        e.position.x += nextX;
        e.position.y += nextY;
        }
        }
        
        
        
        
    }


}