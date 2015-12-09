package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.actor.Scoreboard;

public class LibgdxGameJamTestGame extends ApplicationAdapter {

    private Stage stage;



	@Override
	public void create () {
        stage = new Stage(new ScreenViewport());

        initializeActors();

        Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.act(Gdx.graphics.getDeltaTime()); // before draw - update every actor


        stage.draw();
	}

    /**
     * Initialize and add all stage actors.
     */
    private void initializeActors() {
        initScoreboard();
    }

    /**
     * Initialize scoreboard actor.
     */
    private void initScoreboard() {
        Scoreboard scoreboard = new Scoreboard();

        stage.addActor(scoreboard);
        stage.setKeyboardFocus(scoreboard);
    }
}
