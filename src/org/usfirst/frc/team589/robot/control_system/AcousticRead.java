package org.usfirst.frc.team589.robot.control_system;

import org.usfirst.frc.team589.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AcousticRead extends Command {

    public AcousticRead() {
        
    }

    protected void initialize() {
    	SmartDashboard.putString("DB/String 5", Robot.acoustics.getRightReading() + "");
    	
    	SmartDashboard.putString("DB/String 6", Robot.acoustics.getLeftReading() + "");
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
