Feature: login

  Scenario: validation on login credential.
    Given browser has been launch
    And It should redirect to https://www.saucedemo.com/.
    When pass standard_user as value in username field.
    And pass secret_sauce as value in password field.
    And Click on login button
    Then login is successfully
