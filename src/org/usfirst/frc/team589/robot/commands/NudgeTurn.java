package org.usfirst.frc.team589.robot.commands;

import org.usfirst.frc.team589.robot.Robot;
import org.usfirst.frc.team589.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class NudgeTurn extends Command {

	private double NudgeSpeed = 0.2; //Motor Speed
	
	private int NudgeDuration = 80; //In Milliseconds
	
	private int Factor; //Direction of Turn
	
    public NudgeTurn(int Factor) {
        this.Factor = Factor;
    }

    protected void initialize() {
    	boolean QuickGearChange = false;
    	
    	if(RobotMap.GLOBAL_SPEED_RATIO == RobotMap.SECOND_GEAR)
    		QuickGearChange = true;
    	RobotMap.GLOBAL_SPEED_RATIO = 1;
    	
    	Robot.drive.setLeft(NudgeSpeed * Factor);
    	Robot.drive.setRight(-NudgeSpeed * Factor); //Positive Factor = Clockwise Turning
    	
    	try {
    		Thread.sleep(NudgeDuration);
    	}catch(InterruptedException e) {}
    	
    	Robot.drive.stop();
    	if(QuickGearChange)
    		RobotMap.GLOBAL_SPEED_RATIO = RobotMap.SECOND_GEAR;
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
