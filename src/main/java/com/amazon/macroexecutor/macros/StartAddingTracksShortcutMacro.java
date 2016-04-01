package com.amazon.macroexecutor.macros;

import java.awt.event.KeyEvent;

public class StartAddingTracksShortcutMacro extends ExecutableMacro
{
	public StartAddingTracksShortcutMacro()
	{
		super(100, new int[][]{{KeyEvent.VK_META, KeyEvent.VK_SHIFT, KeyEvent.VK_N}});
	}
	
	public Void call() throws Exception
	{
		//TODO: Replace this with log.debug
		System.out.println("Start adding tracks");
		super.call();
		System.out.println("Command excecuted");
		return null;
	}
}