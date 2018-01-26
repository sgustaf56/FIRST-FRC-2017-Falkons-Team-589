package org.usfirst.frc.team589.robot.control_system;

import org.usfirst.frc.team589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwapSpecialFunction extends Command {

    public SwapSpecialFunction() {
        
    }

    protected void initialize() {
    	try {
    		Robot.drivecontroller.SpecialFunction = !Robot.drivecontroller.SpecialFunction;
    	}catch(Exception e) {}
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
