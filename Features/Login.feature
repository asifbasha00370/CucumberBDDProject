Feature: Login
   

@Sanity 
Scenario: Succesful Login with the credentials
     Given User Launch Chrome Browser
     When  User opens URL "https://admin-demo.nopcommerce.com/login"
     And   User enters Emasil as "admin@yourstore.com" and Password as "admin"
     And   User click Login button
     Then  Page Title should be "Dashboard / nopCommerce administration"
     When  User click on Logout link
     Then  Page Title should be "You store. Login"
     And   Close browser
     
@regression
 Scenario Outline: Successful login with the valid Credentails DDT
     Given User Launch Chrome Browser
     When  User opens URL "https://admin-demo.nopcommerce.com/login"
     And   User enters Email as "<email>" and Password as "<password>"
     And   User click Login button
     Then  Page Title should be "Dashboard / nopCommerce administration"
     When  User click on Logout link
     Then  Page Title should be "You store. Login"
     And   Close browser
       
 Examples:
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|admin|


