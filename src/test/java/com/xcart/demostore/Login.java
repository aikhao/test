package com.xcart.demostore;

import com.xcart.demostore.page.AdminPage;
import com.xcart.demostore.page.CustomerPage;
import com.xcart.demostore.page.Page;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Configuration.baseUrl;

public class Login {

    private AdminPage page;

    @BeforeClass
    public static void setUp(){
//        baseUrl = "http://localhost/next/src/";
        baseUrl = "https://demostore.x-cart.com/";

        System.out.println("error");
    }

    @Test
    public void AdminLogin() throws InterruptedException {
        page = new AdminPage();

        page.open().login("admin@example.com","master");
        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void CustomerLogin() throws InterruptedException {
        CustomerPage page = new CustomerPage();

        page.open();
//        TimeUnit.SECONDS.sleep(10);
    }



}
