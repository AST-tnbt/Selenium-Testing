package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(tagName = "button")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }

    public boolean isErrorMessageDisplay() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("flash")
            ));
            return error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
