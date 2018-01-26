package org.usfirst.frc.team589.robot.commands;

import org.usfirst.frc.team589.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PhotoWait extends Command {

	public static final int MillisecondDelay = 2000;
	
	public static int DelayedWait = 5;
	
	public static boolean ForgetIt = false;
	
	public Timer timer;
	
    public PhotoWait() {
        
    }

    protected void initialize() {
    	timer = new Timer();
    }

    protected void execute() {
    	timer.start();
    	
    	while(Robot.PhotoR.DoWeHaveAGear()) {
    		if((int)(timer.get()) >= DelayedWait) {
    			ForgetIt = true;
    			break;
    		}
    	}
    	
    	try {
    		Thread.sleep(MillisecondDelay);
    	}catch(InterruptedException e) {}
    	
    	
    }

    protected boolean isFinished() {
    	//RobotMap.AutonomousBail = ForgetIt;
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
