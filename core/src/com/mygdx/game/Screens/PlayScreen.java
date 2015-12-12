package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Utils.Constants;

/**
 * Created by mike on 12/12/15.
 */
public class PlayScreen implements Screen {

    //Cameras Stuff
    private OrthographicCamera camera;
    private Viewport cameraViewPort;
    private float V_WIDTH = Gdx.graphics.getWidth();
    private float V_HEIGHT = Gdx.graphics.getHeight();

    @Override
    public void show() {

        camera = new OrthographicCamera();
        cameraViewPort = new FitViewport(V_WIDTH / Constants.PPM, V_HEIGHT / Constants.PPM, camera);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
