package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

class Main extends Game{
    private int tankUser1, tankUser2;
    public ImageButton test;
    private int choosenBattleField;

    public Main() {
        this.choosenBattleField = 1;
        this.tankUser1=1;
        this.tankUser2=1;
    }

    public int getChoosenBattleField() {
        return choosenBattleField;
    }

    public void setChoosenBattleField(int choosenBattleField) {
        this.choosenBattleField = choosenBattleField;
    }

    @Override
    public void create () {
        StartingPage temp = StartingPage.getInstance();
        temp.setMainClass(this);
        setScreen(temp);

    }

    public void setTankUser1(int tankUser1) {
        this.tankUser1 = tankUser1;
    }

    public void setTankUser2(int tankUser2) {
        this.tankUser2 = tankUser2;
    }

    public int getTankUser1() {
        return tankUser1;
    }

    public int getTankUser2() {
        return tankUser2;
    }

    public ImageButton getTest() {
        return test;
    }

    public void setTest(ImageButton test) {
        this.test = test;
    }
//    @Override
//    public void create() {
//        setScreen(new StartingPage(this));
//    }

}
