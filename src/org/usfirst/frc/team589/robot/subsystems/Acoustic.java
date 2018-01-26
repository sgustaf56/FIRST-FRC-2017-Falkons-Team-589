package org.usfirst.frc.team589.robot.subsystems;

import org.usfirst.frc.team589.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Acoustic extends Subsystem {

	public static final double ACOUSTIC_SENSOR_SCALE = 0.009766;
	
	AnalogInput LeftSensor, RightSensor;
	
	DigitalOutput LeftSensorToggle, RightSensorToggle;

	Ultrasonic test;
	
    public void initDefaultCommand() {
        LeftSensor = new AnalogInput(RobotMap.LEFT_ACOUSTIC);
        RightSensor = new AnalogInput(RobotMap.RIGHT_ACOUSTIC);
        
//        LeftSensorToggle = new DigitalOutput(RobotMap.LEFT_ACOUSTIC);
//        RightSensorToggle = new DigitalOutput(RobotMap.RIGHT_ACOUSTIC);      
//        LeftSensorToggle.set(false);
//        RightSensorToggle.set(false);
    }
    
    public double getLeftReading() {
//    	LeftSensorToggle.set(true);
    	double Return = LeftSensor.getVoltage() / ACOUSTIC_SENSOR_SCALE;
    	SmartDashboard.putNumber("Left", Return);
//    	LeftSensorToggle.set(false);
    	
    	return Return;
    }
    
    public double getRightReading() {
//    	RightSensorToggle.set(true);
    	double Return = RightSensor.getVoltage() / ACOUSTIC_SENSOR_SCALE;
    	SmartDashboard.putNumber("Right", Return);
//    	RightSensorToggle.set(false);
    	return Return;
    }
    
    public double getAngle(double LeftSensor, double RightSensor) {
    	return Math.toDegrees(Math.atan((LeftSensor-RightSensor) / RobotMap.ACOUSTIC_DISTANCE)); //What if x > y?
    }
    
    
    
    
    
}

