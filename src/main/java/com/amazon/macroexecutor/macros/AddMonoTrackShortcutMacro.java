package com.amazon.macroexecutor.macros;

import java.awt.event.KeyEvent;

public class AddMonoTrackShortcutMacro extends ExecutableMacro
{
	private AddTrackShortcutMacro addTrackShortcutMacro = new AddTrackShortcutMacro();
	public AddMonoTrackShortcutMacro()
	{
		//By Default, it is at a new mono track
		super(100, null);
	}
	
	public Void call() throws Exception
	{
		//TODO: Replace this with log.debug
		System.out.println("Add mono track to session");
		addTrackShortcutMacro.call();
		super.call();
		System.out.println("Command excecuted");
		return null;
	}
}