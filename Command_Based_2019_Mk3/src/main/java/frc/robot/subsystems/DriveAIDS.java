/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * This subsystem is for programming of driver aids to help the driver 
 * drive the robot with minimal mistakes
 */

//UltrasonicSensor ultrasonicSensor;

public class DriveAIDS extends Subsystem 
{
  
  public AnalogInput opticalSensor = new AnalogInput(0);
  Solenoid ledLight = new Solenoid(1);
  
// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-

  /**
   * Gets the voltage from the Optical Sensor of the robot
   * Returns it as a double
   */
  double GetOpticalSensorVoltage()
  {
    double volts = opticalSensor.getVoltage();
    return volts;
  }

  int GetOpticalSensorValue()
  {
    int value = opticalSensor.getValue();
    return value;
  }

  void LEDlightOn()
  {
    ledLight.set(true);
  }
  
  void LEDlightOff()
  {
    ledLight.set(false);
  }
// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- 

  public void OpticalSensorLineDetected()
  {
    if( GetOpticalSensorVoltage() <= 0.45)
    {
      LEDlightOn();
    }
    else if( GetOpticalSensorVoltage() >= 0.5 )
    {
      LEDlightOff();
    }
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
