package main.CoursesBoundedContext;

import main.Builder;

public class CourseBuilder implements Builder {
    public int courseID;
    public String course_name;
    public int isOpen;
    public String instructor;
    public int instructor_permission;
    public int prereq1;
    public int prereq2;
    public int prereq3;

    public CourseBuilder ID(int courseID){
        this.courseID = courseID;
        return this;
    }

    public CourseBuilder course_name(String course_name){
        this.course_name = course_name;
        return this;
    }

    public CourseBuilder isOpen(int isOpen){
        this.isOpen = isOpen;
        return this;
    }

    public CourseBuilder instructor(String instructor){
        this.instructor = instructor;
        return this;
    }

    public CourseBuilder instructor_permission(int instructor_permission){
        this.instructor_permission = instructor_permission;
        return this;
    }

    public CourseBuilder prereq1(int prereq1){
        this.prereq1 = prereq1;
        return this;
    }

    public CourseBuilder prereq2(int prereq2){
        this.prereq2 = prereq2;
        return this;
    }

    public CourseBuilder prereq3(int prereq3){
        this.prereq3 = prereq3;
        return this;
    }

    public Course build(){
        return new Course(this);
    }



}
