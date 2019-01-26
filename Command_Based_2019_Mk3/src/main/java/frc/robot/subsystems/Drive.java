/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.OI.*;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
 
import com.ctre.phoenix.motorcontrol.can.*;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {

  // Drive base motors
  WPI_VictorSPX leftMotorA           = new WPI_VictorSPX(RobotMap.leftMotorA);
  WPI_VictorSPX leftMotorB           = new WPI_VictorSPX(RobotMap.leftMotorB);
  WPI_VictorSPX rightMotorA          = new WPI_VictorSPX(RobotMap.rightMotorA);
  WPI_VictorSPX rightMotorB          = new WPI_VictorSPX(RobotMap.rightMotorB);

  // Speed Controller Groups
  SpeedControllerGroup leftDriveBase = new SpeedControllerGroup(leftMotorA, leftMotorB); 
  SpeedControllerGroup rightDriveBase = new SpeedControllerGroup(rightMotorA, rightMotorB);

  // Differential Drive
  public DifferentialDrive driveBase = new DifferentialDrive(leftDriveBase, rightDriveBase);

  @Override
  public void initDefaultCommand() 
  {
    driveBase.tankDrive(OI.driver.Get, OI.driverAxis3);
  }
  
}
