package com.amazon.macroexecutor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.HashMap;
import com.amazon.macroexecutor.macros.*;


public class MacroExecutor
{
  private Robot robot = new Robot();
  private static Map<String, ExecutableMacro> executableMacros = new HashMap<String, ExecutableMacro>();
  
  static
  {
	  executableMacros.put("1", new StartAddingTracksShortcutMacro());
	  executableMacros.put("2", new AddMonoTrackShortcutMacro());
	  executableMacros.put("3", new AddStereoTrackShortcutMacro());
	  executableMacros.put("4", new AddQuadTrackShortcutMacro());
	  executableMacros.put("5", new EnterKeyShortcutMacro());
	  executableMacros.put("6", new SaveShortcutMacro());
  }
 
  public static void main(String[] args) throws AWTException
  {
    new MacroExecutor();
    System.exit(0);
  }
   
  public MacroExecutor() throws AWTException
  {
	  
  }
  
  //TODO: In the near future, this will take in an object that will be retrieved
  //from a service and we wont have to configure the macros locally.
  //All the commands will come from the cloud and will be maintained there
  public void execute(String macro)
  {
	  ExecutableMacro executableMacro = executableMacros.get(macro);
	  try
	  {
		  //TODO: Replace this with log.debug
		  System.out.println("About to execute command " + executableMacro+ " for "+ macro);
		  if(executableMacro != null)
		  {
			  executableMacro.call();
		  }
	  } catch(Exception ex){}
  }
}
