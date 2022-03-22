@SecondFeature
Feature: This is to test the second playwright script

  Scenario: verify the opening and navigation of amazon website in second thread
    Given application is loaded in browser
    Then click on the header links
    And close the browser