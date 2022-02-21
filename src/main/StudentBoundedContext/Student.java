package main.StudentBoundedContext;

import java.sql.SQLException;

public class Student {
    /**
     * Entity class that holds all pertinent information regarding a specific student.
     *
     */
    private StudentDataAccessLayer studentdb;
    private int studentId;
    private String lastName;
    private String firstName;


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

    public int getId() {
        return studentId;
    }
    public String getLastName() {
        return studentdb.getLastName();
    }
    public String getFirstName() {
        return studentdb.getFirstName();
    }

    public String getEnrollDate(){
        return studentdb.getEnrollDate();
    }





}
