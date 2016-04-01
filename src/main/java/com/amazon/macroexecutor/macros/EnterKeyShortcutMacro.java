package com.amazon.macroexecutor.macros;

import java.awt.event.KeyEvent;

public class EnterKeyShortcutMacro extends ExecutableMacro
{
	public EnterKeyShortcutMacro()
	{
		super(100, new int[][]{{KeyEvent.VK_ENTER}});
	}
	
	public Void call() throws Exception
	{
		//TODO: Replace this with log.debug
		System.out.println("Start press enter");
		super.call();
		System.out.println("Command excecuted");
		return null;
	}
}