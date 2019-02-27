/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.ctre.phoenix.motorcontrol.SensorCollection;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;

public class Elevator extends Subsystem 
{

  public Joystick operator     = new Joystick(1);
  WPI_VictorSPX rightElevatorMotor  = new WPI_VictorSPX(RobotMap.rightElevatorMotor);
  WPI_VictorSPX leftElevatorMotor   = new WPI_VictorSPX(RobotMap.leftElevatorMotor);

  SensorCollection rightElevatorSensor = new SensorCollection(rightElevatorMotor);
  public DoubleSolenoid p_elevatorBrake = new DoubleSolenoid(6, 7);

  public Encoder e_elevator = new Encoder(16, 17, false, Encoder.EncodingType.k4X);
  double elevatorDistance;
  double currentElevatorHight;



  public Elevator()
  {
    rightElevatorMotor.setInverted(false);
    leftElevatorMotor.setInverted(false);
  }


  // User Input //-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
  
  public void elevatorBrake(Joystick joystick)
  // applies the elevator brake based on the user input
  {
    if(joystick.getRawAxis(1) < .35 && joystick.getRawAxis(1) > -.35) 
    // if the joystick axis is at 35 or gratter deggres at any angle,
    //  the brake will be released 
    {
      p_elevatorBrake.set(Value.kForward); 
      // released brake
    }else{
      p_elevatorBrake.set(Value.kReverse); 
      // brake is applied
    }
  }
  
  public void joystickElevator(Joystick joystick)
  // The elevator motors are spinned based on the user input
  {
    if(e_elevator.getDistance() != 10500.00 && e_elevator.getDistance() != 10.0)
    {
      rightElevatorMotor.set(joystick.getRawAxis(1)); 
      // The right elevator motor speed is set to the joystick input
      leftElevatorMotor.set(joystick.getRawAxis(1));
      // The left elevator motor speed is set to the joystick inptut
    }else{
      rightElevatorMotor.stopMotor();
      leftElevatorMotor.stopMotor();
    }
  }


  // Automatic Input // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  

  public void autoElevator(boolean elevatorDirection, double elevatorSpeed) 
  // Controll of the elevator for computor controlled robot
  {
    elevatorSpeed = Math.abs(elevatorSpeed); 
    // Learn how this actualy works so it can be properly commented
    if(elevatorDirection)
    {
      rightElevatorMotor.set(elevatorSpeed);
      // Sets the right elevator motor to the elevator speed given by the computer
      leftElevatorMotor.set(elevatorSpeed);
      // Sets the left elevator motor to the elevator speed given by the computer
    }else{
      rightElevatorMotor.set(-elevatorSpeed);
      // Sets the right elevator motor to the elevator speed given by the computer at negitive
      leftElevatorMotor.set(-elevatorSpeed);
      // Set the left elevator motor to the elevator
    }
  }

  public void stop()
  // Stops all voltage to the elevator motors
  {
    rightElevatorMotor.stopMotor();
    leftElevatorMotor.stopMotor();
  }

  public void elevatorEncoderReset() 
  // Resets the encoder's zero
  {
    e_elevator.reset();
  }

  public void ElevatorHightset(double setElevatorHight)
  // Sets the elvator motors to raise or lower the diffrent highs on the robot
  {
    elevatorDistance = setElevatorHight;
    currentElevatorHight = e_elevator.getDistance();
    // sets the varaible currentElevatorHight to the encoders recorded distance
    if(e_elevator.getDistance() < setElevatorHight)
    // if current elevator hight is less then set elevaor hight
    {
      p_elevatorBrake.set(Value.kReverse);
      // Opens the elevator brake
      rightElevatorMotor.set(0.5);
      // Sets the right elevator motor to full speed positive 
      leftElevatorMotor.set(0.5);
      // Sets the left elevator motor to full speed positive
    }

    if(e_elevator.getDistance() > setElevatorHight);
    // if current elevaor hight is grater than the set elevator hight
    {
      p_elevatorBrake.set(Value.kReverse);
      // opens the elevator brake
      rightElevatorMotor.set(-0.5);
      // Sets the right elevator motor to full speed negitve
      leftElevatorMotor.set(-0.5);
      // Sets the left elevator motor to full speed negitve
    }

    if(e_elevator.getDistance() == setElevatorHight)
    // If the current hight is equel to the set elevator hight
    {
      p_elevatorBrake.set(Value.kForward);
      // closes the elevator brake
      rightElevatorMotor.stopMotor();
      // stops the right elevator motor
      leftElevatorMotor.stopMotor();
      // stops the left elevator motor
    }
  }
  public double ElevatorReturn()
  {
    return elevatorDistance;
  }

  
//-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
