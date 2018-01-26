package org.usfirst.frc.team589.robot.commands.group;

import org.usfirst.frc.team589.robot.commands.AcousticApproach;
import org.usfirst.frc.team589.robot.commands.DriveAutonomous;
import org.usfirst.frc.team589.robot.commands.TurnAutonomous;
import org.usfirst.frc.team589.robot.commands.WaitMilliseconds;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SidePegAutonomous extends CommandGroup {

	private double AUTONOMOUS_DRIVE_SPEED = .4;
	private double AUTONOMOUS_TURN_SPEED = .7;
	
	
    public SidePegAutonomous(String Input) {
    	if(Input.equals("RightPeg[BLUE]")) {
    		addSequential(new DriveAutonomous(5.667,AUTONOMOUS_DRIVE_SPEED));
	    	addSequential(new WaitMilliseconds(200));
	    	addSequential(new TurnAutonomous(-60,AUTONOMOUS_TURN_SPEED));
	    	addSequential(new WaitMilliseconds(200));
	    	addSequential(new DriveAutonomous(4.05,AUTONOMOUS_DRIVE_SPEED)); //Real Distance is 5.05
	    	addSequential(new AcousticApproach());
    	}
    	else if(Input.equals("LeftPeg[BLUE]")) {
    		addSequential(new DriveAutonomous(5.416,AUTONOMOUS_DRIVE_SPEED));
		   	addSequential(new WaitMilliseconds(200));
		   	addSequential(new TurnAutonomous(60,AUTONOMOUS_TURN_SPEED));
		 	addSequential(new WaitMilliseconds(200));
		   	addSequential(new DriveAutonomous(4.25,AUTONOMOUS_DRIVE_SPEED)); //Real Distance is 5.25
		   	addSequential(new AcousticApproach());
    	}
    	else if(Input.equals("RightPeg[RED]")) {
        	addSequential(new DriveAutonomous(5.416,AUTONOMOUS_DRIVE_SPEED));
        	addSequential(new WaitMilliseconds(200));
        	addSequential(new TurnAutonomous(-60,AUTONOMOUS_TURN_SPEED));
        	addSequential(new WaitMilliseconds(200));
        	addSequential(new DriveAutonomous(4.25,AUTONOMOUS_DRIVE_SPEED)); //Real Distance is 5.25
        	addSequential(new WaitMilliseconds(200));
        	addSequential(new AcousticApproach());
    	}
    	else if(Input.equals("LeftPeg[RED]")) {
    		addSequential(new DriveAutonomous(5.667,AUTONOMOUS_DRIVE_SPEED));
        	addSequential(new WaitMilliseconds(200));
        	addSequential(new TurnAutonomous(60,AUTONOMOUS_TURN_SPEED));
        	addSequential(new WaitMilliseconds(200));
        	addSequential(new DriveAutonomous(4.05,AUTONOMOUS_DRIVE_SPEED)); //Real Distance is 5.05
        	addSequential(new AcousticApproach());
    	}
    	else if(Input.equals("RightPeg&Goal[RED]")) {
    		addSequential(new DriveAutonomous(5.416,AUTONOMOUS_DRIVE_SPEED));
        	addSequential(new WaitMilliseconds(200));
        	addSequential(new TurnAutonomous(-60,AUTONOMOUS_TURN_SPEED));
        	addSequential(new WaitMilliseconds(200));
        	addSequential(new DriveAutonomous(4.25,AUTONOMOUS_DRIVE_SPEED)); //Real Distance is 5.25
        	addSequential(new AcousticApproach());
        	
        	//FINISH BACKWARDS AUTONOMOUS
        	
    	}
    	else {
    		System.out.println("SidePeg Auto Not Given Value");
    		throw new NullPointerException();
    	}
    }
}
