package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.gdx.Gdx.input;

public class winScreen extends ScreenAdapter {
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

    public Sprite getMainImage() {
        return mainImage;
    }

    public void setMainImage(Sprite mainImage) {
        this.mainImage = mainImage;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public ImageButton getMainMenuB() {
        return mainMenuB;
    }

    public void setMainMenuB(ImageButton mainMenuB) {
        this.mainMenuB = mainMenuB;
    }

    private Main mainClass;
    private Stage stage;
    private SpriteBatch batch;
    private Sprite mainImage;
    private OrthographicCamera camera;
    private ImageButton mainMenuB;

    public winScreen(final Main mainClass, int winner){
        this.mainClass = mainClass;
        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera(1920,1080);
        batch = new SpriteBatch();
        mainImage = new Sprite(new Texture(String.format("screens/%dwinner.png",winner)));
        mainImage.setPosition(-960,-540);
        mainMenuB    = Button.getButton("playB");
        mainMenuB.setPosition(600,200);
        mainMenuB.setHeight(180);
        mainMenuB.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                mainClass.setScreen(StartingPage.getInstance());
                return true;
            }
        });
        stage.addActor(mainMenuB);
        input.setInputProcessor(stage);
            }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        mainImage.draw(batch);
        batch.end();
        stage.act();
        stage.draw();
    }
}
