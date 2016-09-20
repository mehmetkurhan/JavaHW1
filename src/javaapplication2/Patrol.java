package javaapplication2;
import java.util.*;

/**package javaapplication2;
 * 
 */
public class Patrol extends StepStrategy {

    /**
     * Default constructor
     */
    public Position source;
    public Position dest;
    public boolean assigned = false;
    public Patrol() {
      this.name = "P";
     
    }

    /**
     * @param ...
     */
    public void Patrol() {
    
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
        if(!assigned)
        {
              dest = new Position();
        Random r = new Random();
        dest.x = r.nextDouble() * 500 - 250;
        dest.y = r.nextDouble() * 500 - 250;
        dest.x += e.position.x;
        dest.y += e.position.y;
            source = e.position;
            assigned = true;
        }
        if(e.position.distanceTo(dest) < 1)
        {
            double sourcex = source.x;
            double destx = dest.x;
            double sourcey = source.y;
            double desty = dest.y;
            source.x = destx;
            source.y = desty;
            dest.x = sourcex;
            dest.y = desty;
        }
        Position p = new Position();
        p.x = dest.x - source.x;
        p.y = dest.y - source.y;
        p.normalize();
        double nextX = e.position.x + p.x * e.speed;
        double nextY = e.position.y + p.y * e.speed;
            if(nextX < maxX && nextY < maxY
                &&  nextX > minX &&+ nextY > minY)
            {
        e.position.x = nextX;
        e.position.y = nextY;
            }
        
        
        
    }

}