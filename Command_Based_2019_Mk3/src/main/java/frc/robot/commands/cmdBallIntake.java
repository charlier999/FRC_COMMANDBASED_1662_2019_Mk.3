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

  Boolean direction;
  Double speed;

  public cmdBallIntake(boolean direction, double speed) 
  {
    requires(Robot.sub_grabber);

    this.direction = direction;
    // direction = true;
    this.speed = speed;
    // speed = 1;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

// Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    Robot.sub_grabber.Gripperstop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
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
    Robot.sub_grabber.Gripperstop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    Robot.sub_grabber.Gripperstop();
  }
}
