Feature: OrangeHRM Login Validation

@SmokeTest
Scenario Outline: Log into the Orange HRM Website

Given User opens the OrangeHRM website
When User provides his "<UserID>" and "<Password>"
Then User should logs into the website
And User verifies the landing page

Examples:
| UserID | Password  |
| Admin  | admin123  |

@SmokeTest
Scenario: Log into the Orange HRM Website with Datatable

Given User opens the OrangeHRM website
And User provides his credentails in Datatable format
	| UserID | Password |
	| Admin  | admin123 |
Then User should logs into the website
And User verifies the landing page