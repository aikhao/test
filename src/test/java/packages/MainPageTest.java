package packages;

import com.xcart.demostore.page.Page;
import org.junit.*;
import static com.codeborne.selenide.Configuration.baseUrl;


public class MainPageTest extends Page {

//    private WebDriver driver;
    private MainPage mainPage;
    private  SignUpPage signUpPage;

//    @BeforeClass
//    public void setUp(){
////        driver = new ChromeDriver();
////        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////        driver.manage().window().maximize();
////        driver.get("http://github.com");
////        mainPage = new MainPage(driver);
//        baseUrl = "http://github.com";
//
//    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("testuser", "testemail", "testpass");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest(){
        SignUpPage signUpPage = mainPage.register("", "mail", "pass");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest(){
        SignUpPage signUpPage = mainPage.register("qeqwe", "qweq", "pass");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @Test
    public void test() {
        SignUpPage pages = new SignUpPage();
        pages.open();
    }
}
