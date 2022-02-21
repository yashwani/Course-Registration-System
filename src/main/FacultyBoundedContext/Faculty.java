package main.FacultyBoundedContext;


public class Faculty {
    private int facultyId;
    private String lastName;
    private String firstName;
    private FacultyDataAccessLayer facultydb;

    public Faculty(int faculty_id){
        this.facultyId = faculty_id;
        facultydb = new FacultyDataAccessLayer(faculty_id);
    }

    public String assignGrade(int course_id, int student_id, String grade){
        // cant assign bc not teaching that course
        // cant assign bc student not in that course
        // cant assign bc invalid grade type entered

        //grade assigned successfully
        return null;

    }

    public String getLastName() {
        return facultydb.getLastName();
    }

    public String getFirstName() {
        return facultydb.getFirstName();
    }





}
