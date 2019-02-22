package com.xcart.demostore.page;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void close() {
        driver.quit();
    }
}
