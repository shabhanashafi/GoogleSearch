# GoogleSearch
# BDD: Java Maven Cucumber Selenium Setup


Java + Junit + Cucumber + Selenium testing cases

This repo contains the Maven setup for Cucumber / Selenium, with Searching Google with Cheese as example code, which can be run on local or connect to remote SaucsLabs / TestingBot for cross browser testings. Also it can be configured in your CI server (i.e. Bamboo) for continuous testing. It helps to setup a BDD environment for User Acceptance tests.

This repo can be run on local Windows / Mac / Linux Platform, as long as you have Java/Maven setup correctly.

## Setup

### Install on Local Machine

Install Java & Maven on your local machine

= To Run (Maven command line) =Go to Project directory and run below command

```
> mvn test 
```
If you want to run through classfile 
Goto-src/test/java/testRunners/TestRunner.java
and click on play button

# Browser selection 
See README inside /src/main/resources/config folder


# Before we start

## Feature file: Gherkin Syntax
Gherkin is the language that Cucumber understands. 

## Selenium Syntax
Selenium is an automated web browser testing. 

# Configure your project siteUrl

You can update the siteUrl in the pom.xml property (default is http://www.google.com for my example) for your application need, also you can pass in from command line

# Your first BDD Test Case

## Your first feature file
Create a feature file under src\main\resources\Features (You can group your feature in same directory, i.e. GoogleSearch,homepage / contact / products etc)

1. Copy your story / feature description (ideally same as from Jira description, As a site user, I want to ...., So that ...)
2. Under `Scenario Outline:` will contain all the Given / When / Then Gherkin
   You can specify "<keyword>" as parameter from Data Table.
3. Fill in the Data Table for parameters listed in your step 2

The Data Table (even only 1 row) can help you to change the data input in the future and easier to understand the feature testing data. I reserved the use of the PageType / ScreenSize defined in CommonStepDef, so we can have responsive testing ready.

4. Then run the mvn test, it will throw the exception of missing implementation, and it will print out the Java Selenium function you need to implement (for next step)

= Implement the missing Java Scenario Step =
5. Create a java file under src\test\java\myproject (same, you can group as folder as the structure of feature folder)

Copy printed function signatures from last step, and implement the selenium action you want to achieve.

