/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;

// Button intakeButton = new Button(OI.intakeButton) 

// Button ballLevel1Button = new Button(OI.intakeButton);
// Button ballLevel2Button = new Button(OI.intakeButton);
// Button ballLevel3Button = new Button(OI.intakeButton);
// Button ballPickUpButton = new Button(OI.intakeButton);

// Button ballLevel1Button.set(700);
// Button ballLevel2Button.set();
// Button ballLevel3Button.set();
// Button ballPickUpButton.set();

public class Elevator extends Subsystem {

public Joystick operator     = new Joystick(1);

double elevatorAxis = operator.getRawAxis(1); //Left Thumb Stick ~ Y axis ~+/- input

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
