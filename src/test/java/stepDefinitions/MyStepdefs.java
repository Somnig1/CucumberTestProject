package stepDefinitions;

import common.Calculator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {

    private Calculator calculator;

    @Before
    public void setUp(){
        System.out.println("Performing setup");
    }

    @Given("I have two numbers {double} and {double}")
    public void iHaveTwoNumbersAnd(double first, double second) {

        calculator = new Calculator(first, second);
        System.out.println("I have two numbers");
    }

    @When("I add the two numbers")
    public void iAddTheTwoNumbers() {

        calculator.add();
        System.out.println("Adding numbers");
    }

    @Then("I get the result {double}")
    public void iGetTheResult(double expected) {
        double actual = calculator.getResult();

        System.out.println("And get the result");

        assertEquals(expected, actual, 0.001);
    }

    @When("I subtract the two numbers")
    public void iSubtractTheTwoNumbers() {
        calculator.sub();
        System.out.println("Subtracting numbers");
    }

    @Given("the test case starts with this")
    public void theTestCaseStartsWithThis() {
        System.out.println("Test case starts");
    }

    @And("then something else happens")
    public void thenSomethingElseHappens() {
        System.out.println("Something else happens");
    }

    @After
    public void tearDown(){
        System.out.println("Test case ends");
    }

    @And("I get some text {string}")
    public void iGetSomeText(String text) {
        System.out.println(text);
    }

}
