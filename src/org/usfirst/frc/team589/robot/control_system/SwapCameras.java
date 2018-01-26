package org.usfirst.frc.team589.robot.control_system;

import org.usfirst.frc.team589.robot.Robot;
import org.usfirst.frc.team589.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwapCameras extends Command {

    public SwapCameras() {
        
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if(Robot.camera.Camera1Selected) {
    		Robot.camera.SwapToClimberCamera();
    		System.out.println("Swapped to Climber Cam");
    	}
    	else if(Robot.camera.Camera2Selected) {
    		Robot.camera.SwapToGearCamera();
    		System.out.println("Swapped to Gear Cam");
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
