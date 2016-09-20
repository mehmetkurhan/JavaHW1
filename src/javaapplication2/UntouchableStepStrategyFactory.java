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
class UntouchableStepStrategyFactory extends StepStrategyFactory {

    StepStrategy [] s = new StepStrategy[] { new StandStill(), new MoveLinear() };
  
      @Override
    public StepStrategy createStrategy()
    {
        
        return super.createStrategy();
        
    }
    
   @Override
  protected StepStrategy[] availableStepStrategies()
    {
        return s;
    }
    
}
