package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

/**
 * Created by mike on 1/20/16.
 */
public class Flappe {
    private static final float COLLISION_RADIUS = 24f;
    private final Circle collisionCircle;

    private static final float DIVE_ACCEL = 0.30F;
    private static final float FLY_ACCEL = 5f;
    private float ySpeed = 0;

    private float x = 0;
    private float y = 0;

    public Flappe() {
        collisionCircle = new Circle(x, y, COLLISION_RADIUS);
    }

    public void update() {
        ySpeed -= DIVE_ACCEL;
        setPosition(x, y + ySpeed);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;

        updateCollisionCircle();
    }

    private void updateCollisionCircle() {
        collisionCircle.setX(x);
        collisionCircle.setY(y);
    }

    public void flyUp(){
        ySpeed = FLY_ACCEL;
        setPosition(x, y + ySpeed);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(collisionCircle.x, collisionCircle.y, collisionCircle.radius);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
