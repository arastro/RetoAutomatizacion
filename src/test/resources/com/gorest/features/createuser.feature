#Author: Ivan Dario Florez Guerrero
Feature: Create an user on Gorest REST service

  @createAUser
  Scenario Outline: Creation an user
    When I try to create an user
      |<email>|<name>|<lastname>|<gender>|<token>|
    Then I should see the user created
      |<email>|<name>|<lastname>|<gender>|
    Examples:
      |email           |name   |lastname |gender|token                                  |
      |sarahez29@sh.com|miria29|sdfsdf   |female|FXXZ3Kxb8cA8NbjRpqvsxChkmQNk0vYsflfv   |