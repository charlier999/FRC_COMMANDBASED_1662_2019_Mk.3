/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class cmdSmartDashboard extends Command 
{
  public cmdSmartDashboard() 
  {
    requires(Robot.sub_climber);
    requires(Robot.sub_drive);
    requires(Robot.sub_elevator);

    //requires(Robot.sub_ElevatorTry);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    //SmartDashboard.putNumber("Wrist Potentometer", Robot.sub_grabber.ap_gripper.get());
    SmartDashboard.putNumber("Elevator Hight", Robot.sub_elevator.e_elevator.getDistance());
    SmartDashboard.putNumber("Drive Train Left", Robot.sub_drive.e_driveLeft.getDistance());
    SmartDashboard.putNumber("Drive Train Right", Robot.sub_drive.e_driveRight.getDistance());

    //SmartDashboard.putNumber("Elevator Hight", Robot.sub_ElevatorTry.e_elevator.getDistance()); //Added 3/3/19
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {

  }
}
