package org.usfirst.frc.team589.robot.control_system;

import org.usfirst.frc.team589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReInitialize extends Command {

    public ReInitialize() {
        
    }

    protected void initialize() {
    	Robot.buttonObject.Increment();
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
