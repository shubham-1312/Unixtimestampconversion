@Regression
Feature: Validating Unix Timestamp Conversion API

@Positive1
Scenario: Verify if API is working with Correct Unix TimeStamp
	Given UnixTimestamp Conversion API
	When user enters the UnixTimeStamp as "1549892280"
	Then the API Convert it into user readable format as "{"Datetime":"2019-02-11 13:38:00"}"
	And resoponse code is "200"

@Negative1
Scenario: Verify if API throwing error message on wrong unix timestamp entry
    Given UnixTimestamp Conversion API
    When user enters the UnixTimeStamp in wrong format like "154A989228"
    Then the API response throws error message saying "{"Error":"UnixTimeService.RESTHost.fromunixtimestamp.TryCatch.Try.UnixTimeStamp: Input string was not in a correct format."}"
    And resoponse code is "400"
