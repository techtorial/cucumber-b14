@regression1
Feature: Validation of Product with Data Table

  Scenario: Validation of New Product Creation
    Given User navigates to product homepage and click order Button
    When User enters the product information product and quantity
      | product  | MyMoney |
      | quantity | 4       |
    And User enters the address information name, street, city, zip
      | name   | Ahmet          |
      | street | Mount Prospect |
      | city   | Chicago        |
      | zip    | 60133          |
    And User enters the payment information cardType, cardNumber,expireDate and click process button
      | cardType   | Visa     |
      | cardNumber | 13123123 |
      | expireDate | 06/12    |
    Then User validates the message message
      | New order has been successfully added. |






