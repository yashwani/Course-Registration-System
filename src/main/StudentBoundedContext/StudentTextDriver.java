package main.StudentBoundedContext;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentTextDriver {
    Student student;

    public StudentTextDriver(Student student){
        this.student = student;
    }

    public void execute(){
        System.out.printf("You are logged in as student %d. Please select one%n", student.getID());
        System.out.println("\u2022 Enter 'A' to browse courses.");

        Scanner scan = new Scanner(System.in);
        String choice = scan.next();


        if (choice.equals("A")) {
            browseCourses();
        }


    }

    private void browseCourses(){
        student.browseCourses();
    }







}
