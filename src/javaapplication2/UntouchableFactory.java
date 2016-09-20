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
public class UntouchableFactory extends EntityFactory {
    
    public Entity createEntity()
    {
        Untouchable u = new Untouchable();
        u.stepFactory = new UntouchableStepStrategyFactory();
        u.s = u.stepFactory.createStrategy();
        return u;
    }
    
}
