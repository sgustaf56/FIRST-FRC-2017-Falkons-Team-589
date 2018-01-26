package org.usfirst.frc.team589.robot.commands;

import org.usfirst.frc.team589.robot.Robot;
import org.usfirst.frc.team589.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnAutonomous extends Command {
	private double angle, speed;

	
    public TurnAutonomous(double angle, double speed) { //.48 Speed was the best for the test robot
    	if(angle > 179) {
			angle = angle - 360;
		}
    	if(angle < 0) {
    		this.angle = angle;
    		this.speed = -speed;
    	}
    	else {
    		this.angle = angle;
        	this.speed = speed;
    	}
    	
    	
    	SmartDashboard.putString("DB/String 3", angle + "");
    }

    protected void initialize() {
    	Robot.navX.zeroYaw();
    	
    	RobotMap.GLOBAL_SPEED_RATIO = 1;
    	
    	Robot.drive.setLeft(speed);
    	Robot.drive.setRight(-speed);
    	
    	double angleTurned = 0, speedRatio = 0;
    	while(true) {
    		
    		if(Math.abs(angleTurned) >= Math.abs(angle)) {
        		Robot.drive.BreakTurn(speed);
    			Robot.drive.stop();
        		break;
    		}
    		
    		angleTurned = Robot.navX.getYaw(); //Y Rotation
    		
    		SmartDashboard.putString("DB/String 4", Robot.navX.getYaw() + "");
    		
    		speedRatio = angleTurned/angle; //Make it work with -Yaw
    		
    		Robot.drive.setLeft(-(speed * speedRatio) + speed + speed/3.5);
    		Robot.drive.setRight((speed * speedRatio) - speed - speed/3.5);
    		
    	}
    		
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
