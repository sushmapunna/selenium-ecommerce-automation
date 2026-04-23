package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    // Locators
    By checkoutBtn       = By.id("checkout");
    By cartItem          = By.className("inventory_item_name");
    By firstNameField    = By.id("first-name");
    By lastNameField     = By.id("last-name");
    By postalCodeField   = By.id("postal-code");
    By continueBtn       = By.id("continue");
    By finishBtn         = By.id("finish");
    By confirmationText  = By.className("complete-header");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get item name in cart
    public String getCartItemName() {
        return driver.findElement(cartItem).getText();
    }

    // Click checkout button
    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    // Fill shipping details
    public void fillShippingDetails(String firstName, String lastName, String postal) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postal);
    }

    // Click continue
    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    // Click finish
    public void clickFinish() {
        try { Thread.sleep(2000); } catch (Exception e) {}
        driver.findElement(finishBtn).click();
    }

    // Get order confirmation message
    public String getConfirmationMessage() {
        return driver.findElement(confirmationText).getText();
    }
}