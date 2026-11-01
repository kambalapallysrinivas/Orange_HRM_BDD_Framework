Feature: Admin Login
As an admin,I can able to login to admin and do employee registration
Scenario: Verify admin login with valid credentials
Given I open browser and enter url as "http://orangehrm.qedgetech.com/"
Then I see Admin Login page with page title as "OrangeHRM"
When I enter usernames as "admin"
And  I enter password as "Qedge123!@#"
And  I click on login button
Then I  see admin dashboard with "Admin" Module link
When I click on logout button
Then I see Admin Login page with page title as "OrangeHRM"
