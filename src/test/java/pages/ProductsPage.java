package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    // Locators
    By pageTitle     = By.className("title");
    By addToCartBtn  = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon      = By.className("shopping_cart_badge");

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Check if we landed on products page after login
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    // Add first product to cart
    public void addFirstProductToCart() {
        driver.findElement(addToCartBtn).click();
    }

    // Get cart count number
    public String getCartCount() {
        return driver.findElement(cartIcon).getText();
    }

    // Go to cart
    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
