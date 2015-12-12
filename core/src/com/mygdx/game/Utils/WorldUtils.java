package com.mygdx.game.Utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by mike on 12/12/15.
 */
public class WorldUtils {

    public World world;

    public World createWorld() {
        world = new World(new Vector2(0, -9.87f), true);
        return world;
    }

//    public Body createGround(World world) {
//        BodyDef bodyDef = new BodyDef();
//        bodyDef.position.set(new Vector2(Constants.GROUND_X, Constants.GROUND_Y));
//        Body body = world.createBody(bodyDef);
//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(Constants.GROUND_WIDTH / 2, Constants.GROUND_HEIGHT / 2);
//        body.createFixture(shape, Constants.GROUND_DENSITY);
//        shape.dispose();
//        return body;
//    }
//
//    public Body createRunner(World world) {
//        BodyDef bodyDef = new BodyDef();
//        bodyDef.type = BodyDef.BodyType.DynamicBody;
//        bodyDef.position.set(new Vector2(Constants.RUNNER_X, Constants.RUNNER_Y));
//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(Constants.RUNNER_WIDTH / 2, Constants.RUNNER_HEIGHT / 2);
//        Body body = world.createBody(bodyDef);
//        body.setGravityScale(Constants.RUNNER_GRAVITY_SCALE);
//        body.createFixture(shape, Constants.RUNNER_DENSITY);
//        body.resetMassData();
//        shape.dispose();
//        return body;
//    }
}
