/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.Joystick;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  // Joysticks
  Joystick driver       = new Joystick(0);
  Joystick operator     = new Joystick(1);
  Joystick buttonPannel = new Joystick(2);

  // Driver Buttons
  Button shifterButton  = new JoystickButton(driver, 1);
  
  Button intakeButton   = new JoystickButton(driver, 2);
  Button outakeButton   = new JoystickButton(driver, 3);

  Button gripperToggle  = new JoystickButton(driver, 5);

  // Operator Buttons



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
  */

  //Drive Controller Axis's
  double driverAxis0;  // Left Thumb Stick  ~ X axis ~ +/- input
  double driverAxis1;  // Left Thumb Stick  ~ Y axis ~ +/- input
  double driverAxis2 = driver.getRawAxis(2);  // Left Trigger               ~ only positive input
  double driverAxis3 = driver.getRawAxis(3);  // Right Trigger              ~ only positive input
  double driverAxis4 = driver.getRawAxis(4);  // Right Thumb Stick ~ X axis ~ +/- input
  double driverAxis5 = driver.getRawAxis(5);  // Right Thumb Stick ~ Y axis ~ +/- input
  
//  driverAxis0 = driver.getRawAxis(0);
//  driverAxis1 = driver.getRawAxis(1);

  //Operator Controller Axis's
  double operatorAxis0;  // Left Thumb Stick  ~ X axis ~ +/- input
  double operatorAxis1;  // Left Thumb Stick  ~ Y axis ~ +/- input
  double operatorAxis2;  // Left Trigger               ~ only positive input
  double operatorAxis3;  // Right Trigger              ~ only positive input
  double operatorAxis4;  // Right Thumb Stick ~ X axis ~ +/- input
  double operatorAxis5;  // Right Thumb Stick ~ Y axis ~ +/- input

 /* CREATING BUTTONS
  * One type of button is a joystick button which is any button on a
  * joystick.
  * You create one by telling it which joystick it's on and which button
  * Joystick stick = new Joystick(port);
  * Button button = new JoystickButton(stick, buttonNumber);
  *
  * There are a few additional built in buttons you can use. Additionally,
  * by subclassing Button you can create custom triggers and bind those to
  * commands the same as any other Button.
  *
  * TRIGGERING COMMANDS WITH BUTTONS
  * Once you have a button, it's trivial to bind it to a button in one of
  * three ways:
  *
  * Start the command when the button is pressed and let it run the command
  * until it is finished as determined by it's isFinished method.
  * button.whenPressed(new ExampleCommand());
  *
  * Run the command while the button is being held down and interrupt it once
  * the button is released.
  * button.whileHeld(new ExampleCommand());
  *
  * Start the command when the button is released and let it run the command
  * until it is finished as determined by it's isFinished method.
  * button.whenReleased(new ExampleCommand());
  */
}
