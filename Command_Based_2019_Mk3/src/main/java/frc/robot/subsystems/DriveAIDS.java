/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

/**
 * This subsystem is for programming of driver aids to help the driver 
 * drive the robot with minimal mistakes
 */

public class DriveAIDS extends Subsystem 
{
  
  public AnalogInput opticalSensorTop     = new AnalogInput(0);
  public AnalogInput opticalSensorLeft    = new AnalogInput(1);
  public AnalogInput opticalSensorRight   = new AnalogInput(2);
  public AnalogInput opticalSensorMiddle  = new AnalogInput(7);
  public AnalogInput opticalSensorBottom  = new AnalogInput(3);

  Solenoid ledLight = new Solenoid(0, 1);

  Timer timer = new Timer();

  boolean ledStatis;

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
//-------------------------------------------------------//
//                     Timmer Wait                       //
//-------------------------------------------------------// 

boolean TimerWait(double time) 
{
  boolean timerFinished = false;
  if(timerFinished == false)
  {
    timer.reset();
    timer.start();
    if(timer.get() >= time)
    {
      timerFinished = true;
      return false;
    } else {
      return false;
    }
  } else {
    return true;
  }
}

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
//-------------------------------------------------------//
//        Get Value from the aray of light sensors       //
//-------------------------------------------------------//
  double GetOpticalSensorTopValue()
  {
    double Value = opticalSensorTop.getValue();
    return Value;
  }

  double GetOpticalSensorLeftValue()
  {
    double Value = opticalSensorLeft.getValue();
    return Value;
  }

  double GetOpticalSensorMiddleValue()
  {
    double Value = opticalSensorMiddle.getValue();
    return Value;
  }

  double GetOpticalSensorRightValue()
  {
    double Value = opticalSensorRight.getValue();
    return Value;
  }

  double GetOpticalSensorBottomValue()
  {
    double Value = opticalSensorBottom.getValue();
    return Value;
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
//-------------------------------------------------------//
// Converts the Value from the sensor to a boolean Value //
//-------------------------------------------------------//

  public boolean TopOpticalSensorDetected()
  {
    if( GetOpticalSensorTopValue() <= 370 )
    {
      return true;
    }
    else if( GetOpticalSensorTopValue() >= 520 )
    {
      return false;
    }
    return false;
  }

  public boolean LeftOpticalSensorDetected()
  {
    if( GetOpticalSensorLeftValue() <= 370 )
    {
      return true;
    }
    else if( GetOpticalSensorLeftValue() >= 520 )
    {
      return false;
    }
    return false;
  }

  public boolean MiddleOpticalSensorDetected()
  {
    if( GetOpticalSensorMiddleValue() <= 250 )
    {
      return true;
    }
    else if( GetOpticalSensorMiddleValue() >= 520 )
    {
      return false;
    }
    return false;
  }

  public boolean RightOpticalSensorDetected()
  {
    if( GetOpticalSensorRightValue() <= 370 )
    {
      return true;
    }
    else if( GetOpticalSensorRightValue() >= 520 )
    {
      return false;
    }
    return false;
  }

  public boolean BottomOpticalSensorDetected()
  {
    if( GetOpticalSensorBottomValue() <= 370 )
    {
      return true;
    }
    else if( GetOpticalSensorBottomValue() >= 520 )
    {
      return false;
    }
    return false;
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
//-------------------------------------------------------//
// Determans if the robot is lined up with the tape line //
//   gives what rotation direction is needed to line up  //
//                         corectly                      //
//-------------------------------------------------------//

  boolean OpticalArayConterClockwise()
  {
    if( TopOpticalSensorDetected() && LeftOpticalSensorDetected() )
    {
      return true;
    }
    else if( BottomOpticalSensorDetected() && RightOpticalSensorDetected() )
    {
      return true;
    }
    return false;
  }

  boolean OpticalArayClockwise()
  {
    if( LeftOpticalSensorDetected() && BottomOpticalSensorDetected() )
    {
      return true;
    }
    else if( TopOpticalSensorDetected() && RightOpticalSensorDetected() )
    {
      return true;
    }
    return false;
  }

  boolean OpticalArayStrait()
  {
    // if( TopOpticalSensorDetected() && MiddleOpticalSensorDetected() && BottomOpticalSensorDetected() )
    // {
    //   return true;
    // }
    if( TopOpticalSensorDetected() && BottomOpticalSensorDetected() )
    {
      return true;
    }
    return false;
  }

  boolean OpticalArayDetectsAnything()
  {
    if( 
      TopOpticalSensorDetected()    ||
      LeftOpticalSensorDetected()   ||
      RightOpticalSensorDetected()  ||
      BottomOpticalSensorDetected() 
      )
      {
        return false;
      }else{
        return true;
      }
  }



// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
//-------------------------------------------------------//
//             Set the LED light on or off               //
//-------------------------------------------------------//

void LEDlightOn()
{
  ledLight.set(true);
  ledStatis = true;
}

void LEDlightOff()
{
  ledLight.set(false);
  ledStatis = false;
}

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
//-------------------------------------------------------//
//        Set the blick rate LED light on or off         //
//-------------------------------------------------------//

  void SolidLED()
  {
    LEDlightOn();
  }

  void LEDBlink( double rate)
  {
    if( ledStatis )
    {
      LEDlightOff();
      if( TimerWait(rate) )
      {
        LEDlightOn();
      }
    }
  }

// -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=- -=-
//-------------------------------------------------------//
//                    Aligment Command                   //
//-------------------------------------------------------//

  public void IsRobotAligned()
  {
    if( OpticalArayClockwise() )
    {
      LEDBlink(5);
    }
    else if( OpticalArayConterClockwise() )
    {
      LEDBlink(1);
    }
    else if( OpticalArayDetectsAnything() )
    {
      LEDlightOff();
    }
    else if( OpticalArayStrait() )
    {
      SolidLED();
    }
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
