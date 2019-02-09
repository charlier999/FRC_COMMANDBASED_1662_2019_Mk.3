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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

public class Elevator extends Subsystem {

public Joystick operator     = new Joystick(1);
WPI_TalonSRX rightElevatorMotor  = new WPI_TalonSRX(RobotMap.rightElevatorMotor);
WPI_VictorSPX leftElevatorMotor   = new WPI_VictorSPX(RobotMap.leftElevatorMotor);

public DoubleSolenoid p_elevatorBrake = new DoubleSolenoid(6, 7);

public DifferentialDrive elevatorBase;

//public static int  elevatorDistance = new 
public Encoder e_elevatorDrum = new Encoder(14, 15, false, Encoder.EncodingType.k4X);
//int elevatorDistance;



public Elevator()
{
  rightElevatorMotor.setInverted(false);
  leftElevatorMotor.setInverted(false);
}

public void elevatorBrake(Joystick joystick)
{
  if(joystick.getRawAxis(1) < .45 && joystick.getRawAxis(1) > -.45)
  {
    p_elevatorBrake.set(Value.kForward);
  }else{
    p_elevatorBrake.set(Value.kReverse);
  }
}

public void autoElevator(boolean elevatorDirection, double elevatorSpeed) 
{
  elevatorSpeed = Math.abs(elevatorSpeed);
  if(elevatorDirection)
  {
    rightElevatorMotor.set(elevatorSpeed);
    leftElevatorMotor.set(elevatorSpeed);
  }
  else{
    rightElevatorMotor.set(-elevatorSpeed);
    leftElevatorMotor.set(-elevatorSpeed);
   }
}

public void joystickElevator(Joystick joystick)
{
  if(operator.getRawAxis(1) == 0)
  {
    p_elevatorBrake.set(Value.kForward);
  }else{
    p_elevatorBrake.set(Value.kReverse);
    rightElevatorMotor.set(operator.getRawAxis(1));
    leftElevatorMotor.set(operator.getRawAxis(1));
  }
}

// public void ElevatorHold()
// {
//   rightElevatorMotor.set(-0.3);
//   leftElevatorMotor.set(-0.3);
// }

public void testElevator(Joystick joystick)
{
  rightElevatorMotor.set(operator.getRawAxis(1));
  leftElevatorMotor.set(operator.getRawAxis(5));
}
public void stop()
{
  rightElevatorMotor.set(0);
  leftElevatorMotor.set(0);
}

public void encoderConsole() 
{
  
  //elevatorDistance = e_elevatorDrum.getRaw();
  //bvaaSystem.out.println (elevatorDistance);
}

public void elevatorEncoderReset() 
{
  e_elevatorDrum.reset();
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
