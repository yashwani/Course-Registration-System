package main.StudentBoundedContext;

import main.Builder;

public class StudentBuilder implements Builder {

    public int studentId;
    public String lastname;
    public String firstname;
    public String enrollDate;
    public int isHold;

    public StudentBuilder ID(int studentId){
        this.studentId = studentId;
        return this;
    }

    public StudentBuilder lastname(String lastname){
        this.lastname = lastname;
        return this;
    }

    public StudentBuilder firstname(String firstname){
        this.firstname = firstname;
        return this;
    }
    public StudentBuilder enrollDate(String enrollDate){
        this.enrollDate = enrollDate;
        return this;
    }
    public StudentBuilder isHold(int isHold){
        this.isHold = isHold;
        return this;
    }

    public Student build(){
        return new Student(this);
    }



}
