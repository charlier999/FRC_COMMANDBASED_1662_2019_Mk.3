/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class cmdElevatorHeight extends Command 
{
  double elevatorHight;
  public cmdElevatorHeight(double elevatorHight) 
  {
    requires(Robot.sub_elevator);
    this.elevatorHight = elevatorHight;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    Robot.sub_elevator.ElevatorHightset(elevatorHight);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    
    return Math.abs(Robot.sub_elevator.e_elevator.getDistance() - 
                    Robot.sub_elevator.ElevatorReturn()) < 0.3;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    Robot.sub_elevator.p_elevatorBrake.set(Value.kForward);
    Robot.sub_elevator.ElevatorMotorStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
