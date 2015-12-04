package com.mygdx.conf;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.entities.Brick;
import com.mygdx.enums.TiledMapLayer;

/**
 * Created by mike on 12/3/15.
 */
public class WorldCreator {

    //Box2D Stuff
    private Body body;
    private BodyDef bdef = new BodyDef();
    private FixtureDef fdef = new FixtureDef();

    //Retrieving polygon shape from map object
    private static PolygonShape getRectangle(RectangleMapObject rectangleObject) {
        Rectangle rectangle = rectangleObject.getRectangle();
        PolygonShape polygon = new PolygonShape();
        Vector2 size = new Vector2((rectangle.x + rectangle.width * 0.5f) / GameManager.PPM,
                (rectangle.y + rectangle.height * 0.5f) / GameManager.PPM);
        polygon.setAsBox(rectangle.width * 0.5f / GameManager.PPM, rectangle.height * 0.5f / GameManager.PPM, size, 0.0f);
        return polygon;
    }

    private static CircleShape getCircle(CircleMapObject circleObject) {
        Circle circle = circleObject.getCircle();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(circle.radius / GameManager.PPM);
        circleShape.setPosition(new Vector2(circle.x / GameManager.PPM, circle.y / GameManager.PPM));
        return circleShape;
    }

    private static PolygonShape getPolygon(PolygonMapObject polygonObject) {
        PolygonShape polygon = new PolygonShape();
        float[] vertices = polygonObject.getPolygon().getTransformedVertices();

        float[] worldVertices = new float[vertices.length];

        for (int i = 0; i < vertices.length; ++i) {
            System.out.println(vertices[i]);
            worldVertices[i] = vertices[i] / GameManager.PPM;
        }

        polygon.set(worldVertices);
        return polygon;
    }

    private static ChainShape getPolyline(PolylineMapObject polylineObject) {
        float[] vertices = polylineObject.getPolyline().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i = 0; i < vertices.length / 2; ++i) {
            worldVertices[i] = new Vector2();
            worldVertices[i].x = vertices[i * 2] / GameManager.PPM;
            worldVertices[i].y = vertices[i * 2 + 1] / GameManager.PPM;
        }

        ChainShape chain = new ChainShape();
        chain.createChain(worldVertices);
        return chain;
    }

    /**
     * Adds box2d objects to world from @layerName and adds userData to all objects from layer
     *
     * @param world
     * @param map
     * @param layerName
     * @param userData
     */
    public void generateLayer(World world, TiledMap map, TiledMapLayer layerName, String userData) {

        for (MapObject object : map.getLayers().get(layerName.toString()).getObjects()) {
            if (object instanceof RectangleMapObject) {
                Shape shape;
                shape = getRectangle((RectangleMapObject) object);

                //Looks into object properties map for body type and sets it
                // Dynamic or static for now
                if(object.getProperties().containsKey("bodyType")){
                    /*switch (object.getProperties().get("bodyType", String.class)){
                        case "dynamic":
                            bdef.type = BodyDef.BodyType.StaticBody;
                            break;
                        //default and static is static woot
                        case "static":
                        default:
                            bdef.type = BodyDef.BodyType.StaticBody;
                            break;
                    }*/
                    //dno it seems i just cant run it in java 7
                    // and for random fact we cant use java 8 it will brake android ios and html projects

                    if(object.getProperties().get("bodyType", String.class).equals("dynamic")){
                        bdef.type = BodyDef.BodyType.DynamicBody;
                    }
                    if(object.getProperties().get("bodyType", String.class).equals("static")){
                        bdef.type = BodyDef.BodyType.StaticBody;
                    }
                }

                fdef.friction = 0;
                fdef.isSensor = false;

                world.createBody(bdef).createFixture(shape, 1).setUserData(userData);
                // TODO refactor dis stuff
                switch (layerName) {
                    case BRICKS:
                        new Brick(object.getProperties());

                }
            }

            // Not really necessary all these these added them only for testing purposes
            if (object instanceof PolygonMapObject) {
                Shape shape;
                shape = getPolygon((PolygonMapObject) object);
                bdef.type = BodyDef.BodyType.StaticBody;

                fdef.friction = 0;
                fdef.isSensor = false;

                world.createBody(bdef).createFixture(shape, 1).setUserData(userData);
            }
            if (object instanceof PolylineMapObject) {
                Shape shape;
                shape = getPolyline((PolylineMapObject) object);
                bdef.type = BodyDef.BodyType.StaticBody;

                fdef.friction = 0;
                fdef.isSensor = false;

                world.createBody(bdef).createFixture(shape, 1).setUserData(userData);
            }
            if (object instanceof CircleMapObject) {
                Shape shape;
                shape = getCircle((CircleMapObject) object);
                bdef.type = BodyDef.BodyType.StaticBody;

                fdef.friction = 0;
                fdef.isSensor = false;

                world.createBody(bdef).createFixture(shape, 1).setUserData(userData);
            } else {
                continue;
            }

        }
    }
}
