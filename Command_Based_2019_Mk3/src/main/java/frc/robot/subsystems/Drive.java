/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;


public class Drive extends Subsystem {

  public Joystick driver       = new Joystick(0);

  public double driverAxis1 = driver.getRawAxis(1);  // Left Thumb Stick  ~ Y axis ~ +/- input
  public double driverAxis5 = driver.getRawAxis(5);  // Right Thumb Stick ~ Y axis ~ +/- input
  
  public Encoder e_driveRight   = new Encoder(12, 13, false, Encoder.EncodingType.k4X);
  public Encoder e_driveLeft    = new Encoder(10, 11, false, Encoder.EncodingType.k4X);

  int driveRightDistance;
  int driveLeftDistance;

  private DoubleSolenoid p_shifters     = new DoubleSolenoid(0, 1);
 
  // Drive base motors
  WPI_TalonSRX leftMotorA           = new WPI_TalonSRX(RobotMap.leftMotorA);
  WPI_VictorSPX leftMotorB           = new WPI_VictorSPX(RobotMap.leftMotorB);
  WPI_VictorSPX rightMotorA          = new WPI_VictorSPX(RobotMap.rightMotorA);
  WPI_TalonSRX rightMotorB          = new WPI_TalonSRX(RobotMap.rightMotorB);

  // Speed Controller Groups
  SpeedControllerGroup leftDriveBase  = new SpeedControllerGroup(leftMotorA, leftMotorB); 
  SpeedControllerGroup rightDriveBase = new SpeedControllerGroup(rightMotorA, rightMotorB);

  // Differential Drive
  public DifferentialDrive driveBase;

  double downShift = 5;
  double upShift = 10;

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

  public void AutoShifters()
  {
    if (p_shifters.get() == Value.kReverse)
    {
      if (downShift >= e_driveRight.getRate() && downShift >= e_driveLeft.getRate())
      {
        p_shifters.set(Value.kForward);
      } 
    }else{
      if (upShift <= e_driveRight.getRate() && upShift <= e_driveLeft.getRate())
      {
        p_shifters.set(Value.kReverse);
      }
    }
  }


  public void Shifters(boolean direction)
  {
    if (direction)
    {
      p_shifters.set(DoubleSolenoid.Value.kForward);
      System.out.println("Shift Up");
    }else{
      p_shifters.set(DoubleSolenoid.Value.kReverse);
      System.out.println("Shift Down");
    }
  }

  public void driverJoystick(Joystick joystick) 
  {
    // driveBase.tankDrive(joystick.getRawAxis(1), joystick.getRawAxis(5));
    leftDriveBase.set(joystick.getRawAxis(1));
    rightDriveBase.set(-joystick.getRawAxis(5));
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
  
  public void driveEncoderReset()
  {
    e_driveRight.reset();
    e_driveLeft.reset();
  }

  public void DriveEncoderPrint()
  {
    System.out.println(e_driveLeft.getRate());
    System.out.println(e_driveRight.getRate());
  }

  @Override
  public void initDefaultCommand() 
  {

  }  
}
 