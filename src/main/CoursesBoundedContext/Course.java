package main.CoursesBoundedContext;

import main.Modifiable;
import main.Modifier;
import java.sql.Types;

import java.util.ArrayList;

public class Course implements Modifiable {
    /**
     * Entity class that holds all pertinent information regarding a specific course.
     *
     */


    private CourseDataAccessLayer courseDataAccessLayer;
    private int courseId;
    private String course_name;
    private int isOpen;
    private String instructor;
    private int instructor_permission;
    private int prereq1_id = -1;
    private int prereq2_id = -1;
    private int prereq3_id = -1;





    public Course(int courseId){
        courseDataAccessLayer = new CourseDataAccessLayer(courseId);
        this.courseId = courseId;
    }

    public int getID(){
        return courseId;
    }



    public ArrayList<Integer> getPrerequisites(){

        return courseDataAccessLayer.getPrerequisites();
    }


    @Override
    public Modifier getDataAccessLayer() {
        return courseDataAccessLayer;
    }

    @Override
    public String[] listAttributes() {
        String[] result = new String[]{String.valueOf(courseId), course_name, String.valueOf(isOpen), instructor, String.valueOf(instructor_permission), String.valueOf(prereq1_id), String.valueOf(prereq2_id), String.valueOf(prereq3_id) };
        return result;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setInstructor_permission(int instructor_permission) {
        this.instructor_permission = instructor_permission;
    }

    public void setPrereq1_id(int prereq1_id) {
        this.prereq1_id = prereq1_id;
    }

    public void setPrereq2_id(int prereq2_id) {
        this.prereq2_id = prereq2_id;
    }

    public void setPrereq3_id(int prereq3_id) {
        this.prereq3_id = prereq3_id;
    }




}
