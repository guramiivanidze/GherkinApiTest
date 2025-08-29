Feature: User API Testing with reqres.in
  As a tester
  I want to test CRUD operations on users
  So that I can validate API responses

  Scenario: Create a new user
    Given I set POST endpoint for user
    When I send POST request with name "John" and job "QA"
    Then I receive valid status code 201
    And Response should contain name "John" and job "QA"

  Scenario: Get a list of users
    Given I set GET endpoint for users
    When I send GET request
    Then I receive valid status code 200
    And Response should contain "data"

  Scenario: Update an existing user
    Given I set PUT endpoint for user with id 2
    When I send PUT request with name "Mike" and job "Developer"
    Then I receive valid status code 200
    And Response should contain updated name "Mike" and job "Developer"

  Scenario: Delete a user
    Given I set DELETE endpoint for user with id 2
    When I send DELETE request
    Then I receive valid status code 204
