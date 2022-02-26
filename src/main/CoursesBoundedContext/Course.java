package main.CoursesBoundedContext;

import main.Modifiable;

import java.util.ArrayList;

public class Course implements Modifiable {
    /**
     * Entity class that holds all pertinent information regarding a specific course.
     *
     */

    public static int MAX_NUM_PREREQ = 3;
    private int courseId;

    public Course(int courseId){
        this.courseId = courseId;
    }

    public int getID(){
        return courseId;
    }

    @Override
    public boolean createNew() {
        return false;
    }

    public ArrayList<Integer> getPrerequisites(){
        CourseDataAccessLayer c = new CourseDataAccessLayer(courseId);
        return c.getPrerequisites();
    }


}
