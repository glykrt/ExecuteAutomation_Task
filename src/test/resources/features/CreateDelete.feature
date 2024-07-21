Feature: As an administrator, I should be able to create a new employee and delete the new employee

  @ready
  Scenario: Create a new employee and delete a new employee
    Given I navigate to website
    When I login as admin
    And I go to the Employee List page
    And I create a new employee with "Sarah" and 60000 and 3 and "Senior" and "sarah_smith021@gmail.com"
    Then Verify new employee information with "Sarah" on the Employee List page
    When I search for the new employee by "Sarah" and delete it.
    Then Verify the new deleted employee with "sarah_smith021@gmail.com" on the Employee List page


