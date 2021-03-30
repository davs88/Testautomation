Feature: Mail Chimp test
  In order to sign upp different users i want everything to run smooth.

  @mytag


    Scenario Outline: Sign up account
      Given I have entered my "<email>"
      Given I have also entered a "<username>"
      And I have also selected a "<password>"
      When I press sign up
      Then the "<result>" should be on the screen
      Examples:
        | email |username|password|result|
        | mars@mars.se|marsmonth123|Marsmonth1234!|result|