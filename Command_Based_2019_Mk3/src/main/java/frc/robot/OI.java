/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.Joystick;

// Commmands // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
import frc.robot.commands.cmdShift;
import frc.robot.commands.cmdClawDrop;
import frc.robot.commands.cmdClimberPull;
import frc.robot.commands.cmdGrabberOC;
import frc.robot.commands.cmdElevatorHeight;
import frc.robot.commands.cmdBigGasPiston;
// import frc.robot.commands.cmdAutoTimedElevator;

public class OI {
  // Joysticks // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

  public Joystick driver       = new Joystick(0);
  public Joystick operator     = new Joystick(1);
  public Joystick buttonPannel = new Joystick(2);


  // Driver Buttons -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

  public Button shifterButton           = new JoystickButton(driver, 5);
  public Button grabberButton           = new JoystickButton(driver, 6);
  public Button hatchButton             = new JoystickButton(driver, 1);

  // Operator Buttons // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

  public Button linearActuatorUp        = new JoystickButton(operator, 3);
  public Button linearActuatorDown      = new JoystickButton(operator, 2);

  public Button climbingWheel           = new JoystickButton(operator, 5);
  public Button climbingWheelReverse    = new JoystickButton(operator, 6);

  public Button releaseClimbingClaw     = new JoystickButton(operator, 7);
  public Button attachClimbingClaw      = new JoystickButton(operator, 8);

  public Button elevatorDown3           = new JoystickButton(operator, 1);
  public Button elevatorUp3             = new JoystickButton(operator, 4);

  // Button Pannel Buttons // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

  public Button hatchLevel1Button       = new JoystickButton(buttonPannel, 3); 
  public Button hatchLevel2Button       = new JoystickButton(buttonPannel, 4);
  public Button hatchLevel3Button       = new JoystickButton(buttonPannel, 5);

  public Button ballLevel1Button        = new JoystickButton(buttonPannel, 6);
  public Button ballLevel2Button        = new JoystickButton(buttonPannel, 7);
  public Button ballLevel3button        = new JoystickButton(buttonPannel, 8);

  public Button intakeStationButton = new JoystickButton(buttonPannel, 1);

  //public Button pistonUpButton          = new JoystickButton(buttonPannel, 1); 

 // public Button pistonDownButton        = new JoystickButton(buttonPannel, 2); 





  public Joystick getDriverJoystick()
  {
    return driver;
  }

  public Joystick getOperatorJoystick()
  {
    return operator;
  }

  public Joystick getButtonPannelJoystick()
  {
    return buttonPannel;
  }

  public OI()
  {

    // Driver // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
 
    // Shifters
    shifterButton.whenPressed(new cmdShift());
       
    // Grabber Open or Close
    
    grabberButton.whenPressed(new cmdGrabberOC());

    // Operator // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
   
    // Climbing Arms
    
    releaseClimbingClaw.whenPressed(new cmdClawDrop(true));
    attachClimbingClaw.whenPressed(new cmdClawDrop(false));

    climbingWheel.whileHeld(new cmdClimberPull(true));
    climbingWheelReverse.whileHeld(new cmdClimberPull(false));

    // Linear Actuator
    linearActuatorDown.whenPressed(new cmdBigGasPiston(true));
    linearActuatorUp.whenPressed(new cmdBigGasPiston(false));
    // linearActuatorDown.whileHeld(new cmdBAP(true));
    // linearActuatorUp.whileHeld(new cmdBAP(false));


    // Button Pannel // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

   // Hatch Levels
    hatchLevel1Button.whenPressed(new cmdElevatorHeight(3257.25));
    hatchLevel2Button.whenPressed(new cmdElevatorHeight(229866.25));
    hatchLevel3Button.whenPressed(new cmdElevatorHeight(364064.5));

    // Ball Levels
    ballLevel1Button.whenPressed(new cmdElevatorHeight(-12188.5));
    ballLevel2Button.whenPressed(new cmdElevatorHeight(161571.75));
    ballLevel3button.whenPressed(new cmdElevatorHeight(368002.25));

    intakeStationButton.whenPressed(new cmdElevatorHeight(69423.0));

    // Climber
    //pistonUpButton.whenPressed(new cmdPistonRelease(true));
    //pistonDownButton.whenPressed(new cmdPistonRelease(false));

    // Elevator 3 inch move
    // elevatorUp3.whenPressed(new cmdAutoTimedElevator(true, 0.05));
    // elevatorDown3.whenPressed(new cmdAutoTimedElevator(false, 0.05));

    // Auto Climb 
    // climberButton.whenPressed(new SomeOtherCmd());

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

}
}