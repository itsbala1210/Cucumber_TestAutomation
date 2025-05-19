Feature: OrangeHRM Admin Functionality

  @OrangeHrm
  Scenario Outline: Verify user data management in the admin site
    Given user launch url in the browser "<Url>"
    When user enter username "<Username>" and password "<Password>"
    And user click on login button
    Then verify title of the page
    And selects the admin tab in dashboard
    Then user click add button in admin page
    When user selects the user role "<UserRole>"
    Given enters the employee name "<EmployeeName>"
    Then selects the status "<Status>"
    And user sends the username "<AddUsername>"
    Then sends the password "<UserPassword>" and confirm password "<UserPassword>"
    And user click on save button
    And selects the admin tab in dashboard
    And user sends the username "<AddUsername>"
    When user selects the user role "<UserRole>"
    Given enters the employee name "<EmployeeName>"
    Then selects the status "<Status>"
    And user click on search button in admin page
    Then user verify user data "<AddUsername>" in admin page
    And takes a verified screenshot in page
    Then user deletes a user data

    Examples:
      | Url      | Username       | Password       | UserRole | EmployeeName  | Status  | AddUsername     | UserPassword |
      | Base_Url | Admin_Username | Admin_Password | Admin    | James  Butler | Enabled | Test Automation | Test@12345   |
