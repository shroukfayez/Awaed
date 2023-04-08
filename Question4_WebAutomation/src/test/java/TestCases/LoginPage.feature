Feature: User try Login Function


  Scenario: Validate login function with invalid username and password
    Given User open testu website
    When User send invalid username and password
    And Click on Login Button
    Then Verify error message appeared

