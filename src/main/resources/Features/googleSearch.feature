Feature: Google Search

  @test
  Scenario: Perform a Google Search
    Given user open the Google website
    When user enters search phrase in the search bar and submit search
    Then user should see search results
    And user clicks on first nonad result
   And user should see the page with the initial search phrase

