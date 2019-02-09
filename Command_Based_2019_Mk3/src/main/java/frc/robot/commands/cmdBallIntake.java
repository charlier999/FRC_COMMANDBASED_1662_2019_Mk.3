/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class cmdBallIntake extends Command 
{

  // Boolean intakeDirection;
  Boolean direction;
  // Double intakeSpeed;
  Double speed;

  // public cmdBallIntake(boolean intakeDirection, double intakeSpeed) 
  public cmdBallIntake(boolean direction, double speed)
  // public cmdBallIntake()
  {
    requires(Robot.sub_grabber);

    // this.intakeDirection = intakeDirection;
    this.direction = direction;

    // this.intakeSpeed = intakeSpeed;
    this.speed = speed;
  }

// Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    // Robot.sub_grabber.intakeV2(false, 0);
    // Robot.sub_grabber.GrabberStop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    // Robot.sub_grabber.IntakeV3(Robot.m_oi.driver);
    // Robot.sub_grabber.intakeV2(intakeDirection, intakeSpeed); 
    Robot.sub_grabber.intake(direction, speed);
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
    // Robot.sub_grabber.intakeV2(false, 0);
    Robot.sub_grabber.GrabberStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    // Robot.sub_grabber.intakeV2(false, 0);
    // Robot.sub_grabber.GrabberStop();
    end();
  }
}

