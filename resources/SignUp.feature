Feature: Case Study Evaluation
  Using TestMe application

  @Register
  Scenario: Registration
    Given User Must Not be already Register with application
    And user must be on SignUp Page
    When User enter the username "rahul987"
    And User enter the first name "Rahul" and last name "Gupta"
    And User enter the password "Rahul987" and confirm password "Rahul987"
    And User choose the Gender as "Male"
    And User Enter the Email "rahul9867@gmail.com"
    And User Enter the Mobile Number "9856956956"
    And User Choose the DOB from date picker "17/09/1997"
    And User Enter the Address "GateWay Office Chennai 600039"
    And User Choose the Security Question "What is your Birth Place"
    And User Enter the Security Answer "Param"
    And User click on Register
    Then User must be navigate to Login Page
    And Message will be Displayed "User Registered Succesfully!!! Please login"

