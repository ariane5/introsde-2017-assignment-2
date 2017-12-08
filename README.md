# introsde-2017-assignment-2

# identification
Student: Wambo Ariane

E-Mail: ariane [dot] wambometuedjo [at] studenti [dot] unitn [dot] it

Course: Introduction to Service Design and Engineering
Project Structure

# project
The server project consist on one database:lifecoach.sqlite and rest services.

the database contains the following tables :
- activity:the list of activities(sport, social, school...)
- activity_type:the histories of activities :for any activity we have the desciption,the place and the startdate of the activity
- person: they are described by an Id, firstname, lastname and birthdate
- activitypreference: the preference of each person.

the project is divided in the following packages:

introsde.rest.ehealth.dao: it contains the LifeCoachDao (Data Access Object) class responsible of the data storing management, it provides an abstract interface to the database. 

introsde.rest.ehealth.model: it contains the all classes describing our application models, their behavior, their methods and their (JPA) annotations. 

introsde.rest.ehealth.resources : it contains all the rest services.

The task are all the tasks required by the assignment2 from 1 to 10

# Execution
 To compile all the project:
  
  ant compile
 
 To execute the server I call :
 
  ant start
    
 On heroku I first call :https://assign21.herokuapp.com/sdelab/DataBase_init to initialise the database
 then I go on with https://assign21.herokuapp.com/sdelab/person

