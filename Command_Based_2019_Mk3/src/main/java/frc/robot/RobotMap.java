/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class RobotMap {

  // Motors // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  
  //Drive Motors
  public static int leftMotorA = 1;          // Left Drive Train front
  public static int leftMotorB = 5;          // Left Drive Train back
  public static int rightMotorA = 2;         // Right Drive Train front
  public static int rightMotorB = 4;         // Right Drive Train back

  //Intake Motors
  public static int gripperMotorV2 = 6;  //9      // Intake Motor

  //Elevator Motors
  public static int rightElevatorMotor = 8;  // Right elevator motor
  public static int leftElevatorMotor = 7;   // Left elevator motor

  //Climber Linear Actuators
  // public static int linearActuator = 3;      // Linear actuator motor

  //Climber Wheel Motors
  public static int climberWheel = 3;        // Climbing wheel motor on the climbing claw
    
  // Wrist Motor
  public static int wristMotor = 10;         // Wrist Motor to actuate the gripper angle


  // Pnumatics // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  
  //Double Soleniods
  public DoubleSolenoid p_shifters      = new DoubleSolenoid(1, 0, 1); // Drive train shifters 
  public DoubleSolenoid p_gripper       = new DoubleSolenoid(1, 2, 3); // Use to open and close grabber
  public DoubleSolenoid p_climberClaws  = new DoubleSolenoid(1, 4, 5); // used to Drop the climbing claws 
  public DoubleSolenoid p_elevatorBrake = new DoubleSolenoid(1, 6, 7); // Elevator brake to stop the elevator in place
  public DoubleSolenoid p_BAP           = new DoubleSolenoid(0, 4, 5); 


  // Sensors // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
 
  //Encoders
  public Encoder e_driveRight   = new Encoder(12, 13, false, Encoder.EncodingType.k4X); // Right drive train encoder
  public Encoder e_driveLeft    = new Encoder(10, 11, false, Encoder.EncodingType.k4X); // Left drive train encoder
  public Encoder e_elevatorDrum = new Encoder(14, 15, false, Encoder.EncodingType.k4X); // Elevator Drum encoder
  public Encoder e_linearAct    = new Encoder(16, 17, false, Encoder.EncodingType.k4X); // Linear actuator encoder

  // Potentiometers
  public AnalogPotentiometer ap_gripper = new AnalogPotentiometer(1); // Potentiometor on the grabber to record the angle of the grabber

//-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
}