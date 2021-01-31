Feature: DEMO ONLINE SHOP


Scenario Outline: Customer navigation between different categories: Phones, Laptop and Monitors
    Given Open the browser and hit the URL "https://www.demoblaze.com/index.html"
    When customer click and navigates to "<category>"
    Then customer should navigate to "<product>"

    Examples: 
      | category | product           |
      | Phones   | Samsung galaxy s6 |
      | Laptops  | Sony vaio i5       |
      | Monitors | Apple monitor 24  |

      
Scenario: Check purchase amount should be equals to expected amount
    Given Open the browser and hits the URL "https://www.demoblaze.com/index.html"
    When customer clicks and navigates to "Laptops"
    And Add the first product "Sony vaio i5" to cart
    And Add the second product "Dell i7 8gb" to cart
    And Delete added product "Dell i7 8gb" from cart
    And Click on Place order
    And Fill all the required details
    And Click on Purchase to Complete the order
    And Capture the log purchase Id and Amount.
    Then Check Order amount should be equal to product price
    And Click on Ok