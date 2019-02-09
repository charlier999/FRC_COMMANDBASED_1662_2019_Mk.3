/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Toggle;
// import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;



public class Grabber extends Subsystem 
{
  // public Toggle grabberToggle = new Toggle(false);
  public Joystick operator     = new Joystick(1);
  public DoubleSolenoid p_gripper = new DoubleSolenoid(2, 3);
  public WPI_VictorSPX GripperMotor = new WPI_VictorSPX(RobotMap.GripperMotor);
  public WPI_VictorSPX wristMotor = new WPI_VictorSPX(RobotMap.wristMotor);
  public AnalogPotentiometer ap_gripper = new AnalogPotentiometer(1);


  public void intake(boolean intakeDirection, double intakeSpeed)
  {
    intakeSpeed = Math.abs(intakeSpeed);
    
    if(intakeDirection)
    {
      GripperMotor.set(intakeSpeed);
    }else{
      GripperMotor.set(-intakeSpeed);
    }
  }

  public void Gripperstop()
  {
    GripperMotor.stopMotor();
  }
  
  public void wristButtonActuation(boolean wristDirection, double wristSpeed)
  {
    wristSpeed = Math.abs(wristSpeed);

    if(wristDirection)
    {
      wristMotor.set(wristSpeed);
    }else{
      wristMotor.set(-wristSpeed);
    }
  }
  public void wristJoystickActuation(Joystick joystick)
  {
    wristMotor.set(joystick.getRawAxis(5));
  }

  public void WristStop()
  {
    wristMotor.stopMotor();
  }

  public void GrabberOC(boolean direction)
  {
    if (direction)
    {
      p_gripper.set(Value.kForward);
    }else{
      p_gripper.set(Value.kReverse);
    }
  }

  public void GrabberOCv2()
  {
    Toggle grabberToggle = new Toggle(false);
    if(grabberToggle.getToggle())
    {
      p_gripper.set(Value.kForward);
      grabberToggle.toggleVar(true);
    }else{
      p_gripper.set(Value.kReverse);
      grabberToggle.toggleVar(false);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
