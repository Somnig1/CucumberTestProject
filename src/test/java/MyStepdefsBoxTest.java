import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MyStepdefsBoxTest {

    private WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    @Given("I am on the dynamic page")
    public void iAmOnTheDynamicPage() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    }

    @When("I click the add button")
    public void iClickTheAddButton() {
        driver.findElement(By.id("adder")).click();
    }

    @Then("a new box should appear")
    public void aNewBoxShouldAppear() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box0")));


    }

    @When("I reveal the box and enter text")
    public void iRevealTheBoxAndEnterText() {
        driver.findElement(By.id("reveal")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));
        driver.findElement(By.id("revealed")).click();
        driver.findElement(By.id("revealed")).sendKeys("Box test");
        driver.findElement(By.id("revealed")).sendKeys(Keys.ENTER);
    }

    @Then("the text should be entered and submitted successfully")
    public void theTextShouldBeEnteredAndSubmittedSuccessfully() {
        driver.findElement(By.cssSelector("body")).click();
    }
}
