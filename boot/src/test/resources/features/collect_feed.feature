Feature: Collect Feed
  The event provided will contain all the information needed

  Scenario: Collect new information from an RSS feed
    Given an URI related with an external RSS feed
    When the collecting process is init
    Then the created items are stored