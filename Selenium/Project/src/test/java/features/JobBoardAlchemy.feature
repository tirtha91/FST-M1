Feature: JobBoard Alchemy website activities

  @activity
  Scenario Outline: Activity 1 - Verify the website title
    Given User opens the Alchemy website
    And User verifies the title "<websiteTitle>" of the Website

    Examples:
      | websiteTitle                          |
      | Alchemy Jobs – Job Board Application  |

  @activity
  Scenario Outline: Activity 2 - Verify the website heading
    Given User opens the Alchemy website
    And User verifies the heading "<websiteHeading>" of the Website

    Examples:
      | websiteHeading          |
      | Welcome to Alchemy Jobs |

  @activity
  Scenario: Activity 3 - Get the URL of the header image
    Given User opens the Alchemy website
    And User gets the URL of the header image

  @activity
  Scenario Outline: Activity 4 - Verify the website's second heading
    Given User opens the Alchemy website
    And User verifies the second heading "<websiteSecondHeading>" of the Website

    Examples:
      | websiteSecondHeading |
      | Quia quis non        |

  @activity
  Scenario Outline: Activity 5 - Navigate to the Job page
    Given User opens the Alchemy website
    Then User navigates to the job page
    And User verifies the title "<pageTitle>" of the Job page

    Examples:
      | pageTitle           |
      | Jobs – Alchemy Jobs |

  @activity
  Scenario Outline: Activity 6 - Apply to a Job
    Given User opens the Alchemy website
    Then User navigates to the job page
    And User verifies the title "<pageTitle>" of the Job page
    Then User search for the job with keyword "<JobSearchKeyword>"
    And User opens one of the job listed
    When User applies for that opened job
    Then User prints the email to the console

    Examples:
      | pageTitle           | JobSearchKeyword |
      | Jobs – Alchemy Jobs | SDET             |

  @activity7
  Scenario Outline: Activity 7 - Create a new job listing
    Given User opens the Alchemy website
    Then User navigates to the Post job page
    And User needs to sign in with "<Username>" and "<Password>"
    And User fills up JobPosting form with "<JobTitle>" "<Location>" and "<Description>"
    Then User clicks on Submit Listing button
    And User verifies that Job listing with "<JobTitle>" and "<Description>" has been listed successfully

    Examples:
      | Username | Password | JobTitle  | Location  | Description                               |
      | root     | pa$$w0rd | SDET III  | Hyderabad | Need SDET resource for Automation testing |

  @activity8
  Scenario Outline: Activity 8 - Login to the website's backend
    Given User opens the Alchemy website backend
    And User signs in with admin "<Username>" and "<Password>"
    And User verifies the title "<websiteTitle>" of the Website

    Examples:
      | Username | Password | websiteTitle                            |
      | root     | pa$$w0rd | Dashboard ‹ Alchemy Jobs — WordPress    |

  @activity9
  Scenario Outline: Activity 9 - Create a job listing using the backend
    Given User opens the Alchemy website backend
    And User signs in with admin "<Username>" and "<Password>"
    And User verifies the title "<websiteTitle>" of the Website
    Then User clicks on Job Listings from menu item and clicks on Add new
    And we scroll down through the web page to fill job data


    Examples:
      | Username | Password | websiteTitle                            |
      | root     | pa$$w0rd | Dashboard ‹ Alchemy Jobs — WordPress    |