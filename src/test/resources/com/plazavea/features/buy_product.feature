#Author: Ivan Dario Florez Guerrero
Feature: As a plazaewa customer I want to buy a product on the website

  @buyAproduct
  Scenario: buy a product using the search engine
    Given That Ivan is located on the Plazavea website
    When He try to buy a product
    |Televisor SAMSUNG LED 49" FHD Smart TV 49J5290AGXPE|
    Then He Verify that the product was added in the payment page
    |Televisor SAMSUNG LED 49" FHD Smart TV 49J5290AGXPE|