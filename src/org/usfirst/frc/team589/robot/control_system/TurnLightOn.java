package org.usfirst.frc.team589.robot.control_system;

import org.usfirst.frc.team589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnLightOn extends Command {

    public TurnLightOn() {
        
    }

    protected void initialize() {
    	
    }
    

    protected void execute() {
    	Robot.LightRing.set(!Robot.LightRing.get());
    	Robot.BackupLight.set(!Robot.BackupLight.get());
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
