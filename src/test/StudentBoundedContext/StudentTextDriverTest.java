package test.StudentBoundedContext;

import main.StudentBoundedContext.Student;
import main.StudentBoundedContext.StudentTextDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTextDriverTest {

    @Test
    void execute() {
        Student student = new Student(10821);
        StudentTextDriver driver = new StudentTextDriver(student);
        driver.execute();


    }
}