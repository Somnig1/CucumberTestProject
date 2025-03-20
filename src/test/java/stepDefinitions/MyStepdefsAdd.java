package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;

public class MyStepdefsAdd {


    private WebDriver driver;

    @Given("I have the first number {int}")
    public void iHaveTheFirstNumber(int first) {

        driver = new ChromeDriver();

        driver.get("https://marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");


        driver.findElement(By.className("fc-button-label")).click();


        WebElement field = driver.findElement(By.name("n01"));
        field.sendKeys(Integer.toString(first));
    }

    @And("I have the second number {int}")
    public void iHaveTheSecondNumber(int second) {
        WebElement field = driver.findElement(By.name("n02"));
        field.sendKeys(Integer.toString(second));
    }

    @When("I perform add of the two numbers")
    public void iPerformAddOfTheTwoNumbers() {

        driver.findElement(By.cssSelector("[value='Find Addition']")).click();
    }

    @Then("I receive the result {int}")
    public void iReceiveTheResult(int expected) {
        WebElement field = driver.findElement(By.name("answer"));
        String actual = field.getAttribute("value");

        assertEquals(Integer.toString(expected), actual);

    }
}
