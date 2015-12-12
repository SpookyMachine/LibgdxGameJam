package com.mygdx.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Gt
 */
public class TreePart extends Actor {

    private ShapeRenderer renderer = new ShapeRenderer();

    private static final Color COLOR_DARK_GREEN = new Color(0, 0.4f, 0, 1);

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        drawArea(0); // TODO: pass random

        batch.begin();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    /**
     * Draw the block @ x. y = max height (Need to end batch before this method and begin after).
     */
    private void drawArea(float x) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(x, 0,
                40f, 40f,
                COLOR_DARK_GREEN, Color.GREEN, Color.GREEN, COLOR_DARK_GREEN);
        renderer.end();
    }

}
