package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Step 1 — Go to website and login
        loginPage.loginAs("standard_user", "secret_sauce");

        // Step 2 — Verify we reached Products page
        String title = productsPage.getPageTitle();
        Assert.assertEquals(title, "Products", "Login failed!");

        System.out.println("✅ Valid Login Test PASSED");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        // Step 1 — Try login with wrong password
        loginPage.loginAs("standard_user", "wrongpassword");

        // Step 2 — Verify error message appears
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"),
                "Error message not shown!");

        System.out.println("✅ Invalid Login Test PASSED");
    }
}