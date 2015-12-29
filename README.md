[![Build Status](https://travis-ci.org/probablyirina/personaltrainer.svg?branch=master)](https://travis-ci.org/probablyirina/personaltrainer)

## Personal trainer
Spring Boot/Data/Security, REST, Maven, Hibernate, Flyway, Grunt, Bower, Knockout, Requirejs app integrated with [Travis CI](https://travis-ci.org/) and deployed on [Heroku](https://www.heroku.com/) cloud.

###Backend setup of the project
You will need Java 7 or 8 installed. The project has been developed and tested on Linux; it might work on Windows but you are on your own. Install [Git] (https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) and [Maven](https://maven.apache.org/).
Clone this repository:  
```git clone https://github.com/probablyirina/personaltrainer```  
and then cd to *personaltrainer*.

###Front-end setup
Install Node.js by following instructions from [here](https://nodejs.org/en/download/).  
You will get Node package manager (npm).
Install [Bower](http://bower.io/) globally:  
```npm install -g bower```  
Instal [Grunt](http://gruntjs.com/) command-line interface globally:  
```npm install -g grunt-cli```   
Note: do not install bower and grunt with sudo. Change directory privileges if any problems occur.
Front-end build is using Grunt and has been integrated with Maven by using [grunt-maven-plugin] (https://github.com/allegro/grunt-maven-plugin). Front-end sources are located in [*src/main/java/webapp/static*](https://github.com/probablyirina/personaltrainer/tree/master/src/main/webapp/static) dir.
Grunt creates [*node_modules*](https://github.com/probablyirina/personaltrainer/tree/master/src/main/webapp/static/node_modules) dir. [*package.json*](https://github.com/probablyirina/personaltrainer/blob/master/src/main/webapp/static/package.json) defines all Grunt modules that are used for Grunt tasks.  
Bower dependencies are defined in [*bower.json*](https://github.com/probablyirina/personaltrainer/blob/master/src/main/webapp/static/bower.json). Bower install will create *lib* directory under *js*. The location of the directory with dependencies (bower configuration) is defined in [.bowerrc](https://github.com/probablyirina/personaltrainer/blob/development/web/.bowerrc) file.  

###Travis CI integration
The setup for Travis is in [*.travis.yml](https://github.com/probablyirina/personaltrainer/blob/master/.travis.yml) file. Whenever something is committed to the master branch, Travis runs the tests and automatically deploys a successful build to Heroku.

###How to build the project
To build Maven project structure, run  
```mvn test```  
To clean *target* and *target-grunt* directories with build artifacts, run  
```mvn clean```
To create war to be deployed on Heroku, run
```mvn package```

###How to run the project locally
From project root directory run  
```mvn spring-boot:run```  
You should see the app running at *localhost:8181*. If you want to change server port, you can find the setting in [application.properties] (https://github.com/probablyirina/personaltrainer/blob/master/src/main/resources/application.properties). 
