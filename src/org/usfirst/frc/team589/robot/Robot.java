
package org.usfirst.frc.team589.robot;

import org.usfirst.frc.team589.robot.commands.DriveAutonomous;


import org.usfirst.frc.team589.robot.commands.group.MiddlePegAutonomous;
import org.usfirst.frc.team589.robot.commands.group.SidePegAutonomous;
import org.usfirst.frc.team589.robot.control_system.DriveController;
import org.usfirst.frc.team589.robot.subsystems.Acoustic;
import org.usfirst.frc.team589.robot.subsystems.Camera;
import org.usfirst.frc.team589.robot.subsystems.Drive;
import org.usfirst.frc.team589.robot.subsystems.PhotoResistor;
import org.usfirst.frc.team589.robot.subsystems.ReInit;
import org.usfirst.frc.team589.robot.subsystems.SpecialFunction;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi; //Output/Input Object (For Buttons)
	
	public static Camera camera; //Camera class object
	
	public static AHRS navX; //navX Board

	//Joysticks
	public static Joystick j1 = new Joystick(RobotMap.LEFT_JOYSTICK); //Arcade Joystick
	public static Joystick j2 = new Joystick(RobotMap.RIGHT_JOYSTICK); //2nd Joystick for Tank Mode
	public static Joystick j3 = new Joystick(RobotMap.SPECIAL_FUNCTION_JOYSTICK); //Special Function Joystick
	
	public static Drive drive; //Class that controls drive system motors
	public static DriveController drivecontroller; //Teleop Driver Controller
	
	public static ReInit buttonObject; //Reinitialize variables - Timer Class
	
	public static Acoustic acoustics; //Acoustics Object
	
	public static SpecialFunction sf; //Special Function Object
	
	public static DigitalOutput LightRing; //Green Light for Camera
	
	public static DigitalOutput BackupLight; //Red LED's on Back
	
	public static PhotoResistor PhotoR;
	
	Command autonomousCommand;
	static SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		Init();
		buttonObject = new ReInit();
		
	}
	
	//Method used to reinitialize Robot Variables
	public static void Init() { 
		oi = new OI();
		drive = new Drive();
		camera = new Camera();
		navX = new AHRS(SerialPort.Port.kMXP);
		acoustics = new Acoustic();
		sf = new SpecialFunction();
		LightRing = new DigitalOutput(RobotMap.LIGHTRING_DIO_PIN);
		BackupLight = new DigitalOutput(RobotMap.BACKUPLIGHT_DIO_PIN);
		PhotoR = new PhotoResistor();
		
		//Added Autonomous
		chooser.addObject("LeftPeg[BLUE]", new SidePegAutonomous("LeftPeg[BLUE]"));
		chooser.addObject("RightPeg[BLUE]", new SidePegAutonomous("RightPeg[BLUE]"));
		chooser.addObject("LeftPeg[RED]", new SidePegAutonomous("LeftPeg[RED]"));
		chooser.addObject("RightPeg[RED]", new SidePegAutonomous("RightPeg[RED]"));
		chooser.addObject("MiddlePegAutonomous", new MiddlePegAutonomous());
		chooser.addObject("Base Line", new DriveAutonomous(5.74,.5));
		chooser.addObject("Nothing", null);
		SmartDashboard.putData("Autonomous mode chooser", chooser);
		
	}

	@Override
	public void disabledInit() {
		Robot.navX.reset();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putBoolean("LimitUp", sf.limitswitchup.get());
    	SmartDashboard.putBoolean("LimitDown", sf.limitswitchdown.get());
    	
    	SmartDashboard.putNumber("LeftEncoder", drive.getLeftEnc());
    	SmartDashboard.putNumber("RightEncoder", drive.getLeftEnc());
    	
    	SmartDashboard.putNumber("Right", acoustics.getRightReading());
    	SmartDashboard.putNumber("Left", acoustics.getLeftReading());
    	
    	SmartDashboard.putNumber("PhotoR", Robot.PhotoR.getOutputVoltage());
    	
    	SmartDashboard.putBoolean("Calibrating?", Robot.navX.isCalibrating());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
//		autonomousCommand = chooser.getSelected();
		Robot.navX.zeroYaw();
		
		autonomousCommand = chooser.getSelected();
//		double speed = Double.parseDouble(SmartDashboard.getString("DB/String 5","0"));
//		double degrees = Double.parseDouble(SmartDashboard.getString("DB/String 6","0"));

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**	
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		drivecontroller = new DriveController();
		drivecontroller.start();
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		if(drive.Direction == 1) {
			SmartDashboard.putString("Direction-Forward", "Ball Mech");
		}
		else if(drive.Direction == -1) {
			SmartDashboard.putString("Direction-Forward", "Gear Mech");
		}
		
		SmartDashboard.putNumber("Climber-Amps", drive.Climb_Motor.getOutputCurrent());
		
		SmartDashboard.putBoolean("LimitUp", Robot.sf.limitswitchup.get());
    	SmartDashboard.putBoolean("LimitDown", Robot.sf.limitswitchdown.get());
    	
    	SmartDashboard.putNumber("PhotoR", Robot.PhotoR.getOutputVoltage());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
