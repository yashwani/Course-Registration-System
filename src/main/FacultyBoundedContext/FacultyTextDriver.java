package main.FacultyBoundedContext;

import main.RegistrationBoundedContext.RequestResponse;
import main.StudentBoundedContext.Student;


import java.util.Scanner;

public class FacultyTextDriver {
    Faculty faculty;

    public FacultyTextDriver(Faculty faculty){
        this.faculty = faculty;
    }

    public void execute(){
        while(true){
            System.out.println();
            System.out.printf("You are logged in as faculty %d. Please select one%n", faculty.getID());
            System.out.println("\u2022 Enter 'A' to enter grade for student.");
            System.out.println("\u2022 Enter 'Q' to quit.");

            Scanner scan = new Scanner(System.in);
            String choice = scan.next();

            choice = preprocess(choice);

            if (choice.equals("A")){
                assignGrade();
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

    private void assignGrade(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the 5 digit course ID.");
        int course_id = scan.nextInt();

        System.out.println("Enter the 5 digit student ID");
        int student_id = scan.nextInt();

        System.out.println("Enter grade. Pressing enter will update the student's grade.");
        String grade = scan.next();

        RequestResponse requestResponse = faculty.assignGrade(course_id, student_id, grade);
        processResponse(requestResponse);

    }

    private void processResponse(RequestResponse r){
        if (r.isSuccess()){
            System.out.println("Operation successful.");
        } else {
            System.out.println("Operation NOT successful.");
            System.out.println(r.getReason());
        }
    }

}
