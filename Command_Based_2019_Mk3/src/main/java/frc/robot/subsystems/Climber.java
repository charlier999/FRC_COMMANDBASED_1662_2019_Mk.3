
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

public class Climber extends Subsystem //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
{
  public DoubleSolenoid p_climberClaws = new DoubleSolenoid(4 , 5);
  // public DoubleSolenoid p_BAP          = new DoubleSolenoid(8, 9);

  WPI_VictorSPX climberWheel  = new WPI_VictorSPX(RobotMap.climberWheel);



  //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
  
  public Climber()
  {
    climberWheel.setInverted(false);
  }


  // User Input // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
 
  public void ClawRelease(boolean direction)
  // Changes the direction of the climber claw release piston based on the user input
  {
    if(direction)
    {
      p_climberClaws.set(Value.kForward); // Release
    }else{
      p_climberClaws.set(Value.kReverse); // Close
    }
  }

  public void BAPToggle(Boolean direction)
  {
    // if(direction)
    // {
    //   p_BAP.set(Value.kForward);
    // }else{
    //   p_BAP.set(Value.kReverse);
    // }
  }
  
  public void ClimbingWheel(Boolean direction)
  // Sets the direction of the of the climbing wheel on the climbing arm based on user input
  {
    if(direction)
    {
      climberWheel.set(1); // Spin at full speed (+)
    }else{
      climberWheel.set(-1); // Spin at full speed (-)
    }
  }



  // Automatic Commands //  -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  
 
  public void climberStop() 
  // Stops the climber wheel on the climbing arms 
  {
    climberWheel.stopMotor(); // Stops all voltage to the motor
  }

  @Override
  public void initDefaultCommand() 
  {

  }
}
// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-  