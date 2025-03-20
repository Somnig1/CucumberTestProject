package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MyStepdefsBuyBooks {

    WebDriver driver = new ChromeDriver();
    private WebDriverWait wait;

    @Given("I am on the books page")
    public void iAmOnTheBooksPage() {
        // Navigate to the books page on the Demo Webshop
        driver.get("https://demowebshop.tricentis.com/books");
    }

    @When("I search for {string}")
    public void iSearchFor(String bookTitle) {
        // Find the search box and enter the book title
        WebElement book = driver.findElement(By.cssSelector("a[href='/computing-and-internet'"));
        book.click();
    }

    @When("I add the book to the cart")
    public void iAddTheBookToTheCart() {

        // Add the book to the cart by clicking the "Add to cart" button
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button-13"));
        addToCartButton.click();
    }

    @When("I go to the checkout page")
    public void iGoToTheCheckoutPage() {
        // Go to the cart page
        WebElement cartButton = driver.findElement(By.className("cart-label"));
        cartButton.click();

        WebElement termsOfService = driver.findElement(By.id("termsofservice"));
        termsOfService.click();

        // Proceed to checkout
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement guest = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button-1.checkout-as-guest-button")));
        guest.click();
    }

    @And("I go through the entire purchase process {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iGoThroughTheEntirePurchaseProcess(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15) {

    }

    @And("I select {string}")
    public void iSelect(String paymentMethod) {


    }

    @And("I select In-Store Pickup")
    public void iSelectInStorePickup() {
        driver.findElement(By.id("PickUpInStore")).click();
    }


    @Then("I should see the order confirmation page")
    public void iShouldSeeTheOrderConfirmationPage() {
        // Check if the order confirmation page is displayed
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Your order has been successfully processed!"));
    }

    @Then("the order should contain {string}")
    public void theOrderShouldContain(String bookTitle) {
        // Verify that the book is present in the order summary
        WebElement orderSummary = driver.findElement(By.className("order-summary"));
        assertTrue(orderSummary.getText().contains(bookTitle));
    }


}
