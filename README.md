
# Unix epoch time conversion to human readable format API Automation Test Suite

This test suite consists of test cases for Unix epoch time conversion API


## Documentation
The API Test suite is written in Cucumber BDD framework using Java as a programming language.

Features and Scenarios are present inside feature file. Tests are categorized based on the tags-> 

## Usage/Examples

```javascript
@Regression
Feature: Validating Unix Timestamp Conversion API

@Positive1
Scenario: Verify if API is working with Correct Unix TimeStamp
	Given UnixTimestamp Conversion API
	When user enters the UnixTimeStamp as "1549892280"
	Then the API Convert it into user readable format as "{"Datetime":"2019-02-11 13:38:00"}"
	And resoponse code is "200"
```


## Run Locally using commad line

Pre- requisite -> 
* Java should be installed in the system
* Maven should be installed in the system


Clone the project

```bash
  git clone https://github.com/shubham-1312/Unixtimestampconversion.git
```

Go to the project directory

```bash
  cd my-project
```

Run all tests in one go using Maven Test

```bash
  mvn test
```

You can also run individual test cases using Tags 

```bash
  mvn test -Dcucumber.options="-t @Positive1"
```


