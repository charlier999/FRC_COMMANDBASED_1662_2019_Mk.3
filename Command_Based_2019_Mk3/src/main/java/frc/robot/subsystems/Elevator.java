/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Timer;

import com.ctre.phoenix.motorcontrol.SensorCollection;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;

public class Elevator extends Subsystem 
{
  WPI_VictorSPX rightElevatorMotor  = new WPI_VictorSPX(RobotMap.rightElevatorMotor);
  WPI_VictorSPX leftElevatorMotor   = new WPI_VictorSPX(RobotMap.leftElevatorMotor);

  SensorCollection rightElevatorSensor = new SensorCollection(rightElevatorMotor);

  public DoubleSolenoid p_elevatorBrake = new DoubleSolenoid(1, 6, 7);

  public Encoder e_elevator = new Encoder(16, 17, false, Encoder.EncodingType.k4X);

  boolean elevatorHeightSafe;

  boolean commandIsRunning;
  boolean sectionIsRunning;
  boolean oneTimePrint;

  int elevatorDirection;

  double elevatorDiffrence;

  double elevatorUP   = -0.75;
  double elevatorDown =  0.75;

  double minElevatorHeight = 100;
  double maxElevatorHeight = 10000;

  Timer timer = new Timer();


  public Elevator()
  {
    rightElevatorMotor.setInverted(false);
    leftElevatorMotor.setInverted(false);
  }


  // User Input //-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  


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

  public void CommandIsRunning(boolean running)
  {
    commandIsRunning = running;
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-

// void printEncoderValue()
// {
//   System.out.println(e_elevator.getDistance());
// }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-

  void ElevatorBrakeOn()
  {
    p_elevatorBrake.set(Value.kForward);
  }

  void ElevatorBrakeOff()
  {
    p_elevatorBrake.set(Value.kReverse);
    // System.out.println("Brake OFF");

  }
// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-

  void MoveElevatorDOWN()
  {

    ElevatorBrakeOff();
    rightElevatorMotor .set(elevatorDown);
    leftElevatorMotor  .set(elevatorDown);
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-

  void MoveElevatorUP()
  {

    ElevatorBrakeOff();
    rightElevatorMotor .set(elevatorUP);
    leftElevatorMotor  .set(elevatorUP);
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-

  void ElevatorStop()
  {
    System.out.println("Stopping Elevator");
    rightElevatorMotor.stopMotor();
    leftElevatorMotor.stopMotor();
    //stop();
    ElevatorBrakeOn();
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
  
  void MakeElevatorSafe()
  {

    double elevatorDistance = e_elevator.getDistance();
    //double minElevatorHeight = 100;
    //double maxElevatorHeight = 10000;

    if(elevatorDistance < minElevatorHeight)
    {
      MoveElevatorUP();
      System.out.println("Moving into safety area UP");
      do
      {
        elevatorDistance = e_elevator.getDistance();
      }while(elevatorDistance < minElevatorHeight);
    }else{
      if(elevatorDistance > maxElevatorHeight)
      {
        MoveElevatorDOWN();   
        System.out.println("Moving into safty area DOWN");
        do
        {
          elevatorDistance = e_elevator.getDistance();
        }while(elevatorDistance > maxElevatorHeight);
      }
    }
    ElevatorStop();
    System.out.println("Inside of safe area");
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-

  public void ElevatorHightset(double setElevatorHight)
  // Sets the elvator motors to raise or lower the diffrent highs on the robot
  {
    double elevatorDistance = e_elevator.getDistance();

    System.out.print("Elevator Moiving From ");
    System.out.print(elevatorDistance);
    System.out.print(" to ");
    System.out.println(setElevatorHight);

    MakeElevatorSafe();
    System.out.println("Elevator is safe");

    if(elevatorDistance < setElevatorHight)
    {
      System.out.println("Elevator is moving UP");
      MoveElevatorUP();
      while(elevatorDistance < setElevatorHight && elevatorDistance < maxElevatorHeight )
      {
        elevatorDistance = e_elevator.getDistance();
        
        System.out.println(elevatorDistance);
      }
    }else{
      if(elevatorDistance > setElevatorHight)
      {
        System.out.println("Elevator is moiving DOWN");
        MoveElevatorDOWN();
        while(elevatorDistance > setElevatorHight && elevatorDistance > minElevatorHeight)
        {
          elevatorDistance = e_elevator.getDistance();
        }
      }
    }
    ElevatorStop();
    System.out.println("Elevator has reached its location");
  }
//-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
  
public void elevatorBrake(Joystick joystick)
  // applies the elevator brake based on the user input
  {

    if(joystick.getRawAxis(1) < .35 && joystick.getRawAxis(1) > -.35) 
    // if the joystick axis is at 35 or gratter deggres at any angle,
    //  the brake will be released 
    {
      ElevatorBrakeOn();
      // released brake
    }else{
      ElevatorBrakeOff(); 
      // brake is applied
    }
  }
  
  public void joystickElevator(Joystick joystick)
  // The elevator motors are spinned based on the user input
  {
      rightElevatorMotor.set(joystick.getRawAxis(1)); 
      // The right elevator motor speed is set to the joystick input
      leftElevatorMotor.set(joystick.getRawAxis(1));

      // The left elevator motor speed is set to the joystick inptut
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}