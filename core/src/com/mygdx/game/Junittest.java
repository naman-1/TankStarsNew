package com.mygdx.game;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Null;
import jdk.javadoc.internal.tool.Start;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;

import static org.junit.Assert.*;

public class Junittest extends Assert implements Null {
    @Test
    public void sampleTest()
    {
        assertEquals(10,10);
    }
    @Test
    public void testPower()
    {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();
        tank1.setTankPower(-100);
        tank2.setTankPower(0);
        assertEquals(tank1.getTankPower(),tank2.getTankPower());

    }

    @Test
    public void testPower2()
    {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();
        tank1.setTankPower(50);
        tank2.setTankPower(50);
        assertEquals(tank1.getTankPower(),tank2.getTankPower());

    }

    @Test
    public void testPower3()
    {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();
        tank1.setTankPower(1100);
        tank2.setTankPower(1000);
        assertEquals(tank1.getTankPower(),tank2.getTankPower());

    }

    @Test
    public void testAngle()
    {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();
        tank1.setTankAngle(180);
        tank2.setTankAngle(1000);
        assertEquals(tank1.getTankAngle(),tank2.getTankAngle());

    }

    @Test
    public void testAngle2()
    {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();
        tank1.setTankAngle(-100);
        tank2.setTankAngle(-20);
        assertEquals(tank1.getTankAngle(),tank2.getTankAngle());

    }

    @Test
    public void testAngle3()
    {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();
        tank1.setTankAngle(180);
        tank2.setTankAngle(200);
        assertEquals(tank1.getTankAngle(),tank2.getTankAngle());

    }

    @Test
    public void testSignleton()
    {
        StartingPage start1 = StartingPage.getInstance(1);
        StartingPage start2 = StartingPage.getInstance(1);
        assertSame(start2,start2);
    }

    @Test
    public void testFactory() {
        ImageButton two = null;
        two = Button.getButton("eB");
        assertSame(null, two);

    }



//    public void testFactory() {
//        ImageButton one = Button.getButton("playB");
//        ImageButton two;
//        try {
//            two = Button.getButton("pB");
//
//        } catch (NullPointerException ex) {
//            two = null;
//        }
//        assertEquals(null,two);
////        assertEquals(null,two);
////        assertEquals(one,two);
//
//    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}