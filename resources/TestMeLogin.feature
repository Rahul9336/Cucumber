 Feature: TestMe Login Check
  Scenario Outline: Login Page Check
    Given User must be on Login Page
    When User enter the Username "<username>" and Password "<password>"
    Then User Must Land on Home Page with Sigout Link is Enabled

    Examples: 
      | username  | password |
      | lalitha | Password123 |
      |AlexUser|alex123|
