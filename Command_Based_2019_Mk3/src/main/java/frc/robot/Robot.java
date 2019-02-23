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
import edu.wpi.first.wpilibj.Compressor;

// Cammra Imports
// import org.opencv.core.Mat;
// import org.opencv.imgproc.Imgproc;
// import edu.wpi.cscore.VideoMode;

// import edu.wpi.cscore.CvSink;
// import edu.wpi.cscore.CvSource;
// import edu.wpi.cscore.UsbCamera;
// import edu.wpi.first.wpilibj.CameraServer;
// import 

// Subsystem Imports //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.GrabberOpenClose;

// Commands //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
import frc.robot.commands.cmdDrive;
import frc.robot.commands.cmdJoystickElevator;
import frc.robot.commands.cmdWristJoystick;
import frc.robot.commands.cmdSmartDashboard;
import frc.robot.commands.cmdEncoderPrint;
import frc.robot.commands.cmdAutoShift;
import frc.robot.commands.cmdTriggerIntake;


public class Robot extends TimedRobot 
{
  // Subsystems // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

  public static Climber sub_climber            = new Climber();
  public static Drive sub_drive                = new Drive();
  public static Elevator sub_elevator          = new Elevator();
  public static GrabberOpenClose sub_grabberOC = new GrabberOpenClose();
  public static OI m_oi;

  // Commands // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  
  Command cmdDrive                = new cmdDrive();
  Command cmdJoystickElevator     = new cmdJoystickElevator();
  Command cmdWristJoystick        = new cmdWristJoystick();
  Command cmdSmartDashboard       = new cmdSmartDashboard();
  Command cmdEncoderPrint         = new cmdEncoderPrint();
  Command cmdAutoShift            = new cmdAutoShift();
  Command cmdTriggerIntake        = new cmdTriggerIntake();

  // Other Components // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  
  // Compressor
  Compressor compressor = new Compressor(0);


  @Override
  public void robotInit() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    
    // CameraServer.getInstance().startAutomaticCapture();
    // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    // camera.setVideoMode(VideoMode.PixelFormat.kYUYV, 640, 480, 60);
    
    m_oi = new OI();

    compressor.setClosedLoopControl(true);
    compressor.start();
    cmdSmartDashboard.start();
    // cmdEncoderPrint.start();
    }


  @Override
  public void robotPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    // cmdEncoderPrint.start();
  }

  @Override
  public void disabledInit() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {

  }

  @Override
  public void disabledPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    cmdDrive.start();
    cmdWristJoystick.start();
    cmdJoystickElevator.start();
    cmdWristJoystick.start();
    // cmdAutoShift.start();
    // cmdBallIntake.start();
    cmdTriggerIntake.start();
    
  }

  @Override
  public void autonomousPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  {
    cmdDrive.start();
    cmdWristJoystick.start();
    cmdJoystickElevator.start();
    cmdWristJoystick.start();
    // cmdBallIntake.start();
    // cmdAutoShift.start();
    cmdTriggerIntake.start();
  }

  @Override
  public void teleopPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
  {
    Scheduler.getInstance().run();
    cmdDrive.start();
    cmdWristJoystick.start();
    cmdJoystickElevator.start();
    cmdWristJoystick.start();
    // cmdAutoShift.start();
    // cmdBallIntake.start();
    cmdTriggerIntake.start();
  }

  @Override
  public void testPeriodic() // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
  {
    
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
}
