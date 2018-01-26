package org.usfirst.frc.team589.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Camera extends Subsystem {
    
	UsbCamera Camera1;
	UsbCamera Camera2;
	
	public boolean Camera1Selected = false;
	public boolean Camera2Selected = true;
	
	public Camera() {
		Camera1 = CameraServer.getInstance().startAutomaticCapture(0);
		Camera2 = CameraServer.getInstance().startAutomaticCapture(1);
	}
	
	public void SwapToGearCamera() {
		NetworkTable.getTable("").putString("CameraSelection", Camera1.getName());
		Camera1Selected = true;
		Camera2Selected = false;
		
	}
	
	public void SwapToClimberCamera() {
		NetworkTable.getTable("").putString("CameraSelection", Camera2.getName());
		Camera2Selected = true;
		Camera1Selected = false;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	
	
	
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.
//	int session;
//    Image frame;
//    public Camera(){
//    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
//        session = NIVision.IMAQdxOpenCamera("cam0",
//                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
//        NIVision.IMAQdxConfigureGrab(session);
//    }
//    public void update(){
//    	NIVision.IMAQdxStartAcquisition(session);
//
//        /**
//         * grab an image, draw the circle, and provide it for the camera server
//         * which will in turn send it to the dashboard.
//         */
//        NIVision.Rect rect = new NIVision.Rect(0, 0, 0, 0);
//
//        NIVision.IMAQdxGrab(session, frame, 1);
//        NIVision.imaqDrawShapeOnImage(frame, frame, rect,
//                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, 0.0f);
//            
//        //CameraServer.getInstance()).setImage(frame);
//        CameraServer.getInstance().startAutomaticCapture();
//
//        
//    }
//    public void stop(){
//    	NIVision.IMAQdxStopAcquisition(session);
//    }
//
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//    }
}

