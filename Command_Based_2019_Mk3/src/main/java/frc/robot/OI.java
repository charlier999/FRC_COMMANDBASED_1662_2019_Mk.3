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
import frc.robot.commands.cmdBallIntakeStop;
import frc.robot.commands.cmdShift;
import frc.robot.commands.cmdClawDrop;
import frc.robot.commands.cmdClimberPull;
import frc.robot.commands.cmdGrabberOC;
import frc.robot.commands.cmdLinearActuator;
// import frc.robot.commands.cmdEncoderReset;

public class OI {
  public Boolean b_Grabber;

  // Joysticks
  public Joystick driver       = new Joystick(0);
  public Joystick operator     = new Joystick(1);
  // public Joystick buttonPannel = new Joystick(2);
  // public Joystick encoderReset = new Joystick(3);

// public Button encoderResetButton = new JoystickButton(encoderReset, 1);
// public Button encoderDriveLeftConsole = new JoystickButton(encoderReset, 2);
// public Button encoderDriveRightConsole = new JoystickButton(encoderReset, 3);
// public Button encoderElevatorConsole = new JoystickButton(encoderReset, 4);
// public Button encoderLinearActConsole = new JoystickButton(encoderReset, 5);


  // Driver Buttons
  // public Button shifterButton  = new JoystickButton(driver, 1);
  //public Button shifterUp         = new JoystickButton(driver, 7);
  //public Button shifterDown       = new JoystickButton(driver, 8);

  public Button shifterUp = new JoystickButton(driver, 7);
  public Button shifterDown = new JoystickButton(driver, 8);
  
  public Button intakeButton   = new JoystickButton(driver, 6); //2
  // intakeButton.whileHeld(Ball_Intake);
  // public Button intakeButtonv2 = new JoystickButton(driver, 4);

  public Button outakeButton   = new JoystickButton(driver, 5); //3

  public Button gripperToggleClose  = new JoystickButton(driver, 3); //5
  public Button gripperToggleOpen = new JoystickButton(driver, 2); //6

  public Button clawDropButton = new JoystickButton(operator, 10);
  public Button clawUpButton   = new JoystickButton(operator, 9);

  public Button climberPullButton = new JoystickButton(operator, 4);

  public Button linearActuatorButtonIn  = new JoystickButton(operator, 3);
  public Button linearActuatorButtonOut = new JoystickButton(operator, 2);



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
    intakeButton.whenReleased(new cmdBallIntakeStop());
    // intakeButtonv2.whileHeld(new cmdBallIntake(true, 1));
    outakeButton.whileHeld(new cmdBallIntake(false, 1));
    outakeButton.whenReleased(new cmdBallIntakeStop());

    // shifterButton.whenReleased(new cmdShift());
    shifterUp.whenPressed(new cmdShift(true));
    shifterDown.whenPressed(new cmdShift(false));

    clawDropButton.whenPressed(new cmdClawDrop(false));
    clawUpButton.whenPressed(new cmdClawDrop(true));
    climberPullButton.whileHeld(new cmdClimberPull());

    gripperToggleClose.whenPressed(new cmdGrabberOC(true));
    gripperToggleOpen.whenPressed(new cmdGrabberOC(false));
    // gripperToggle.whenPressed(new cmdGrabberOC());

    linearActuatorButtonIn.whileHeld(new cmdLinearActuator(false));
    linearActuatorButtonOut.whileHeld(new cmdLinearActuator(true));
    // encoderResetButton.whenReleased(new cmdEncoderReset());
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
