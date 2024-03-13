package TestCase;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertTrue;

public class GetProduct extends BaseTest {
    @Test(priority = 1)
    @Description("Assert Price")
    public void getPrice() throws InterruptedException {
        // Tes dan Assert harga Smarthphone Samsung Galaxy s6
        WebElement phonesCat = driver.get().findElement(By.xpath("//a[.='Phones']"));
        phonesCat.click();
        Thread.sleep(2000);
        WebElement samsung = driver.get().findElement(By.xpath("//a[.='Samsung galaxy s6']"));
        samsung.click();

        //Assert or validate price
        WebElement price = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='price-container']")));
        Assert.assertTrue(price.getText().contains("$360"));
    }

    @Test(priority = 2)
    @Description("Test Description: Sign Up functionality check.")
    public void testSignUp() {
        driver.get().findElement(By.xpath("//a[.='Sign up']")).click();
        explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        driver.get().findElement(By.id("sign-username")).sendKeys("Fuy");
        driver.get().findElement(By.id("sign-password")).sendKeys("hohoho123");
        driver.get().findElement(By.xpath("//button[.='Sign up']")).click();
        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Sign up successful.") || alertMessage.equals("This user already exist."), "Alert message was not as expected: " + alertMessage);
        alert.accept();
    }

    @Test(priority = 3)
    @Description("Test Description: Product Added to Cart check")
    public void testAddCart() throws InterruptedException {

        try {
            // Navigate to the "Laptops" category
            WebElement laptopCat = driver.get().findElement(By.xpath("//a[.='Laptops']"));
            laptopCat.click();
            Thread.sleep(2000);

            // Select the first laptop listed in the category
            WebElement firstLaptop = driver.get().findElement(By.xpath("(//a[@class='hrefch'])[1]"));
            firstLaptop.click();
            Thread.sleep(2000);

            // Click on the "Add to cart" button
            WebElement addCart = driver.get().findElement(By.xpath("//a[.='Add to cart']"));
            addCart.click();

            // //Assert or validate alert message "Product added"
            Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
            String alertMessage = alert.getText();
            Assert.assertTrue(alertMessage.equals("Product added"));
            alert.accept();
            Thread.sleep(2000);

            // Navigate to the "Cart" page
            WebElement cartLink = driver.get().findElement(By.xpath("//a[@id='cartur']"));
            cartLink.click();
            Thread.sleep(2000);

            // Validate that the added laptop appears in the cart
            WebElement productInCart = driver.get().findElement(By.xpath("//td[.='Sony vaio i5']"));
            assertTrue("Product not found in the cart", productInCart.isDisplayed());

            // Ensure the test checks for the presence of the product name in the cart items
            assertTrue("Product name not found in the cart items", productInCart.getText().contains("Sony vaio i5"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}