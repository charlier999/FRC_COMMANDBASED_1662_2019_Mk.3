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
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

public class Elevator extends Subsystem 
{

  public Joystick operator     = new Joystick(1);
  WPI_TalonSRX rightElevatorMotor  = new WPI_TalonSRX(RobotMap.rightElevatorMotor);
  WPI_VictorSPX leftElevatorMotor   = new WPI_VictorSPX(RobotMap.leftElevatorMotor);

  public DoubleSolenoid p_elevatorBrake = new DoubleSolenoid(6, 7);

  // public DifferentialDrive elevatorBase;

  //public static int  elevatorDistance = new 
  public Encoder e_elevatorDrum = new Encoder(14, 15, false, Encoder.EncodingType.k4X);
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
    rightElevatorMotor.set(joystick.getRawAxis(1)); 
    // The right elevator motor speed is set to the joystick input
    leftElevatorMotor.set(joystick.getRawAxis(1));
    // The left elevator motor speed is set to the joystick inptut
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

  public void encoderConsole() 
  // Outputs the encoder distance to the drive station console
  {
   elevatorDistance = e_elevatorDrum.getDistance();
    // Sets elevatorDistance to the encoder's recorded distance
    System.out.println (elevatorDistance);
    // Prints the elevatorDistance value to the driver station console
  }

  public void elevatorEncoderReset() 
  // Resets the encoder's zero
  {
    e_elevatorDrum.reset();
  }

  public void ElevatorHightset(double elevatorHight)
  // Sets the elvator motors to raise or lower the diffrent highs on the robot
  {
    currentElevatorHight = e_elevatorDrum.getDistance();
    // sets the varaible currentElevatorHight to the encoders recorded distance
    if(currentElevatorHight < elevatorHight)
    // if current elevator hight is less then set elevaor hight
    {
      p_elevatorBrake.set(Value.kForward);
      // Opens the elevator brake
      rightElevatorMotor.set(1);
      // Sets the right elevator motor to full speed positive 
      leftElevatorMotor.set(1);
      // Sets the left elevator motor to full speed positive
    }

    if(currentElevatorHight > elevatorHight);
    // if current elevaor hight is grater than the set elevator hight
    {
      p_elevatorBrake.set(Value.kForward);
      // opens the elevator brake
      rightElevatorMotor.set(-1);
      // Sets the right elevator motor to full speed negitve
      leftElevatorMotor.set(-1);
      // Sets the left elevator motor to full speed negitve
    }

    if(currentElevatorHight == elevatorHight)
    // If the current hight is equel to the set elevator hight
    {
      p_elevatorBrake.set(Value.kReverse);
      // closes the elevator brake
      rightElevatorMotor.stopMotor();
      // stops the right elevator motor
      leftElevatorMotor.stopMotor();
      // stops the left elevator motor
    }
  }

  
//-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
