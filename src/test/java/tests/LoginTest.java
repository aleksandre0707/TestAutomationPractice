package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoggedInPage;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private LoggedInPage loggedInPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.setUsername("student");
        loginPage.setPassword("Password123");
        loginPage.clickLoginButton();
        loggedInPage = new LoggedInPage(driver);
        Assert.assertEquals(loggedInPage.getLoggedInLabel(), "Logged In Successfully");
    }

    @Test
    public void testInvalidUsername() {
        loginPage.setUsername("incorrectUser");
        loginPage.setPassword("Password123");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getError(), "Your username is invalid!");
    }

    @Test
    public void testInvalidPassword() {
        loginPage.setUsername("student");
        loginPage.setPassword("incorrectPassword");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getError(), "Your password is invalid!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
