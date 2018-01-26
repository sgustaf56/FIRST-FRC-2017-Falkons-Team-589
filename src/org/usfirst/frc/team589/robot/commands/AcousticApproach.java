package org.usfirst.frc.team589.robot.commands;

import org.usfirst.frc.team589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AcousticApproach extends Command {

    public AcousticApproach() {
        
    }

    protected void initialize() {
    	double InchGoal = 11.25;
		
		double DistanceAway = getAverage();
		
		if(DistanceAway == -1.0) {
			return;
		}
		
        SmartDashboard.putString("DB/String 9", DistanceAway + "");
        if(DistanceAway > InchGoal) {
        	Robot.drive.resetEncoders();
        	Command drive = new DriveAutonomous(((DistanceAway - InchGoal)/12), .35);
        	System.out.println("The Math is " + ((DistanceAway - InchGoal)/12));
        	drive.start();
        	
        	try {
        		Thread.sleep(1000);
        	}catch(InterruptedException e) {}
        }
        
    }

    
    private double getAverage() {
    	double Average = 0.0;
    	int NumOfItt = 3;
    	for(int i = 0; i < NumOfItt; i++) {
    		double temp = Robot.acoustics.getLeftReading();
    		
//    		if(temp > 100)
//    			i--;
    		
    		if(temp > 100)
    			return -1.0;
    		else
    			Average += temp;
    		//System.out.println(temp + ":" + Average/(i+1));
    	}
    	
    	return Average/NumOfItt;
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
