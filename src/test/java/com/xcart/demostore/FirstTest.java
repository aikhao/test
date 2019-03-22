package com.xcart.demostore;

import com.xcart.demostore.page.Page;
import org.junit.*;

public class FirstTest extends Page {

    @Ignore
    @Test
    public void firstTest() {
        driver.get("https://demostore.x-cart.com/");

        String title = driver.getTitle();
        Assert.assertEquals(title,("X-Cart Demo store company > Catalog"));

    }

    @Test
    public void newTest() {
        String s = "new";

        System.out.println(s.equals("ne2"));
    }



}
