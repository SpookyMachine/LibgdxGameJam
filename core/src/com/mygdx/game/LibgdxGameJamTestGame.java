package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.conf.GameManager;
import com.mygdx.screens.InventoryScreen;
import com.mygdx.screens.PlayScreen;

public class LibgdxGameJamTestGame extends Game {
    public SpriteBatch batch;

    private GameManager gameManager;

    @Override
    public void create() {
        batch = new SpriteBatch();

        if (GameManager.instance != null) {
            gameManager = GameManager.instance;
        } else {
            gameManager = new GameManager();
        }

        setScreen(new InventoryScreen());
    }

    @Override
    public void render() {
        super.render();
    }


    @Override
    public void dispose() {
        super.dispose();
        gameManager.dispose();
    }
}
