package com.mygdx.game.actor.part;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.mygdx.game.Utils.Constants;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by Gt
 */
public class TreePart extends AbstractPart {

    private ShapeRenderer renderer = new ShapeRenderer();

    // additional color of tree part
    private static final Color COLOR_DARK_GREEN = new Color(0, 0.4f, 0, 1);

    private float time;

    private MoveByAction mba;

    public TreePart() {
        setName("TreePart");
        setSize(40f, 40f);
        setBounds(getX(), getY(), getWidth(), getHeight());

        createMovement();

        this.addAction(mba);
    }

    /**
     * Creates part with initial x position.
     * @param initialX x position
     */
    public TreePart(float initialX) {
        this();
        setX(initialX);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        drawArea();

        batch.begin();
    }

    @Override
    public void act(float delta) {
        time += delta;
        if (time > Constants.TREE_PART_APPEAR_TIME) {
            setX(ThreadLocalRandom.current().nextInt(0, (int) (Gdx.graphics.getWidth() - getWidth())));
            createMovement();
            this.addAction(mba);
            time = 0;
        }
        super.act(delta);
    }

    /**
     * Draw the part (Need to end batch before this method and begin after).
     */
    private void drawArea() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(getX(), getY(),
                getWidth(), getHeight(),
                COLOR_DARK_GREEN, Color.GREEN, Color.GREEN, COLOR_DARK_GREEN);
        renderer.end();
    }

    private void createMovement() {
        mba = new MoveByAction();
        // set movement from top to bottom
        mba.setAmountY(Gdx.graphics.getHeight() + getHeight());
        mba.setDuration(SPEED_FAST);
        mba.setReverse(true); // from top, to bot
    }
}
