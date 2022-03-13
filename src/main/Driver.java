package main;

import main.AdminBoundedContext.Admin;
import main.AdminBoundedContext.AdminTextDriver;
import main.FacultyBoundedContext.Faculty;
import main.FacultyBoundedContext.FacultyBuilder;
import main.FacultyBoundedContext.FacultyTextDriver;
import main.StudentBoundedContext.Student;
import main.StudentBoundedContext.StudentTextDriver;

public class Driver {

    public static void main(String[] args) {



//        Student student = new Student(10821);
//        StudentTextDriver driver = new StudentTextDriver(student);
//        driver.execute();

//        Faculty faculty = new Faculty(20000);
//        FacultyTextDriver driver = new FacultyTextDriver(faculty);
//        driver.execute();

        Admin admin = new Admin();
        AdminTextDriver driver = new AdminTextDriver(admin);
        driver.execute();



    }
}
