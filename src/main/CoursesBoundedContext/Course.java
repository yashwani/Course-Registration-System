package main.CoursesBoundedContext;

import java.util.ArrayList;

public class Course {

    public static int MAX_NUM_PREREQ = 3;
    private int courseId;

    public Course(int courseId){
        this.courseId = courseId;
    }

    public int getId(){
        return courseId;
    }

    public ArrayList<Integer> getPrerequisites(){
        CourseDataAccessLayer c = new CourseDataAccessLayer(courseId);
        return c.getPrerequisites();
    }


}
