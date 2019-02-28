/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


import frc.robot.RobotMap;

//-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
  
public class GrabberOpenClose extends Subsystem 
{
  // public AnalogPotentiometer ap_gripper = new AnalogPotentiometer(1);
  public Joystick opwerator = new Joystick(1);

  public WPI_VictorSPX gripperMotorV2 = new WPI_VictorSPX(RobotMap.gripperMotorV2);
  public WPI_VictorSPX wristMotor = new WPI_VictorSPX(RobotMap.wristMotor);

  public DoubleSolenoid p_gripper = new DoubleSolenoid(2, 3);

  public GrabberOpenClose()
  {
    gripperMotorV2.setInverted(false);

    gripperMotorV2.setSafetyEnabled(true);
  }


  // User //-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  

  public void GrabberOC()
  // Open and closes the grabber based on user input
  {
    if (p_gripper.get() == Value.kForward)
    {
      p_gripper.set(Value.kReverse);
    }else{
      p_gripper.set(Value.kForward);
    }
    // if (direction)
    // {
    //   p_gripper.set(Value.kForward);
    //   // closes the grabber arms
    // }else{
    //   p_gripper.set(Value.kReverse);
    //   // opens the grabber arms
    // }
  }

  public void Intake(Boolean direction)
  // Controlls the intake speed based on user input
  {
    if(direction)
    {
      gripperMotorV2.set(1);
      // sets the grabber motor to full speed positive
    }else{
      gripperMotorV2.set(-1);
      // sets the grabber motor to full speed negitive
    }
  }


  // Auto //-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  

  public void IntakeStop()
  // Stops all voltake to intake motor
  {
    gripperMotorV2.stopMotor();
  }

  //-=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  

  @Override
  public void initDefaultCommand() 
  {

  }
}
