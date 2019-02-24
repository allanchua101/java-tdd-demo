# JAVA TDD Demo
This repository showcases typical concepts and implementation of TDD in Java.

## Code Coverage

![Code Coverage](https://github.com/allanchua101/java-tdd-demo/blob/master/results/test%20results.png)

## Dependencies
Below is a list of testing frameworks used for this POC.

- JUnit - Testing suite
- AssertJ - Assertion library
- Mockito - Mocking Library
- Google Guice - Dependency Injection (IOC)

## Vital Points

1. Mocking is utilised for the following classes to focus on their internal wirings and not on logic inside its dependencies.

- [Input Collection](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/test/java/com/achilles/utilities/InputCollectionTest.java) 
- [Tax Domain Service](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/test/java/com/achilles/domain/TaxDomainServiceTest.java)

2. Spying is implemented through the use of counter on input collection class to understand how many times did it run. This helps on indentifying which simulated output is going to be returned to prevent manual capturing of data from end-users.

- [Input Collection](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/test/java/com/achilles/utilities/InputCollectionTest.java) 

3. Composition root (App.java) is not tested because most of the logic inside it is offloaded to lower level aggregates.

- [App.java](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/main/java/com/achilles/App.java)

4. Exception throwing test is implemented to check if IOC mappings are working properly.

- [ModuleBootTesting](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/test/java/com/achilles/ioc/ModuleBootTest.java)

5. Context reset of spy related fields is implemented on [InputCollection.java](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/test/java/com/achilles/utilities/InputCollectionTest.java) class. Thanks to **@After** annotation from JUnit.

6. [ConsoleScanner](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/main/java/com/achilles/utilities/ConsoleScanner.java) is not tested since it requires manual user interaction to be validated.

### Improvement Points

- **Hardcoded values** - Some of the values associated with tax calculation are hardcoded for the sake of brevitity of the testing showcase. 
- **Data stores** could have been used to load data from a persistent data store to ease configuration of software. (EG. Tax Brackets + Tax Reliefs). This was intentionally done to simplify of testing.
