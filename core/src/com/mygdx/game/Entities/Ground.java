package com.mygdx.game.Entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.box2d.GroundUserData;

/**
 * Created by mike on 12/9/15.
 */
public class Ground extends BaseActor {
    public Ground(Body body) {
        super(body);
    }

    @Override
    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }
}
