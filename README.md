To Do:
-fix admin bounded context, create student --> unable to enter more than one word 
-when admin is updating course, if they dont enter quotes around a string field i.e. 'yash', the update will fail. Don't want this



# Course-Registration-System

## Setting up the REGIE Database
1. Log into MySQL through command line filling in appropriate username and password fields: $ mysql -u 'username' -p 'password'
2. Enter password
3. Create a database named REGIE: mysql> CREATE DATABASE regie;
4. use the database: mysql> USE regie;
5. confirm using regie: mysql> select database() from dual;
6. run the sql script to create and populate tables: mysql> source /......./src/main/db/createTables.sql
7. In .../src/main/db/DatabaseConnection.java, line 13, change user and password strings to whatever your MySQL username and password are

## SOLID Principles

For the single responsibility principle, instead of listing out every single class and its responsibility, I will point out particular use case where I had to deliberately focus my attention on using SRP: when a student wants to register for a course. The Student class is only responsible for what a student can do - which restricts the student to initiating the request to add a course. Since the student cannot actually add a course by themselves, the classes handling registration are used in the registration bounded context (interactions happen thorugh the StudentRegistration class). The StudentRegistration class delegates registration out to appropriate classes. Since browsing courses is a single, relatively stable (in my opinion), piece of code, I didn't create a class for it and just included it in StudentRegistration. CourseAddDrop performs actually performs course modification for students including relevant checks. The actual interaction with the database, however, is delegated out to various data access layers, in particular, the StudentsCoursesDataAccessLayer. 

I use the open-close principle and avoid violating the Liskov Substitution Principle by separating out the data access layers for each table. An early implementation I was considering was to separate out operations on each table into different classes. However, there would be common code (actually interacting with the database in a well-defined manner i.e. CRUD) that should be closed for modification. Additionally, it turns out that every table would benefit from having access to each of these operations. So I separated out generic CRUD interactions into DataAccessLayer and extended table-specific data access layers that would handle relevant use cases needed by classes. Now any additional use case would go in the subclass DAL and not touch the core CRUD operations. Since each table is capable of using all CRUD operations, and not a subset, the implementation does not violate LSP either. 

I am using interfaces to allow admin to manipulate the status of students, courses, and faculty. I created two interfaces, Modifiable (Student, Course, Faculty), and Modifier (the respective data access layers for each). The interfaces allow admin to make modifications to the three modifiables without actually knowing what they are modifying. If there is a new modifiable/modifier pair that comes up that admin may need to manipulate, the classes can implement the interfaces. Here, admin is not able to call methods on the data access layers that are not relevant to creating/updating/or deleting modifiable classes. This is an example of obeying the interface segregation principle. 

I am still in the process of incorporating dependency inversion in my code, and I intend to make it more widespread. For now, a deliberate example is in the text-based drivers. Instead of instantiating an object of the Student class in the driver or delegated classes, I remove the dependency by passing a student. Now, the driver class is only dependent on the interface of the student, instead of the actual implementation of the constructor. I'm planning on actually instantiating the student in the authentication bounded context (will be implemented last). 



## Patterns

The database connection is a singleton, since only one instance is needed throughout the code. A builder is used to instantiate student, course, and faculty. This is useful because when admin need to create a new student, they need to have all information pertaining to the student. However, when a student logs in and just needs to drop a course, only the ID is needed (primary key) for database manipulation. Additionally, I am using the facade pattern to control access to the Registration bounded context. 