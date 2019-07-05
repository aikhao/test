package ru.yandex.disk.uiTest;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.disk.ApplicationManager;

import static ru.yandex.disk.Config.*;

public class First {


    private String newFolder = "folder14";
    protected ApplicationManager app;

    @Parameters({"browser"})
    @BeforeClass
    public void init(@Optional("chrome") String browser) {
        app = new ApplicationManager(browser);
        app.getDriver().get(BASE_URL);
        app.getLoginPage().waitLoadPage();
        app.getUserHelper().auth(USER_NAME, USER_PASS);
    }

    @BeforeMethod
    public void setup() {
        app.getDriver().get(BASE_URL);
        app.getMainPage().waitLoadPage();
    }

    @Test
    public void newFolder() throws InterruptedException {
        Assert.assertFalse(app.getMainPage().checkPresentElementOnDisk(newFolder));
        app.getMainPage().createFolder(newFolder);
    }

    //    @Ignore
    @Test(dependsOnMethods = {"newFolder"})
    public void publicLink() throws InterruptedException {
        Assert.assertTrue(app.getMainPage().checkPresentElementOnDisk(newFolder));
        String text = app.getMainPage().createPublicLink(newFolder);
        app.getDriver().get(text);
        Assert.assertNotEquals(app.getUserHelper().getPageTitle(), "Ничего не найдено — Яндекс.Диск");
        Assert.assertEquals(app.getUserHelper().getNameFile(), newFolder);

    }

    @Test(dependsOnMethods = {"newFolder"})
    public void checkColorBasket() throws InterruptedException {
        Assert.assertTrue(app.getMainPage().checkPresentElementOnDisk(newFolder));
        app.getMainPage().checkBasketColorOnFocus(newFolder);
        //background-color=rgba(0, 115, 255, 0.5) none repeat scroll 0% 0% / auto padding-box border-box

    }

    @Test(dependsOnMethods = {"checkColorBasket"})
    public void deleteFolder() {
        Assert.assertTrue(app.getMainPage().checkPresentElementOnDisk(newFolder));
        app.getMainPage().deleteDiskElement(newFolder);
        //        app.getMainPage().deleteDiskElementWithDragAndDrop(newFolder);
        //        app.getMainPage().checkBasketColorOnFocus(newFolder);
        Assert.assertFalse(app.getMainPage().checkPresentElementOnDisk(newFolder));
    }

    @AfterClass
    public void tearDown() {
        app.getDriver().quit();
    }



}
