# registering a new user
Feature: user register

  Scenario: succesful register
    Given the user is on the registerpage
    When the user enters the new username
    And the user enters the new password
    And the user enters the address
    And the user enters the phone number
    And the user enters the email
    And the user clicks the register button
    Then the user will be navigated to the loginpage
    
  Scenario: unsuccesful register user exists:
  	Given the user is on the registerpage
  	When the user enters the existing username
  	And the user clicks the register button
  	Then the user will see UserAlreadyExists message
  	

  Scenario: unsuccesful register password is not filled:
  	Given the user is on the registerpage
  	When the user enters the new username
  	And the user enters the empty password
    And the user enters the address
    And the user enters the phone number
    And the user enters the email
    And the user clicks the register button
  	Then the user will see passwordNotFilled message
  	

	Scenario: unsuccesful register address is not filled:
  	Given the user is on the registerpage
  	When the user enters the new username
  	And the user enters the password
    And the user enters the empty address
    And the user enters the phone number
    And the user enters the email
    And the user clicks the register button
  	Then the user will see addressNotFilled message
  	
  Scenario: unsuccesful register email is not filled:
  	Given the user is on the registerpage
  	When the user enters the new username
  	And the user enters the password
    And the user enters the address
    And the user enters the phone number
    And the user enters the empty email
    And the user clicks the register button
  	Then the user will see emailNotFilled message
  	
  Scenario: unsuccesful register phone is not filled:
  	Given the user is on the registerpage
  	When the user enters the new username
  	And the user enters the password
    And the user enters the address
    And the user enters the empty phone number
    And the user enters the  email
    And the user clicks the register button
  	Then the user will see emailNotFilled message
