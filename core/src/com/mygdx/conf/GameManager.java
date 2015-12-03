package com.mygdx.conf;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by mike on 12/3/15.
 */
public class GameManager implements Disposable {

    public static final float PPM = 16;
    public static final int WINDOW_WIDTH = Gdx.graphics.getWidth();
    public static final int WINDOW_HEIGHT = Gdx.graphics.getHeight();
    public static final float V_WIDTH = 20.0f;
    public static final float V_HEIGHT = 15.0f;
    public static final Vector2 GRAVITY = new Vector2(0.0f, -9.8f * 4);
    public static final float STEP = 1 / 60.0f;

    public static final String musicPath = "audio/music/";
    public static GameManager instance;
    public static float timeScale = 1;
    private AssetManager assetManager;


    public GameManager() {
        if (instance == null) {
            instance = this;
        }

        if (assetManager == null) {
            assetManager = new AssetManager();
        }

        loadAudio();

    }

    public static void setTimeScale(float value) {
        timeScale = MathUtils.clamp(value, 0.0f, 2.0f);
    }

    private void loadAudio() {
        assetManager.load("audio/music/mario_music.ogg", Music.class);
        assetManager.load("audio/music/mario_music_hurry.ogg", Music.class);
        assetManager.load("audio/music/out_of_time.ogg", Music.class);
        assetManager.load("audio/music/game_over.ogg", Music.class);
        assetManager.load("audio/music/invincible.ogg", Music.class);
        assetManager.load("audio/music/stage_clear.ogg", Music.class);
        assetManager.load("audio/music/flagpole.ogg", Music.class);
        assetManager.load("audio/sfx/breakblock.wav", Sound.class);
        assetManager.load("audio/sfx/bump.wav", Sound.class);
        assetManager.load("audio/sfx/coin.wav", Sound.class);
        assetManager.load("audio/sfx/jump_small.wav", Sound.class);
        assetManager.load("audio/sfx/jump_super.wav", Sound.class);
        assetManager.load("audio/sfx/mariodie.wav", Sound.class);
        assetManager.load("audio/sfx/powerdown.wav", Sound.class);
        assetManager.load("audio/sfx/powerup.wav", Sound.class);
        assetManager.load("audio/sfx/powerup_spawn.wav", Sound.class);
        assetManager.load("audio/sfx/stomp.wav", Sound.class);
        assetManager.load("audio/sfx/fireball.ogg", Sound.class);
        assetManager.load("audio/sfx/kick.ogg", Sound.class);
        assetManager.finishLoading();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
