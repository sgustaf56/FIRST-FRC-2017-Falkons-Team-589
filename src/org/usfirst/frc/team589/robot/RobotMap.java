package org.usfirst.frc.team589.robot;

public class RobotMap {
	
	//CAN Addresses to TALONSRX
	public static final int LEFT_MOTOR = 4;
	public static final int LEFT_MOTOR_SLAVE = 6;
	
	public static final int RIGHT_MOTOR = 3;
	public static final int RIGHT_MOTOR_SLAVE = 5;
	
	public static final int SPECIAL_FUNCTION_MOTOR = 7;
	
	public static final int CLIMB_MOTOR = 10;
	
	//Joystick Inputs (USB)
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	public static final int SPECIAL_FUNCTION_JOYSTICK = 2;
	
	//Acoustic Analog Input Pins
	public static final int LEFT_ACOUSTIC = 0;
	public static final int RIGHT_ACOUSTIC = 3;
	public static final int PHOTO_RESISTOR_PORT = 2;
	
	//DIO Pins
	public static final int LIGHTRING_DIO_PIN = 4;
	public static final int BACKUPLIGHT_DIO_PIN = 6;
	
	//Speed Ratios used with Speed Controller Button
	public static double GLOBAL_SPEED_RATIO = .5; //Current Gear Across Drive Motors
	
	public static double FIRST_GEAR = .9;
	
	public static double SECOND_GEAR = .35;
	
	//To reset the robot, I have to hit a button # times within _ seconds.
	public static final double RESET_TIMER = 3.0;
	
	//Distance Between the Two Acoustic Sensors in Inches (Check Later?)
	public static final double ACOUSTIC_DISTANCE = 18.5; 
	
	//MISC
	public static boolean AutonomousBail = false;

}
