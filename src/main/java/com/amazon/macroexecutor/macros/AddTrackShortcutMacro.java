package com.amazon.macroexecutor.macros;

import java.awt.event.KeyEvent;

public class AddTrackShortcutMacro extends ExecutableMacro
{
	public AddTrackShortcutMacro()
	{
		super(100, new int[][]{{KeyEvent.VK_META, 107}});
	}
	
	public Void call() throws Exception
	{
		//TODO: Replace this with log.debug
		System.out.println("Add track to session");
		super.call();
		System.out.println("Command excecuted");
		return null;
	}
}