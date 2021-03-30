Feature: Mail Chimp test
  In order to sign upp different users i want everything to run smooth.

  @mytag
  Scenario: Sign up account

    Given I have entered my "abc@abc.se"
    Given I have also entered a "abc123"
    And I have also selected a "Abcdefgh123!"
    When I press sign up
    Then the <result> should be on the screen