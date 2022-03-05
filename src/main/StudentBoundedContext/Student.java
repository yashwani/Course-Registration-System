package main.StudentBoundedContext;

import main.CoursesBoundedContext.CourseDataAccessLayer;
import main.Modifiable;
import main.Modifier;
import main.RegistrationBoundedContext.RequestResponse;
import main.RegistrationBoundedContext.StudentRegistration;
import main.db.DataAccessLayer;

import java.sql.SQLException;
import java.util.ArrayList;

public class Student implements Modifiable {
    /**
     * Entity class that holds all pertinent information regarding a specific student.
     *
     */
    private StudentDataAccessLayer studentdb;
    private int studentId;
    private String lastName = "''";
    private String firstName = "''";
    private String enrollDate = "''";
    private int isHold = 0;


    public Student(int studentId){
        this.studentId = studentId;
        try {
            studentdb = new StudentDataAccessLayer(studentId);
        } catch (SQLException e){
            System.out.println("Error in student constructor");
            System.out.println(e.getMessage());
        }

    }

    public String requestAddCourse(int courseID){
        /**
         *
         */
        //calls addCourse in StudentRegistration

        return null;
    }

    public String dropCourse(int courseID){
        StudentRegistration s = new StudentRegistration();
        RequestResponse requestResponse = s.dropCourse(this, courseID);
        return requestResponse.getReason();
    }

    public String dropAllCourses(){
        StudentRegistration s = new StudentRegistration();
        RequestResponse requestResponse = s.dropAllCourses(this);
        return requestResponse.getReason();
    }

    public void browseCourses(){
        StudentRegistration s = new StudentRegistration();
        s.browseCourses();
    }



    @Override
    public Modifier getDataAccessLayer(){
        return studentdb;
    }

    @Override
    public String[] listAttributes() {
        return new String[]{String.valueOf(studentId), lastName, firstName, enrollDate, String.valueOf(isHold)};
    }

    @Override
    public String primaryKey() {
        return String.valueOf(studentId);
    }

    public int getID() {
        return studentId;
    }


    public String getLastNameDB() {
        this.lastName =  studentdb.getLastName();
        return lastName;
    }
    public String getFirstNameDB() {
        this.firstName = studentdb.getFirstName();
        return firstName;
    }

    public String getEnrollDateDB(){
        this.enrollDate = studentdb.getEnrollDate();
        return enrollDate;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



}
