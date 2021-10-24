Feature: Weather API Validation Feature

  Scenario Outline: Check if you can get current weather of existed country
    Given user choose CurrentWeatherAPI with "<accessKey>" and "<country>"
    When user calls GetCurrentWeatherAPI with Get http request
    Then API call will with have status code <status>
    And "<name>" "<type>" "<region>" and "<timezone_id>" will be displayed in response body

    Examples:
      |accessKey|country|name|type|region|timezone_id|status|
      |0dd8ac87d968d5e4ae281c4d34337001|Cairo |Cairo|City|Al Qahirah|Africa/Cairo|200|

    Scenario Outline: Verify that you can't find currentWeather with invalid country
      Given user choose CurrentWeatherAPI with "<accessKey>" and "<country>"
      When user calls GetCurrentWeatherAPI with Get http request
      Then API call will with have status code <status>
      And API response body contains invalid country error details

      Examples:
        |accessKey|country |status|
        |0dd8ac87d968d5e4ae281c4d34337001|invalidCountry |200|

      Scenario Outline: Verify that you can't access current weather with invalid access key
        Given user choose CurrentWeatherAPI with "<accessKey>" and "<country>"
        When user calls GetCurrentWeatherAPI with Get http request
        Then API call will with have status code <status>
        And API response body contains "<invalidAccess>" invalid key error details

        Examples:
          |accessKey|country|invalidAccess|status|
          |invalidAccessKey |Cairo|invalid_access_key|200|

        Scenario Outline: Verify that you can't access current weather without access key
          Given user choose CurrentWeatherAPI with "<accessKey>" and "<country>"
          When user calls GetCurrentWeatherAPI with Get http request
          Then API call will with have status code <status>
          And API response body contains "<invalidAccess>" missing key error details

          Examples:
            |accessKey|country|invalidAccess|status|
            ||Cairo|missing_access_key|200         |

  Scenario Outline: Verify that you can't access current weather without country
    Given user choose CurrentWeatherAPI with "<accessKey>" and "<country>"
    When user calls GetCurrentWeatherAPI with Get http request
    Then API call will with have status code <status>
    And API response body contains "<invalidAccess>" missing query error details

    Examples:
      |accessKey|country|invalidAccess|status|
      |0dd8ac87d968d5e4ae281c4d34337001||missing_query|200|

