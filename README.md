# JAVA TDD Demo
This repository showcases typical concepts and implementation of TDD in Java.

## Dependencies
Below is a list of testing frameworks used for this POC.

- JUnit - Testing suite
- AssertJ - Assertion library
- Mockito - Mocking Library
- Google Guice - Dependency Injection (IOC)

## Vital Points

1. Mocking is utilized for the following classes because we want to focus on its internal wirings and not on logic inside it's dependencies.

- [Input Collection](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/test/java/com/achilles/utilities/InputCollectionTest.java) 
- [Tax Domain Service](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/test/java/com/achilles/domain/TaxDomainServiceTest.java)

2. Spying is implemented through the use of counter on input collection to simulate different input from end-users. This helps to control test environment and not rely on end-user involvement on test executions.

- [Input Collection](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/test/java/com/achilles/utilities/InputCollectionTest.java) 

3. Composition root is not tested. We did not test App.java because most of the logic inside it is offloaded to lower level aggregates.

- [App.java](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/main/java/com/achilles/App.java)

4. Exception throwing testing is implemented to check if IOC mappings are working properly.

- [ModuleBootTesting](https://github.com/allanchua101/java-tdd-demo/blob/master/taxmanager/src/test/java/com/achilles/ioc/ModuleBootTest.java)
