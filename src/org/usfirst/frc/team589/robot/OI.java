package org.usfirst.frc.team589.robot;

import edu.wpi.first.wpilibj.buttons.Button;




import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team589.robot.commands.NudgeTurn;
import org.usfirst.frc.team589.robot.control_system.AcousticRead;
import org.usfirst.frc.team589.robot.control_system.ReInitialize;
import org.usfirst.frc.team589.robot.control_system.ShiftGear;
import org.usfirst.frc.team589.robot.control_system.SwapCameras;
import org.usfirst.frc.team589.robot.control_system.SwapDrive;
import org.usfirst.frc.team589.robot.control_system.SwapSpecialFunction;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public OI() {
		Button speedController = new JoystickButton(Robot.j1,2);
		speedController.whenPressed(new ShiftGear()); //Changes Speed to Set Amount
		
		Button swapDrive = new JoystickButton(Robot.j1,3);
		swapDrive.whenPressed(new SwapDrive()); //Swaps Direction of Robot Drive System
		
		Button reInit = new JoystickButton(Robot.j1,7);
		reInit.whenPressed(new ReInitialize()); //Reinitializes Robot Variables - Quick Restarts Robot
		
		Button NudgeLeft = new JoystickButton(Robot.j1,8);
		NudgeLeft.whenPressed(new NudgeTurn(-1));
		
		Button NudgeRight = new JoystickButton(Robot.j1,9);
		NudgeRight.whenPressed(new NudgeTurn(1));
		
//		Button temp = new JoystickButton(Robot.j1, 1);
//		temp.whenPressed(new AcousticRead());
		
		Button TestAcoustics = new JoystickButton(Robot.j1,1);
		TestAcoustics.whenPressed(new AcousticRead());
		
		Button SwapSpecialFunction = new JoystickButton(Robot.j3,2);
		SwapSpecialFunction.whenPressed(new SwapSpecialFunction());
		
		Button CameraButton = new JoystickButton(Robot.j3,3);
		CameraButton.whenPressed(new SwapCameras());
		
//		Button ClimberForwardHalf = new JoystickButton(Robot.j3,11);
//		ClimberForwardHalf.whileHeld(new RunClimber(.5));
//		
//		Button ClimberForwardFull = new JoystickButton(Robot.j3,9);
//		ClimberForwardFull.whileHeld(new RunClimber(1));
//		
//		Button ClimberBackwardHalf = new JoystickButton(Robot.j3,12);
//		ClimberBackwardHalf.whileHeld(new RunClimber(-.5));
//		
//		Button ClimberBackwardFull = new JoystickButton(Robot.j3,10);
//		ClimberBackwardFull.whileHeld(new RunClimber(-1));
	}
	
	
	
}
