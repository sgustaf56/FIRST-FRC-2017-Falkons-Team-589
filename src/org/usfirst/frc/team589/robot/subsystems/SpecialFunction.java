package org.usfirst.frc.team589.robot.subsystems;

import org.usfirst.frc.team589.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SpecialFunction extends Subsystem {

	CANTalon Slider;
	
	public DigitalInput limitswitchup;
	public DigitalInput limitswitchdown;
	
    public void initDefaultCommand() {
        Slider = new CANTalon(RobotMap.SPECIAL_FUNCTION_MOTOR);
        
        limitswitchup = new DigitalInput(2);
		limitswitchdown = new DigitalInput(3);
    }
    
    public void setSlider(double speed) {
    	Slider.set(speed);
    }
    
    public void Fix() {
    	//"Unstucks" balls
    }
    
}


