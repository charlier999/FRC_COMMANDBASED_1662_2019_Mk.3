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

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //Drive Motors
  public static int leftMotorA = 1;
  public static int leftMotorB = 3;
  public static int rightMotorA = 2;
  public static int rightMotorB = 4;

  //Intake Motors
  // public static int GripperMotor = 9;
  public static int gripperMotorV2 = 9; //9

  //Elevator Motors
  public static int rightElevatorMotor = 8;
  public static int leftElevatorMotor = 7;

  //Climber Linear Actuators
  public static int linearActuator = 5; //5

  //Climber Wheel Motors
  public static int climberWheel = 6;    
    
  // Wrist Motor
  public static int wristMotor = 10;

  //Double Soleniods
  public DoubleSolenoid p_shifters     = new DoubleSolenoid(0, 1); 
  public DoubleSolenoid p_gripper      = new DoubleSolenoid(2, 3); // Use to open and close grabber
  public DoubleSolenoid p_climberClaws = new DoubleSolenoid(4, 5); // used to Drop the climbing claws 
  public DoubleSolenoid p_elevatorBrake= new DoubleSolenoid(6, 7); // 

  //Encoders
  public Encoder e_driveRight   = new Encoder(12, 13, false, Encoder.EncodingType.k4X);
  public Encoder e_driveLeft    = new Encoder(10, 11, false, Encoder.EncodingType.k4X);
  public Encoder e_elevatorDrum = new Encoder(14, 15, false, Encoder.EncodingType.k4X);
  public Encoder e_linearAct    = new Encoder(16, 17, false, Encoder.EncodingType.k4X);

  public AnalogPotentiometer ap_gripper;
}

