
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Climber extends Subsystem 
{
  Joystick operator = new Joystick(1);

  public DoubleSolenoid p_climberClaws = new DoubleSolenoid(1 , 2);

  WPI_TalonSRX linearActuator = new WPI_TalonSRX(RobotMap.linearActuator);
  WPI_VictorSPX climberWheel  = new WPI_VictorSPX(RobotMap.climberWheel);

  public Encoder e_linearAct    = new Encoder(16, 17, false, Encoder.EncodingType.k4X);
  int linearActDistance;

  public Climber()
  {
    linearActuator.setInverted(false);
    climberWheel.setInverted(false);

    linearActuator.setSafetyEnabled(true);
    climberWheel.setSafetyEnabled(false);
  }

  public void linearActuatorEncoderReset()
  {
    e_linearAct.reset();
  }

  public void ClawRelease()
  {
    if(p_climberClaws.get() == Value.kForward)
    {
      p_climberClaws.set(Value.kReverse);
    }else{
      p_climberClaws.set(Value.kForward);
    }
  }

  public void ClimberPull()
  {
    climberWheel.set(-1);
  }

  public void LinearActuatorExtend(Boolean direction)
  {
    if(direction)
    {
      linearActuator.set(1);
    }else{
      linearActuator.set(-1);
    }
  }

  public void climberStop()
  {
    climberWheel.set(0);
  }

  public void encoderConsole()
  {
    //SmartDashboard PutString("DB/String 0", "This is a string");
    //SmartDashboard PutString()

    linearActDistance = e_linearAct.getRaw();
    System.out.println (linearActDistance);  
  }

  public void linearActuatorStop()
  {
    linearActuator.set(0);
  }

  @Override
  public void initDefaultCommand() 
  {

  }
}
