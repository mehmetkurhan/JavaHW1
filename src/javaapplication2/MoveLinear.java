package javaapplication2;
import java.util.*;

/**
 * 
 */
public class MoveLinear extends StepStrategy {

    /**
     * Default constructor
     */
    private double xpos;
    private double ypos;
   

    public MoveLinear() {
        super();
        this.name = "ML";
        Random r = new Random();
        xpos = (r.nextDouble() - 0.5);
        ypos = (r.nextDouble() - 0.5); 
    }

    /**
     * @param ...
     */
    public void MoveLinear() {
        // TODO implement here
    }
    @Override
    public void reset()
    {
        super.reset();
             Random r = new Random();
        xpos = (r.nextDouble() - 0.5);
        ypos = (r.nextDouble() - 0.5); 
        
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public void step(Entity e,double deltaTime)
    {
       super.step(e, deltaTime);
      double nextX = e.position.x + xpos * e.speed;
       double nextY = e.position.y + ypos * e.speed;
       if(nextX < maxX && nextY < maxY && nextX > minX && nextY > minY)
       {
        e.position.x = nextX;
        e.position.y = nextY;
       }
        
    }

}