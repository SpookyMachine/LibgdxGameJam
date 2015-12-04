package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.conf.GameManager;
import com.mygdx.conf.WorldContactListener;
import com.mygdx.conf.WorldCreator;
import com.mygdx.enums.TiledMapLayer;
import com.mygdx.game.LibgdxGameJamTestGame;


/**
 * Created by mike on 12/3/15.
 */
public class PlayScreen implements Screen {
    public World world;
    private LibgdxGameJamTestGame game;
    private float accumulator;

    private OrthographicCamera camera;
    private Viewport viewport;

    private float cameraLeftLimit;
    private float cameraRightLimit;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer mapRenderer;

    private float mapWidth;

    private TextureAtlas textureAtlas;

    private Box2DDebugRenderer box2DDebugRenderer;
    private boolean renderB2DDebug;


    public PlayScreen(LibgdxGameJamTestGame game) {
        this.game = game;
    }

    @Override
    public void show() {

        camera = new OrthographicCamera();

        viewport = new ExtendViewport(GameManager.V_WIDTH, GameManager.V_HEIGHT);
        viewport.setCamera(camera);

        camera.position.set(GameManager.V_WIDTH / 2, GameManager.V_HEIGHT / 2, 0);

        textureAtlas = new TextureAtlas("imgs/actors.atlas");

        // create Box2D world
        world = new World(GameManager.GRAVITY, true);
        world.setContactListener(new WorldContactListener());

        // load tmx tiled map
        TmxMapLoader tmxMapLoader = new TmxMapLoader();
        tiledMap = tmxMapLoader.load("maps/level1.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1 / GameManager.PPM);

        mapWidth = ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
//        mapHeight = ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight(); // currently not used

        // create world from TmxTiledMap
//        WorldCreator worldCreator = new WorldCreator(this, tiledMap);

        WorldCreator creator = new WorldCreator();
        creator.generateLayer(world, tiledMap, TiledMapLayer.BRICKS, "");

        box2DDebugRenderer = new Box2DDebugRenderer();
        renderB2DDebug = false;


    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public float getMapWidth() {
        return mapWidth;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }


    public void handleInput() {

        // Press B to toggle Box2DDebuggerRenderer
        if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
            renderB2DDebug = !renderB2DDebug;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT_BRACKET)) {
            float timeScale = GameManager.timeScale;
            GameManager.setTimeScale(timeScale - 0.2f);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT_BRACKET)) {
            float timeScale = GameManager.timeScale;
            GameManager.setTimeScale(timeScale + 0.2f);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.EQUALS)) {
            GameManager.setTimeScale(1.0f);
        }
    }

    public void update(float delta) {
        delta *= GameManager.timeScale;
        float step = GameManager.STEP * GameManager.timeScale;

        handleInput();

        // Box2D world step
        accumulator += delta;
        if (accumulator > step) {
            world.step(step, 8, 3);
            accumulator -= step;
        }


        // camera control
        float targetX = camera.position.x;


        camera.position.x = MathUtils.lerp(camera.position.x, targetX, 0.1f);
        if (Math.abs(camera.position.x - targetX) < 0.1f) {
            camera.position.x = targetX;
        }
        camera.update();

        // update map renderer
        mapRenderer.setView(camera);

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw map
        mapRenderer.render(new int[]{0, 1});

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();


        game.batch.end();


        if (renderB2DDebug) {
            box2DDebugRenderer.render(world, camera.combined);
        }

        update(delta);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
        tiledMap.dispose();
        world.dispose();
        textureAtlas.dispose();
        box2DDebugRenderer.dispose();
    }
}
