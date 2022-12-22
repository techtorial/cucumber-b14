Feature: Testing the Registration of New User

  Scenario: Happy Path Of Registration
    Given User navigates to the AutomationExercise and validates the title 'TITLE'
    When User clicks signUp Login button and validates the 'New User Signup!' visible
    And User provides username 'username' and email adress 'emailadress' and click sign up button
    And User verify 'ENTER ACCOUNT INFORMATION' message is visible
    And User provides Title 'title', Name, Email,Password 'Password', Date of Birth 'Date of birth'
    And User selects Sign up for our newsletter! and Receive special offers from our partners!
    And User provides 'First name', 'Last name', 'Company', 'Address', 'Address2', 'Country', 'State', 'City, 'Zipcode', 'Mobile Number'
    Then User clicks Create Account button and validates 'ACCOUNT CREATED!'
    And User clicks Continue Button and validate Logged in as username
    Then User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
    And User clicks continue button






