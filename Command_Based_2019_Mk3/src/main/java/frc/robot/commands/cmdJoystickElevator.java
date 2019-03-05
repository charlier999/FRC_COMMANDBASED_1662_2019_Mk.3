/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class cmdJoystickElevator extends Command 
{
  public cmdJoystickElevator() 
  {
    requires(Robot.sub_elevator);

    //requires(Robot.sub_ElevatorTry); //Added 3/3/19

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    Robot.sub_elevator.stop();

    //Robot.sub_ElevatorTry.stop(); //Added 3/3/19
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    Robot.sub_elevator.joystickElevator(Robot.m_oi.operator);
    
    Robot.sub_elevator.elevatorBrake(Robot.m_oi.operator);

    //Robot.sub_ElevatorTry.joystickElevator(Robot.m_oi.operator); //Added 3/3/19
   // Robot.sub_ElevatorTry.elevatorBrake(Robot.m_oi.operator); //Added 3/3/19

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
    Robot.sub_elevator.stop();

    //Robot.sub_ElevatorTry.stop(); //Added 3/3/19
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    Robot.sub_elevator.stop();

    //Robot.sub_ElevatorTry.stop(); //Added 3/3/19
  }
}
