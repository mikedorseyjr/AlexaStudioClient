package com.amazon.macroexecutor.macros;

import java.awt.Robot;
import java.util.concurrent.Callable;

public class ExecutableMacro implements Callable<Void>
{
	private static Robot robot;

	static
	{
		try
		{
			robot = new Robot();
		} 
		catch(Exception ex)
		{
			//TODO: Add log.error
			//TODO
			System.exit(0);
		}
	}
	
	private final int[][] arrayOfEvents;
	private final int delay;
	
	public ExecutableMacro(int delay, int[][] arrayOfEvents)
	{
		this.arrayOfEvents = arrayOfEvents;
		this.delay = delay;
	}
	
	public Void call() throws Exception
	{
		try
		{
			executeEvents();
		} 
		catch (Exception ex)
		{
			//TODO: Replace with log.error
			ex.printStackTrace();
		}
		
		return null;
	}
	
	private void executeEvents()
	{
		if(arrayOfEvents != null){
			robot.delay(this.delay);
			for(int[] events : arrayOfEvents)
			{
				for(int i = 0; i < events.length ; i++)
				{
				   robot.keyPress(events[i]);
				}
				for(int i = events.length -1; i >= 0 ; i--)
				{
					robot.keyRelease(events[i]);
				}
			}
		}
	}
}
