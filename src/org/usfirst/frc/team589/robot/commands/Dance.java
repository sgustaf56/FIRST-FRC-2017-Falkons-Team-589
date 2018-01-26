package org.usfirst.frc.team589.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Dance extends CommandGroup {

    public Dance() {
    	//addSequential(new DriveAutonomous(5.83,.45));
    	addSequential(new NudgeTurn(1));
    	addSequential(new WaitMilliseconds(200));
    	addSequential(new NudgeTurn(-1));
    	addSequential(new WaitMilliseconds(200));
    	addSequential(new NudgeTurn(1));
    	addSequential(new WaitMilliseconds(200));
    	addSequential(new NudgeTurn(-1));
        
    }
}
