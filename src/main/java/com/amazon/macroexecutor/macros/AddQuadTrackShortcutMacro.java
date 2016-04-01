package com.amazon.macroexecutor.macros;

import java.awt.event.KeyEvent;

public class AddQuadTrackShortcutMacro extends ExecutableMacro
{
	private AddTrackShortcutMacro addTrackShortcutMacro = new AddTrackShortcutMacro();
	public AddQuadTrackShortcutMacro()
	{
		super(100, new int[][]{
								{KeyEvent.VK_META, KeyEvent.VK_RIGHT},
								{KeyEvent.VK_META, KeyEvent.VK_RIGHT},
								{KeyEvent.VK_META, KeyEvent.VK_RIGHT},
								{KeyEvent.VK_META, KeyEvent.VK_RIGHT},
								{KeyEvent.VK_META, KeyEvent.VK_RIGHT}
							});
	}
	
	public Void call() throws Exception
	{
		//TODO: Replace this with log.debug
		System.out.println("Add quad track to session");
		addTrackShortcutMacro.call();
		super.call();
		System.out.println("Command excecuted");
		return null;
	}
}