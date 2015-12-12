package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.mygdx.game.Screens.PlayScreen;

public class LibgdxGameJamTestGame extends Game {

	@Override
	public void create () {

       setScreen(new PlayScreen());
	}

	@Override
	public void render () {
       super.render();
	}

}
