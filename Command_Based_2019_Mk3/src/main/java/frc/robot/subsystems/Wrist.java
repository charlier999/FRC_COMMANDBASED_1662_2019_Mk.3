/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * Add your docs here.
 */
public class Wrist extends Subsystem {
  public Joystick operator     = new Joystick(1);

  void MakeWristSafe()
  {

    // double elevatorDistance = e_elevator.getDistance();
    // double minElevatorHeight = 100;
    // double maxElevatorHeight = 10000;

    // if(elevatorDistance < minElevatorHeight)
    
    // {
    //   MoveElevatorUP();
    //   System.out.println("Moving into safety area UP");
    //   do
    //   {
    //     elevatorDistance = e_elevator.getDistance();
    //   }while(elevatorDistance < minElevatorHeight);
    // }else{
    //   if(elevatorDistance > maxElevatorHeight)
    //   {
    //     MoveElevatorDOWN();   
    //     System.out.println("Moving into safty area DOWN");
    //     do
    //     {
    //       elevatorDistance = e_elevator.getDistance();
    //     }while(elevatorDistance > maxElevatorHeight);
    //   }
    // }
    // ElevatorStop();
    // System.out.println("Inside of safe area");
   
  }

  // if(elevatorDistance < minElevatorHeight)
    
  //   {
  //     MoveElevatorUP();
  //     System.out.println("Moving into safety area UP");
  //     do
  //     {
  //       elevatorDistance = e_elevator.getDistance();
  //     }while(elevatorDistance < minElevatorHeight);
  //   }else{
  //     if(elevatorDistance > maxElevatorHeight)
  //     {
  //       MoveElevatorDOWN();   
  //       System.out.println("Moving into safty area DOWN");
  //       do
  //       {
  //         elevatorDistance = e_elevator.getDistance();
  //       }while(elevatorDistance > maxElevatorHeight);
  //     }
  //   }
  //   ElevatorStop();
  //   System.out.println("Inside of safe area");
  // }

  public WPI_VictorSPX wristMotor = new WPI_VictorSPX(RobotMap.wristMotor);

    public void wristJoystickActuation(Joystick joystick)
    // Changes the angle of the grabber wrist based on user input via joystick
    {
      wristMotor.set(joystick.getRawAxis(5));
      // sets the wrist motor to the joystick input
    }

    public void WristStop()
    {
      wristMotor.stopMotor();
    }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
