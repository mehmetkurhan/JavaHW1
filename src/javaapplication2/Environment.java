

package javaapplication2;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;

/**
 * 
 */
public class Environment {

    /**
     * Default constructor
     */
    public BufferedImage agentIcon,soldierIcon,untouchableIcon,terroristIcon,brainIcon,bombIcon;
    public BufferedImage icon,map;
    private int numOfAgents = 3;
    private int numOfSoldiers = 3;
    private int numOfUntouchables = 3;
    private int numOfCitizens = 50;
    private int numOfCamps = 1;
    private int numOfStorages = 1;
    private int numTerrorists = 5;
    
    private List<Camp> allCamps;
    private List<Terrorist> allTerrorists;
    public List<Entity> entities;
    private List<SupplyStorage> allStorages;
    private List<BrainWashed> allBrainWashed;
    private List<Equipped> allEquipped;
    private List<Exploded> allExploded;
    private EntityFactoryProducer fp;
    private List<Entity> died;
    private List<RecentlyDeceived> allRecentlyDeceived;
    private List<Entity> security;
    public int deadCitizens,deadSoldiers,deadAgents,deadTerrorists,steps = 0;
    public int caughtByAgents,caughtBySoldiers = 0;
    
    public Environment(int windowWidth,int windowHeight,int topPanelHeight
    ,int agents,int soldiers,int untouchables,int citizen,int camp,int storage,int terrorist)
    {
        this.numOfAgents = agents;
        this.numOfSoldiers = soldiers;
        this.numOfUntouchables = untouchables;
        this.numOfCitizens = citizen;
        this.numOfCamps = camp;
        this.numOfStorages = storage;
        this.numTerrorists = terrorist;
        fp = new EntityFactoryProducer();
        allStorages = new ArrayList<SupplyStorage>();
        allCamps = new ArrayList<Camp>();
        allTerrorists = new ArrayList<Terrorist>();
        allRecentlyDeceived = new ArrayList<RecentlyDeceived>();
        allBrainWashed = new ArrayList<BrainWashed>();
        allEquipped = new ArrayList<Equipped>();
        allExploded = new ArrayList<Exploded>();
        died = new ArrayList<Entity>();
        security = new ArrayList<Entity>();
        try
        {
          String basePath = new File(".").getCanonicalPath() + "\\imgsrc\\";
          String agentIconpath =  "Agent.gif";
          String soldierIconPath =  "Soldier.gif";
          String untouchableIconPath =  "Untouchable2.gif";
          String terroristIconPath =  "Terrorist.gif";
          String brainIconPath =  "Brain.gif";
          String bombIconPath = "Bomb.gif";
          String iconPath =  "Logo.gif";
          String mapPath = "Map.gif";
          icon = ImageIO.read(new File(iconPath));
          map = ImageIO.read(new File(mapPath));
          agentIcon = ImageIO.read(new File(agentIconpath));
          soldierIcon = ImageIO.read(new File(soldierIconPath));
          untouchableIcon = ImageIO.read(new File(untouchableIconPath));
          terroristIcon = ImageIO.read(new File(terroristIconPath));
          brainIcon = ImageIO.read(new File(brainIconPath));
          bombIcon = ImageIO.read(new File(bombIconPath));
        }
        catch(IOException e)
        {
            System.out.println("IOException");
        }
        Random r = new Random();
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.topPanelHeight = topPanelHeight;
        entities = new ArrayList<Entity>();
       for(int i = 0; i < numOfCitizens; i++)
       {
           Citizen c = (Citizen)this.createEntity(fp.produceFactory("CitizenFactory"));
  ;
        
    }
       for(int i = 0; i < numOfCamps; i++ )
       {
           Camp c = (Camp)this.createEntity(fp.produceFactory("CampFactory"));
           
          
       }
       for(int i= 0; i < numOfStorages; i++)
       {
           SupplyStorage s = (SupplyStorage)this.createEntity(fp.produceFactory("SupplyStorageFactory"));
       
       }
       for(int i=0; i < numOfAgents; i++)
       {
           Agent a = (Agent)this.createEntity(fp.produceFactory("AgentFactory"));
        
       }
       for(int i = 0; i < numOfSoldiers; i++)
       {
           Soldier s =(Soldier)this.createEntity(fp.produceFactory("SoldierFactory"));
           
       }
       for(int i = 0; i < numOfUntouchables; i++)
       {
           Untouchable u = (Untouchable)this.createEntity(fp.produceFactory("UntouchableFactory"));
       
       }
       for(int i =0; i < numTerrorists; i++)
       {
           this.createEntity(fp.produceFactory("TerroristFactory"));
          
          
       }
    }
    public Environment() {
     
       
    }

    /**
     * 
     */
    

    /**
     * 
     */
    public int windowWidth;

    /**
     * 
     */
    public int windowHeight;

    /**
     * 
     */
    public int topPanelHeight;


