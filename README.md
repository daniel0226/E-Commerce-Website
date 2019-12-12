# eCommerce Movie Website
An eCommerce movie booking website created for Software Engineering at UGA. Movies, Showtimes, and prices are based on the administrator database. Currently meant to be used with Tomcat 9.0 servers and Eclipse.

## Installation
### Required Technologies
Eclipse for Java EE Developers or add in the Java EE portion
* [Eclipse for Java EE Developers](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/photonr)
Apache Tomcat Download
* [Apache Tomcat 9.0](https://tomcat.apache.org/download-90.cgi)
* [Adding Tomcat to Eclipse:](https://stackoverflow.com/questions/8046871/how-to-add-tomcat-server-in-eclipse)

### Validate Java EE Installed
You can validate if you have Java EE by going to File -> New -> Other and search for Dynamic Web Project<br>
If you don't have Java EE installed, ask Seth for more info because managed to install just the plugin. It should be in the Eclipse Marketplace under the name Maven Java EE for Luna or something similar.

### Need Valid database installed.
To test the website, please contact me for the MySQL databases. The movies displayed, showtimes, seatings, users, administrators, and other key functionalities are dependent on the databases.

### What I would do different
The project was developed with scrum methodology. The user stories were first generated. Based on the user stories, the user interface and database was then created using HTML/CSS/Bootstrap/MySQL/MySQLWorkbench. Next, using the Model-View-Controller pattern, the functionalities were then generated for each user story.

If I could redo this project, 
1) I would add more identification or unique keys to each database table For example, rather than connecting a user's cord by email in the database, the user's card would be correlated by a unique key. <br/>
2) Next, rather than creating a static Database and session class, I would implement the singleton pattern as singleton is more flexible. <br/>
3) A lot of the models generated would be through a factory method. There was a lot of models generated that made reading the code messy. This could have been simplified. <br/>
4) Reduce the number of functions within utilities or queries. The database.java class has a lot of functions that have repeated code/functions that could have been simplified. <br/>
5) Increase cohesion. There were some java classes that had functions that didn't belong within the class. Organizing the cohesion would have increased readability and maintainability.
