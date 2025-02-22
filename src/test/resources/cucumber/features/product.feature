@ProductPage
Feature: Product Page

  Background:
    Given Launch Portal
    Given User Logins to system with below data:
      | useremail | user_id         |
      | password  | portal_password |

  Scenario: Verify product names are displayed
    Given I fetch the product names
#    Then I should see the product names in the output
