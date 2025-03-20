Feature: ToDoList

  Scenario: Add new task to the to-do list
    Given the user has an empty to-do list
    When the user adds a task with the description "Buy milk"
    Then the to-do list should contain one task
    And the task "Buy milk" should not be marked as completed

  Scenario: Mark a task as finished
    Given the user has a to-do list with the task "Buy milk"
    When the user marks the task "Buy milk" as finished
    Then the task "Buy milk" should be marked as completed
    And the task status should show "[X] Buy milk"