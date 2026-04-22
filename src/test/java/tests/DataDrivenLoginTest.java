package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.BaseTest;
import utils.ExcelReader;

public class DataDrivenLoginTest extends BaseTest {

    // This reads data from Excel and feeds it to the test
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {
        String filePath = System.getProperty("user.dir") 
                        + "\\testdata\\LoginData.xlsx";
        return ExcelReader.getLoginData(filePath);
    }

    // This test runs once for EACH row in Excel
    @Test(dataProvider = "loginData")
    public void dataDriverLoginTest(String username, 
                                    String password, 
                                    String expected) {
        LoginPage loginPage = new LoginPage(driver);

        // Step 1 — Try to login with data from Excel
        loginPage.loginAs(username, password);

        if (expected.equals("success")) {
            // If expected is success — verify Products page loaded
            ProductsPage productsPage = new ProductsPage(driver);
            String title = productsPage.getPageTitle();
            Assert.assertEquals(title, "Products",
                    "Login should have succeeded for: " + username);
            System.out.println("✅ PASSED — " + username 
                             + " logged in successfully");

        } else {
            // If expected is failure — verify error message shown
            String error = loginPage.getErrorMessage();
            Assert.assertFalse(error.isEmpty(),
                    "Error message should appear for: " + username);
            System.out.println("✅ PASSED — " + username 
                             + " correctly rejected");
        }
    }
}