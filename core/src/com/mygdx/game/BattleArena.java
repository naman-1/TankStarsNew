package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.badlogic.gdx.Gdx.input;

public class BattleArena extends ScreenAdapter implements InputProcessor {
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

    public Sprite getHealth1() {
        return health1;
    }

    public void setHealth1(Sprite health1) {
        this.health1 = health1;
    }

    public Sprite getHealth2() {
        return health2;
    }

    public void setHealth2(Sprite health2) {
        this.health2 = health2;
    }

    public Sprite getVs() {
        return vs;
    }

    public void setVs(Sprite vs) {
        this.vs = vs;
    }

    public Sprite getHeart() {
        return heart;
    }

    public void setHeart(Sprite heart) {
        this.heart = heart;
    }

    public Tank getTank1() {
        return tank1;
    }

    public void setTank1(Tank tank1) {
        this.tank1 = tank1;
    }

    public Tank getTank2() {
        return tank2;
    }

    public void setTank2(Tank tank2) {
        this.tank2 = tank2;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Viewport getCameraPort() {
        return cameraPort;
    }

    public void setCameraPort(Viewport cameraPort) {
        this.cameraPort = cameraPort;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Box2DDebugRenderer getB2dr() {
        return b2dr;
    }

    public void setB2dr(Box2DDebugRenderer b2dr) {
        this.b2dr = b2dr;
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(OrthogonalTiledMapRenderer renderer) {
        this.renderer = renderer;
    }

    public TiledMap getMap() {
        return map;
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }

    public static float getPpm() {
        return ppm;
    }

    public static void setPpm(float ppm) {
        BattleArena.ppm = ppm;
    }

    public Body getTank1Body() {
        return tank1Body;
    }

    public void setTank1Body(Body tank1Body) {
        this.tank1Body = tank1Body;
    }

    public Body getTank2Body() {
        return tank2Body;
    }

    public void setTank2Body(Body tank2Body) {
        this.tank2Body = tank2Body;
    }

    public Body getHealthUpgrade() {
        return healthUpgrade;
    }

    public void setHealthUpgrade(Body healthUpgrade) {
        this.healthUpgrade = healthUpgrade;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public ImageButton getRetrieveB() {
        return retrieveB;
    }

    public void setRetrieveB(ImageButton retrieveB) {
        this.retrieveB = retrieveB;
    }

    public Body getProj() {
        return proj;
    }

    public void setProj(Body proj) {
        this.proj = proj;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isTurnHeart() {
        return turnHeart;
    }

    public void setTurnHeart(boolean turnHeart) {
        this.turnHeart = turnHeart;
    }

    public float getCountTimer() {
        return countTimer;
    }

    public void setCountTimer(float countTimer) {
        this.countTimer = countTimer;
    }

    public float getHealthTimer() {
        return healthTimer;
    }

    public void setHealthTimer(float healthTimer) {
        this.healthTimer = healthTimer;
    }

    public ShapeRenderer getHealthShape() {
        return healthShape;
    }

    public void setHealthShape(ShapeRenderer healthShape) {
        this.healthShape = healthShape;
    }

    private Main mainClass;
    private SpriteBatch batch;
    private Sprite health1, health2, vs, heart;
    private Tank tank1, tank2;
    private OrthographicCamera camera;
    private Viewport cameraPort;
    private World world;
    private Box2DDebugRenderer b2dr;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;
    public static float ppm =32;
    private Body tank1Body, tank2Body, healthUpgrade;
    private Texture img;
    private ImageButton retrieveB;
    private Body proj;
    boolean turn,turnHeart;
    private float countTimer, healthTimer;
    private    ShapeRenderer healthShape;

    public BattleArena(){};
    public BattleArena(Main mainClass) {
        turnHeart = true;
        countTimer = 0;
        turn = true;
        img = new Texture("elements/back.png");
        camera = new OrthographicCamera();
        cameraPort = new StretchViewport(1920,1080,camera);
        camera.setToOrtho(false,1920,1080);
//        camera.update();
        input.setInputProcessor(this);
//
        health1 = new Sprite(new Texture("elements/healthBar.png"));
        health2 = new Sprite(new Texture("elements/healthBar.png"));
        vs = new Sprite(new Texture("elements/VS.png"));
        health1.setPosition(200,900);
        health2.setPosition(1200,900);
        vs.setSize(100,100);
        vs.setPosition(800,900);
        retrieveB = Button.getButton("retrieveB");
        batch = new SpriteBatch();
        retrieveB.setPosition(420,60);
        this.mainClass = mainClass;
        tank1 = new Tank(mainClass.getTankUser1(),"R");
        tank2 = new Tank(mainClass.getTankUser2());

        world = new World(new Vector2(0,-9.8f),false);
        b2dr = new Box2DDebugRenderer();
        if (mainClass.getChoosenBattleField() == 1){
            map = new TmxMapLoader().load("battleFieldOne.tmx");
            renderer = new OrthogonalTiledMapRenderer(map);
        }
        else{
            map = new TmxMapLoader().load("battleFieldTwo.tmx");
            renderer = new OrthogonalTiledMapRenderer(map);
        }
        mapParser.parser(world,map.getLayers().get(1).getObjects());

        tank1Body = createTanks(4,9,100,100,false);
        tank2Body = createTanks(40,7,100,100,false);
//        heart = new Sprite(new Texture("elements/heart.png"));
//        healthUpgrade = createBullet(20,10,20,20);
        healthShape = new ShapeRenderer();
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        renderer.render();
        countTimer+=delta;

        healthTimer+=delta;
        if (healthTimer > 5&&turnHeart){
            healthUpgrade = createHeartDrop((float)(((Math.random()*100)%4)*10+10),25);
            turnHeart = false;
        }
        if (healthTimer > 8){
            if (healthUpgrade != null){
                world.destroyBody(healthUpgrade);
                healthUpgrade = null;
                turnHeart = true;
                healthTimer = 0;
            }
        }
        if (countTimer > 1){
            if (proj!=null){
                System.out.println("proj");
                world.destroyBody(proj);
                System.out.println("proj2");
                proj = null;
            }
        }
        batch.begin();
        this.tank1.setPosition((tank1Body.getPosition().x)*ppm-this.tank1.getTank().getWidth()/2,(tank1Body.getPosition().y)*ppm-this.tank1.getTank().getHeight()/2-40);
        this.tank2.setPosition((tank2Body.getPosition().x)*ppm-this.tank1.getTank().getWidth()/2,(tank2Body.getPosition().y)*ppm-this.tank1.getTank().getHeight()/2-40);
        if(healthUpgrade!=null && healthUpgrade.getUserData()!=null && healthUpgrade.getUserData() instanceof Sprite){
            Sprite s= (Sprite) (healthUpgrade.getUserData());
            s.setPosition((healthUpgrade.getPosition().x)*ppm-s.getWidth()/2,(healthUpgrade.getPosition().y)*ppm-s.getHeight()/2);
            s.draw(batch);
        }
        this.tank1.getTank().draw(batch);
        this.tank2.getTank().draw(batch);
        vs.draw(batch);
        health2.draw(batch);
        health1.draw(batch);
        if(proj!=null && proj.getUserData()!=null && proj.getUserData() instanceof Sprite){
            Sprite s= (Sprite) (proj.getUserData());
            s.setPosition((proj.getPosition().x)*ppm-s.getWidth()/2,(proj.getPosition().y)*ppm-s.getHeight()/2);
            s.draw(batch);
        }
        batch.end();
        updateHealth(delta);
        updateHeart(delta);
        healthShape.setProjectionMatrix(camera.combined);
        healthShape.begin(ShapeRenderer.ShapeType.Filled);
        healthShape.setColor(com.badlogic.gdx.graphics.Color.GREEN);
        healthShape.rect(200+10,900+78,(health1.getWidth()-114f)*tank1.getHealth()/100,health1.getHeight()-220);
        healthShape.rect(1200+10,900+78,(health1.getWidth()-114f)*tank2.getHealth()/100,health2.getHeight()-220);
        healthShape.end();
        b2dr.render(world,camera.combined.scl(ppm));
//        batch.draw(this.tank1.texture,tank1Body.getPosition().x*ppm,tank1Body.getPosition().y*ppm);

    }
    public void updateHeart(float delta){
        if (healthUpgrade!=null && healthUpgrade.getUserData()!=null && healthUpgrade.getUserData() instanceof Sprite){
            Sprite s= (Sprite) (healthUpgrade.getUserData());
            if (s.getBoundingRectangle().overlaps(tank1.getTank().getBoundingRectangle())){
                tank1.setHealth(tank1.getHealth()+10);
                world.destroyBody(healthUpgrade);
                healthUpgrade = null;
                turnHeart = true;
                healthTimer = 0;
            }
            if (s.getBoundingRectangle().overlaps(tank2.getTank().getBoundingRectangle())){
                tank2.setHealth(tank2.getHealth()+10);
                world.destroyBody(healthUpgrade);
                healthUpgrade = null;
                turnHeart = true;
                healthTimer = 0;

            }
        }
    }
    public void updateHealth(float delta){
//        check if proj has hit tank
        if (proj!=null && proj.getUserData()!=null && proj.getUserData() instanceof Sprite){
            Sprite s= (Sprite) (proj.getUserData());
            if (s.getBoundingRectangle().overlaps(tank1.getTank().getBoundingRectangle())){
                tank1.setHealth(tank1.getHealth()-10);
                if (tank1.getHealth() < 5){
                    mainClass.setScreen(new winScreen(mainClass,2));
                }
                world.destroyBody(proj);
                proj = null;
            }
            if (s.getBoundingRectangle().overlaps(tank2.getTank().getBoundingRectangle())){
                tank2.setHealth(tank2.getHealth()-10);
                if (tank2.getHealth() < 5){
                    mainClass.setScreen(new winScreen(mainClass,1));
                }
                world.destroyBody(proj);
                proj = null;
            }
        }
    }
    private void update(float delta){
        world.step(1 / 60f,6,2);
        inputUpdate(delta);
        cameraUpdate(delta);
        renderer.setView(camera);
        batch.setProjectionMatrix(camera.combined);
    }
    public Body createTanks(int x, int y, int h, int w, boolean isStatic) {
        Body pBody;
        BodyDef def = new BodyDef();
        if (isStatic){
            def.type = BodyDef.BodyType.StaticBody;
        }
        else {
            def.type = BodyDef.BodyType.DynamicBody;
        }
        def.position.set(x, y);
        def.fixedRotation = true;
        pBody = world.createBody(def);
        PolygonShape shape = new PolygonShape( );
        shape.setAsBox(h / 2 / ppm, w / 2/ppm);
        pBody.createFixture(shape, 2.5f);
        shape.dispose();
        return pBody;
    }
    public Body createBullet(Body tankBody,float x, float y){
        Body localProj;
        Sprite s;
        BodyDef bdef =new BodyDef();
        bdef.type=BodyDef.BodyType.DynamicBody;
        bdef.position.set(tankBody.getPosition().x,tankBody.getPosition().y+5);
        CircleShape c=new CircleShape();
        c.setRadius(0.5f);
        FixtureDef fdef=new FixtureDef();
        fdef.shape=c;
        fdef.density=10f;
        fdef.friction=0.5f;
        fdef.restitution=0.1f;
        localProj=world.createBody(bdef);
        localProj.createFixture(fdef);
        localProj.setLinearVelocity(x,y);
        s=new Sprite(new Texture("elements/back.png"));
            s.setSize(40,40);
        s.setPosition(localProj.getPosition().x*ppm,localProj.getPosition().y*ppm);
        localProj.setUserData(s);
        return localProj;
    }
    public Body createHeartDrop(float x, float y){
        Body localProj;
        Sprite s;
        BodyDef bdef =new BodyDef();
        bdef.type=BodyDef.BodyType.DynamicBody;
        bdef.position.set(x,y);
        CircleShape c=new CircleShape();
        c.setRadius(0.5f);
        FixtureDef fdef=new FixtureDef();
        fdef.shape=c;
        fdef.density=5f;
        fdef.friction=0.5f;
        fdef.restitution=0.1f;
        localProj=world.createBody(bdef);
        localProj.createFixture(fdef);
//        localProj.setLinearVelocity(x,y);
        s=new Sprite(new Texture("elements/heart.png"));
        s.setSize(80,80);
        s.setPosition(localProj.getPosition().x*ppm,localProj.getPosition().y*ppm);
        localProj.setUserData(s);
        return localProj;
    }
    private void inputUpdate(float delta){
        int horizontalforce = 0;

        if (input.isKeyPressed(Input.Keys.NUM_1) && turn){
            if (Gdx.input.isKeyPressed(Input.Keys.A) ) {
                horizontalforce-=1;
            }
            if(Gdx.input.isKeyPressed (Input. Keys. D)) {
                horizontalforce += 1;
            }
            if(Gdx.input.isKeyJustPressed (Input.Keys.W)) {
                tank1Body.applyForceToCenter(0,2000,false);
            }
            if(Gdx.input.isKeyJustPressed (Input.Keys.ENTER)) {
                proj = createBullet(tank1Body,MathUtils.cosDeg(this.tank1.getTankAngle())*this.tank1.getTankPower(), MathUtils.sinDeg(this.tank1.getTankAngle())*this.tank1.getTankPower());
                countTimer = 0;
                turn = false;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                this.tank1.setTankPower(this.tank1.getTankPower()+5);
//                if (this.tank1.getTankPower() > 100){
//                    this.tank1.setTankPower(100);
//                }
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                this.tank1.setTankPower(this.tank1.getTankPower()-5);
//                if (this.tank1.getTankPower() < 0){
//                    this.tank1.setTankPower(0);
//                }
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
                this.tank1.setTankAngle(this.tank1.getTankAngle()-1);
//                if (this.tank1.getTankAngle() < 0){
//                    this.tank1.setTankAngle(0);
//                }

            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
                this.tank1.setTankAngle(this.tank1.getTankAngle()+1);
//                if (this.tank1.getTankAngle() > 180){
//                    this.tank1.setTankAngle(180);
//                }
            }
            tank1Body.setLinearVelocity(horizontalforce*5,tank1Body.getLinearVelocity().y);
        }
        if (input.isKeyPressed(Input.Keys.NUM_2)&& !turn){
            if (Gdx.input.isKeyPressed(Input.Keys.A) ) {
                horizontalforce-=1;
            }
            if(Gdx.input.isKeyPressed (Input. Keys. D)) {
                horizontalforce += 1;
            }
            if(Gdx.input.isKeyJustPressed (Input.Keys.W)) {
                tank2Body.applyForceToCenter(0,2000,false);
            }
            if(Gdx.input.isKeyJustPressed (Input.Keys.ENTER)) {
                proj = createBullet(tank2Body,-1*MathUtils.cosDeg(this.tank2.getTankAngle())*this.tank2.getTankPower(), MathUtils.sinDeg(this.tank2.getTankAngle())*this.tank2.getTankPower());
//                try {
//                    destroy(proj);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                countTimer = 0;
                turn = true;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                this.tank2.setTankPower(this.tank2.getTankPower()+5);
//                if (this.tank2.getTankPower() > 100){
//                        this.tank2.setTankPower(100);
//                }
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                this.tank2.setTankPower(this.tank2.getTankPower()-5);
//                if (this.tank2.getTankPower() < 0){
//                    this.tank2.setTankPower(0);
//                }
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
                this.tank2.setTankAngle(this.tank2.getTankAngle()-1);
//                if (this.tank2.getTankAngle() < 0){
//                    this.tank2.setTankAngle(0);
//                }
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
                this.tank2.setTankAngle(this.tank2.getTankAngle()+1);
//                if (this.tank2.getTankAngle() > 180){
//                    this.tank2.setTankAngle(180);
//                }
            }
            tank2Body.setLinearVelocity(horizontalforce*5,tank2Body.getLinearVelocity().y);
        }
        if(Gdx.input.isKeyJustPressed (Input.Keys.ESCAPE)) {
//            mainClass.setScreen(StartingPage.getInstance());
            mainClass.setScreen(new PauseMenu(mainClass,this,mainClass.getChoosenBattleField()));
        }
    }
    private void destroy(Body body) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(4);
        world.destroyBody(body);
    }
//        if (tank1Body.getPosition().y < -10){
//            mainClass.setScreen(StartingPage.getInstance());
//        }
//        if (tank2Body.getPosition().y < -10){
//            mainClass.setScreen(StartingPage.getInstance());
//        }
    private void cameraUpdate(float delta){
//        Vector3 position = camera.position;
//        position.x = tank1Body.getPosition().x*ppm;
//        position.y = tank1Body.getPosition().y*ppm;
//        camera.position. set(position);
        camera.update() ;
    }
    @Override
    public void resize(int width, int height) {
        cameraPort.update(width,height);
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }
    @Override
    public boolean keyTyped(char character) {
        return false;
    }
    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
}