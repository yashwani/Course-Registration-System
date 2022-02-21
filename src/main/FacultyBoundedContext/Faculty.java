package main.FacultyBoundedContext;


import main.AdminBoundedContext.FacultyCourseDataAccessLayer;

public class Faculty {
    /**
     * Entity class that holds all pertinent information regarding a specific faculty member.
     *
     */


    private int facultyId;
    private String lastName;
    private String firstName;
    private FacultyDataAccessLayer facultydb;

    public Faculty(int faculty_id){
        this.facultyId = faculty_id;
        facultydb = new FacultyDataAccessLayer(faculty_id);
    }

    public String assignGrade(int course_id, int student_id, String grade){

        FacultyCourseDataAccessLayer f = new FacultyCourseDataAccessLayer(facultyId, course_id);
        if (!f.isTeachingCourse()){
            return "Sorry, you cannot update a course that you do not teach.";
        }

        GradesDataAccessLayer g = new GradesDataAccessLayer(course_id, student_id);
        if (!g.updateGrade(grade)){
            return "Sorry, your grade update failed. Please ensure the student is in your course, and that you have entered a valid grade type";
        }

        return "Successfully assigned grade";

    }

    public String getLastName() {
        return facultydb.getLastName();
    }

    public String getFirstName() {
        return facultydb.getFirstName();
    }





}
