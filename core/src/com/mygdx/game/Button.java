package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Button {
    public static ImageButton getButton(String type){
        if (type.equals("playB")){
            return new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("elements/playB.png"))));
        }
        else if (type.equals("exitB")){
            return new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("elements/exitB.png"))));
        }
        else if(type.equals("retrieveB")){
            return new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("elements/retrieveB.png"))));
        }
        else
        {
            return null;

        }
    }
}
