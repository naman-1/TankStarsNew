package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.io.Serializable;

public class Tank implements Serializable {
    private Sprite tankSprite;

    public Sprite getTankSprite() {
        return tankSprite;
    }

    public void setTankSprite(Sprite tankSprite) {
        this.tankSprite = tankSprite;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Vector3 getPosnArr() {
        return posnArr;
    }

    public void setPosnArr(Vector3 posnArr) {
        this.posnArr = posnArr;
    }

    private SpriteBatch batch;
    private float HP;
    private int tankPower, tankAngle;

    public int getTankPower() {
        return tankPower;
    }

    public void setTankPower(int tankPower) {
        if (tankPower > 100) {
            this.tankPower = 100;
        } else if (tankPower < 0) {
            this.tankPower = 0;
        } else {
            this.tankPower = tankPower;
        }
    }

    public int getTankAngle() {
        return tankAngle;
    }

    public void setHealth(float HP) {
        if (HP > 100) {
            this.HP = 100;
        } else if (HP < 0) {
            this.HP = 0;
        } else {
            this.HP = HP;
        }
    }

    public void setTankAngle(int tankAngle) {
        if (tankAngle > 180) {
            this.tankAngle =  180;
        } else if (tankAngle < -20) {
            this.tankAngle =  -20;
        } else {
            this.tankAngle = tankAngle;
        }
    }

    public Texture texture;
    private Vector3 posnArr;
    public Tank(int tankNum){
        tankAngle = 0;
        tankPower = 100;
        this.texture = new Texture(String.format("elements/tank%d.png",tankNum));
        this.tankSprite = new Sprite(new Texture(String.format("elements/tank%d.png",tankNum)));
        this.tankSprite.setScale(0.5f,0.5f);
        this.HP = 100;
    }
    public Tank(int tankNum,String path){
        tankAngle = 0;
        tankPower = 100;
        this.texture = new Texture(String.format("elements/tank%dR.png",tankNum));
        this.tankSprite = new Sprite(new Texture(String.format("elements/tank%dR.png",tankNum)));
        this.tankSprite.setScale(0.5f,0.5f);
        this.HP = 100;
    }
    public Tank(){}
    void setPosition(float X, float Y){
        this.tankSprite.setPosition(X, Y);
    }
    Sprite getTank(){
        return tankSprite;
    }

    public float getHealth() {
        return HP;

    }
}
