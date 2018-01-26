package org.usfirst.frc.team589.robot.control_system;

import org.usfirst.frc.team589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwapDrive extends Command {

    public SwapDrive() {
        
    }

    protected void initialize() {
    	Robot.drive.SwapDrive();
    	Command SwitchLights = new TurnLightOn();
    	SwitchLights.start();
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
