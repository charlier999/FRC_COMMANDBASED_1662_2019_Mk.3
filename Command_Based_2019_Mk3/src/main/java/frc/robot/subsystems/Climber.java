
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Climber extends Subsystem //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
{
  Joystick operator = new Joystick(1);

  public DoubleSolenoid p_climberClaws = new DoubleSolenoid(4 , 5);

  // WPI_TalonSRX linearActuator = new WPI_TalonSRX(RobotMap.linearActuator);
  WPI_VictorSPX linearActuator = new WPI_VictorSPX(RobotMap.linearActuator);
  WPI_VictorSPX climberWheel  = new WPI_VictorSPX(RobotMap.climberWheel);

  public Encoder e_linearAct  = new Encoder(16, 17, false, Encoder.EncodingType.k4X);

    // Drive base motors
    WPI_TalonSRX leftMotorA           = new WPI_TalonSRX(RobotMap.leftMotorA);
    WPI_VictorSPX leftMotorB           = new WPI_VictorSPX(RobotMap.leftMotorB);
    WPI_VictorSPX rightMotorA          = new WPI_VictorSPX(RobotMap.rightMotorA);
    WPI_TalonSRX rightMotorB          = new WPI_TalonSRX(RobotMap.rightMotorB);
  
    // Speed Controller Groups
    SpeedControllerGroup leftDriveBase  = new SpeedControllerGroup(leftMotorA, leftMotorB); 
    SpeedControllerGroup rightDriveBase = new SpeedControllerGroup(rightMotorA, rightMotorB);


  double linearActDistance;

  double linearActStopMax;
  double linearActStopMin;


  //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
  
  public Climber()
  {
    linearActuator.setInverted(false);
    climberWheel.setInverted(false);
  }


  // User Input // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
 
  public void ClawRelease(boolean direction)
  // Changes the direction of the climber claw release piston based on the user input
  {
    if(direction)
    {
      p_climberClaws.set(Value.kForward); // Release
    }else{
      p_climberClaws.set(Value.kReverse); // Close
    }
  }

  public void LinearActuatorExtend(boolean direction)
  // Extends or Retracts the linear actuator based on user input  
  {
    // if(e_linearAct.getDistance() != linearActStopMax && e_linearAct.getDistance() != linearActStopMin)
    // {
      if(direction)
      {
       linearActuator.set(-1);  // Extend at full speed (+)
      }else{
       linearActuator.set(1); // Retract at full speed (-)
      }
    // }
  }

  public void ClimbingWheel(boolean direction //, 
                            // double leftSpeed, double rightSpeed
                           )
  // Sets the direction of the of the climbing wheel on the climbing arm based on user input
  {
    if(direction)
    {
      climberWheel.set(1); // Spin at full speed (+)
      // leftDriveBase.set(leftSpeed);
    }else{
      climberWheel.set(-1); // Spin at full speed (-)
      // rightDriveBase.set(rightSpeed);
    }
  }


  // Automatic Commands //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
 
  public void linearActuatorEncoderReset()
  // Resets the zero on the linear actuator encoder 
  {
    e_linearAct.reset(); // resets the encoder zero
  }


  public void encoderConsole() // Testing //
  // Prints the encoder data to the console
  {
    linearActDistance = e_linearAct.getDistance(); // sets the varablie to the encoder distance
    System.out.println (linearActDistance);        // prints the varable in the () to the drive station console
  }

  public void linearActuatorStop()
  // Stops the linear actuator motor 
  {
    linearActuator.stopMotor(); // Stops all voltage to the motor
  }

  public void climberStop() 
  // Stops the climber wheel on the climbing arms 
  {
    climberWheel.stopMotor(); // Stops all voltage to the motor
  }

  @Override
  public void initDefaultCommand() 
  {

  }
}
// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  