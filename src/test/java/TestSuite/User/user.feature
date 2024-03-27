Feature: User

  Background:
    Given url "https://petstore.swagger.io/v2"
    And print "--Connect petstore API--"


  Scenario: Creates list of user
    Given request [{id: 110, username: "estiarista", firstName: "Esti", lastName: "Arista", email: "estiarista@gmail.com", password: "3571esti", phone: "0877753453627", userStatus: 0}]
    When url "https://petstore.swagger.io/v2/user/createWithList"
    When method post
    Then print response
    And status 200


  Scenario: Get User by user name
    When url "https://petstore.swagger.io/v2/user/estiarista"
    When method get
    Then print response
    And status 200


  Scenario: Updated user
  #  * def reqUsername = "estiarista1234"
    * def reqBody = {id: 110, username: "estiarista", firstName: "Esti", lastName: "Arista Cantik", email: "estiarista@gmail.com", password: "3571esti", phone: "0877753453627", userStatus: 0}
    When url "https://petstore.swagger.io/v2/user/estiarista"
    And request reqBody
    When method put
  #  And request reqUsername
    Then print response
    And status 200


  Scenario: Delete User
    When url "https://petstore.swagger.io/v2/user/estiarista"
    When method delete
    Then print response
    And status 200


  Scenario: Get to logs user into the system
    * def reqUsername = "estiarista"
    * def reqPass = "3571esti"
    When url "https://petstore.swagger.io/v2/user/login"
    When method get
    And request reqUsername
    And request reqPass
    Then print response
    And status 200


  Scenario: Get to logs out current logged in user session
    When url "https://petstore.swagger.io/v2/user/logout"
    When method get
    Then print response
    And status 200


  Scenario: Creates list of user
    Given request [{id: 111, username: "estiarista", firstName: "Esti", lastName: "Arista", email: "estiarista@gmail.com", password: "3571esti", phone: "0877753453627", userStatus: 0}]
    When url "https://petstore.swagger.io/v2/user/createWithArray"
    When method post
    Then print response
    And status 200


  Scenario: Creates user
    Given request {id: 112, username: "estiarista", firstName: "Esti", lastName: "Arista", email: "estiarista@gmail.com", password: "3571esti", phone: "0877753453627", userStatus: 0}
    When url "https://petstore.swagger.io/v2/user"
    When method post
    Then print response
    And status 200