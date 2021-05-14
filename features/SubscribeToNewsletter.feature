Feature: Subscribe to the newsletter

  Scenario: Get confirmation of subscription
    Given A Hoeffner login page [https://www.hoeffner.de/login]
    When I open a page
    Then I can see a newsletter subscription input
    When I enter my email in the input field
    And I press Absenden button
    Then I can see a confirmation message that my subscription is in progress

