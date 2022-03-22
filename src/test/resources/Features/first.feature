@FirstFeature
Feature: This is to test the first playwright script

  Scenario: verify the opening and navigation of amazon website
    Given application is loaded in browser
    Then click on the header links
    And close the browser