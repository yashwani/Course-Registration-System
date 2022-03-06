package main.StudentBoundedContext;

import main.RegistrationBoundedContext.RequestResponse;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentTextDriver {
    Student student;

    public StudentTextDriver(Student student){
        this.student = student;
    }

    public void execute(){

        while(true) {

            System.out.println();
            System.out.printf("You are logged in as student %d. Please select one%n", student.getID());
            System.out.println("\u2022 Enter 'A' to browse courses.");
            System.out.println("\u2022 Enter 'B' to add a course.");
            System.out.println("\u2022 Enter 'C' to drop a course.");
            System.out.println("\u2022 Enter 'D' to drop all course.");
            System.out.println("\u2022 Enter 'Q' to quit.");

            Scanner scan = new Scanner(System.in);
            String choice = scan.next();

            choice = preprocess(choice);

            if (choice.equals("A")) {
                browseCourses();
            } else if (choice.equals("B")) {
                addCourse();
            } else if (choice.equals("C")) {
                dropCourse();
            } else if (choice.equals("D")) {
                dropAllCourses();
            } else if (choice.equals("Q")){
                break;
            } else {
                System.out.println("Please enter a valid option.");
            }


        }

    }

    private void browseCourses(){
        student.browseCourses();
    }

    private void addCourse(){
        System.out.println("Please enter the 5 digit course ID of the course you wish to add:");

        Scanner scan = new Scanner(System.in);
        int course_num = scan.nextInt();

        RequestResponse r = student.addCourse(course_num);
        processResponse(r);
    }

    private void dropCourse(){
        System.out.println("Please enter the 5 digit course ID of the course you wish to drop:");

        Scanner scan = new Scanner(System.in);
        int course_num = scan.nextInt();

        System.out.printf("Are you sure you want to attempt dropping course %d?%n", course_num);
        System.out.println("Enter Y/N");

        scan = new Scanner(System.in);
        String conf = scan.next();
        conf = preprocess(conf);

        if (conf.equals("Y")){
            RequestResponse r = student.dropCourse(course_num);
            processResponse(r);
        } else{
            return;
        }

    }

    private void dropAllCourses(){
        System.out.printf("Are you sure you want to attempt dropping ALL courses?");
        System.out.println("Enter Y/N");

        Scanner scan = new Scanner(System.in);
        String conf = scan.next();
        conf = preprocess(conf);

        if (conf.equals("Y")){
            RequestResponse r = student.dropAllCourses();
            processResponse(r);
        } else{
            return;
        }
    }


    private void processResponse(RequestResponse r){
        if (r.isSuccess()){
            System.out.println("Operation successful.");
        } else {
            System.out.println("Operation NOT successful.");
            System.out.println(r.getReason());
        }
    }

    private String preprocess(String s){
        s = s.toUpperCase();
        s = s.replaceAll("\\s", ""); //remove white spaces
        return s;
    }





}
