Feature:  Verify the Revenue Calculator

Background: Given User is on the FitPeo Homepage
And User clicks on the Revenue Calculator tab

  Scenario: User navigates to the Revenue Calculator page
    Then User should be redirected to the Revenue Calculator page


  Scenario: User Scroll Down to the Slider
    When User scroll down the page until the revenue calculator slider is visible
    Then User should see the revenue calculator slider


  Scenario: User adjusts the slider and sets its value to 93
    When User adjusts the slider to set its value to 93
    Then User should see the bottom text field value updated to 816
    

Scenario: User updates the text field and the slider value changes accordingly
    When User enters the value 560 in the text field
    Then The slider should update to reflect the value 560


Scenario: User Select CPT Codes
	When User selects the checkboxes for "CPT-99091", "CPT-99453", "CPT-99454", and "CPT-99474"
	Then User should select the checkboxes "CPT-99091", "CPT-99453", "CPT-99454", and "CPT-99474"

	
	
 Scenario: User validates total recurring reimbursement
    When User enters the value 820 in the text field
    When User selects the checkboxes for "CPT-99091", "CPT-99453", "CPT-99454", and "CPT-99474"
    Then The total recurring reimbursement should be validated
    
 
 Scenario: User validates total recurring reimbursement
    When User adjusts the slider to set its value to 93
    When User selects the checkboxes for "CPT-99091", "CPT-99453", "CPT-99454", and "CPT-99474"
    Then The total recurring reimbursement should be match with "$110160" value