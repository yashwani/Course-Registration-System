DROP TABLE IF EXISTS Students;

CREATE TABLE Students (student_id int NOT NULL, last_name varchar(255) NOT NULL,
first_name varchar(255), enroll_date varchar(255), isHold boolean, PRIMARY KEY (student_id));

INSERT INTO Students (student_id, last_name, first_name, enroll_date, isHold)
VALUES (10821, 'Spencer', 'Shawn', 2022-02-14, 0);
INSERT INTO Students (student_id, last_name, first_name, enroll_date, isHold)
VALUES (10822, 'Guster', 'Burton', 2022-02-14, 0);
INSERT INTO Students (student_id, last_name, first_name, enroll_date, isHold)
VALUES (10823, 'O Hara', 'Juliet', 2022-02-14,0);
INSERT INTO Students (student_id, last_name, first_name, enroll_date, isHold)
VALUES (10824, 'Lassiter', 'Carlton', 2022-02-14, 1);
INSERT INTO Students (student_id, last_name, first_name, enroll_date, isHold)
VALUES (10825, 'Spencer', 'Henry', 2022-02-14, 0);


DROP TABLE IF EXISTS Courses;
CREATE TABLE Courses (course_id int NOT NULL, course_name varchar(255) NOT NULL,
isOpen boolean NOT NULL, instructor varchar(255) NOT NULL, instructor_permission boolean NOT NULL,
prereq1_id int, prereq2_id int, prereq3_id int, PRIMARY KEY (course_id));

INSERT INTO Courses (course_id, course_name, isOpen, instructor, instructor_permission) VALUES (10000, 'Cloud Computing', 1, 'The Mantis', 0);
INSERT INTO Courses (course_id, course_name, isOpen, instructor, instructor_permission) VALUES (10001, 'Distributed Systems', 1, 'Pierre Despereaux', 0);
INSERT INTO Courses (course_id, course_name, isOpen, instructor, instructor_permission) VALUES (10002, 'Parallel Programming', 0, 'Marlow', 1);
INSERT INTO Courses (course_id, course_name, isOpen, instructor, instructor_permission, prereq1_id, prereq3_id) VALUES (10003, 'Object Oriented Programming', 1, 'Zapato', 0, 10001, 10002);
INSERT INTO Courses (course_id, course_name, isOpen, instructor, instructor_permission) VALUES (10004, 'Java Programming', 1, 'Billy Bob', 1);




DROP TABLE IF EXISTS Courses_Students;
CREATE TABLE Courses_Students (course_id int NOT NULL,
                               student_id int NOT NULL, student_status varchar(255) NOT NULL, PRIMARY KEY(course_id, student_id));

# DROP TABLE IF EXISTS Courses_Students;
# CREATE TABLE Courses_Students (course_id int NOT NULL, course_name varchar(255),
# student_id int NOT NULL, permission_recieved boolean NOT NULL DEFAULT 0 , student_status varchar(255) NOT NULL, PRIMARY KEY(course_id, student_id));

# INSERT INTO Courses_Students(course_id, course_name, student_id, student_status) VALUES (10000, 'Cloud Computing', 10821, 'Enrolled');
# INSERT INTO Courses_Students(course_id, course_name, student_id, student_status) VALUES (10000, 'Cloud Computing', 10823, 'Enrolled');
# INSERT INTO Courses_Students(course_id, course_name, student_id, student_status) VALUES (10000, 'Cloud Computing', 10822, 'Enrolled');
# INSERT INTO Courses_Students(course_id, course_name, student_id, student_status) VALUES (10000, 'Cloud Computing', 10824, 'Enrolled');
# INSERT INTO Courses_Students(course_id, course_name, student_id, student_status) VALUES (10001, 'Cloud Computing', 10824, 'Enrolled');
# INSERT INTO Courses_Students(course_id, course_name, student_id, student_status) VALUES (10002, 'Cloud Computing', 10824, 'Enrolled');
# INSERT INTO Courses_Students(course_id, course_name, student_id, student_status) VALUES (10003, 'Cloud Computing', 10824, 'Enrolled');




