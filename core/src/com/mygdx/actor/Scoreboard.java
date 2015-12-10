package com.mygdx.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * A basic 1 player scoreboard.
 */
public class Scoreboard extends Actor {

    private ShapeRenderer renderer = new ShapeRenderer();

    private BitmapFont font;

    private int score;

    public Scoreboard() {
        font = createFont(14);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        drawArea();

        batch.begin();

        drawScore(batch);
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

    /**
     * Draw score numbers.
     * @param batch batch
     */
    private void drawScore(Batch batch) {
        font.draw(batch, String.valueOf(score), 5, Gdx.graphics.getHeight() - 20);
    }

    private BitmapFont createFont(int size) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/OpenSans-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
