package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GarageOne extends ScreenAdapter{
    private Main mainClass;
    private SpriteBatch batch;
    private Sprite garageOneBackground;
    private Stage stage;
    private OrthographicCamera camera;
    private ImageButton tank1, tank2, tank3, tank4, next;
    Tank tank;
    public GarageOne(final Main mainClass) {
        this.mainClass = mainClass;
        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera(1920,1080);
        batch = new SpriteBatch();
        garageOneBackground = new Sprite(new Texture("screens/tankGarage1.png"));
        garageOneBackground.setPosition(-960,-540);
        next = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("elements/playB.png"))));
        tank1= new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("elements/tank1R.png"))));
        tank2= new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("elements/tank2R.png"))));
        tank3= new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("elements/tank3R.png"))));
        tank4= new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("elements/tank4.png"))));
        this.mainClass.test = tank1;
        stage.addActor(tank1);
        stage.addActor(tank2);
        stage.addActor(tank3);
        stage.addActor(tank4);
        stage.addActor(next);
        tank1.setHeight(350);
        tank1.setWidth(350);
        tank2.setHeight(350);
        tank2.setWidth(350);
        tank3.setHeight(350);
        tank3.setWidth(350);
        tank4.setHeight(350);
        tank4.setWidth(350);
        next.setWidth(180);
        next.setHeight(180);
        tank1.setPosition(900,400);
        tank4.setPosition(550,390);
        tank3.setPosition(600,170);
        tank2.setPosition(930,150);
        next.setPosition(100,100);
        tank1.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("tank1");
                mainClass.setTankUser1(1);
                return true;
            }
        });
        tank2.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("tank2");
                mainClass.setTankUser1(2);
                return true;
            }
        });
        tank3.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("tank3");
                mainClass.setTankUser1(3);
                return true;
            }
        });
        tank4.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("tank4");
                mainClass.setTankUser1(4);
                return true;
            }
        });
        next.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("next");
                mainClass.setScreen(new GarageTwo(mainClass));
                return true;
            }
        });
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        garageOneBackground.draw(batch);
        batch.end();
        stage.act();
        stage.draw();
    }
//    @Override
//    public void hide(){
//        Gdx.input.setInputProcessor(null);
//    }
    @Override
    public void dispose(){
        stage.dispose();
        batch.dispose();
    }

    public Main getMainClass() {
        return mainClass;
    }

    public void setMainClass(Main mainClass) {
        this.mainClass = mainClass;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Sprite getGarageOneBackground() {
        return garageOneBackground;
    }

    public void setGarageOneBackground(Sprite garageOneBackground) {
        this.garageOneBackground = garageOneBackground;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public ImageButton getTank1() {
        return tank1;
    }

    public void setTank1(ImageButton tank1) {
        this.tank1 = tank1;
    }

    public ImageButton getTank2() {
        return tank2;
    }

    public void setTank2(ImageButton tank2) {
        this.tank2 = tank2;
    }

    public ImageButton getTank3() {
        return tank3;
    }

    public void setTank3(ImageButton tank3) {
        this.tank3 = tank3;
    }

    public ImageButton getTank4() {
        return tank4;
    }

    public void setTank4(ImageButton tank4) {
        this.tank4 = tank4;
    }

    public ImageButton getNext() {
        return next;
    }

    public void setNext(ImageButton next) {
        this.next = next;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
