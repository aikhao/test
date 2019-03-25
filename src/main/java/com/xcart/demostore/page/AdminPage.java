package com.xcart.demostore.page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AdminPage extends Page {

    private By inputEmail = By.name("login");
    private By inputPassword = By.name("password");
    private By buttonLogIn = By.cssSelector("button.submit");

    public AdminPage open(){
        Selenide.open("admin.php");
        return this;
    }

    public void login(String email, String password){
        $(inputEmail).val(email);
        $(inputPassword).val(password);
        $(buttonLogIn).submit();
    }

}
