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
import frc.robot.commands.cmdLinearActuator;
import frc.robot.commands.cmdElevatorHeight;

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

  public Button releaseClimbingClaw     = new JoystickButton(operator, 7);
  public Button attachClimbingClaw      = new JoystickButton(operator, 8);

  // Button Pannel Buttons // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

  public Button hatchLevel1Button       = new JoystickButton(buttonPannel, 1);
  public Button hatchLevel2Button       = new JoystickButton(buttonPannel, 2);
  public Button hatchLevel3Button       = new JoystickButton(buttonPannel, 3);

  public Button ballLevel1Button        = new JoystickButton(buttonPannel, 4);
  public Button ballLevel2Button        = new JoystickButton(buttonPannel, 5);
  public Button ballLevel3button        = new JoystickButton(buttonPannel, 6);

  public Button ballPickUpButton        = new JoystickButton(buttonPannel, 7);

  public Button climberButton           = new JoystickButton(buttonPannel, 8);


  public Joystick getDriverJoystick()
  {
    return driver;
  }

  public Joystick getOperatorJoystick()
  {
    return operator;
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

    // Linear Actuator
    linearActuatorDown.whileHeld(new cmdLinearActuator(true));
    linearActuatorUp.whileHeld(new cmdLinearActuator(false));


    // Button Pannel // -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

    // Hatch Levels
    hatchLevel1Button.whileHeld(new cmdElevatorHeight(-3045));
    hatchLevel2Button.whileHeld(new cmdElevatorHeight(-20750));
    hatchLevel3Button.whileHeld(new cmdElevatorHeight(-39732));

    // Ball Levels
    ballLevel1Button.whileHeld(new cmdElevatorHeight(-7824));
    ballLevel2Button.whileHeld(new cmdElevatorHeight(-27700));
    ballLevel3button.whileHeld(new cmdElevatorHeight(-39732));
    ballPickUpButton.whileHeld(new cmdElevatorHeight(0));

    // Auto Climb 
    // climberButton.whenPressed(new SomeOtherCmd());

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 
  }
}