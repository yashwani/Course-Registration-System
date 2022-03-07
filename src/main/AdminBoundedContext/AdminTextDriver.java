package main.AdminBoundedContext;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AdminTextDriver {
    Admin admin;

    public AdminTextDriver(Admin admin){
        this.admin = admin;
    }

    public void execute(){
        while(true){
            System.out.println();
            System.out.printf("You are logged in as an administrator. Please select one%n");
            System.out.println("\u2022 Enter 'A' to add a course.");
            System.out.println("\u2022 Enter 'B' to add a student.");
            System.out.println("\u2022 Enter 'C' to add a faculty.");

            Scanner scan = new Scanner(System.in);
            String choice = scan.next();

            choice = preprocess(choice);


            if (choice.equals("A")) {
                addCourse();
            } else if (choice.equals("B")) {
                addStudent();
            } else if (choice.equals("C")) {
                addFaculty();
            } else if (choice.equals("D")) {
                continue;
            } else if (choice.equals("Q")){
                break;
            } else {
                System.out.println("Please enter a valid option.");
            }



        }



    }
    private String preprocess(String s){
        s = s.toUpperCase();
        s = s.replaceAll("\\s", ""); //remove white spaces
        return s;
    }

    //use the builder pattern here
    private void addCourse(){
        Scanner scan = new Scanner(System.in);
        boolean hasPrereq = false;

        System.out.println("Please enter a 5 digit course ID:");
        int course_id = scan.nextInt();
        System.out.println("Enter the course name:");
        String course_name = scan.next();
        System.out.println("Is the course open?: 0 if NO, 1 if YES");
        int isOpen = scan.nextInt();
        if (isOpen== 0 || isOpen==1){
            System.out.println("Invalid number entered. Terminating process.");
            return;
        }
        System.out.println("Enter instructor name:");
        String instructor = scan.next();
        System.out.println("Instructor permission required?: 0 if NO, 1 if YES ");
        int instructorPermission = scan.nextInt();
        if (instructorPermission!= 0 || instructorPermission!=1){
            System.out.println("Invalid number entered. Terminating process.");
            return;
        }








    }

    private void addStudent(){}

    private void addFaculty(){}



}
