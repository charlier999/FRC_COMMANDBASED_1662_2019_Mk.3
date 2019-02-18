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
import frc.robot.commands.cmdElevatorHeight;
// import frc.robot.commands.cmdEncoderReset;

public class OI {
  public Boolean b_Grabber;

  // Joysticks
  public Joystick driver       = new Joystick(0);
  public Joystick operator     = new Joystick(1);
  //public Joystick buttonPannel = new Joystick(2);
  public Joystick testPannel   = new Joystick(2);

  // Driver Buttons
  public Button gripperToggleClose      = new JoystickButton(driver, 3);
  public Button gripperToggleOpen       = new JoystickButton(driver, 2);
  public Button outakeButton            = new JoystickButton(driver, 5);
  public Button intakeButton            = new JoystickButton(driver, 6); 

  public Button shifterUp               = new JoystickButton(driver, 7);
  public Button shifterDown             = new JoystickButton(driver, 8);
  
  // Operator Buttons
  public Button clawDropButton          = new JoystickButton(operator, 10);
  public Button clawUpButton            = new JoystickButton(operator, 9);

  public Button climberPullButton       = new JoystickButton(operator, 4);

  public Button linearActuatorButtonIn  = new JoystickButton(operator, 3);
  public Button linearActuatorButtonOut = new JoystickButton(operator, 2);

  // //Button Pannel Buttons
  // public Button hatchLevel1Button       = new JoystickButton(buttonPannel, 1);
  // public Button hatchLevel2Button       = new JoystickButton(buttonPannel, 2);
  // public Button hatchLevel3Button       = new JoystickButton(buttonPannel, 3);

  // public Button ballLevel1Button        = new JoystickButton(buttonPannel, 4);
  // public Button ballLevel2Button        = new JoystickButton(buttonPannel, 5);
  // public Button ballLevel3button        = new JoystickButton(buttonPannel, 6);

  // public Button ballPickUpButton        = new JoystickButton(buttonPannel, 7);

  // public Button climberButton           = new JoystickButton(buttonPannel, 8);

  public Button hatchLevel1Button       = new JoystickButton(testPannel, 1); //A
  public Button hatchLevel2Button       = new JoystickButton(testPannel, 2); //B
  public Button hatchLevel3Button       = new JoystickButton(testPannel, 3); //X

  public Button ballLevel1Button        = new JoystickButton(testPannel, 4); //Y
  public Button ballLevel2Button        = new JoystickButton(testPannel, 5); //LB
  public Button ballLevel3button        = new JoystickButton(testPannel, 6); //RB

  public Button ballPickUpButton        = new JoystickButton(testPannel, 10); //Press right Joystick

  public Button climberButton           = new JoystickButton(testPannel, 8);


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
    // Intake
    intakeButton.whileHeld(new cmdBallIntake(true, 1));
    intakeButton.whenReleased(new cmdBallIntakeStop());

    // Outake
    outakeButton.whileHeld(new cmdBallIntake(false, 1));
    outakeButton.whenReleased(new cmdBallIntakeStop());

    // Shifters
    shifterUp.whenPressed(new cmdShift(true));
    shifterDown.whenPressed(new cmdShift(false));

    // Climbing Arms
    clawDropButton.whenPressed(new cmdClawDrop(false));
    clawUpButton.whenPressed(new cmdClawDrop(true));
    climberPullButton.whileHeld(new cmdClimberPull());

    // 
    gripperToggleClose.whenPressed(new cmdGrabberOC(true));
    gripperToggleOpen.whenPressed(new cmdGrabberOC(false));
    // gripperToggle.whenPressed(new cmdGrabberOC());

    linearActuatorButtonIn.whileHeld(new cmdLinearActuator(false));
    linearActuatorButtonOut.whileHeld(new cmdLinearActuator(true));
    // encoderResetButton.whenReleased(new cmdEncoderReset());

    hatchLevel1Button.whenPressed(new cmdElevatorHeight(354));
    hatchLevel2Button.whenPressed(new cmdElevatorHeight(186));
    hatchLevel3Button.whenPressed(new cmdElevatorHeight(18));

    ballLevel1Button.whenPressed(new cmdElevatorHeight(405));
    ballLevel2Button.whenPressed(new cmdElevatorHeight(237));
    ballLevel3button.whenPressed(new cmdElevatorHeight(69));

    ballPickUpButton.whenPressed(new cmdElevatorHeight(0));

    //climberButton.whenPressed(new SomeOtherCmd());

  }


//   //Drive Controller Axis's
//   public double driverAxis0 = driver.getRawAxis(0);  // Left Thumb Stick  ~ X axis ~ +/- input
//   public double driverAxis1 = driver.getRawAxis(1);  // Left Thumb Stick  ~ Y axis ~ +/- input
//   public double driverAxis2 = driver.getRawAxis(2);  // Left Trigger               ~ only positive input
//   public double driverAxis3 = driver.getRawAxis(3);  // Right Trigger              ~ only positive input
//   public double driverAxis4 = driver.getRawAxis(4);  // Right Thumb Stick ~ X axis ~ +/- input
//   public double driverAxis5 = driver.getRawAxis(5);  // Right Thumb Stick ~ Y axis ~ +/- input
  
//  driverAxis0 = driver.getRawAxis(0);
//  driverAxis1 = driver.getRawAxis(1);

  //Operator Controller Axis's
  // public double operatorAxis0;  // Left Thumb Stick  ~ X axis ~ +/- input
  // public double operatorAxis1;  // Left Thumb Stick  ~ Y axis ~ +/- input
  // public double operatorAxis2;  // Left Trigger               ~ only positive input
  // public double operatorAxis3;  // Right Trigger              ~ only positive input
  // public double operatorAxis4;  // Right Thumb Stick ~ X axis ~ +/- input
  // public double operatorAxis5;  // Right Thumb Stick ~ Y axis ~ +/- input
}
