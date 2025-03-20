package stepDefinitions;

import ToDoList.TodoList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MyStepdefsToDoList {

   private TodoList todoList;

    @Given("the user has an empty to-do list")
    public void theUserHasAnEmptyToDoList() {
        todoList = new TodoList();
        assertNotNull(todoList);
    }

    @When("the user adds a task with the description {string}")
    public void theUserAddsATaskWithTheDescription(String description) {
        todoList.addTask(description);
    }

    @Then("the to-do list should contain one task")
    public void theToDoListShouldContainOneTask() {
        assertEquals(1, todoList.getNbrOfTasks());
    }

    @And("the task {string} should not be marked as completed")
    public void theTaskShouldNotBeMarkedAsCompleted(String description) {
        boolean taskFoundAndNotCompleted = false;
        for (int i = 0; i < todoList.getNbrOfTasks(); i++) {
            if (todoList.getTasks().get(i).getDescription().contains(description) &&
                    !todoList.getTasks().get(i).isCompleted()) {
                taskFoundAndNotCompleted = true;
                break;
            }
        }
        assertTrue(taskFoundAndNotCompleted);
    }

    @Given("the user has a to-do list with the task {string}")
    public void theUserHasAToDoListWithTheTask(String description) {
        todoList = new TodoList();
        todoList.addTask(description);
    }

    @When("the user marks the task {string} as finished")
    public void theUserMarksTheTaskAsFinished(String description) {
        for (int i = 0; i < todoList.getNbrOfTasks(); i++) {
            if (todoList.getTasks().get(i).getDescription().contains(description)) {
                todoList.completeTask(i);
                break;
            }
        }
    }

    @Then("the task {string} should be marked as completed")
    public void theTaskShouldBeMarkedAsCompleted(String description) {
        boolean taskFoundAndCompleted = false;
        for (int i = 0; i < todoList.getNbrOfTasks(); i++) {
            if (todoList.getTasks().get(i).getDescription().contains(description) &&
                    todoList.getTasks().get(i).isCompleted()) {
                taskFoundAndCompleted = true;
                break;
            }
        }
        assertTrue(taskFoundAndCompleted);
    }

    @And("the task status should show {string}")
    public void theTaskStatusShouldShow(String expectedStatus) {
        boolean statusMatches = false;
        for (int i = 0; i < todoList.getNbrOfTasks(); i++) {
            if (todoList.getTasks().get(i).getDescription().contains(expectedStatus)) {
                statusMatches = true;
                break;
            }
        }
        assertTrue(statusMatches);
    }


}
