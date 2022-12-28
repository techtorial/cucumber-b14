Feature: Testing Search Functionality of Etsy Search Bar Scenario Outline

  Scenario Outline: Validation Title of Etsy Search for Hat
    Given User navigates to '<url>'
    When User searches for '<key>' in Etsy webpage
    Then User validates the title '<title>' from etsy
    Examples:
      | url                   | key | title      |
      | https://www.etsy.com/ | Hat | Hat - Etsy |
      | https://www.etsy.com/ | Key | Key - Etsy |
      | https://www.etsy.com/ | Pin | Pin - Etsy |

