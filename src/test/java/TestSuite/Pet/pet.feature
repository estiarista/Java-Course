Feature: Pet Module

  Background:
    Given url "https://petstore.swagger.io/v2"
    And print "--Connect petstore API--"

  Scenario: Add Pet to Store
    * def reqBody = {"id": 100,  "category": {"id": 101, "name": "string"},"name":"doggie","photoUrls": ["string"],"tags": [{"id": 102,"name": "string"}],"status": "available"}
    When url "https://petstore.swagger.io/v2/pet"
    When method post
    And request reqBody
    Then print response
    And status 200

  Scenario: Get Pet
    When url "https://petstore.swagger.io/v2/pet/134340"
    When method get
    Then print response
    And status 200

  Scenario: Get Pet by Status
    When url "https://petstore.swagger.io/v2/pet/findByStatus"
    And params {status:available, status:sold}
    When method get
    Then print response
    And status 200

  Scenario: Delete Pet
    When url "https://petstore.swagger.io/v2/pet/1094770336"
    When method delete
    Then print response
    And status 200

  Scenario: Check Pet after delete
    When url "https://petstore.swagger.io/v2/pet/1094770336"
    When method get
    Then print response
    And status 404