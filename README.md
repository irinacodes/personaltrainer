[![Build Status](https://travis-ci.org/probablyirina/personaltrainer.svg?branch=master)](https://travis-ci.org/probablyirina/personaltrainer)

## Personal trainer
Spring Boot/Data/Security, REST, Maven, Hibernate, Flyway, Grunt, Bower, Knockout, Requirejs app integrated with [Travis CI](https://travis-ci.org/) and deployed on [Heroku](https://www.heroku.com/) cloud.

###Project setup
You will need Java 7 installed; the project has been developed and tested on Linux; it might work on Windows but you are on your own. Install [Git] (https://git-scm.com/book/en/v2/Getting-Started-Installing-Git), [Maven](https://maven.apache.org/), and [npm](https://www.npmjs.com/) .
Clone this repository:  
```git clone https://github.com/probablyirina/personaltrainer```  
and then cd to *personaltrainer*.
Project has separate frontend and backend builds integrated by using [grunt-maven-plugin] (https://github.com/allegro/grunt-maven-plugin). Front-end sources are located under [WEB-INF](https://github.com/probablyirina/personaltrainer/tree/master/src/main/webapp/WEB-INF) dir.
[*package.json*](https://github.com/probablyirina/personaltrainer/blob/master/package.json) defines all Grunt modules. Bower dependencies are defined in [*bower.json*](https://github.com/probablyirina/personaltrainer/blob/master/bower.json).
Grunt and Bower are installed locally during Maven build; you will see that Grunt created *node_modules*, while Bower added bower_components dirs in project root. The setup for cloud continuous integration is in [*.travis.yml](https://github.com/probablyirina/personaltrainer/blob/master/.travis.yml) file. Whenever something is committed to the master branch, Travis runs the tests and automatically deploys a successful build to Heroku.

###How to build and run the project
In development, the Spring Boot project is run by running  
```mvn spring-boot:run```  
from the project dir, which runs the app extracted rather than from WAR. You should see the app running at *localhost:8181*. If you want to change server port, you can find the setting in [application.properties] (https://github.com/probablyirina/personaltrainer/blob/master/src/main/resources/application.properties). 
