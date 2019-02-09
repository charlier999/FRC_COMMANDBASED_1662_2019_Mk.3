/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Toggle 
{
   boolean toggle = false;
   boolean intInput;

   public Toggle(boolean init) 
  {
	toggle = init;
	}
	
  public boolean toggleVar(boolean input) 
  {
  if(input && !intInput) // If ith boolean input is true and and intInput is true, then run 
    {
		toggle = !toggle;	// reverses the boolean statement (e.g true -> false, false -> true)
		}

	intInput = input;	// sets the intInput to the current input 
	return toggle;
	}
	
	public boolean getToggle() 
	{
	return toggle;
	}
}
