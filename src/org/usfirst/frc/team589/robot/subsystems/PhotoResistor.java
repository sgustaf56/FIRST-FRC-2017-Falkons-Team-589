package org.usfirst.frc.team589.robot.subsystems;

import org.usfirst.frc.team589.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PhotoResistor extends Subsystem {

	public AnalogInput PhotoResistorOutput;
	
	public double GearThreshold = 1.3; //TEST THIS TEST THIS TEST THIS!!!
	
    public void initDefaultCommand() {
        PhotoResistorOutput = new AnalogInput(RobotMap.PHOTO_RESISTOR_PORT);
        
        GearThreshold = (int)(getOutputVoltage()) + 20;
    }
    
    public boolean DoWeHaveAGear() {
    	return (int)(this.getOutputVoltage()) <= this.GearThreshold;
    }
    
    public double getOutputVoltage() {
    	return PhotoResistorOutput.getVoltage();
    }
    
}


