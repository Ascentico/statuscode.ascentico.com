Feature: Calling the REST API for an individual HTTP status code
  As a user
  I want obtain status code information on an individual HTTP status code
  So that I can use the information within my software

  Scenario: User makes a request for valid HTTP status code information
    When a user makes a HTTP GET for valid HTTP Status Code 226
    Then the user should see 226 in the response

  Scenario: User makes a request for invalid HTTP status code information
    When a user makes a HTTP GET for invalid HTTP Status Code 99
    Then the user should see a HTTP 404 response