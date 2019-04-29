package com.xcart.demostore.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AdminPage extends Page {

    private By inputEmail = By.name("login");
    private By inputPassword = By.name("password");
    private By buttonLogIn = By.cssSelector("button.submit");

//    @FindBy(css = "button.submit")
////    @CacheLookup
//    private WebElement buttonLogIn;

    public static Set<Cookie> cokies;

    public AdminPage open(){
        Selenide.open("admin.php?target=address_book&profile_id=7");
        return this;
    }
    public AdminPage openAddessBook(){
        Selenide.open("admin.php?target=address_book&profile_id=7");
        return this;
    }

    public void login(String email, String password) throws InterruptedException {
        $(inputEmail).val(email);
        $(inputPassword).val(password);
                TimeUnit.SECONDS.sleep(2);

        $(buttonLogIn).submit();

    }

    public SelenideElement buttonLogIn(){
        return $(buttonLogIn);
    }

}
