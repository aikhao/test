package ru.yandex.disk.helpers;

import org.openqa.selenium.By;
import ru.yandex.disk.ApplicationManager;

import static junit.framework.TestCase.assertTrue;

public class UserHelper {

    ApplicationManager app;

    public UserHelper(ApplicationManager app) {
        this.app = app;
    }

    public void auth(String username, String password) {
        if (!app.getMainPage().isLoggedIn()) {
            app.getLoginPage().login(username, password);
        }
        app.getMainPage().waitLoadPage();
        assertTrue(app.getMainPage().isLoggedIn());
    }

    public String getPageTitle(){

        return app.getDriver().findElement(By.cssSelector("title")).getText();
    }

    public String getNameFile(){
        return app.getDriver().findElement(By.cssSelector("div.public-listing__header div.listing-item__title")).getText();
    }
}
