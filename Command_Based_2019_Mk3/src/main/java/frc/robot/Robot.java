/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Compressor;

// Cammra Imports
// import org.opencv.core.Mat;
// import org.opencv.imgproc.Imgproc;
// import edu.wpi.cscore.VideoMode;

// import edu.wpi.cscore.CvSink;
// import edu.wpi.cscore.CvSource;
// import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
// import 

// Subsystem Imports //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.GrabberOpenClose;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.DriveAIDS;
//import frc.robot.subsystems.ElevatorTry; //Added 3/3/19

// Commands //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
import frc.robot.commands.cmdDrive;
import frc.robot.commands.cmdJoystickElevator;
import frc.robot.commands.cmdWristJoystick;
import frc.robot.commands.cmdEncoderPrint;
import frc.robot.commands.cmdBallIntake;
import frc.robot.commands.cmdOpticalSensor;


public class Robot extends TimedRobot 
{
  // Subsystems // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

  public static Climber sub_climber            = new Climber();
  public static Drive sub_drive                = new Drive();
  public static Elevator sub_elevator          = new Elevator();
  public static GrabberOpenClose sub_grabberOC = new GrabberOpenClose();
  public static Wrist sub_wrist                = new Wrist();
  public static DriveAIDS sub_DriveAIDS        = new DriveAIDS();

  public static OI m_oi;

  // Commands // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  
  Command cmdDrive                = new cmdDrive();
  Command cmdJoystickElevator     = new cmdJoystickElevator();
  Command cmdWristJoystick        = new cmdWristJoystick();
  Command cmdEncoderPrint         = new cmdEncoderPrint();
  Command cmdBallIntake           = new cmdBallIntake();
  Command cmdOpticalSensor        = new cmdOpticalSensor();


  // Other Components // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

  // Compressor
  Compressor compressor = new Compressor(0);


  @Override
  public void robotInit() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    
    CameraServer.getInstance().startAutomaticCapture();
    // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    // camera.setVideoMode(VideoMode.PixelFormat.kYUYV, 640, 480, 60);
    
    m_oi = new OI();
    

    compressor.setClosedLoopControl(true);
    compressor.start();
    // cmdEncoderPrint.start();
    }


  @Override
  public void robotPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    // cmdEncoderPrint.start();
    cmdOpticalSensor.start();
  }

  @Override
  public void disabledInit() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {

  }

  public void allPeriodic()
  {
    // Elevator Height
    SmartDashboard.putNumber("Current Elevator Height", Robot.sub_elevator.e_elevator.getDistance());

    // Right Drive Train
    SmartDashboard.putNumber("Right Drive Train Speed", Robot.sub_drive.e_driveRight.getRate());
    SmartDashboard.putNumber("Right Drive Train Distance", Robot.sub_drive.e_driveRight.getDistance());

    // Left Drive Train
    SmartDashboard.putNumber("Left Drive Train Speed", Robot.sub_drive.e_driveLeft.getRate());
    SmartDashboard.putNumber("Left Drive Train Distance", Robot.sub_drive.e_driveLeft.getDistance());
    
    // Optical Sensor Voltage
    SmartDashboard.putNumber("Optical Sensor Voltage", Robot.sub_DriveAIDS.opticalSensor.getVoltage());
    SmartDashboard.putNumber("Optical Sensor Value", Robot.sub_DriveAIDS.opticalSensor.getValue());
  }

  @Override
  public void disabledPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    Scheduler.getInstance().run();
    allPeriodic();
  }

  @Override
  public void autonomousInit() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    cmdDrive.start();
    cmdWristJoystick.start();
    cmdJoystickElevator.start();
    cmdWristJoystick.start();
    // cmdAutoShift.start();
    cmdBallIntake.start();

  }

  @Override
  public void autonomousPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    Scheduler.getInstance().run();
    allPeriodic();
  }



  @Override
  public void teleopInit() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    //cmdDrive.start();
    cmdWristJoystick.start();
    cmdJoystickElevator.start();
    cmdWristJoystick.start();
    cmdBallIntake.start();
    // cmdAutoShift.start();

  }

  @Override
  public void teleopPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
  {
    Scheduler.getInstance().run();
    //cmdDrive.start();
    //cmdJoystickElevator.start();
    cmdWristJoystick.start();

    allPeriodic();
    // cmdAutoShift.start();
    cmdBallIntake.start();
  }

  @Override
  public void testPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
  {
    
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
}
