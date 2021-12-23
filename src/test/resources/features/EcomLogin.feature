Feature: Ecommerce tests

  @login @smoketest @regression
  Scenario: Happy path login test
    When user logs in with valid name
    Then user should see list of items