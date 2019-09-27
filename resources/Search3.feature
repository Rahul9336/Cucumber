Feature: search Box test
@Positive
Scenario: Positive Test
Given User Must Login with TestMe
When User Click on Search Box
And User Enter the four letter "Head"
And User click  on the dropdown suggestion "Headphone"
And Click on link Find Details
And User click on "Add to cart" button
And Cart Value is Updated and Visible
And User click on Cart Button
Then User Must be on CheckOut page and Proceed with Payment gateway

@Negative1
Scenario: Neagtive Test-Search Box Suggestion
Given User Must Login with TestMe
When User Click on Search Box
And User Enter the four letter "gajs"
And Application does not show any Suggestion
Then User Must be on Same page and  Test Terminated