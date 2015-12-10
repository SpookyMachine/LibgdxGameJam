package com.mygdx.game.utils;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by mike on 12/10/15.
 */
public class InputListenerForStage extends InputListener {

    @Override
    public boolean keyUp(InputEvent event, int keycode) {
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
    public boolean keyDown(InputEvent event, int keycode) {
        return super.keyDown(event, keycode);
    }
}
