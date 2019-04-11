package com.xcart.demostore.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AdminPage extends Page {

    private By inputEmail = By.name("login");
    private By inputPassword = By.name("password");
    private By buttonLogIn = By.cssSelector("button.submit");
    public static Set<Cookie> cokies;

    public AdminPage open(){
        Selenide.open("admin.php");
        return this;
    }

    public void login(String email, String password){
        $(inputEmail).val(email);
        $(inputPassword).val(password);
        $(buttonLogIn).submit();

    }

    public SelenideElement buttonLogIn(){
        return $(buttonLogIn);
    }

}
