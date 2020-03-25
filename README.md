# Project Title 
   ### TestLeaf Selenium Contest 

# Project Description
  This project contains an automated test script of ServiceNow problem ticket creation flow.
  
# Tools and Technology
  Project is created with:
* Selenium with Java for UI automation and writting business logics
* Maven for build control
* Applied BDD approach with Cucumber
* Cucumber extent report to generate test reports
* Log4j to generate logs 
* Git for version control

# Project Location
 Please clone https://github.com/iamKrishnendu/TestLeaf.git using  ```git clone ``` command using git bash to get this project in your local



# Project Dependensies
 * JDK should be installed (created on version 13.0.1)
 * Maven should be install (create on version 3.6.2)
 * Developed on Windows 10 platform 
 * To check installed jdk version run command ```java --version``` from command prompt
 * To check maven version run command ```mvn --version ``` from command prompt
 
 # Project Setup
 * First take a clone of this repository (repository link and command mentioned above)
 * Go to the project location and launch command prompt (for windows) 
 * Type command ```mvn install``` 
 
 # Reporting
   Once execution is completed, go to root directory and open a folder called ```Test-Report``` and open the latest folder created with current date and time instance
  
 # Test Artifacts
   Problem ticket number is stored under ```data.json``` place under ```target-->cucumber-report```
   
 #Screenshot
   In case test execution is failed, screenshot of the failed step will be available under ```root directory --> Screenshot
