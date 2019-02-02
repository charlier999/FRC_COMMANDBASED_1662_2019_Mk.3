/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.Joystick;

// Commmands
import frc.robot.commands.cmdBallIntake;
import frc.robot.commands.cmdShift;
import frc.robot.commands.cmdClawDrop;
// import frc.robot.commands.cmdClimberPull;
import frc.robot.commands.cmdGrabberOC;

public class OI {
  
  // Joysticks
  public Joystick driver       = new Joystick(0);
  public Joystick operator     = new Joystick(1);
  // public Joystick buttonPannel = new Joystick(2);

  // Driver Buttons
  public Button shifterButton  = new JoystickButton(driver, 1);
  
  public Button intakeButton   = new JoystickButton(driver, 2);
  // intakeButton.whileHeld(Ball_Intake);

  public Button outakeButton   = new JoystickButton(driver, 3);

  public Button gripperToggle  = new JoystickButton(driver, 5);

  public Button clawDropButton = new JoystickButton(operator, 10);

  public Button climberPullButton = new JoystickButton(operator, 4);



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
    intakeButton.whileHeld(new cmdBallIntake(true, 1));
    outakeButton.whileHeld(new cmdBallIntake(false, 1));
    shifterButton.whenReleased(new cmdShift());
    clawDropButton.whenPressed(new cmdClawDrop());
    // climberPullButton.whileHeld(new cmdClimberPull(false, 1));
    gripperToggle.whenReleased(new cmdGrabberOC());

  }


  // Button Pannel Buttons
  /*
  Button hatchLevel1Button = new JoystickButton(buttonPannel, 1);
  Button hatchLevel2Button = new JoystickButton(buttonPannel, 2);
  Button hatchLevel3Button = new JoystickButton(buttonPannel, 3);

  Button ballLevel1Button = new JoystickButton(buttonPannel, 1);
  Button ballLevel2Button = new JoystickButton(buttonPannel, 2);
  Button ballLevel3button = new JoystickButton(buttonPannel, 3);

  Button ballPickUpButton = new JoystickButton(buttonPannel, 1);

  Button climberButton = new JoystickButton(buttonPannel, 1);
  //Drive Controller Axis's
 public double driverAxis0 = driver.getRawAxis(0);  // Left Thumb Stick  ~ X axis ~ +/- input
  public double driverAxis1 = driver.getRawAxis(1);  // Left Thumb Stick  ~ Y axis ~ +/- input
  public double driverAxis2 = driver.getRawAxis(2);  // Left Trigger               ~ only positive input
  public double driverAxis3 = driver.getRawAxis(3);  // Right Trigger              ~ only positive input
  public double driverAxis4 = driver.getRawAxis(4);  // Right Thumb Stick ~ X axis ~ +/- input
  public double driverAxis5 = driver.getRawAxis(5);  // Right Thumb Stick ~ Y axis ~ +/- input
  
//  driverAxis0 = driver.getRawAxis(0);
//  driverAxis1 = driver.getRawAxis(1);

  //Operator Controller Axis's
  // public double operatorAxis0;  // Left Thumb Stick  ~ X axis ~ +/- input
  // public double operatorAxis1;  // Left Thumb Stick  ~ Y axis ~ +/- input
  // public double operatorAxis2;  // Left Trigger               ~ only positive input
  // public double operatorAxis3;  // Right Trigger              ~ only positive input
  // public double operatorAxis4;  // Right Thumb Stick ~ X axis ~ +/- input
  // public double operatorAxis5;  // Right Thumb Stick ~ Y axis ~ +/- input
*/
}
