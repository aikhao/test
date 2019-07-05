package ru.yandex.disk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.disk.helpers.UserHelper;
import ru.yandex.disk.pages.LoginPage;
import ru.yandex.disk.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;

    private LoginPage loginPage;
    private MainPage mainPage;

    private UserHelper userHelper;

    public ApplicationManager() {

    }

    public ApplicationManager(String browser) {
        this();
        System.setProperty("webdriver.chrome.driver",
                "/Users/olegivanov/work/chromedriver");

        ChromeOptions ChromeOptions = new ChromeOptions();
//            ChromeOptions.setHeadless(true);

        if ("Firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver(ChromeOptions);
        }


//            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
//            driver.getWindowHandle();

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        userHelper = new UserHelper(this);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}


