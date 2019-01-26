/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.beans.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;

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
  public static int rightGripperMotor1 = 5;
  public static int leftGripperMotor1 = 6; 

  //Outake Motors
  //public static int rightGripperMotor2 = 5;
  //public static int leftGripperMotor2 = 6;

    //Elevator Motors
    public static int rightElevatorMotor1 = 7;
    public static int leftElevatorMotor2 = 8;

    //Climber Linear Actuators
    public static int rightLinearActuator = 9;
    public static int leftLinearActuator = 10;

    //Climber Wheel Motors
    public static int rightClimberWheel = 11;
    public static int leftClimberWheel = 12;    
    
    // Wrist Motor
    public static int wristMotor = 13;

    //Double Soleniods
    DoubleSolenoid p_shifters = new DoubleSolenoid(1, 2);
    DoubleSolenoid p_gripper = new DoubleSolenoid(3, 4); //Use to open and close grabber
    DoubleSolenoid p_climberClaws = new DoubleSolenoid(5, 6);

    //Encoders
    Encoder e_driveLeft;
    Encoder e_driveRight;
    Encoder e_elevatorDrum;

  
  //This was causing a error on line 58 on the " ; " 
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
