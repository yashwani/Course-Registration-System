package main;

import main.StudentBoundedContext.Student;
import main.StudentBoundedContext.StudentTextDriver;

public class Driver {

    public static void main(String[] args) {
        Student student = new Student(10821);
        StudentTextDriver driver = new StudentTextDriver(student);
        driver.execute();
    }
}
