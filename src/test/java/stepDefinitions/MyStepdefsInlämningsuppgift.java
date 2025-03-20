package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MyStepdefsInlämningsuppgift {

    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));



    @After
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }

    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @Given("I am on the registration page and the user is using {string}")
    public void iAmOnTheRegistrationPageAndTheUserIsUsing(String browser) {

        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }

        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }


    @When("I enter valid registration details")
    public void iEnterValidRegistrationDetails() {

        driver.findElement(By.id("dp")).sendKeys("14/12/1987");
        driver.findElement(By.id("member_firstname")).sendKeys("Marcus");
        driver.findElement(By.id("member_lastname")).sendKeys("Aurelius");
        driver.findElement(By.id("member_emailaddress")).sendKeys("Marcus.Aurelius@tester.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("Marcus.Aurelius@tester.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Test1234");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Test1234");
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > label")).click();
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div.md-checkbox.margin-top-10 > label")).click();
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(7) > label")).click();

    }

    @And("I submit the registration form")
    public void iSubmitTheRegistrationForm() {

    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {

    }

    @When("I enter registration details with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iEnterRegistrationDetailsWith(String firstName, String lastName, String DOB, String eMail, String confirmEmail, String password, String confirmPassword, String termsAccepted) {

        driver.findElement(By.id("dp")).sendKeys(DOB);
        driver.findElement(By.id("member_firstname")).sendKeys(firstName);
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);
        driver.findElement(By.id("member_emailaddress")).sendKeys(eMail);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);

        if (termsAccepted.equals("Yes")) {

            driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > label")).click();
            driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div.md-checkbox.margin-top-10 > label")).click();
            driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(7) > label")).click();

        }

    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expectedError) {



    }

}
