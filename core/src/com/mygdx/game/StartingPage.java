package com.mygdx.game;

import com.badlogic.gdx.Gdx;
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


public class StartingPage extends ScreenAdapter{
    private Main mainClass;
    private SpriteBatch batch;

    public Main getMainClass() {
        return mainClass;
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

    public Sprite getLedger() {
        return ledger;
    }

    public void setLedger(Sprite ledger) {
        this.ledger = ledger;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public ImageButton getPlayB() {
        return playB;
    }

    public void setPlayB(ImageButton playB) {
        this.playB = playB;
    }

    public ImageButton getExitB() {
        return exitB;
    }

    public void setExitB(ImageButton exitB) {
        this.exitB = exitB;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static StartingPage getStart() {
        return start;
    }

    public static void setStart(StartingPage start) {
        StartingPage.start = start;
    }

    public ImageButton getRetrieveB() {
        return retrieveB;
    }

    public void setRetrieveB(ImageButton retrieveB) {
        this.retrieveB = retrieveB;
    }

    private Sprite mainImage, ledger;
    private OrthographicCamera camera;
    private ImageButton playB, exitB, retrieveB ;
    Stage stage;
    private static StartingPage start;
    public static StartingPage getInstance(){
        if (start== null){
            start= new StartingPage();
        }
        input.setInputProcessor(start.stage);
        return start;
    }
    public static StartingPage getInstance(int number){

        if (start== null){
            start= new StartingPage(number);
        }
        return start;
    }
    private StartingPage(int num){}
    private StartingPage(){
        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera(1920,1080);
        batch = new SpriteBatch();
        mainImage = new Sprite(new Texture("screens/mainPage.jpg"));
        mainImage.setPosition(-960,-540);

        playB    = Button.getButton("playB");
        exitB    = Button.getButton("exitB");
        retrieveB= Button.getButton("retrieveB");
        playB.setPosition(600,200);
        exitB.setPosition(780,60);
        retrieveB.setPosition(420,60);
        playB.setHeight(180);
        exitB.setHeight(180);
        retrieveB.setHeight(180);
        playB.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("play button clicked");
                mainClass.setScreen(new BattleFieldSelection(mainClass));
                return true;
            }
        });
        exitB.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("exit button clicked");
                Gdx.app.exit();
                return true;
            }
        });
        retrieveB.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                ledger = new Sprite(new Texture("screens/ledger.png"));
                ledger.setPosition(-960,-150);
                ledger.setSize(1920,1080);
                System.out.println("retrieve"+" button clicked");
                return true;
            }
        });
        stage.addActor(playB);
        stage.addActor(exitB);
        stage.addActor(retrieveB);
        input.setInputProcessor(stage);
    }

    public void setMainClass(Main main){
        this.mainClass = main;
    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(1,0,0,1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        mainImage.draw(batch);
        if (ledger!=null) {
            ledger.draw(batch);
        }
        //        play.draw(batch);
//        exit.draw(batch);
//        retrieve.draw(batch);
        batch.end();
        stage.act();
        stage.draw();
    }
//
//    @Override
//    public boolean keyDown(int keycode) {
//        return true;
//    }
//
//    @Override
//    public boolean keyUp(int keycode) {
//        return false;
//    }
//
//    @Override
//    public boolean keyTyped(char character) {
//        return false;
//    }
//
//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
//            System.out.println("CLICK: " + screenX + ", " + screenY);
//            System.out.println("Mouse left clicked!");
//        }
//        else if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
//            System.out.println("CLICK: " + screenX + ", " + screenY);
//            System.out.println("Mouse right clicked!");
//        }
//        return true;
//    }
//
//    @Override
//    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//        return false;
//    }
//
//    @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        return false;
//    }
//
//    @Override
//    public boolean mouseMoved(int screenX, int screenY) {
//        return false;
//    }
//
//    @Override
//    public boolean scrolled(float amountX, float amountY) {
//        return false;
//    }
//    @Override
//    public void hide(){
//        Gdx.input.setInputProcessor(null);
//    }
    @Override
    public void dispose(){
//        stage.dispose();
//        batch.dispose();
    }

}
