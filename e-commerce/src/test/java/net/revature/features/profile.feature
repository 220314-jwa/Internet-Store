# updating a user profile
Feature: user update

  Scenario: succesful update
    Given the user is on the profilepage
    When the user changes the  username
    And the user clicks the update button
    Then the user will see a update message
    
  Scenario: unsuccesful update
  	Given the user is on the profilepage
  	When the user changes the  username to existing username
    And the user clicks the update button
    Then the user will see a UserExisting  message