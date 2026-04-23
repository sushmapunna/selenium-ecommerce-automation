package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By checkoutBtn      = By.id("checkout");
    By cartItem         = By.className("inventory_item_name");
    By firstNameField   = By.id("first-name");
    By lastNameField    = By.id("last-name");
    By postalCodeField  = By.id("postal-code");
    By continueBtn      = By.id("continue");
    By finishBtn        = By.id("finish");
    By confirmationText = By.className("complete-header");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        // Wait up to 10 seconds for elements to appear
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Get item name in cart
    public String getCartItemName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        return driver.findElement(cartItem).getText();
    }

    // Click checkout button
    public void clickCheckout() {
        try { Thread.sleep(2000); } catch (Exception e) {}
        driver.findElement(checkoutBtn).click();
    }

    // Fill shipping details
    public void fillShippingDetails(String firstName, String lastName, String postal) {
        try { Thread.sleep(2000); } catch (Exception e) {}
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postal);
    }

    // Click continue
    public void clickContinue() {
        try { Thread.sleep(2000); } catch (Exception e) {}
        driver.findElement(continueBtn).click();
    }

    // Click finish
    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        driver.findElement(finishBtn).click();
    }

    // Get order confirmation message
    public String getConfirmationMessage() {
        wait.until(ExpectedConditions
                  .visibilityOfElementLocated(confirmationText));
        return driver.findElement(confirmationText).getText();
    }
}