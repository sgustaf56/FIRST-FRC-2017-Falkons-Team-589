package org.usfirst.frc.team589.robot.subsystems;

import org.usfirst.frc.team589.robot.RobotMap;


import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem {
	
	//M2's are mounted opposite
	
	public CANTalon m1;
	public CANTalon m2; //ENCODER HERE
	
	public CANTalon m1Slave; //ENCODER HERE
	public CANTalon m2Slave;
	
	public CANTalon Climb_Motor;
	
	//Slave motors mimick their counterpart
	
	public int Direction = 1;
	
	public void initDefaultCommand() {
		m1 = new CANTalon(RobotMap.LEFT_MOTOR);
		m2 = new CANTalon(RobotMap.RIGHT_MOTOR);
		
		m1Slave = new CANTalon(RobotMap.LEFT_MOTOR_SLAVE);
		m2Slave = new CANTalon(RobotMap.RIGHT_MOTOR_SLAVE);
		
		m1Slave.changeControlMode(CANTalon.TalonControlMode.Follower);
		m1Slave.set(m1.getDeviceID());
		
		m2Slave.changeControlMode(CANTalon.TalonControlMode.Follower);
		m2Slave.set(m2.getDeviceID());
		
		Climb_Motor = new CANTalon(RobotMap.CLIMB_MOTOR);
		//Climb_Motor.setCurrentLimit(39)
		
		this.resetEncoders();
	}
	
	
	//Methods for Changing Motor speed*Direction
	public void setLeft(double speed) { //Separate Auto and Teleop Motor Methods?
		if(Direction == 1)
			m1.set(getSpeed(speed));
		if(Direction == -1)
			m2.set(getSpeed(speed));
	}
	
	public void setRight(double speed) {
		if(Direction == 1)
			m2.set(-getSpeed(speed));
		if(Direction == -1)
			m1.set(-getSpeed(speed));
	}
	
	public void setBoth(double speed) {
		setLeft(speed*Direction);
		setRight(speed*Direction);
	}
	
	public void stop() {
		setBoth(0);
	}
	
	private double getSpeed(double speed) {
		return RobotMap.GLOBAL_SPEED_RATIO*speed;
	}
	
	public void Turn(double speed) {
		setLeft(speed);
		setRight(-speed);
	}
	
	public void Break(double speed) {
		setLeft(-speed*Direction);
		setRight(-speed*Direction);
		
		try {
			Thread.sleep(40);
		}catch(InterruptedException e) {}
		
		stop();
	}
	
	public void BreakTurn(double speed) {
		setLeft(-speed);
		setRight(speed);
		
		try {
			Thread.sleep(75);
		}catch(InterruptedException e) {}
		
		stop();
	}
	
	public void SwapDrive() {
		Direction = -Direction;
	}
	
	public void RunClimber(double speed) {
		Climb_Motor.set(speed);
	}
	
	public void StopClimber() {
		Climb_Motor.set(0);
	}
	//----------------------------
	
	
	
	//Methods Concerning Encoder Positions
	public int getLeftEnc() {
		int Reading = m1Slave.getEncPosition();
		SmartDashboard.putNumber("LeftEncoder", Reading);
		return Reading;
	}
	
	public int getRightEnc() {
		int Reading = m2.getEncPosition();
		SmartDashboard.putNumber("RightEncoder", Reading);
		return -Reading;
	}
	
	public void resetEncoders() {
		m1Slave.setEncPosition(0);
		m2.setEncPosition(0);
	}
	//----------------------------
	
}
