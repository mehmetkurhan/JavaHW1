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
public class CampFactory extends EntityFactory {
    
    public Entity createEntity()
    {
        Camp c = new Camp();
        c.stepFactory = new CampStepStrategyFactory();
        c.s = c.stepFactory.createStrategy();
        return c;
    }
    
}