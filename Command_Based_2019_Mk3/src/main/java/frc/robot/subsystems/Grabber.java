/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
// import frc.robot.OI;
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class Grabber extends Subsystem {

  public Joystick operator     = new Joystick(1);
  public DoubleSolenoid p_gripper = new DoubleSolenoid(3, 4);

  //Intake Motors
  WPI_VictorSPX GripperMotor = new WPI_VictorSPX(RobotMap.GripperMotor);
  // WPI_VictorSPX leftGripper1 = new WPI_VictorSPX(RobotMap.leftGripperMotor1);  

  // SpeedControllerGroup gripperIntake = new SpeedControllerGroup(rightGripper1, leftGripper1);

  public void intake(boolean direction, double speed)
  {
    speed = Math.abs(speed);
    
    if(direction)
    {
      GripperMotor.set(speed);
    }else{
      GripperMotor.set(-speed);
    }
  }

  public void stop()
  {
    GripperMotor.stopMotor();
  }








  
  
  double wristAxis = operator.getRawAxis(5);    //Right Thumb Stick ~ Y axis ~ +/- input

  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
