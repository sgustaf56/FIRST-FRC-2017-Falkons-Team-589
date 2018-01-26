package org.usfirst.frc.team589.robot.commands;

import org.usfirst.frc.team589.robot.Robot;
import org.usfirst.frc.team589.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveAutonomous extends Command {

	private final double WheelCircumference = .5*Math.PI;
	
	private double feet, speed;
	
	private int OneRevolution;
	
    public DriveAutonomous(double feet, double speed) {
        this.feet = feet;
        this.speed = speed;
        OneRevolution = 1024;
        
    }

    protected void initialize() {
    	Robot.drive.resetEncoders();
    	
    	RobotMap.GLOBAL_SPEED_RATIO = 1;
    	
//    	SmartDashboard.putString("DB/String 0", "Autonomous");
    	
    	int EncoderStepsNeeded = (int)(OneRevolution * (feet/WheelCircumference));
    	
    	
    	Robot.drive.setLeft(speed);
    	Robot.drive.setRight(speed);
    	
    	double EncoderAverage = 0, SpeedRatio = 1;
    	while(true) {
    		
    		if(EncoderAverage > EncoderStepsNeeded) {
        		Robot.drive.Break(speed);
        		break;
    		}
    		
    		EncoderAverage = (Robot.drive.getRightEnc() + Robot.drive.getLeftEnc())/2;
    		
    		SpeedRatio = (EncoderAverage/EncoderStepsNeeded);
    		
    		Robot.drive.setLeft((-speed * SpeedRatio) + speed + .1);
    		Robot.drive.setRight((-speed * SpeedRatio) + speed + .1);
    		
    		SmartDashboard.putString("DB/String 9", EncoderStepsNeeded + "");
    		SmartDashboard.putString("DB/String 8", EncoderAverage + "");
    		
//    		if(EncoderAverage < 20) {
//    			break;
//    		}
    		
    	}
    	
    	Robot.drive.stop();
    	
    	RobotMap.GLOBAL_SPEED_RATIO = RobotMap.SECOND_GEAR;
    	Robot.drive.resetEncoders();
    	
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	Robot.drive.stop();
    }

    protected void interrupted() {
    	Robot.drive.stop();
    }
}
