package com.mygdx.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;


/**
 * Created by Gt
 */
public class TreePart extends AbstractPart {

    private ShapeRenderer renderer = new ShapeRenderer();

    private static final Color COLOR_DARK_GREEN = new Color(0, 0.4f, 0, 1);

    public TreePart() {
//        setBounds(); TODO:

        MoveByAction mba = new MoveByAction();
        mba.setAmountY(Gdx.graphics.getHeight());
        mba.setDuration(SPEED_SLOW);
        mba.setReverse(true); // from top, to bot

        this.addAction(mba);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        drawArea(); // TODO: pass random x

        batch.begin();
    }

    @Override
    public void act(float delta) {
        super.act(delta);


    }

    /**
     * Draw the block @ x. y = max height (Need to end batch before this method and begin after).
     */
    private void drawArea() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(getX(), getY(),
                40f, 40f,
                COLOR_DARK_GREEN, Color.GREEN, Color.GREEN, COLOR_DARK_GREEN);
        renderer.end();
    }

}
