Feature: Testing Search Functionality of Etsy Search Bar

  Scenario: Validation Title of Etsy Search for Hat
    Given User navigates to 'https://www.etsy.com/'
    When User searches for 'Hat' in Etsy webpage
    Then User validates the title 'Hat - Etsy' from etsy

  Scenario: Validation Title of Etsy Search for Hat
    Given User navigates to 'https://www.etsy.com/'
    When User searches for 'Key' in Etsy webpage
    Then User validates the title 'Key - Etsy' from etsy

  Scenario: Validation Title of Etsy Search for Hat
    Given User navigates to 'https://www.etsy.com/'
    When User searches for 'Pin' in Etsy webpage
    Then User validates the title 'Pin - Etsy' from etsy
