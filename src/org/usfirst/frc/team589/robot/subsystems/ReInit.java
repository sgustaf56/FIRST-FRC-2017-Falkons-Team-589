package org.usfirst.frc.team589.robot.subsystems;

import org.usfirst.frc.team589.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ReInit extends Subsystem {

	private int ButtonCounter;
	
	private Timer timer;
	
    public void initDefaultCommand() {
    	ButtonCounter = 0;
    	timer = new Timer();
    }
    
    public void Increment() {
    	if(ButtonCounter == 0)
    		timer.start();
    	
    	ButtonCounter++;
    	if(ButtonCounter == 3) {
    		Robot.Init();
    		this.reset();
    	}
    }
    
    public void reset() {
    	ButtonCounter = 0;
    	timer.stop();
    	timer.reset();
    }
    
    public double getTime() {
    	return timer.get();
    }
    
    
}

