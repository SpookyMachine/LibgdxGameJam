package com.mygdx.game.Entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.box2d.RunnerUserData;

/**
 * Created by mike on 12/9/15.
 */
public class Runner extends BaseActor {
    private boolean jumping;

    public Runner(Body body) {
        super(body);
    }

    @Override
    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }

    public void jump() {

        if (!jumping) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }

    }

    public void landed() {
        jumping = false;
    }
}
