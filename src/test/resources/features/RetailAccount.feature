Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'test@yandex.ru' and password 'Qerty12345!'
    And User click on login button
    And User should be logged in into Account

  @Regression @Account @updateProfile
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Ela Zavy' and Phone '2231234583'
    And User click on Update button
    Then User profile information should be updated

  @Regression @Account @updatePassword
  Scenario: Verify User can Update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Qerty123456!     | Qerty12345! | Qerty12345!     |
    And User click on Change Password button
    Then a message should be displayed ‘Password Updated Successfully’

  @Regression @Account @addPayment
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard   | expirationMonth | expirationYear | securityCode |
      | 1111222233334455 | Elena Zavila |               3 |           2025 |          888 |
    And User click on Add your card button
    Then a message should be displayed ‘Payment Method added successfully’
