Feature: User API

  Scenario: CRUD User

    Given I want to create a new user
    When I send a "POST" request to "/api/user.json" with body
    """
    {
      "Email": "pustehamla@gufum.com",
      "FullName": "Robert Sylosis",
      "Password": "1234567"
    }
    """
    Then the response status should be 200
    And the "ID" should be save in the "userId" variable
    When I sent a "PUT" request to "/users/{userId}" with body
    """
    {
      "FullName: "Robert Sylosis Sepultura",
    }
    """
    Then the response status should be 200
    """
    {
      "FullName: "Robert Sylosis Sepultura",
    }
    """
    Then the response status should be 200
    And the "FullName" should be "Robert Sylosis Sepultura"
    When I send a "GET" request to "/users/{userId}"
    Then the response status should be 200
    When I send a "DELETE" request to "/users/{userId}"
    Then the response status should be 200