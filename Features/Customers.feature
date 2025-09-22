Feature: Customer

Background: Below are common steps for every scenario
   Given User Launch Chrome Browser
   When  User opens URL "https://admin-demo.nopcommerce.com/login"
   And   User enters Email as "admin@yourstore.com" and Password as "admin"
   And   User click Login button
   Then  User can view Dashboard page
   
@Sanity   
Scenario: Add a new customer
   When User click on Customers Menu 
   And  User click on Customer Menu item
   And  Click on add new button
   Then User can view add new Customers page
   And  User enter customers info
   And  Click on Save button
   Then User can view confirmation message "The new customer has been added successfully."
   And  Close browser
   
@regression   
Scenario: Search  Customer By Email ID
   When User click on Customers Menu 
   And  User click on Customer Menu item
   And  User enter customer Email
   When User click on search button
   Then User should found Email in the search table
   And  Close browser
   
@regression   
Scenario: Search Customer By FirstName and LastName
    When User click on Customers Menu 
    And  User click on Customer Menu item
    And  User enter FirstName
    And  User enter LastName
    When User click on search button
    Then User should found Name in the search table
    And  Close browser
    
    
    
    
    
    
    
    


   
   