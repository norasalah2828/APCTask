# Welcome to Weather API Automation Test Project

This is a simple Automation Java project using to test the API of getting current weather in specific country, And it uses "Weatherstack" API
for more info about the API please visit [Weatherstack](https://weatherstack.com/?utm_source=any-api&utm_medium=OwnedSites).

## How to install 
***Before you start make sure that you have already installed the following on your machine:***
 1. [Java](https://www.java.com/en/download/manual.jsp) JDK.
 2. [Apache maven](https://maven.apache.org/).
 3. IDE as [**_intellij_**](https://www.jetbrains.com/idea/) or [**_Eclipse_**](https://www.eclipse.org/).
 
***Steps to run the project:***

 1. Click on "Clone" button and copy the link.
 2. Open Intellij IDE and create new project from source control.
 3. Paste the URL which copied and set the path which you want to add your cloned project.
 4. Wait until all dependencies are finishing the setup.
 5. In the project panel click on "APCTask" folder, Then open the path "src/test/java/runner/TestRunner".
 6. Run "TestRunner" class.

***Steps to generate HTML Report:***

 1. Open terminal into your project or in the same path
 2. Write the command "mvn clean verify" and wait until it finish.
 3. Open target folder then open the path "cucumber-report-html"
 4. Right click on html files then choose open in >Browser>Choose any browser.

now cucumber report will be opened on your browser successfully.


## Technologies used in the project
  
 - Cucumber
 - Rest Assured 
 - Maven
 - Junit
