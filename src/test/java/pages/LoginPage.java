package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Locators — these tell Selenium WHERE each element is on the page
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton   = By.id("login-button");
    By errorMessage  = By.cssSelector("[data-test='error']");

    // Constructor — receives the driver from BaseTest
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions — what we can DO on the login page
    public void goTo() {
        driver.get("https://www.saucedemo.com");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void loginAs(String username, String password) {
        goTo();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}