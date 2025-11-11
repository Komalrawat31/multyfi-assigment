MultyFi Automation Test Suite
Overview

This project contains Selenium WebDriver automated tests for the MultyFi web application. The test suite covers:

User login with phone number and OTP

Dashboard page verification

History section validation

Viewing historical cards for different segments (Equity, Futures, Options, Commodities, Multibaggers)

Logout functionality

The project uses the Page Object Model (POM) pattern for maintainable and reusable code.

Technology Stack

Java 24

Selenium WebDriver 4.21

TestNG for test execution and assertions

WebDriverManager to manage browser drivers

Maven for build and dependency management

ChromeDriver for browser automation

Project Structure
Assignment/
├── src/main/java/assignment/
│   ├── LoginPage.java          # Contains login page actions
│   ├── DashboardPage.java      # Contains dashboard page actions
├── src/test/java/assignment/
│   ├── LoginFlowTest.java      # Contains test cases for login → dashboard → history → logout
├── pom.xml                     # Maven configuration file
└── README.md                   # Project documentation

Page Object Details
LoginPage.java

enterPhoneNumber(String phone) – Enters the user phone number

clickLoginButton() – Clicks the login button

enterOtp(String otp) – Enters OTP

clickContinueAfterOtp() – Clicks the Continue button (handles stale elements)

DashboardPage.java

isDashboardDisplayed() – Verifies dashboard is loaded

isHistoryVisible() – Verifies History section is visible

viewHistoricalCards(String segment) – Clicks a segment chip, waits for cards, prints content, optionally clicks “view historical trades”

clickLogout() – Logs out the user

Test Flow

Navigate to https://multyfi.com/

Enter phone number and click Login

Enter OTP and click Continue

Verify Dashboard page is displayed

Verify History section is visible

Iterate through all segments: Equity, Futures, Options, Commodities, Multibaggers

Click each segment chip

Wait for historical cards

Print card content

Click view historical trades button if present

Logout




API Testing Postman +Newman
Running Tests with Newman

Export your Postman collection as MultyFi_API_Tests.postman_collection.json

Install Newman (if not already):

npm install -g newman


Run the collection via CLI:

newman run MultyFi_API_Tests.postman_collection.json


Generate reports:

newman run MultyFi_API_Tests.postman_collection.json -r cli,html,json





Performance Testing
MultyFi Performance Testing
Overview

This project contains performance tests for the MultyFi API using k6. The focus is on the historical multibaggers endpoint, testing how it performs under load.

Target Endpoint
GET https://multyfi.com/api/multibaggers/historical

Tool

k6 – Open-source load testing tool

JavaScript – For writing test scripts

Metrics are collected during execution to measure performance and reliability.

Test Scenario

Simulate 50 virtual users (VUs)

Duration: 30 seconds

Collect metrics:

Average response time

P95 latency (95th percentile)

Error rate

Example: http_req_duration < 2000ms



Run the script:

k6 run historical_multibaggers_test.js





Bug Report
Overview

This template helps testers log bugs clearly and consistently for developers to reproduce and fix.

Fields

Title – Short description of the bug

Steps to Reproduce – Numbered steps to trigger the bug

Expected Result – What should happen if the app works correctly

Actual Result – What actually happens

Severity – Impact level: Critical, Major, Minor
