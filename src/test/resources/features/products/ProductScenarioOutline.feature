@regression
Feature: Validation of Product

  Scenario Outline: Validation of New Product Creation
    Given User navigates to product homepage and click order Button
    When User enters the product information '<product>' and '<quantity>'
    And User enters the address information '<name>','<street>','<city>','<zip>'
    And User enters the payment information '<cardType>','<cardNumber>','<expireDate>' and click process button
    Then User validates the message '<message>'
    And User validates all the information '<name>','<product>','<quantity>','<street>','<city>','<zip>','<cardType>','<cardNumber>','<expireDate>'
    Examples:
      | product     | quantity | name  | street         | city    | zip   | cardType         | cardNumber  | expireDate | message                                |
      | MyMoney     | 4        | Ahmet | Mount-Prospect | Chicago | 60123 | Visa             | 12312312313 | 06/21      | New order has been successfully added. |
      | FamilyAlbum | 7        | Ahmet | Mount-Prospect | Chicago | 60123 | MasterCard       | 12312312313 | 06/24      | New order has been successfully added. |
      | ScreenSaver | 11       | Ahmet | Mount-Prospect | Chicago | 60123 | American Express | 12312313454 | 06/27      | New order has been successfully added. |
