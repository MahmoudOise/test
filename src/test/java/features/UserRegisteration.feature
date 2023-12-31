Feature: User Registration
     I want to check that the user can register in out e-commerce website.
     
     Scenario Outline:
 : User Registration
     Given the user in the home page
     When user click on register link
     And user entered "<firstname>" ,"<lastname>" , "<email>" , "<password>"
     Then the registration page displayed successfully 

     Examples:
      |firstname|lastname|email           |password |
      |amr      |mohamed |amr@gmail.com   |12345687 |
      |ali      |karim   |ali234@gmail.com|127845687|