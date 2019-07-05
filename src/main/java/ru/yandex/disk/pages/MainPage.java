package ru.yandex.disk.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends Page {

    private By userButton = By.cssSelector(".user2__current-account");
    private By createButton = By.cssSelector(".create-resource-popup-with-anchor");
    private By createResourceList = By.cssSelector(".create-resource-popup-with-anchor__create-items > button");
    private By nameModalInput = By.cssSelector(".modal__table input");
    private By submitModalButton = By.cssSelector(".confirmation-dialog__button");
    private By resourceList = By.cssSelector("div.listing__items > div");
    private By buttonShareElementInContextMenu = By.xpath("//div[contains(@class,'popup2_visible_yes')]//span[contains(@class,'menu__text')]/span[contains(text(),'Поделиться')]");
    private By buttonDeleteElementInContextMenu = By.xpath("//div[contains(@class,'popup2_visible_yes')]//span[@class='menu__text'][text()='Удалить']");
    private By inputShareURL = By.cssSelector(".popup2_visible_yes input.publish-resource-tumbler__input");
    String elementOnPage = "//div[@class='listing__items']//span[contains(text(),'%s')]";
    String elementFromMove = "//div[@class='listing__items']//span[contains(text(),'%s')]/ancestor::div[contains(@class,'listing-item')]/div[contains(@class,'listing-item__icon')]//span";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn() {
        setImplicitly(false);
        boolean result = driver.findElements(userButton).size() > 0;
        setImplicitly(true);
        return result;
    }

    public void waitLoadPage() {
        waitVisible(userButton);
    }

    public void createFolder(String name) throws InterruptedException {
        driver.findElement(createButton).click();
        waitElementIsClickable(createResourceList);
        driver.findElements(createResourceList).get(0).click();
        waitElementIsClickable(nameModalInput);
        driver.findElement(nameModalInput).click();
        driver.findElement(nameModalInput).sendKeys(Keys.chord(Keys.COMMAND, Keys.DELETE));
        waitElementIsClickable(nameModalInput);
        driver.findElement(nameModalInput).sendKeys(name);
        waitElementIsClickable(submitModalButton);
        driver.findElement(submitModalButton).click();
    }

    public WebElement getResourceByIndex(int index) {
        return driver.findElements(resourceList).get(index);
    }

    public String createPublicLink(String name) throws InterruptedException {

        waitElementIsClickable(By.xpath(String.format(elementOnPage,name)));
        WebElement contextMenu = driver.findElement(By.xpath(String.format(elementOnPage,name)));

        Actions actions = new Actions(driver);
        actions.contextClick(contextMenu)
                .perform();
        waitElementIsClickable(buttonShareElementInContextMenu);
        WebElement shareUrlButton = driver.findElement(buttonShareElementInContextMenu);
        shareUrlButton.click();

        waitElementIsClickable(inputShareURL);
        return driver.findElement(inputShareURL).getAttribute("value");

    }

    public void deleteDiskElement(String name) {
        Actions actions = new Actions(driver);
        WebElement contextMenu = getResource(name);
        actions.contextClick(contextMenu)
                .perform();

        WebElement deleteButton = driver.findElement(buttonDeleteElementInContextMenu);
        deleteButton.click();
    }

    public void deleteDiskElementWithDragAndDrop(String name) {

        WebElement one = getMoveResource(name);
        WebElement two = getMoveResource("Корзина");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(one,two).perform();
    }

    /**
     * FIXME
     */
    public void checkBasketColorOnFocus(String name) {
        WebElement LocatorFrom = getMoveResource(name);
        WebElement LocatorTo = getMoveResource("Корзина");

        String xto=Integer.toString(LocatorTo.getLocation().x);
        String yto=Integer.toString(LocatorTo.getLocation().y);

        ((JavascriptExecutor)driver).executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; " +
                        " simulate(arguments[0],'mousedown'); simulate(arguments[0],'mousemove',arguments[1],arguments[2]); ",
                LocatorFrom,xto,yto);

//        System.out.println("color="+driver.findElement(By.xpath("//div[@class='listing__items']//span[contains(text(),'Корзина')]/ancestor::div[contains(@class,\"listing-item\")]")).getCssValue("color"));
        System.out.println("background-color="+driver.findElement(By.xpath("//div[@class='listing__items']//span[contains(text(),'Корзина')]/ancestor::div[contains(@class,'listing-item')]")).getCssValue("background"));

    }


    public Boolean checkPresentElementOnDisk(String name) {
        return isElementPresent(By.xpath(String.format(elementOnPage,name)));
    }

    public WebElement getMoveResource(String name) {
        return driver.findElement(By.xpath(String.format(elementFromMove,name)));
    }

    public WebElement getResource(String name) {
        return driver.findElement(By.xpath(String.format(elementOnPage,name)));
    }


}
