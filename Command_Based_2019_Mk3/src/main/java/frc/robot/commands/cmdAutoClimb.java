/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class cmdAutoClimb extends Command 
{
  Timer timer;
  public cmdAutoClimb() 
  {
    requires(Robot.sub_climber);
    requires(Robot.sub_drive);
    requires(Robot.sub_elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
  timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    Robot.sub_drive.AutoDrive(0.2, 0.2);
    timer.start();
    if(timer.get() == 2.0)
    {
      timer.stop();
    }
    Robot.sub_elevator.autoElevator(true, 1);
    // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    timer.reset();
    timer.start();

    if(timer.get() == 2.0)
    {
      timer.stop();
    }
    Robot.sub_elevator.autoElevator(true, 0);
    Robot.sub_climber.ClawRelease(true);
    // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    timer.reset();
    timer.start();

    if(timer.get() == 2.0)
    {
      timer.stop();
    }
    Robot.sub_climber.ClawRelease(false);
    Robot.sub_elevator.ElevatorHightset(-15000);
    // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    timer.reset();
    timer.start();

    if(timer.get() == 2.0)
    {
      timer.stop();
    }
    Robot.sub_elevator.autoElevator(false, 0.75);
    Robot.sub_climber.LinearActuatorExtend(true);
    // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    timer.reset();
    timer.start();

    if(timer.get() == 2.0)
    {
      timer.stop();
    }    
    Robot.sub_climber.linearActuatorStop();
    Robot.sub_elevator.autoElevator(true, 0);
    // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    timer.reset();
    timer.start();

    if(timer.get() == 2.0)
    {
      timer.stop();
    }
    Robot.sub_drive.AutoDrive(0.4, 0.4);
    Robot.sub_climber.ClimbingWheel(true);
    // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    timer.reset();
    timer.start();

    if(timer.get() == 2.0)
    {
      timer.stop();
    }
    Robot.sub_climber.climberStop();
    Robot.sub_drive.AutoDrive(0.0, 0.0);
    // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    timer.reset();
    timer.start();

    if(timer.get() == 2.0)
    {
      timer.stop();
    }
    Robot.sub_climber.LinearActuatorExtend(false);
    // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
    timer.reset();
    timer.start();

    if(timer.get() == 2.0)
    {
      timer.stop();
    }
    Robot.sub_climber.linearActuatorStop();
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
  protected void interrupted() {
  }
}
