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

public class BattleFieldSelection extends ScreenAdapter {
    public Main getMainClass() {
        return mainClass;
    }

    public void setMainClass(Main mainClass) {
        this.mainClass = mainClass;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Sprite getBackground() {
        return background;
    }

    public void setBackground(Sprite background) {
        this.background = background;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public ImageButton getGround1() {
        return ground1;
    }

    public void setGround1(ImageButton ground1) {
        this.ground1 = ground1;
    }

    public ImageButton getGround2() {
        return ground2;
    }

    public void setGround2(ImageButton ground2) {
        this.ground2 = ground2;
    }

    public ImageButton getNext() {
        return next;
    }

    public void setNext(ImageButton next) {
        this.next = next;
    }

    private Main mainClass;
    private Stage stage;
    private SpriteBatch batch;
    private Sprite background;
    private OrthographicCamera camera;
    ImageButton ground1, ground2, next;
    public BattleFieldSelection(final Main mainClass) {
        this.mainClass = mainClass;
        this.camera = new OrthographicCamera(1920,1080);
        batch = new SpriteBatch();
        background = new Sprite(new Texture("screens/mainPage.jpg"));
        background.setPosition(-960,-540);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        this.next = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("elements/playB.png"))));
        this.ground1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("screens/battleField1.jpg"))));
        this.ground2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("screens/battleField2.jpg"))));
        stage.addActor(ground1);
        stage.addActor(ground2);
        stage.addActor(next);
        ground1.setWidth(600);
        ground2.setWidth(600);
        ground1.setHeight(800);
        ground2.setHeight(800);
        next.setWidth(180);
        next.setHeight(180);
        ground1.setPosition(120,50);
        ground2.setPosition(740,50);
        next.setPosition(650,80);
        ground1.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("1");
                mainClass.setChoosenBattleField(1);
                return true;
            }
        });
        ground2.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("2");
                mainClass.setChoosenBattleField(2);
                return true;
            }
        });
        next.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                mainClass.setScreen(new GarageOne(mainClass));
                return true;
            }
        });

    }
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        background.draw(batch);
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
}
