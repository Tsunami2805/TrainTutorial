Feature: Buy individual tickets
  In order to save time at the station
  As a casual traveller
  I want to be able to buy train tickets online


  Scenario: Lucy wants to travel from London City to Newark Liberty for a festival
  Tracy prefers low cost tickets to flexibility or arriving at a specific time.
  She isn't sure when she will return, so she wants to keep her options open.

    Given that Lucy has decided to check available tickets
    When she looks at a trip from London City to Newark Liberty leaving tomorrow on First
    Then she should be shown the cheapest cheapest ticket price from London City to Newark Liberty