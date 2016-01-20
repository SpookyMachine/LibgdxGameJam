package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.LibgdxGameJamTestGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Flaaabeeee bird!";
        config.height = 320;
        config.width = 240;
		new LwjglApplication(new LibgdxGameJamTestGame(), config);
	}
}
