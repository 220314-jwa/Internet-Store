Feature: user login

  Scenario: succesful login
    Given the user is on the loginpage
    When the user enters the correct username
    And the user enters the correct password
    And the user clicks the login button
    Then the nav will show the user's first name
