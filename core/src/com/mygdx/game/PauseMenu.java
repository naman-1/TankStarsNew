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

import java.io.IOException;

import static com.badlogic.gdx.Gdx.input;

public class PauseMenu extends ScreenAdapter {
    public BattleArena getBattleArena() {
        return battleArena;
    }

    public void setBattleArena(BattleArena battleArena) {
        this.battleArena = battleArena;
    }

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

    public ImageButton getResumeB() {
        return resumeB;
    }

    public void setResumeB(ImageButton resumeB) {
        this.resumeB = resumeB;
    }

    public ImageButton getExitB() {
        return exitB;
    }

    public void setExitB(ImageButton exitB) {
        this.exitB = exitB;
    }

    public ImageButton getSaveB() {
        return saveB;
    }

    public void setSaveB(ImageButton saveB) {
        this.saveB = saveB;
    }

    private BattleArena battleArena;
    private Main mainClass;
    Stage stage;
    private SpriteBatch batch;
    private Sprite mainImage;
    private OrthographicCamera camera;
    private ImageButton resumeB, exitB, saveB;
    public PauseMenu(final Main mainClass, final BattleArena battleArena,int screen) {
        this.mainClass = mainClass;
        this.battleArena = battleArena;
        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera(1920,1080);
        batch = new SpriteBatch();
        mainImage = new Sprite(new Texture(String.format("screens/pause%d.jpg",screen)));
        mainImage.setPosition(-960,-540);
        resumeB    = Button.getButton("playB");
        exitB    = Button.getButton("exitB");
        saveB= Button.getButton("retrieveB");
        resumeB.setPosition(600,200);
        exitB.setPosition(780,60);
        saveB.setPosition(420,60);
        resumeB.setHeight(180);
        exitB.setHeight(180);
        saveB.setHeight(180);
        resumeB.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                mainClass.setScreen(battleArena);
                return true;
            }
        });
        exitB.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                mainClass.setScreen(StartingPage.getInstance());
                return true;
            }
        });
        saveB.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                try {
//                    com.mkyong.io.object.SerializationClass.writeObjectToFile(battleArena);
//                    io.object.SerializationClass.writeObjectToFile(battleArena);
                    SerializationClass.writeObjectToFile(new Tank());
                    System.out.println("Done");
                } catch (IOException e) {
                    System.out.println("Error in saving");
                    throw new RuntimeException(e);
                }
                //        File file = new File("tank.bin");

//                mainClass.setScreen(SaveMenu.getInstance(mainClass, battleArena));
                return true;
            }
        });
        stage.addActor(resumeB);
        stage.addActor(exitB);
        stage.addActor(saveB);
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


