package org.example;

import org.example.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.edge.driver", ConfigReader.getDriverPath());
        driver = new EdgeDriver();
        driver.get(ConfigReader.getBaseUrl());
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Login with valid username and password")
    public void testValidLogin() {
        loginPage.login(ConfigReader.getValidUsername(), ConfigReader.getValidPassword());
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
        loginPage.login(ConfigReader.getValidUsername(), "wrongpassword");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with invalid username and valid password")
    public void testInvalidUsername() {
        loginPage.login("wrongusername", ConfigReader.getValidPassword());
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with invalid username includes special character")
    public void testInvalidUsernameWithSpecialCharacter() {
        loginPage.login("tomsmithϟ", ConfigReader.getValidPassword());
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with invalid password includes special character")
    public void testInvalidPasswordWithSpecialCharacter() {
        loginPage.login(ConfigReader.getValidUsername(), "SuperSecretPassword!ϟ");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with empty username")
    public void testEmptyUsername() {
        loginPage.login("", ConfigReader.getValidPassword());
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with empty password")
    public void testEmptyPassword() {
        loginPage.login(ConfigReader.getValidUsername(), "");
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
        loginPage.login("a", ConfigReader.getValidPassword());
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with password include 1 character")
    public void testOneCharPassword() {
        loginPage.login(ConfigReader.getValidUsername(), "a");
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with username include 255 characters")
    public void test255CharsUsername() {
        loginPage.login(ConfigReader.getString255(), ConfigReader.getValidPassword());
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with password include 255 characters")
    public void test255CharsPassword() {
        loginPage.login(ConfigReader.getValidUsername(), ConfigReader.getString255());
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with username include 256 characters")
    public void test256CharsUsername() {
        loginPage.login(ConfigReader.getString256(), ConfigReader.getValidPassword());
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @Test(description = "Test login with password include 256 characters")
    public void test256CharsPassword() {
        loginPage.login(ConfigReader.getValidUsername(), ConfigReader.getString256());
        Assert.assertTrue(loginPage.isErrorMessageDisplay(), "Error message does not display");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
