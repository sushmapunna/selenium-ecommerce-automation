package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Step 1 — Login
        loginPage.loginAs("standard_user", "secret_sauce");

        // Step 2 — Add product to cart
        productsPage.addFirstProductToCart();

        // Step 3 — Verify cart count shows 1
        String cartCount = productsPage.getCartCount();
        Assert.assertEquals(cartCount, "1", "Cart count is wrong!");

        System.out.println("✅ Add to Cart Test PASSED");
    }

    @Test
    public void checkoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Step 1 — Login
        loginPage.loginAs("standard_user", "secret_sauce");

        // Step 2 — Add product and go to cart
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        // Step 3 — Verify item is in cart
        String itemName = cartPage.getCartItemName();
        Assert.assertTrue(itemName.contains("Backpack"), "Item not in cart!");

        // Step 4 — Checkout
        cartPage.clickCheckout();
        cartPage.fillShippingDetails("Arjun", "Reddy", "500001");
        cartPage.clickContinue();
        cartPage.clickFinish();

        // Step 5 — Verify order confirmation
        String confirmation = cartPage.getConfirmationMessage();
        Assert.assertEquals(confirmation, "Thank you for your order!",
                "Order not placed!");

        System.out.println("✅ Checkout Test PASSED");
    }
}