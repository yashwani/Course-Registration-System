package main.StudentBoundedContext;

import main.Modifiable;

import java.sql.SQLException;

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

    public int getID() {
        return studentId;
    }

    @Override
    public boolean createNew() {
        return studentdb.createNew(this);
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

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getEnrollDate(){
        return enrollDate;
    }

    public int getHold(){
        return isHold;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setHold(int hold){
        this.isHold = hold;
    }


}
