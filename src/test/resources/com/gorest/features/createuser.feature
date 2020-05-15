#Author: Ivan Dario Florez Guerrero
Feature: Create an user on Gorest REST service

  @createAUser
  Scenario Outline: Creation an user
    When I try to create an user
      |<email>|<name>|<lastname>|<gender>|
    Then I should see the user created
      |<email>|<name>|<lastname>|<gender>|
    Examples:
      |email           |name   |lastname |gender|
      |sarahez26@sh.com|miria26|sdfsdf   |female|