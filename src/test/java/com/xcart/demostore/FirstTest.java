package com.xcart.demostore;

import com.xcart.demostore.page.Page;
import org.junit.*;

public class FirstTest extends Page {

    @Test
    public void firstTest() {
        driver.get("https://demostore.x-cart.com/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("X-Cart Demo store company > Catalog"));

    }



}
