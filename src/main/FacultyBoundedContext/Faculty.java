package main.FacultyBoundedContext;


import main.AdminBoundedContext.FacultyCourseDataAccessLayer;
import main.Modifiable;
import main.Modifier;
import main.RegistrationBoundedContext.RequestResponse;

public class Faculty implements Modifiable {


    /**
     * Entity class that holds all pertinent information regarding a specific faculty member.
     *
     */


    private int facultyId;
    private String lastName;
    private String firstName;
    private FacultyDataAccessLayer facultydb;
    private String email;

    public Faculty(int faculty_id){
        this.facultyId = faculty_id;
        facultydb = new FacultyDataAccessLayer(faculty_id);
    }

    public Faculty(FacultyBuilder builder){
        this.facultyId = builder.facultyId;
        facultydb = new FacultyDataAccessLayer(this.facultyId);
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.email = builder.email;
    }

    public RequestResponse assignGrade(int course_id, int student_id, String grade){
        RequestResponse requestResponse = new RequestResponse();


        FacultyCourseDataAccessLayer f = new FacultyCourseDataAccessLayer();
        if (!f.isTeachingCourse(facultyId, course_id)){
            requestResponse.addReason("Sorry, you cannot update a course that you do not teach.");
            requestResponse.setSuccess(false);
            return requestResponse;
        }

        GradesDataAccessLayer g = new GradesDataAccessLayer(course_id, student_id);
        if (!g.updateGrade(grade)){
            requestResponse.addReason("Sorry, your grade update failed. Please ensure the student is in your course, and that you have entered a valid grade type");
            requestResponse.setSuccess(false);
            return requestResponse;
        }

        requestResponse.setSuccess(true);
        return requestResponse;
    }


    public String getLastName() {
        return facultydb.getLastName();
    }

    public String getFirstName() {
        return facultydb.getFirstName();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getID(){
        return facultyId;
    }


    @Override
    public Modifier getDataAccessLayer() {
        return facultydb;
    }

    @Override
    public String[] listAttributes() {
        return new String[]{String.valueOf(facultyId),lastName, firstName, email};
    }

    @Override
    public String[] modifiableAttributes() {
        return new String[0];
    }

    @Override
    public String primaryKey() {
        return String.valueOf(facultyId);
    }
}
