# viewing my orders
Feature: my orders

  Scenario: succesful viewing the orders
    Given the user is on the mainpage
    When the user clicks my orders
    Then the user will be navigated to the myOrdersPage
