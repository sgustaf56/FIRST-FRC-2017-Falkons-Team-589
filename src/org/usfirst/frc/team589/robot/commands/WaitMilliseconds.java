package org.usfirst.frc.team589.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WaitMilliseconds extends Command {

	private int Milliseconds;
	
    public WaitMilliseconds(int Input) {
        this.Milliseconds = Input;
    }

    protected void initialize() {
    	try {
         	Thread.sleep(Milliseconds);
         }catch(InterruptedException e) {}
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
