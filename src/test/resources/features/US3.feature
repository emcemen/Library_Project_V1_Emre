
@wip@db
Feature: As a data consumer, I want UI and DB book categories are match.
  Scenario: verify book categories with DB
    Given user login as a librarian
    When user navigate to "Books" page
    And user take all book categories in UI
    And user execute query to get book categories
    Then verify book categories must match book_categories table from db