package com.mygdx.game;

import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;

public class mapParser {
    public static void parser(World world, MapObjects obj){
        for (MapObject object:obj){
            Shape shape;
            if (object instanceof PolygonMapObject){
                shape = makePolyline((PolygonMapObject) object);
            }
            else {
                continue;
            }
            Body body;
            BodyDef bdef = new BodyDef();
            bdef.type = BodyDef.BodyType.StaticBody;
            body = world.createBody(bdef);
            body.createFixture(shape,1.0f);
            shape.dispose();
        }
    }

    private static ChainShape makePolyline(PolygonMapObject object){
        float[] vertices = object.getPolygon().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length/2];
        for (int i = 0 ; i < worldVertices.length ; i++){
            worldVertices[i] = new Vector2(vertices[i*2]/BattleArena.ppm,vertices[i*2+1]/BattleArena.ppm);
        }
        ChainShape cs = new ChainShape();
        cs.createChain(worldVertices);
        return cs;
    }
}
