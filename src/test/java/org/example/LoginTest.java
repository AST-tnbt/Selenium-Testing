package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String str255 = "fD4w1ZqObTPe6K9xMJnL7GvRm0HACyY5EIBtzp3XNUrVWQkagslFhBdcoiuvn2xqYjtmPbDKRhGLTwXeAfVZn7U0yIMgWq1CBokp3dLUvhsrZ9NqTAymcEJF4xBRlOH52SvdgKawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnsXAm2dfw6rM3CZU";
    private String str256 = "afD4w1ZqObTPe6K9xMJnL7GvRm0HACyY5EIBtzp3XNUrVWQkagslFhBdcoiuvn2xqYjtmPbDKRhGLTwXeAfVZn7U0yIMgWq1CBokp3dLUvhsrZ9NqTAymcEJF4xBRlOH52SvdgKawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnsXAm2dfw6rM3CZU";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "driver/msedgedriver");
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Login with valid username and password")
    public void testValidLogin() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
        String expectUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), expectUrl, "Login failed");
    }

    @Test(description = "Login with invalid username and password")
    public void testInvalidLogin() {
        loginPage.login("wrongusername", "wrongpassword");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with valid username and invalid password")
    public void testInvalidPassword() {
        loginPage.login("tomsmith", "wrongpassword");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with invalid username and valid password")
    public void testInvalidUsername() {
        loginPage.login("wrongusername", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with invalid username includes special character")
    public void testInvalidUsernameWithSpecialCharacter() {
        loginPage.login("tomsmithϟ", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with invalid password includes special character")
    public void testInvalidPasswordWithSpecialCharacter() {
        loginPage.login("tomsmith", "SuperSecretPassword!ϟ");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with empty username")
    public void testEmptyUsername() {
        loginPage.login("", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with empty password")
    public void testEmptyPassword() {
        loginPage.login("tomsmith", "");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with SQL injection username")
    public void testInjectionUsername() {
        loginPage.login("' or 1=1 --", "");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with SQL injection password")
    public void testInjectionPassword() {
        loginPage.login("", "' or 1=1 --");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with username include 1 character")
    public void testOneCharUsername() {
        loginPage.login("a", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with password include 1 character")
    public void testOneCharPassword() {
        loginPage.login("tomsmith", "a");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with username include 255 characters")
    public void test255CharsUsername() {
        loginPage.login(str255, "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with password include 255 characters")
    public void test255CharsPassword() {
        loginPage.login("tomsmith", str255);
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with username include 256 characters")
    public void test256CharsUsername() {
        loginPage.login(str256, "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with password include 256 characters")
    public void test256CharsPassword() {
        loginPage.login("tomsmith", str256);
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
