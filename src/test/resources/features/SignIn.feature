Feature: Sign In Feature

	@test @Regression @SignIn
  Scenario: Verify user can sign in into Retail Application
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'lenazavila@gmail.com' and password 'Qerty5432!'
    And User click on login button
    Then User should be logged in into Account
