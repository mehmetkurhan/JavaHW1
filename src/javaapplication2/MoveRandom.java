package javaapplication2;
import java.util.*;

/**
 * 
 */
public class MoveRandom extends StepStrategy {

    /**
     * Default constructor
     */
    
    public MoveRandom() {
        super();
        this.name = "MR";
        
    }

    /**
     * @param ...
     */
    public void MoveRandom() {
        // TODO implement here
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
        Random r = new Random();
        double xpos = (r.nextDouble() - 0.5) * e.speed;
        double ypos = (r.nextDouble() - 0.5) * e.speed;
        double nextX = e.position.x + xpos;
        double nextY = e.position.y + ypos;
            if( nextX < maxX && nextY < maxY
                &&  nextX > minX &&  nextY > minY)
            {
        e.position.x = nextX;
        e.position.y = nextY;
            }
    }

}