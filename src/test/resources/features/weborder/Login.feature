Feature: Testing Login Functionality of WebOrder Page

  Background: User navigates to page
     Given User navigates to WebOrder Page

  Scenario: Testing positive Login(correct username and correct password)
   # Given User navigates to WebOrder Page
    When User provides username 'guest1@microworks.com' and password 'Guest1!' for WebOrder
    Then User validates the title 'ORDER DETAILS - Weborder' from homepage

    Scenario: Testing negative Login(Correct username and wrong password)
     # Given User navigates to WebOrder Page
      When User provides username 'guest1@microworks.com' and password 'Ahmet' for WebOrder
      Then User validates the error message 'Sign in Failed'

      Scenario: Testing negative Login(Wrong username and wrong password)
      #  Given User navigates to WebOrder Page
        When User provides username 'guest134@microworks.com' and password 'Ahmetsdf' for WebOrder
        Then User validates the error message 'Sign in Failed'
