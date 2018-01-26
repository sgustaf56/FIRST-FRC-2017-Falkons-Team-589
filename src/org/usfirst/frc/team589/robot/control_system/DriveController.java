package org.usfirst.frc.team589.robot.control_system;

import org.usfirst.frc.team589.robot.Robot;

import org.usfirst.frc.team589.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveController extends Command {

	public boolean SpecialFunction = true;

    public DriveController() {
    	
    }

    protected void initialize() {
    	Robot.drive.resetEncoders();
    	Robot.LightRing.set(false);
    	Robot.BackupLight.set(true);
    	Robot.drive.Direction = 1;
    	Robot.navX.reset();
    	
    	SmartDashboard.putBoolean("LimitUp", Robot.sf.limitswitchup.get());
    	SmartDashboard.putBoolean("LimitDown", Robot.sf.limitswitchdown.get());
    	
    	SmartDashboard.putNumber("PhotoR", Robot.PhotoR.getOutputVoltage());
    }

    protected void execute() {
    	//Debugging:
    	//SmartDashboard.putString("DB/String 0", Robot.drive.getRightEnc() + "");
    	//SmartDashboard.putString("DB/String 1", Robot.drive.getLeftEnc() + "");
    	//SmartDashboard.putString("DB/String 9", Robot.navX.getYaw() + "");
    	
    	//Arcade Drive
    	if(Robot.j1.getZ()<=0){
    		double Y = Robot.j1.getY();
    		double X = Robot.j1.getX();
    		
    		//Fixes Joystick Spamming
    		
    		if(Math.abs(Robot.j1.getY()) < .1)
    			Y = 0;
    		if(Math.abs(Robot.j1.getX()) < .1)
    			X = 0;
    		Robot.drive.setLeft(Y + X);
    		Robot.drive.setRight(Y - X);
    	}
    	
    	//Tank Drive
    	else{
    		Robot.drive.setLeft(Robot.j1.getY());
    		Robot.drive.setRight(Robot.j2.getY());
    		
    	}
    	
    	//Robot Quick Reset
    	if(Robot.buttonObject.getTime() > RobotMap.RESET_TIMER) {
    		Robot.buttonObject.reset();
    	}
    	
    	
    	//Special Function
    	if(!this.SpecialFunction) {
    		if(Robot.j3.getY() < 0) {
    			Robot.drive.Climb_Motor.set(Robot.j3.getY());
    			Robot.sf.setSlider(0);
    		}
    	}
    	else {
    		Robot.drive.Climb_Motor.set(0);
    		if(-Robot.j3.getY() > 0 && Robot.sf.limitswitchup.get()){
				Robot.sf.setSlider(0);
			}
			else if(-Robot.j3.getY() < 0 && Robot.sf.limitswitchdown.get()){
				Robot.sf.setSlider(0);
			}
			else{
				Robot.sf.setSlider(-Robot.j3.getY());
			}
    	}
   
    	
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
