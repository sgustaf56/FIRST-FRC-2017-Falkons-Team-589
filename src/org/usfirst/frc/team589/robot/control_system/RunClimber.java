package org.usfirst.frc.team589.robot.control_system;

import org.usfirst.frc.team589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunClimber extends Command {
	
	double speed = 0.0;
	
    public RunClimber(double speed) {
        this.speed = speed;
    }

    protected void initialize() {
    	Robot.drive.RunClimber(this.speed);
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drive.StopClimber();
    }

    protected void interrupted() {
    	Robot.drive.StopClimber();
    }
}
