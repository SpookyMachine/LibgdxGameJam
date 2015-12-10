package com.mygdx.game.Entities;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.box2d.RunnerUserData;

/**
 * Created by mike on 12/9/15.
 */
public class Runner extends BaseActor implements InputProcessor {
    private boolean jumping;
    private boolean dodging;

    public Runner(Body body) {
        super(body);
        addListener(new InputListener()
        {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch (keycode)
                {


                    case Input.Keys.LEFT:
                        System.out.println("LEFT");
                        break;
                    case Input.Keys.RIGHT:
                        System.out.println("RIGHT");
                        break;
                }
                return true;
            }

            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button)
            {
                System.out.println("down");
                return true;
            }

            public void touchUp(InputEvent event, float x, float y,
                                int pointer, int button)
            {
                System.out.println("up");
            }
        });
    }

    @Override
    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }


    public void jump() {

            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);

    }

    public void landed() {
        jumping = false;
    }

    public void dodge() {
        if (!jumping) {
            body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public void stopDodge() {
        dodging = false;
        body.setTransform(getUserData().getRunningPosition(), 0f);
    }

    public boolean isDodging() {
        return dodging;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                System.out.println("LEFT");
                break;
            case Input.Keys.RIGHT:
                System.out.println("RIGHT");
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
