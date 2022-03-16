package main;

import main.AdminBoundedContext.Admin;
import main.AdminBoundedContext.AdminTextDriver;
import main.AuthenticationBoundedContext.AuthenticationTextDriver;
import main.FacultyBoundedContext.Faculty;
import main.FacultyBoundedContext.FacultyBuilder;
import main.FacultyBoundedContext.FacultyTextDriver;
import main.StudentBoundedContext.Student;
import main.StudentBoundedContext.StudentTextDriver;

import java.util.logging.Level;

public class Driver {

    public static void main(String[] args) {


        AuthenticationTextDriver a = new AuthenticationTextDriver();
        a.execute();

    }
}