    /**
     * @param f  
     * @return
     */
    public Entity createEntity(EntityFactory f ) {
   
       Entity e = f.createEntity();
        Random rnd = new Random();
        int xpos = (int)(rnd.nextDouble() * Display.WIDTH);
        int ypos = (int)(rnd.nextDouble() * (Display.HEIGHT - Display.TOP_PANEL_HEIGHT)) + Display.TOP_PANEL_HEIGHT;
        e.position.x = (double)xpos;
        e.position.y = (double)ypos;
        if(e instanceof RecentlyDeceived)
        {
          RecentlyDeceived t = (RecentlyDeceived)e;
          t.icon = terroristIcon;
          t.brainIcon = brainIcon;
          t.bombIcon = bombIcon;
          Random random = new Random();
          int randomCampIndex =  random.nextInt(numOfCamps);
          t.target = allCamps.get(randomCampIndex).position;
          allTerrorists.add(t);
          allRecentlyDeceived.add((RecentlyDeceived)t);
            
        }
        else if(e instanceof Camp)
        {
            allCamps.add((Camp)e);
        }
        else if(e instanceof SupplyStorage)
        {
            allStorages.add((SupplyStorage)e);
        }
        else if(e instanceof Agent)
        {
            ((Agent) e).icon = agentIcon;
            security.add(e);
        }
        else if(e instanceof Soldier)
        {
            ((Soldier) e).icon = soldierIcon;
            security.add(e);
        }
        else if(e instanceof Untouchable)
        {
            ((Untouchable) e).icon = untouchableIcon;
        }
       entities.add(e);
       return e;
   
    }

    /**
     * @param e 
     * @return
     */
    public StepStrategy generateStrategy(Entity e) {
        // TODO implement here
          StepStrategy s = e.stepFactory.createStrategy();
          s.reset();
          return s;
    }

    /**
     * @param deltaTime 
     * @return
     */
    public synchronized void stepAll(double deltaTime) {
       for(Entity e: entities)
       {
           this.steps++;
           e.step(deltaTime);
           if(e.s.isFinished())
           {
               e.s = generateStrategy(e);
           }
       }
      
       for(Iterator<Equipped> it = allEquipped.iterator(); it.hasNext();)
       {
           Equipped eq = it.next();
           Random r = new Random();
           if(r.nextDouble() < 0.1)
           {
               
               Exploded ex = new Exploded(eq);
               for(Entity e : entities)
               {
                   if(e.position.distanceTo(ex.position) < 100)
                   {
                       if(e instanceof Citizen || e instanceof Soldier 
                               || e instanceof Agent || e instanceof Terrorist && e != ex)
                       {
                          e.s = new StandStill();
                          ex.killed.add(e);
                          
                       }
                   }
               }
               it.remove();
               entities.remove(eq);
               
               entities.add(ex);
               allExploded.add(ex);
               
           }
       }
       for(Iterator<BrainWashed> it = allBrainWashed.iterator(); it.hasNext();)
       {
           BrainWashed b = it.next();
           for(SupplyStorage s: allStorages)
           {
               if(b.position.distanceTo(s.position) < 10)
               {
                     
                   Equipped e = new Equipped(b);
                   it.remove();
                   entities.remove(b);
                   entities.add(e);
                   allEquipped.add(e);
                   allTerrorists.remove(b);
                   allTerrorists.add(e);
                   Position newTarget = new Position();
                   Random r = new Random();
                   newTarget.x = r.nextInt(windowWidth);
                   newTarget.y = r.nextInt(windowHeight);
                   e.target = newTarget;
                   
               }
           }
       }
       for(Iterator<Exploded> it = allExploded.iterator(); it.hasNext();)
       {
           Exploded ex = it.next();
           ex.stepCounter--;
           if(ex.stepCounter < 0)
           {
               for(Entity e : ex.killed)
               {
                   if(e != ex)
                   {
                   respawn(e);
                   if(e instanceof Citizen)
                   {
                       deadCitizens++;
                   }
                   else if(e instanceof Agent)
                   {
                       deadAgents++;
                   }
                   else if(e instanceof Soldier)
                   {
                       deadSoldiers++;
                   }
                   else if(e instanceof Terrorist)
                   {
                       deadTerrorists++;
                   }
                   }
                   
               }
               it.remove();
              allTerrorists.remove(ex);
              allExploded.remove(ex);
            entities.remove(ex);
           this.createEntity(fp.produceFactory("TerroristFactory"));
                       
           }
       }
       List<Terrorist> toBeCatched = new ArrayList<Terrorist>();
       for(Iterator<Entity> it = security.iterator(); it.hasNext();)
       {
           Entity sec = it.next();
           for(Iterator<Terrorist> itt = allTerrorists.iterator(); itt.hasNext(); )
           {
               Terrorist t = itt.next();
               if(sec.position.distanceTo(t.position) < 32)
                  {
                      if(!toBeCatched.contains(t))
                      {
                         toBeCatched.add(t);
                         if(sec instanceof Agent)
                         {
                             this.caughtByAgents++;
                         }
                         else if(sec instanceof Soldier)
                         {
                             this.caughtBySoldiers++;
                         }
                      }
                  }
           }
       }
       catchTerrorist(toBeCatched);
       for(Iterator<RecentlyDeceived>  it = allRecentlyDeceived.iterator(); it.hasNext();)
       {
           Terrorist t = it.next();
           for(Camp c: allCamps)
           {
               if(t.position.distanceTo(c.position) < 10)
               {
                   BrainWashed b = new BrainWashed(t);
                   
                   entities.remove(t);
                   entities.add(b);
                   allBrainWashed.add(b);
                   allTerrorists.remove(t);
                   allTerrorists.add(b);
                   it.remove();
                   Random randomstorage = new Random();
                   int index= randomstorage.nextInt(allStorages.size());
                   b.target = allStorages.get(index).position;
                   
                
               }
           }
           
       }
       
       
    }
    public void respawn(Entity e)
    {
        Random r = new Random();
        e.position.x = r.nextInt(Display.WIDTH);
        e.position.y = r.nextInt(Display.HEIGHT - Display.TOP_PANEL_HEIGHT) + Display.TOP_PANEL_HEIGHT;
        e.s = e.stepFactory.createStrategy();
    }
    public void catchTerrorist(List<Terrorist> terr)
    {
      for(Terrorist t : terr )  
      {
            respawn(t);
         
      }
     }  
    
      

}