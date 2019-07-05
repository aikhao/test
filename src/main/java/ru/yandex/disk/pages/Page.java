package ru.yandex.disk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static ru.yandex.disk.Config.IMPLICITY_WAIT;

public class Page {


    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected WebElement waitElementIsClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 3, 100);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void setImplicitly(boolean val) {
        if (val) {
            driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
            return;
        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    protected boolean isElementPresent(By selector) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        logger.debug("Is element present"+selector);
        boolean returnVal = true;
        try{
            driver.findElement(selector);
        } catch (NoSuchElementException e){
            returnVal = false;
        } finally {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return returnVal;
    }

}
