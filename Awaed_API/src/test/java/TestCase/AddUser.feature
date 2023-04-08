Feature: Validate Add user API

  Scenario Outline: Verify adding user successfully Using AddUser API
    Given Add user payload with "<firstName>" "<lastName>" "<email>" "<active>"
    When User Call adduser API with POST http request
    Then The API request sent successfully with status code equal 20
    And  firstName in response body is "<firstName>"
    And  verify that UserID created with "<firstName>" was sent Using GetUserAPI



Examples:
    |firstName |lastName|email|active|
    |shorouk    |Fayez   |Test |true|
