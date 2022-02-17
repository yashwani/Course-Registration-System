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
    public Student(int studentId){
        this.studentId = studentId;

    }

    private int studentId;
    private String lastName;
    private String firstName;


    public int getStudentId() {
        return studentId;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }



}
