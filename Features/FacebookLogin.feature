Feature: FacebookLogin
 
 Scenario Outline: Successful login with the valid Credentails DDT
 
  Given User Launch Chrome Browser 
  When  User opens URL "https://www.facebook.com/"
  And   User enters Email as "<email>" and Password as "<password>"
  And   User click on Login
  Then  User can view "Welcome to Facebook, Asif"
  When  User can click logout link
  Then  User can view "facebook Recent logins"
  And   User close the browser
  
 Examples:
|email|password|
|asifbasha00370@gmail.com|arshtaha@123|
|asifbasha@gmail.com|arshtaha@123|