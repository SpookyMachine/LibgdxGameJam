package com.mygdx.game.Entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.box2d.UserData;

/**
 * Created by mike on 12/9/15.
 */
public abstract class BaseActor extends Actor {

    protected Body body;
    protected UserData userData;

    public BaseActor(Body body) {
        this.body = body;
        this.userData = (UserData) body.getUserData();
    }

    public abstract UserData getUserData();
}
