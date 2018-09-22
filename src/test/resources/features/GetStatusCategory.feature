Feature: Calling the REST API for a HTTP status code category
  As a user
  I want obtain status code information on all HTTP status codes within a category
  So that I can use the information within my software

  Scenario: User makes a request for a valid category of HTTP status codes
    When a user makes a HTTP get for the valid HTTP status code category 200
    Then the user should see 10 responses

  Scenario: User makes a request for an invalid category of HTTP status codes
    When a user makes a HTTP get for the invalid status code category 900
    Then the user should see a HTTP 404 repsonse