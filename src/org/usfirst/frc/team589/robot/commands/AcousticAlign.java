package org.usfirst.frc.team589.robot.commands;

import org.usfirst.frc.team589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AcousticAlign extends Command {

	String Direction;
	
	private final double ALIGNING_TURN_SPEED = .4;
	
	private final double ACOUSTIC_ERROR = 5; //INCHES
	
	private boolean AcousticReadingAccepted = false;
	
    public AcousticAlign(String Direction) {
        this.Direction = Direction;
    }

    protected void initialize() {
    	if(Direction.equals("Right")) {
    		Robot.drive.Turn(this.ALIGNING_TURN_SPEED);
    	}
    	else if(Direction.equals("Left")) {
    		Robot.drive.Turn(-this.ALIGNING_TURN_SPEED);
    	}
    	else {
    		throw new NullPointerException("Align Direction Not Set Correctly");
    	}
    }

    protected void execute() {
    	double LeftAcousticReading = getLeftAverage();
    	double RightAcousticReading = getRightAverage();
    	
    	double AcousticOutOfReach = 60;
    	if(LeftAcousticReading < AcousticOutOfReach && RightAcousticReading < AcousticOutOfReach) {
    		if(Direction.equals("Right")) {
    			AcousticReadingAccepted = RightAcousticReading - LeftAcousticReading < this.ACOUSTIC_ERROR ? true : false;
    		}
    		else if(Direction.equals("Left")) {
    			AcousticReadingAccepted = LeftAcousticReading - RightAcousticReading < this.ACOUSTIC_ERROR ? true : false;
    		}
    	}
    }
    
    private double getLeftAverage() {
    	double Average = 0.0;
    	int NumOfItt = 3;
    	for(int i = 0; i < NumOfItt; i++) {
    		double temp = Robot.acoustics.getLeftReading();
    		
//    		if(temp > 100)
//    			i--;
    		
    		if(temp > 100)
    			return -1.0;
    		else
    			Average += temp;
    		//System.out.println(temp + ":" + Average/(i+1));
    	}
    	
    	return Average/NumOfItt;
    }
    
    private double getRightAverage() {
    	double Average = 0.0;
    	int NumOfItt = 3;
    	for(int i = 0; i < NumOfItt; i++) {
    		double temp = Robot.acoustics.getRightReading();
    		
//    		if(temp > 100)
//    			i--;
    		
    		if(temp > 100)
    			return -1.0;
    		else
    			Average += temp;
    		//System.out.println(temp + ":" + Average/(i+1));
    	}
    	
    	return Average/NumOfItt;
    }

    protected boolean isFinished() {
    	if(AcousticReadingAccepted) {
    		double NavXAngle = Robot.navX.getYaw();
    		
    		Command CorrectTurn = new TurnAutonomous(this.RoundToFives(NavXAngle), this.ALIGNING_TURN_SPEED);
    		CorrectTurn.start();
    		
    		try {
    			Thread.sleep(1000);
    		}catch(InterruptedException e) {}
    		
    	}
        return AcousticReadingAccepted;
    }
    
    private double RoundToFives(double Input) {
    	double ScalledToTens = (int)(Input/10)*10;
    	if(Input - ScalledToTens < 5) {
    		if(Input - ScalledToTens < 2.5) {
    			return ScalledToTens;
    		}
    		else if(Input - ScalledToTens > 2.5) {
    			return ScalledToTens + 5;
    		}
    	}
    	else if(Input - ScalledToTens > 5) {
    		ScalledToTens += 5;
    		if(Input - ScalledToTens < 2.5) {
    			return ScalledToTens;
    		}
    		else if(Input - ScalledToTens > 2.5) {
    			return ScalledToTens + 5;
    		}
    	}
    	throw new NullPointerException("Something Went Wrong in 'RoundToFives' with an Input of " + Input);
    }

    protected void end() {
    	Robot.drive.stop();
    }

    protected void interrupted() {
    	Robot.drive.stop();
    }
}
