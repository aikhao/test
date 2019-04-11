package com.xcart.demostore;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.xcart.demostore.page.AdminPage;
import com.xcart.demostore.page.CustomerPage;
import com.xcart.demostore.page.Page;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.sql.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.xcart.demostore.page.AdminPage.cokies;
import static java.sql.DriverManager.getDriver;
import static java.sql.DriverManager.println;

public class Login {

    private AdminPage page;

    @BeforeClass
    public static void setUp(){
        baseUrl = "http://localhost/next/src/";
//        baseUrl = "https://demostore.x-cart.com/";

        System.out.println("error");
    }

    @Test
    public void AdminLogin() {
        page = new AdminPage();
        page.open();

        page.buttonLogIn().shouldBe(Condition.text("Log In"));
        page.login("admin@example.com","master");
//        TimeUnit.SECONDS.sleep(10);
        cokies = WebDriverRunner.getWebDriver().manage().getCookies();
        System.out.println("Size="+cokies.size());
        for (Cookie ck : WebDriverRunner.getWebDriver().manage().getCookies()) {
            System.out.println(ck.getName() + ";" + ck.getValue() + ";" + ck.
                    getDomain()
                    + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.
                    isSecure());
        }

    }

    @Test
    public void SecondLogin() throws InterruptedException {
        page = new AdminPage();

        SelenideElement element = $(By.cssSelector(".storefront-status a"));
        WebDriverRunner.driver().actions().click(element).perform();
        switchTo().alert().accept();
//        TimeUnit.SECONDS.sleep(10);
    }

    @Ignore
    @Test
    public void CustomerLogin() throws InterruptedException {
        CustomerPage page = new CustomerPage();

        page.open();
        Set<Cookie> var = WebDriverRunner.getWebDriver().manage().getCookies();
        System.out.println("Size="+var.size());
//        TimeUnit.SECONDS.sleep(10);
    }



}
