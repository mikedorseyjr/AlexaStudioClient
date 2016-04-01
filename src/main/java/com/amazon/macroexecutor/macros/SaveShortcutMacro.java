package com.amazon.macroexecutor.macros;

import java.awt.event.KeyEvent;

public class SaveShortcutMacro extends ExecutableMacro
{
	public SaveShortcutMacro()
	{
		super(100, new int[][]{{KeyEvent.VK_META, KeyEvent.VK_S}});
	}
	
	public Void call() throws Exception
	{
		//TODO: Replace this with log.debug
		System.out.println("Start save session");
		super.call();
		System.out.println("Command excecuted");
		return null;
	}
}