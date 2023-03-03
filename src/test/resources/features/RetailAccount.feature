Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'test@yandex.ru' and password 'Qwert5432!'
    And User click on login button
    And User should be logged in into Account
	
	@LabSession
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'El Zav' and Phone '1231234581'
    And User click on Update button
    Then User profile information should be updated
    And User Name is 'El Zav' and Phone is '1231234581'
