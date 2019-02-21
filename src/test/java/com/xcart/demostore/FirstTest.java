package com.xcart.demostore;

import org.junit.*;

public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() {
        driver.get("https://demostore.x-cart.com/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("X-Cart Demo store company > Catalog"));

    }



}
