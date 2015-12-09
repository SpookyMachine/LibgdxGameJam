package com.mygdx.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * A basic 1 player scoreboard.
 */
public class Scoreboard extends Actor {

    private ShapeRenderer renderer = new ShapeRenderer();

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        drawArea();

        batch.begin();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    /**
     * Draws the scoreboard area. (Need to end batch before this method and begin after).
     */
    private void drawArea() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.triangle(0f, Gdx.graphics.getHeight(),
                0f, Gdx.graphics.getHeight() - 0.15f * Gdx.graphics.getHeight(),
                Gdx.graphics.getWidth() * 0.2f, Gdx.graphics.getHeight(),
                Color.BLUE, Color.BLUE, Color.BLUE);
        renderer.end();
    }
}
