#navigate to the amazon
  #Search for iphone 14 pro max case
  #Validate the result contains 20000
  #Validate the all headers contain "iphone 14"
  Feature: Testing the Search Functionality of Amazon
    Scenario: Testing the Happy Path results for Iphone 14 Pro Max Case
      Given User navigates to the Amazon
      When User searches for 'Iphone 14 Pro Max Case' on Amazon
      Then User validates the result contains 20000
      And User validates all header contains 'iphone 14'

