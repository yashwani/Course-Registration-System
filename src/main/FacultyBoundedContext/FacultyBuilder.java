package main.FacultyBoundedContext;

import main.Builder;
import main.StudentBoundedContext.Student;

public class FacultyBuilder implements Builder {

    public int facultyId;
    public String lastName;
    public String firstName;
    public String email;

    public FacultyBuilder ID(int facultyId){
        this.facultyId = facultyId;
        return this;
    }

    public FacultyBuilder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public FacultyBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public FacultyBuilder email(String email){
        this.email = email;
        return this;
    }

    public Faculty build(){
        return new Faculty(this);
    }


}
