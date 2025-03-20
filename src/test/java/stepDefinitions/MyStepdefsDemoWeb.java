package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefsDemoWeb {

    WebDriver driver;

    @Given("I am on the Tricentis demowebshop")
    public void iAmOnTheTricentisDemowebshop() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
    }

    @When("I click on {string} in the main menu")
    public void iClickOnInTheMainMenu(String category) {
        WebElement categoryLink = driver.findElement(By.linkText(category));
        categoryLink.click();
    }

    @Then("I should see a list of products on the page")
    public void iShouldSeeAListOfProductsOnThePage() {

        WebElement productGrid = null;
        try {
            productGrid = driver.findElement(By.className("product-grid"));
        } catch (Exception e) {
            try {
                WebElement subCategoryGrid = driver.findElement(By.className("sub-category-grid"));
                Assert.assertTrue("Subkategori grid ska vara synlig", subCategoryGrid.isDisplayed());
            } catch (Exception ex) {
                Assert.fail("Varken product-grid eller sub-category-grid hittades på sidan");
            }
        }

        if (productGrid != null) {
            Assert.assertTrue("Produkter ska vara synliga på sidan", productGrid.isDisplayed());
        }
    }
}
