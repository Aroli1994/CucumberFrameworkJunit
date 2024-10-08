Feature: Place the orders for Products in home page
@PlaceOrder
  Scenario Outline: Search and place the orders for products in home page
    Given User is on Greenkart Landing page
    When user searched with shortname <Name> and extracted actual name of product
    And Added "3" items of selected product to cart
    Then User proceeds to checkout and validate the <Name> items in checkout page 
    And verify user has ability to enter promo code and place the order

    Examples: 
      | Name  |
      | Tom   |
      
