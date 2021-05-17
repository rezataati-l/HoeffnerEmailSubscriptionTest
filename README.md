# HoeffnerEmailSubscriptionTest

This is the test project for Hoeffner Email subscription task. To set up the project you need to install Eclipse for Java developer and download Firefox, Selenium files (including web driver for firefox), and Cucumber files. Also, JUnit5 has been used in this project and the library should be added. Based on the style of test scenario description I decided to go for the BDD technique.
The below link helps you prepare tools to run the test.

https://www.guru99.com/using-cucumber-selenium.html

If you wish, you can use the required external jar files that I put in the jar_files folder of the repository.



## Optional 1

It's better to have negative scenarios in which a subscription must be failed. 

#### Positive scenario:
1- Subscribe with a valid email address and confirm it.

2- Unsubscribe a previously subscribed email address.

#### Negative scenarios:
3- Trying to subscribe (click the "Absenden" button) when the email address is already subscribed.

4- Trying to subscribe when the email box is empty.

5- Trying to subscribe when the email box is filled with a wrong formatted email address.

Assuming we have three testing phases: Acceptance testing, System testing, Regression testing, I recommend all scenarios to be tested in system testing, and scenarios number 1,2,3 to be tested in acceptance and regression testing. According to this recommendation, I only automate the ones that are in regression testing.
