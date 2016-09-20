/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Random;

/**
 *
 * @author ASUS
 */
public abstract class StepStrategyFactory {
    
    public StepStrategyFactory()
    {
      
    }
    public StepStrategy createStrategy()
    {
        StepStrategy [] available = availableStepStrategies();
        Random r = new Random();
        int index = (int)(r.nextDouble() * available.length);
        StepStrategy avail = available[index];
        avail.reset();
        return avail;
    }
    protected StepStrategy[] availableStepStrategies()
    {
        return null;
    }
    
}
