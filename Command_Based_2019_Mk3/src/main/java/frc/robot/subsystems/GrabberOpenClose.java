/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


import frc.robot.RobotMap;

//import edu.wpi.first.wpilibj.Joystick;

//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


/**
 * Add your docs here.
 */
public class GrabberOpenClose extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
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

  public void wristJoystickActuation(Joystick joystick)
  {
    wristMotor.set(joystick.getRawAxis(5));
  }

  // public void WristStop()
  // {
  //   wristMotor.set(0);
  // }

  public void GrabberOC(boolean direction)
  {
    if (direction)
    {
      p_gripper.set(Value.kForward);
    }else{
      p_gripper.set(Value.kReverse);
    }
  }

  public void Intake(Boolean direction)
  {
    if(direction)
    {
      gripperMotorV2.set(1);
    }else{
      gripperMotorV2.set(-1);
    }
  }

  public void IntakeStop()
  {
    // gripperMotorV2.stopMotor();
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
