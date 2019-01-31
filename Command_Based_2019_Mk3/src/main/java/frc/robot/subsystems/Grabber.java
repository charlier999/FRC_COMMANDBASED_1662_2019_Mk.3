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
import frc.robot.RobotMap;
import frc.robot.OI;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;



public class Grabber extends Subsystem {

  public Joystick operator     = new Joystick(1);
  public DoubleSolenoid p_gripper = new DoubleSolenoid(3, 4);
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

  public void WristStop()
  {
    wristMotor.stopMotor();
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

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
