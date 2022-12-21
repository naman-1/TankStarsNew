package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadingPage extends ScreenAdapter {
    private OrthographicCamera camera;
    private Main main;
    private Sprite loadingImage;
    private SpriteBatch batch;
    private float time;
    public LoadingPage(Main main){
        camera = new OrthographicCamera(1920,1080);
        time = 0;
        this.main = main;
        batch = new SpriteBatch();
        loadingImage = new Sprite(new Texture("screens/landingPage.jpg"));
        loadingImage.setPosition(-960,-540);

    }
    @Override
    public void render(float delta) {
        if (time >= 5.0){
            main.setScreen(StartingPage.getInstance());
        }
        batch.setProjectionMatrix(camera.combined);
        time += Gdx.graphics.getDeltaTime();
        batch.begin();
        loadingImage.draw((Batch) batch);
        batch.end();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Sprite getLoadingImage() {
        return loadingImage;
    }

    public void setLoadingImage(Sprite loadingImage) {
        this.loadingImage = loadingImage;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
