import java.sql.SQLException;

public class Student {
    /**
     * Entity class that holds all pertinent information regarding a specific student.
     *
     * TODO: add getters and setters for other instance variables
     * to add:
     *      - previous courses
     *      - courses currently registered for
     *      - holds
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

    public String addCourse(int courseID){
        /**
         * Client for chain of responsibility consisting of handlers for: holds, instructor permission, database insertion
         */

        AddCourseHandler chain = new HoldHandler();
        System.out.println(chain.check(studentId, courseID));


        return "Enrolled in " + String.valueOf(courseID);
    }

    public int getStudentId() {
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
