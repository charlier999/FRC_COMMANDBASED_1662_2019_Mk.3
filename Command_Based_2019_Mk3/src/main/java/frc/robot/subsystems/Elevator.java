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
      p_elevatorBrake.set(Value.kForward); // released brake
    }else{
      p_elevatorBrake.set(Value.kReverse); // brake is applied
    }
  }
  
  public void joystickElevator(Joystick joystick)
  // The elevator motors are spinned based on the user input
  {
    rightElevatorMotor.set(joystick.getRawAxis(1)); // 
    leftElevatorMotor.set(joystick.getRawAxis(1));
  }



  // Automatic Input // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
  


  public void autoElevator(boolean elevatorDirection, double elevatorSpeed) 
  {
    elevatorSpeed = Math.abs(elevatorSpeed);
    if(elevatorDirection)
    {
      rightElevatorMotor.set(elevatorSpeed);
      leftElevatorMotor.set(elevatorSpeed);
    }else{
      rightElevatorMotor.set(-elevatorSpeed);
      leftElevatorMotor.set(-elevatorSpeed);
    }
  }

  public void stop()
  {
    rightElevatorMotor.set(0);
   leftElevatorMotor.set(0);
  }

  public void encoderConsole() 
  {
   elevatorDistance = e_elevatorDrum.getRaw();
    System.out.println (elevatorDistance);
  }

  public void elevatorEncoderReset() 
  {
    e_elevatorDrum.reset();
  }

  public void ElevatorHightset(double elevatorHight)
  {
    currentElevatorHight = e_elevatorDrum.getDistance();
    if(currentElevatorHight < elevatorHight)
    {
      p_elevatorBrake.set(Value.kForward);
      rightElevatorMotor.set(1);
      leftElevatorMotor.set(1);
    }

    if(currentElevatorHight > elevatorHight);
    {
      p_elevatorBrake.set(Value.kForward);
      rightElevatorMotor.set(-1);
      leftElevatorMotor.set(-1);
    }

    if(currentElevatorHight == elevatorHight)
    {
      p_elevatorBrake.set(Value.kReverse);
      rightElevatorMotor.stopMotor();
      leftElevatorMotor.stopMotor();
    }
  }




  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
