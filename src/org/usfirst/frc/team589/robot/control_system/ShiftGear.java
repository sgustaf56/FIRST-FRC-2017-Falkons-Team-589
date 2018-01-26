package org.usfirst.frc.team589.robot.control_system;

import org.usfirst.frc.team589.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftGear extends Command {

    public ShiftGear() {
        
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if(RobotMap.GLOBAL_SPEED_RATIO == RobotMap.FIRST_GEAR) {
    		RobotMap.GLOBAL_SPEED_RATIO = RobotMap.SECOND_GEAR;
    	}
    	else {
    		RobotMap.GLOBAL_SPEED_RATIO = RobotMap.FIRST_GEAR;
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
