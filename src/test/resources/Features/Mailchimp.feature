Feature: Mail Chimp test
  In order to sign upp different users i want everything to run smooth.

  @mytag


    Scenario Outline: Sign up account
      Given I have entered my "<mailadress>"
      Given I have also entered a "<username>"
      And I have also selected a "<password>"
      When I press sign up
      Then the "<result>" should be on the screen for "<username>"
      Examples:
        | mailadress |username|password|result|
        |mail|newusername|Losenord123!|   Check your email|
        | mail|Longname|Losenord123!|  Enter a value less than 100 characters long|
        |mail |      Davuserexists  |          Losenord123!  |        Another user with this username already exists. Maybe it's your evil twin. Spooky.|
        |     |    noemail    |       Losenord123!     |         Please enter a value|