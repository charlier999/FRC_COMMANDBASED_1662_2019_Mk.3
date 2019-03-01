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

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;

public class Elevator extends Subsystem 
{
  WPI_VictorSPX rightElevatorMotor  = new WPI_VictorSPX(RobotMap.rightElevatorMotor);
  WPI_VictorSPX leftElevatorMotor   = new WPI_VictorSPX(RobotMap.leftElevatorMotor);

  SensorCollection rightElevatorSensor = new SensorCollection(rightElevatorMotor);
  public DoubleSolenoid p_elevatorBrake = new DoubleSolenoid(6, 7);

  public Encoder e_elevator = new Encoder(16, 17, false, Encoder.EncodingType.k4X);

  boolean elevatorHeightSafe;
  boolean commandIsRunning;

  Integer elevatorDirection;

  double elevatorDistance;

  Timer timer = new Timer();

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
    // if(e_elevator.getDistance() != 10500.00 && e_elevator.getDistance() != 10.0)
    // {
      rightElevatorMotor.set(joystick.getRawAxis(1)); 
      // The right elevator motor speed is set to the joystick input
      leftElevatorMotor.set(joystick.getRawAxis(1));
      // The left elevator motor speed is set to the joystick inptut
    // }else{
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

  public void CommandIsRunning(boolean running)
  {
    commandIsRunning = running;
  }
// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
  
  public void ElevatorHightset(double setElevatorHight)
  // Sets the elvator motors to raise or lower the diffrent highs on the robot
  {
    while(commandIsRunning)
    {

      if(e_elevator.getDistance() < 100)
      {

        elevatorHeightSafe = false;

      }

      if(e_elevator.getDistance() > 10500)
      {

        elevatorHeightSafe = false;

      } 

      if(e_elevator.getDistance() < 100 &&
      e_elevator.getDistance() > 10500)
      {

        elevatorHeightSafe = true;
   
      }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    
      if(elevatorHeightSafe == false)
      {
        if(e_elevator.getDistance() < 100)
        {

          p_elevatorBrake.set(Value.kForward);
          rightElevatorMotor .set(-0.5);
          leftElevatorMotor  .set(-0.5);

        }

        if(e_elevator.getDistance() > 10500)
        {

          p_elevatorBrake.set(Value.kForward);
          rightElevatorMotor .set(0.5);
          leftElevatorMotor  .set(0.5);    

        }

        if(e_elevator.getDistance() < 100 &&
           e_elevator.getDistance() > 10500)
        {

          elevatorHeightSafe = true;
          rightElevatorMotor .set(0.0);
          leftElevatorMotor  .set(0.0);
          p_elevatorBrake    .set(Value.kReverse);

        }

      }
      else  // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
      {

        if(Math.abs(e_elevator.getDistance() - setElevatorHight) < 100 &&
        Math.abs(e_elevator.getDistance() - setElevatorHight) > -100)
        // if the elevator height - sethElevatorHeight is less then 0
        // then the elevator is below the setElevatorheight
        {

          elevatorDirection = 0;
          // the elevator is at the correct height

        } 

        if(Math.abs(e_elevator.getDistance() - setElevatorHight) > 100 &&
        Math.abs(e_elevator.getDistance() - setElevatorHight) < -100)
        // if the elevator height - sethElevatorHeight is less then 0
        // then the elevator is below the setElevatorheight
        {

          elevatorDirection = 3;
          // the elevator us not at the correct height

        }
// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
        while(elevatorDirection != 0)
        {

          if(Math.abs(e_elevator.getDistance() - setElevatorHight) < 100 &&
          Math.abs(e_elevator.getDistance() - setElevatorHight) > -100)
          // if the elevator height - sethElevatorHeight is less then 0
          // then the elevator is below the setElevatorheight
          {

            elevatorDirection = 0;
            // the elevator needs to go up

          }

          if(Math.abs(e_elevator.getDistance() - setElevatorHight) >= 0)
          // if the elevator height - sethElevatorHeight is grater then 0
          // then the elevator is above the setElevatorheight
          {

            elevatorDirection = -1;
            // the elevator needs to go down
        
          } 

          if(Math.abs(e_elevator.getDistance() - setElevatorHight) <= 0)
          // if the elevator height - sethElevatorHeight is less then 0
          // then the elevator is below the setElevatorheight
          {

            elevatorDirection = 1;
            // the elevator needs to go up

          }
    

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

          if(elevatorDirection == 1)
          {

            p_elevatorBrake.set(Value.kForward);
            rightElevatorMotor .set(-0.5);
            leftElevatorMotor  .set(-0.5);
            System.out.println("Elevator ++++++++++++++ UP");

          }

          if(elevatorDirection == -1)
          {

            p_elevatorBrake.set(Value.kForward);
            rightElevatorMotor .set(0.5);
            leftElevatorMotor  .set(0.5);
            System.out.println("Elevator -------------- DOWN");

          }

          if(elevatorDirection == 0)
          {

            p_elevatorBrake.set(Value.kReverse);
            rightElevatorMotor .set(0.0);
            leftElevatorMotor  .set(0.0);
            System.out.println("Elevator ============== REACHED");
            commandIsRunning = false;

          }
        }
      }
    }
// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  }



/*

    maxElevatorHeight = 10500;
    minElevatorHeight = 100;
    elevatorDistance = setElevatorHight;
    currentElevatorHight = e_elevator.getDistance();
    SmartDashboard.putNumber("Set Elevator Hight", setElevatorHight);
    // sets the varaible currentElevatorHight to the encoders recorded distance


if(joystick.getRawButton(1) == false)
// if Button #1 on the button pannel is not pressed,
// then run auto height elevator.
{

    while(e_elevator.getDistance() >  setElevatorHight   && 
          e_elevator.getDistance() != maxElevatorHeight &&
          e_elevator.getDistance() != minElevatorHeight)
    // if current elevator hight is less then set elevaor hight
    {
      System.out.println("Elevator Going Down");
      p_elevatorBrake.set(Value.kReverse);
      // Opens the elevator brake

      rightElevatorMotor.set(0.5);
      // Sets the right elevator motor to full speed positive 
      leftElevatorMotor.set(0.5);
      // Sets the left elevator motor to full speed positive
    }



    while(e_elevator.getDistance() <  setElevatorHight   && 
          e_elevator.getDistance() != maxElevatorHeight &&
          e_elevator.getDistance() != minElevatorHeight);
    // if current elevaor hight is grater than the set elevator hight
    {
      System.out.println("Elevator Going UP");
      p_elevatorBrake.set(Value.kReverse);
      // opens the elevator brake

      rightElevatorMotor.set(-0.5);
      // Sets the right elevator motor to full speed negitve
      leftElevatorMotor.set(-0.5);
      // Sets the left elevator motor to full speed negitve
    }



    while(e_elevator.getDistance() == setElevatorHight  && 
          e_elevator.getDistance() != maxElevatorHeight &&
          e_elevator.getDistance() != minElevatorHeight)
    // If the current hight is equel to the set elevator hight
    {
      System.out.println("Elevator Stop");
      p_elevatorBrake.set(Value.kForward);
      // closes the elevator brake

      rightElevatorMotor.stopMotor();
      // stops the right elevator motor
      leftElevatorMotor.stopMotor();
      // stops the left elevator motor.

    }
  }else{
    rightElevatorMotor.stopMotor();
    leftElevatorMotor.stopMotor();
    p_elevatorBrake.set(Value.kForward);
  }
*/
  public void ElevatorMotorStop()
  {
    rightElevatorMotor.stopMotor();
    leftElevatorMotor.stopMotor();
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
