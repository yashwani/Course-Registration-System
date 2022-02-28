package main.CoursesBoundedContext;

public class CourseFactory {

    public Course createCourse(int courseID){
        return new Course(courseID);
    }

    public Course createCourse(int courseID, String course_name, int isOpen, String instructor, int instructor_permission){
        Course c = new Course(courseID);
        c.setCourse_name(course_name);
        c.setIsOpen(isOpen);
        c.setInstructor(instructor);
        c.setInstructor_permission(instructor_permission);
        return c;
    }

    public Course createCourse(int courseID, String course_name, int isOpen, String instructor, int instructor_permission, int prereq1, int prereq2, int prereq3){
        Course c = new Course(courseID);
        c.setCourse_name(course_name);
        c.setIsOpen(isOpen);
        c.setInstructor(instructor);
        c.setInstructor_permission(instructor_permission);
        c.setPrereq1_id(prereq1);
        c.setPrereq2_id(prereq2);
        c.setPrereq3_id(prereq3);
        return c;
    }

}
