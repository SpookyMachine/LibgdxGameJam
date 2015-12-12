package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
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

    //Box2D Stuff
    private World world;
    private Box2DDebugRenderer b2dr;

    @Override
    public void show() {

        // Init cammera stuff
        camera = new OrthographicCamera();
        cameraViewPort = new FitViewport(V_WIDTH / Constants.PPM, V_HEIGHT / Constants.PPM, camera);


        // Init box2d Stuff
        world = new World(new Vector2(0,-10f), true);
        b2dr = new Box2DDebugRenderer();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Box2D debug
        b2dr.render(world, camera.combined);


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
