package com.technokratos.tests;

import com.technokratos.screens.Screen;
import org.junit.jupiter.api.Test;
import com.technokratos.tests.baseTest.BaseTest;

public class FirstTest extends BaseTest {

    Screen screen = new Screen(driver);

    @Test
    public void firstTest() throws Exception{
        screen.signInEsiaButtonClick();
        Thread.sleep(5000);
    }
}
