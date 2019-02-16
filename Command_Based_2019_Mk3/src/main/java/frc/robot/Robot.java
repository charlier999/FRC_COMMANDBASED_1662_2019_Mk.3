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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

// Subsystem Imports
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
// import frc.robot.subsystems.Grabber; 
import frc.robot.subsystems.GrabberOpenClose;

// Commands
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.cmdDrive;
import frc.robot.commands.cmdJoystickElevator;
import frc.robot.commands.cmdJoystickElevatorTest;
import frc.robot.commands.cmdWristJoystick;
// import frc.robot.commands.cmdBallIntake;
// import frc.robot.commands.cmdShift;
// import frc.robot.commands.cmdClawDrop;
// import frc.robot.commands.cmdGrabberOC;
// import frc.robot.commands.cmdLinearActuator;
import frc.robot.commands.cmdSmartDashboard;
//import frc.robot.commands.cmdOpenClose;
import frc.robot.commands.cmdEncoderPrint;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  // Subsystems

  public static ExampleSubsystem sub_subsystem = new ExampleSubsystem();
  public static Climber sub_climber            = new Climber();
  public static Drive sub_drive                = new Drive();
  public static Elevator sub_elevator          = new Elevator();
  // public static Grabber sub_grabber            = new Grabber();
  public static GrabberOpenClose sub_grabberOC = new GrabberOpenClose();
  public static OI m_oi;

  // Commands
  // Command cmdLinearActuator       = new cmdLinearActuator();
  // Command cmdGrabberOC            = new cmdGrabberOC();
  // Command cmdClawDrop             = new cmdClawDrop();
  Command cmdDrive                = new cmdDrive();
  Command cmdJoystickElevator     = new cmdJoystickElevator();
  Command cmdJoystickElevatorTest = new cmdJoystickElevatorTest();
  Command cmdWristJoystick        = new cmdWristJoystick();
  // Command cmdBallIntake           = new cmdBallIntake();
  // Command cmdShift                = new cmdShift();
  Command cmdSmartDashboard       = new cmdSmartDashboard();
  Command cmdEncoderPrint         = new cmdEncoderPrint();
  // Command cmdOpenClose = new cmdOpenClose();

  Compressor compressor = new Compressor(0);


  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() 
  {
    // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    // camera.setVideoMode(VideoMode.PixelFormat.kYUYV, 640, 480, 60);
    
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

    // CameraServer.getInstance().startAutomaticCapture();

    compressor.setClosedLoopControl(true);
    compressor.start();
    cmdSmartDashboard.start();
    // cmdEncoderPrint.start();
    }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
    // cmdEncoderPrint.start();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() 
  {

  }

  @Override
  public void disabledPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() 
  {
    m_autonomousCommand = m_chooser.getSelected();
    cmdDrive.start();
    cmdWristJoystick.start();
    cmdJoystickElevator.start();
    cmdWristJoystick.start();
    // cmdBallIntake.start();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) 
    {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() 
  {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    cmdDrive.start();
    cmdWristJoystick.start();
    cmdJoystickElevator.start();
    cmdWristJoystick.start();
    // cmdBallIntake.start();

    if (m_autonomousCommand != null) 
    {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    Scheduler.getInstance().run();
    cmdDrive.start();
    cmdWristJoystick.start();
    cmdJoystickElevator.start();
    cmdWristJoystick.start();
    // cmdBallIntake.start();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {
    cmdJoystickElevatorTest.start();
  }
}
