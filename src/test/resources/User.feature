Feature: User API

  Scenario: CRUD User

    Given I have access to todo.ly to create a user
    When I send a "POST" request to "/api/user.json" with body
    """
    {
      "Email": "5996gentle@navalcadets.com",
      "FullName": "Robert Sylosis",
      "Password": "1234567"
    }
    """
    Then the response status should be 200
    And the "Id" should be save in the "userId" variable
    When I sent a "PUT" request to "/api/user/userId.json" with body
    """
    {
      "FullName": "Robert Sylosis Sepultura"
    }
    """
    Then the response status should be 200
    When I send a "DELETE" request to "/api/user/userId.json"
    Then the response status should be 200

