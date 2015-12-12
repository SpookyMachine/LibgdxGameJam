package com.mygdx.game.actor.part;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Utils.Constants;
import com.mygdx.game.actor.Tree;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Gt
 */
public class TreePart extends AbstractPart {

    private ShapeRenderer renderer = new ShapeRenderer();

    private float time;

    private MoveByAction mba = new MoveByAction();

    public TreePart() {
        setName("TreePart");
        setSize(20f, 20f); // TODO: iskelti is cia ir Tree

        setBounds(getX(), getY(), getWidth(), getHeight());

        createMovement();

        addMouseClickEvent();
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
            resetPart();
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
                Tree.COLOR_DARK_GREEN, Color.GREEN, Color.GREEN, Tree.COLOR_DARK_GREEN);
        renderer.end();
    }

    private void createMovement() {
        // set movement from top to bottom
        mba.setAmountY(Gdx.graphics.getHeight() + getHeight());
        mba.setDuration(SPEED_FAST);
        mba.setReverse(true); // from top, to bot
        this.addAction(mba);
    }

    private void addMouseClickEvent() {
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("--MOUSE--", "clicked: x=" + x + ", y=" + y);
                Tree.addPart();
            }

        });
    }

    private void resetPart() {
        setX(ThreadLocalRandom.current().nextInt(0, (int) (Gdx.graphics.getWidth() - getWidth())));
        mba.reset();
        createMovement();
        time = 0;
    }

}
