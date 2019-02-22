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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;


public class Drive extends Subsystem // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
{

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

  double downShift;
  double upShift;

  public Drive() 
  {
    leftMotorA.setInverted(false); // Reverses the voltage of the motor
    leftMotorB.setInverted(false); // Reverses the voltage of the motor
    rightMotorA.setInverted(false); // Reverses the voltage of the motor
    rightMotorB.setInverted(false); // Reverses the voltage of the motor
  }


  // User Input //-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  

  // public void Shifters(boolean direction)
  // // Actuates the shifters to high or low based on user input
  // {
  //   if (direction)
  //   {
  //     p_shifters.set(DoubleSolenoid.Value.kForward);  // Up Shift
  //     System.out.println("Shift Up");
  //   }else{
  //     p_shifters.set(DoubleSolenoid.Value.kReverse);  // Down Shift
  //     System.out.println("Shift Down");
  //   }
  // }

  public void Shifters()
  {
    if (p_shifters.get() == Value.kForward)
    {
      p_shifters.set(Value.kReverse);
    }else{
      p_shifters.set(Value.kForward);
    }
  }

  public void driverJoystick(Joystick joystick) 
  // Spins the drive trains based on the user input
  {
    leftDriveBase.set(joystick.getRawAxis(1));   // Left drive train to left y-axis thumb stick
    rightDriveBase.set(-joystick.getRawAxis(5)); // Right drive train to right y-axis thumb stick
  }

  // Automatic Input // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
  
  public void AutoShifters()
  // Automaticly shifts the drive train shifters based on the rpm of the drive train
  {
    downShift = 12345;
    upShift   = 12345;
    if (p_shifters.get() == Value.kReverse) 
    // Gets the direction of the shifters and compares it to the value
    {
      if (downShift >= e_driveRight.getRate() && downShift >= e_driveLeft.getRate()) 
      // If the downShift is grater then the the rpm of both left and right drive encoders
      {
        p_shifters.set(Value.kReverse); // shifts the shifters down
      } 
    }else{
      if (upShift <= e_driveRight.getRate() && upShift <= e_driveLeft.getRate())
      // If the upShift if less then the rpm of both left and right drive encoders
      {
        p_shifters.set(Value.kForward); // shifts the shifters up
      }
    }
  }
  
  public void stop()
  // Removes all voltage on the drive motors
  {
    leftDriveBase.stopMotor(); // Stops all voltage to the motor
    rightDriveBase.stopMotor(); // Stops all voltage to the motor
  }
  
  public void driveEncoderReset()
  // resets the drive train encoders
  {
    e_driveRight.reset();  // resets right drive train enocder
    e_driveLeft.reset();   // resets left drive train encoder
  }

  public void DriveEncoderPrint()
  // prints the drive encoders data to the drive station encoders
  {
    System.out.println(e_driveLeft.getRate()); // prints the left drive encoder
    System.out.println(e_driveRight.getRate());// prints the right drive encoder
  }

  @Override
  public void initDefaultCommand() 
  {

  }  
}
 