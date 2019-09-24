Feature: Qabify tests
  Scenarios to test QAbify app funcionalities
  
  Scenario: Validate login screen objects
  Given I am at login screen
  Then I validate the login screen objects

  Scenario Outline: Login with invalid user and password
    Given I input login "<login>"
    And I input password "<pass>"
    When I click on "LOGIN" button
    Then The message "User name or Password is not correct" is showed

    Examples: 
      | login | pass |
      |       |      |
      | a     |      |
      |       | a    |
      | a     | a    |

  Scenario Outline: Login with valid user and password
    Given I input login "<login>"
    And I input password "<pass>"
    When I click on "LOGIN" button
    Then The requesting code screen is showed

    Examples: 
      | login           | pass    |
      | user@qabify.com | 1234Abc |


  Scenario: Validate the requesting code screen
  	Given I login the app
  	Then I validate the requesting code screen objects      
  
  Scenario: Validate journey settings screen
  	Given I login the app
  	When I click on "NEXT" button
  	Then I validate the journey settings screen objects
  	
	Scenario: Estimate journey filling no fields
		Given I login the app
		When I click on "NEXT" button
		And I click on "ESTIMATE" button
		Then The message "Captcha typed is wrong" is showed
		
	Scenario: Estimate journey filling captcha field with invalid value		
		Given I login the app
		And I click on "NEXT" button
		And I put the value "9A9" in captcha field
		When I click on "ESTIMATE" button
		Then The message "Captcha typed is wrong" is showed
			
Scenario: Estimate journey without selecting origin and destination	  	
	Given I login the app
	And I save the requesting code
	And I click on "NEXT" button
	And I put the saved requesting code in captcha field
	When I click on "ESTIMATE" button
	Then The message "Select pick up and drop off points" is showed

Scenario: Estimate journey without selecting destination  	
	Given I login the app
	And I save the requesting code
	And I click on "NEXT" button
	And I select the pick up point "Aeropuerto Madrid Barajas, T4"
	And I put the saved requesting code in captcha field
	When I click on "ESTIMATE" button
	Then The message "Select pick up and drop off points" is showed

Scenario: Estimate journey without selecting origin  	
	Given I login the app
	And I save the requesting code
	And I click on "NEXT" button
	And I select the drop off point "Aeropuerto Madrid Barajas, T4"
	And I put the saved requesting code in captcha field
	When I click on "ESTIMATE" button
	Then The message "Select pick up and drop off points" is showed
	
Scenario: Estimate journey selecting both car type options
	Given I login the app
	And I click on "NEXT" button
	When I select the "Executive" car type
	Then The "Lite" car type is unselected

Scenario: Estimate journey selecting both car type options 2
	Given I login the app
	And I click on "NEXT" button
	And I unselect all car type options
	When I select the "Lite" car type
	Then The "Executive" car type is unselected
	
Scenario: Drop off point must have be different from pick up point
	Given I login the app
	And I save the requesting code
	And I click on "NEXT" button
	And I select the pick up point "Calle Pradillo, 42"	
	And I select the drop off point "Calle Pradillo, 42"
	And I put the saved requesting code in captcha field
	When I click on "ESTIMATE" button
	Then The message "Select different origin and destination points" is showed
	
Scenario: Estimating journey successfully
	Given I login the app
	And I save the requesting code
	And I click on "NEXT" button
	And I select the pick up point "Aeropuerto Madrid Barajas, T4"	
	And I select the drop off point "Calle Pradillo, 42"
	And I select the "Lite" car type
	And I put the saved requesting code in captcha field
	When I click on "ESTIMATE" button
	Then The estimated price is "15.6 €"
	And the REQUEST CAR button is showed
	And the REQUEST CAR button is enabled
	
Scenario: Requesting car
	Given I login the app
	And I save the requesting code
	And I click on "NEXT" button
	And I select the pick up point "Aeropuerto Madrid Barajas, T4"	
	And I select the drop off point "Calle Pradillo, 42"
	And I unselect all car type options
	And I select the "Executive" car type
	And I put the saved requesting code in captcha field
	And I click on "ESTIMATE" button
	And I save the estimated price
	When I click on "REQUEST CAR" button
	Then The last journey title must be "Aeropuerto Madrid Barajas, T4 - Calle Pradillo, 42"
	And The last journey price must be "17.16 €"