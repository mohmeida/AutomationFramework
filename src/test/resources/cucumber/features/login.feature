@LoginPage @Run
Feature: Login to System

  Background:
    Given Launch Portal

  Scenario: User is able to login to system with valid credentials
    Given User Logins to system with below data:
      | useremail | user_id         |
      | password  | portal_password |
    When verifies user was able to successfully login