DROP TABLE IF EXISTS Grades;
CREATE TABLE Grades (course_id int NOT NULL, student_id int NOT NULL, grade varchar(255), PRIMARY KEY(course_id, student_id));

INSERT INTO Grades(course_id, student_id) VALUES(10000, 10821);
INSERT INTO Grades(course_id, student_id) VALUES(10000, 10823);



DROP TABLE IF EXISTS Faculty;
CREATE TABLE Faculty (faculty_id int NOT NULL, last_name varchar(255) NOT NULL, first_name varchar(255) NOT NULL, email varchar(255), PRIMARY KEY(faculty_id));

INSERT INTO FACULTY (faculty_id, last_name, first_name, email) VALUES (20000, 'Bob','Billy', 'billybob@hotmail.com');
INSERT INTO FACULTY (faculty_id, last_name, first_name, email) VALUES (20001, 'Johnson','Jim', 'jimJohnson@AOL.com');




DROP TABLE IF EXISTS Courses_Faculty;
CREATE TABLE Courses_Faculty(course_id int NOT NULL, faculty_id int NOT NULL);

INSERT INTO Courses_Faculty(course_id, faculty_id) VALUES (10000, 20000);
INSERT INTO Courses_Faculty(course_id, faculty_id) VALUES (10001, 20001);
INSERT INTO Courses_Faculty(course_id, faculty_id) VALUES (10002, 20001);



DROP TABLE IF EXISTS Course_Permission;
CREATE TABLE Course_Permission (course_id int NOT NULL, student_id int NOT NULL, status varchar(255) NOT NULL, PRIMARY KEY(course_id,student_id));

INSERT INTO Course_Permission(course_id, student_id, status) VALUES (10002, 10825, 'GRANTED');
INSERT INTO Course_Permission(course_id, student_id, status) VALUES (10004, 10825, 'DENIED');
INSERT INTO Course_Permission(course_id, student_id, status) VALUES (10002, 10823, 'DENIED');
INSERT INTO Course_Permission(course_id, student_id, status) VALUES (10002, 10824, 'PENDING');
INSERT INTO Course_Permission(course_id, student_id, status) VALUES (10002, 10821, 'PENDING');
INSERT INTO Course_Permission(course_id, student_id, status) VALUES (10002, 10822, 'PENDING');



DROP TABLE IF EXISTS Previous_Courses;
CREATE TABLE Previous_Courses(student_id int NOT NULL, course_id int NOT NULL, PRIMARY KEY (student_id, course_id));

INSERT INTO Previous_Courses(student_id, course_id) VALUES(10825, 10001);
INSERT INTO Previous_Courses(student_id, course_id) VALUES(10825, 10002);
INSERT INTO Previous_Courses(student_id, course_id) VALUES(10824, 10001);
INSERT INTO Previous_Courses(student_id, course_id) VALUES(10821, 10001);



DROP TABLE IF EXISTS Passwords;
CREATE TABLE Passwords(id int NOT NULL, password varchar(255) NOT NULL, position varchar(255) NOT NULL, PRIMARY KEY(id));
INSERT INTO Passwords(id, password,position) VALUES(10821, 'password','s');
INSERT INTO Passwords(id, password,position) VALUES(10822, 'password','s');
INSERT INTO Passwords(id, password,position) VALUES(10823, 'password','s');
INSERT INTO Passwords(id, password,position) VALUES(10824, 'password','s');
INSERT INTO Passwords(id, password,position) VALUES(10825, 'password','s');
INSERT INTO Passwords(id, password,position) VALUES(20000, 'password','f');
INSERT INTO Passwords(id, password,position) VALUES(20001, 'password','f');
INSERT INTO Passwords(id, password,position) VALUES(20002, 'password','f');
INSERT INTO Passwords(id, password,position) VALUES(20003, 'password','f');
INSERT INTO Passwords(id, password,position) VALUES(30000, 'password','a');








