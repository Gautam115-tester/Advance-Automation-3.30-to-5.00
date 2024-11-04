Feature: MultiLogin

  Scenario Outline: Verify the functionality of login page.
    Given Browser has been launch And redircted to https://www.saucedemo.com/
    When Pass "<username>" as a value in username field And pass "<password>" as a value in password field.
    Then then click on login button And User should be logout After clicking on logout button.

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
