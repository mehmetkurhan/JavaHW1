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
public class SupplyStorageFactory extends EntityFactory {
    
    public Entity createEntity()
    {
        SupplyStorage s = new SupplyStorage();
        s.stepFactory = new StorageStepStrategyFactory();
        s.s = s.stepFactory.createStrategy();
        return s;
    }
    
}
