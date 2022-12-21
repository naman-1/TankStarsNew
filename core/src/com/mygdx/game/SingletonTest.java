package com.mygdx.game;

import org.junit.Assert;
import org.junit.Test;
public class SingletonTest extends Assert {
    @Test
    public void testSingleton() {
        StartingPage startingPage = StartingPage.getInstance(67);
        StartingPage startingPage2 = StartingPage.getInstance(78);
        assertEquals(startingPage, startingPage2);
    }
}