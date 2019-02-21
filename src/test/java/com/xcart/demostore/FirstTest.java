package com.xcart.demostore;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    @Test
    public void firstTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demostore.x-cart.com/");
    }
}
