/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author ASUS
 */
public class EntityFactoryProducer {
    
    
    
    public EntityFactory produceFactory(String factoryType)
    {
        if(factoryType.equals("TerroristFactory"))
        {
            return new TerroristFactory();
        }
        else if(factoryType.equals("CitizenFactory"))
        {
            return new CitizenFactory();
        }
        else if(factoryType.equals("AgentFactory"))
        {
            return new AgentFactory();
        }
        else if(factoryType.equals("CampFactory"))
        {
            return new CampFactory();
        }
        else if(factoryType.equals("SoldierFactory"))
        {
            return new SoldierFactory();
        }
        else if(factoryType.equals("SupplyStorageFactory"))
        {
            return new SupplyStorageFactory();
        }
        else if(factoryType.equals("UntouchableFactory"))
        {
            return new UntouchableFactory();
        }
        return null;
    }
    
}
