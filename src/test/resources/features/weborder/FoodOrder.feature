Feature: WebOrder page Food Order Functionality

  Background:
    Given User navigates to WebOrder and login successfully
    And User validates the title 'ORDER DETAILS - Weborder' from order page
    When User clicks Group Order Box and Next button
    And User sends the word 'I love Cucumber' for note to invitees section
    And User sends e-mail address which are 'ahmet@gmail.com' and 'berkay@gmail.com' to Invite List

  Scenario: Testing the happy path food order for My House
    And User chooses the delivery address 'My House' and validates the address '3137 Laguna Street'
    And User clicks the create Group order button
    Then User validates the header of page is 'View Group Order'

  Scenario: Testing the happy path food order for Office
    And User chooses the delivery address 'Office' and validates the address '2012 EMPIRE BLVD'
    And User clicks the create Group order button
    Then User validates the header of page is 'View Group Order'

