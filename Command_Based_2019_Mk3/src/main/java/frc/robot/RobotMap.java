/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.beans.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //Drive Motors
  public static int leftMotorA = 1;
  public static int leftMotorB = 2;
  public static int rightMotorA = 3;
  public static int rightMotorB = 4;

  //Intake Motors
  public static int GripperMotor = 5;

  //Elevator Motors
  public static int rightElevatorMotor = 6;
  public static int leftElevatorMotor = 7;

  //Climber Linear Actuators
  public static int linearActuator = 8;

  //Climber Wheel Motors
  public static int climberWheel = 9;    
    
  // Wrist Motor
  public static int wristMotor = 10;

  //Double Soleniods
  public DoubleSolenoid p_shifters     = new DoubleSolenoid(1, 2);
  public DoubleSolenoid p_gripper      = new DoubleSolenoid(3, 4); //Use to open and close grabber
  public DoubleSolenoid p_climberClaws = new DoubleSolenoid(5, 6);

  //Encoders
  public Encoder e_driveLeft;
  public Encoder e_driveRight;
  public Encoder e_elevatorDrum;

  public AnalogPotentiometer ap_gripper;
  


  /*
  e_driveLeft = new Encoder(0, false, Encoder.EncodingType.k4X);
  e_driveRight = new Encoder(1, false, Encoder.EncodingType.k4X);
  e_elevatorDrum = new Encoder(2, false, Encoder.EncodingType.k4X);
  */

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
