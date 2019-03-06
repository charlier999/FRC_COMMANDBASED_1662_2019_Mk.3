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

public class cmdPistonRelease extends Command {

 double position = 0;
 boolean UP;

  public cmdPistonRelease(boolean UP) {
    requires(Robot.sub_elevator);
    //this.position = Robot.sub_elevator.getEncoderClicks();
    this.UP = UP;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (UP) {
      position = Robot.sub_elevator.getEncoderClicks() + 5000;
      SmartDashboard.putBoolean("Moving up", true);
    } else {
      position = Robot.sub_elevator.getEncoderClicks() - 5000;
      SmartDashboard.putBoolean("Moving up", false);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Boolean UP = false;

    //Robot.sub_elevator.ElevatorHightset(position + 5000);
    //Robot.sub_elevator.ElevatorHightset(position - 5000);
    Robot.sub_elevator.ElevatorHightset(position);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //return false;
   // return Math.abs(Robot.sub_elevator.getEncoderClicks() - position) < 1000;
    return Math.abs(Robot.sub_elevator.getEncoderClicks() - position) < 1000;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.sub_elevator.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
