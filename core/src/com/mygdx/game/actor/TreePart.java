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
//        renderer.rect(x, (float) Gdx.graphics.getHeight(),
//                40f, 40f,
//                Color.BLUE, Color.BLUE, Color.BLUE);
        renderer.end();
    }

}
