/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */

public class Drive extends Subsystem {

  public Joystick driver       = new Joystick(0);

 //public Joystick driver = new Joystick(OI.driver);

  public DoubleSolenoid shifters = new DoubleSolenoid(1 , 2);

  public double driverAxis1 = driver.getRawAxis(1);  // Left Thumb Stick  ~ Y axis ~ +/- input
  public double driverAxis5 = driver.getRawAxis(5);  // Right Thumb Stick ~ Y axis ~ +/- input
  

 
  // Drive base motors
  WPI_VictorSPX leftMotorA           = new WPI_VictorSPX(RobotMap.leftMotorA);
  WPI_VictorSPX leftMotorB           = new WPI_VictorSPX(RobotMap.leftMotorB);
  WPI_VictorSPX rightMotorA          = new WPI_VictorSPX(RobotMap.rightMotorA);
  WPI_VictorSPX rightMotorB          = new WPI_VictorSPX(RobotMap.rightMotorB);

  // Speed Controller Groups
  SpeedControllerGroup leftDriveBase = new SpeedControllerGroup(leftMotorA, leftMotorB); 
  SpeedControllerGroup rightDriveBase = new SpeedControllerGroup(rightMotorA, rightMotorB);

  // Differential Drive
  public DifferentialDrive driveBase;


  public Drive() 
  {
    leftMotorA.setInverted(false);
    leftMotorB.setInverted(false);
    rightMotorA.setInverted(false);
    rightMotorB.setInverted(false);

    leftMotorA.setSafetyEnabled(false);
    leftMotorB.setSafetyEnabled(false);
    rightMotorA.setSafetyEnabled(false);
    rightMotorB.setSafetyEnabled(false);
    // driveBase = new DifferentialDrive(leftDriveBase, rightDriveBase);
  }

  public void Shifters(DoubleSolenoid doubleSolenoid, Boolean state)
  {
    // if(state)
    // {
    //   shifters.set(shifters.Value.forward);
    //   Shifters(shifters.Forward);
    //   shifters.set(shifters.Value.kForward);
    // }
  }

  public void driverJoystick(Joystick joystick) 
  {
    // driveBase.tankDrive(joystick.getRawAxis(1), joystick.getRawAxis(5));
    leftDriveBase.set(joystick.getRawAxis(1));
    rightDriveBase.set(joystick.getRawAxis(5));
  }

  public void autoDrive(double speed, double rotationSpeed)
  {
    driveBase.arcadeDrive(speed, rotationSpeed);
  }

  public void stop()
  {
    leftDriveBase.set(0);
    rightDriveBase.set(0);
  }

  @Override
  public void initDefaultCommand() 
  {
    //driveBase.tankDrive(  );
  }
  
}
 