package org.usfirst.frc.team589.robot.commands.group;

import org.usfirst.frc.team589.robot.commands.AcousticApproach;
import org.usfirst.frc.team589.robot.commands.Dance;
import org.usfirst.frc.team589.robot.commands.DriveAutonomous;
import org.usfirst.frc.team589.robot.commands.PhotoWait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddlePegAutonomous extends CommandGroup {

    public MiddlePegAutonomous() {
    	//addSequential(new DriveAutonomous(5.83,.45));
    	
        addSequential(new DriveAutonomous(5,.35)); //5.83 is the Correct Distance;
        addSequential(new AcousticApproach()); //Reconsider AcousticApproach for 1st Match
        addSequential(new PhotoWait());
        addSequential(new Dance());
        
    }
}
