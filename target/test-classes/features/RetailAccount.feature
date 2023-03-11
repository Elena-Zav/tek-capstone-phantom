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

  @Regression @Account @payment @addPayment @removeCard
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard   | expirationMonth | expirationYear | securityCode |
      | 1111222233330777 | Elena Zavila |               3 |           2026 |          888 |
    And User click on 'Add Your card' button
    Then a message should be displayed ‘Payment Method added successfully’

  @Regression @Account @payment @editCard
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And User edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1111222233339666 | An Ni      |               5 |           2028 |          123 |
    And User click on 'Update Your Card' button
    Then a message should be displayed ‘Payment Method updated Successfully‘

  @Regression @Account @payment @removeCard
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed
