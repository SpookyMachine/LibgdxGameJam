package com.mygdx.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.actor.part.TreePart;

/**
 * Created by Gt
 */
public class Tree extends Actor {

    private ShapeRenderer renderer = new ShapeRenderer();

    private static int partsNumber;

    // additional color of tree part
    public static final Color COLOR_DARK_GREEN = new Color(0, 0.4f, 0, 1);

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        drawArea();

        batch.begin();
    }

    /**
     * Draw stem by number of parts (Need to end batch before this method and begin after).
     */
    private void drawArea() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(getStage().getWidth() / 2, 0,
                TreePart.TREE_PART_WIDTH, partsNumber * TreePart.TREE_PART_HEIGHT,
                COLOR_DARK_GREEN, Color.GREEN, Color.GREEN, COLOR_DARK_GREEN);
        renderer.end();
    }

    public static void addPart() {
        partsNumber++;
        Gdx.app.log("--TREE--", "parts=" + partsNumber);
    }

    public static void removePart() {
        partsNumber--;
    }
}
