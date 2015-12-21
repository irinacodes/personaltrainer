## Personal trainer
Spring Boot/Data/Security, REST, Maven, Flyway, Grunt, Bower, Knockout, Requirejs app

###How to setup the project
You will need Linux and Java installed. Install [Git] (https://git-scm.com/book/en/v2/Getting-Started-Installing-Git), Maven, and some IDE (preferably [Intellij IDEA](https://www.jetbrains.com/idea/)).
Clone this repository:  
```git clone https://github.com/probablyirina/personaltrainer```  
and then cd to *personaltrainer*.

###How to bootstrap front-end setup
Install Node.js by following instructions from [here](https://nodejs.org/en/download/).  
You will get Node package manager (npm).
Install bower globally:  
```npm install -g bower```  
Instal Grunt command-line interface globally:  
```npm install -g grunt-cli```   
Next, cd into *web* dir and run  
```npm install grunt```  
to install Grunt in the working dir. It will create *node_modules* dir under *web*.  
File *package.json* defines all Grunt modules that are used for Grunt tasks.  
Next, run  
```npm install grunt-auto-install```    
```npm install load-grunt-tasks```    
to install a plugin that will automatically install Grunt modules and bower dependencies defined in *package.json* and *bower.json* files, respectively.
Bower install will create *lib* directory under *js*, with all js dependencies defined in *bower.json* file.   
The location of the directory with dependencies (bower configuration) is defined in *.bowerrc* file.  
Finally, run  
```grunt auto_install```  
and you are all set!

###How to run the project
To copy the front-end to *src/webapp* folder of the Maven project structure, run  
```grunt copy```  
Then, cd .. to get out of the *web* dir, and run  
```mvn spring-boot:run```  
You should see the app running at *localhost:8181*. If you want to change server port, you can find the setting in [application.properties] (https://github.com/probablyirina/personaltrainer/blob/master/src/main/resources/application.properties). 
