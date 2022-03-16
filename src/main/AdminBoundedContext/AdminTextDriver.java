package main.AdminBoundedContext;

import main.Builder;
import main.CoursesBoundedContext.Course;
import main.CoursesBoundedContext.CourseBuilder;
import main.FacultyBoundedContext.Faculty;
import main.FacultyBoundedContext.FacultyBuilder;
import main.Modifiable;
import main.StudentBoundedContext.Student;
import main.StudentBoundedContext.StudentBuilder;

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
            System.out.println("\u2022 Enter 'D' to delete a course.");
            System.out.println("\u2022 Enter 'E' to delete a student.");
            System.out.println("\u2022 Enter 'F' to delete a faculty.");
            System.out.println("\u2022 Enter 'G' to modify a course.");
            System.out.println("\u2022 Enter 'H' to modify a student.");
            System.out.println("\u2022 Enter 'I' to modify a faculty.");
            System.out.println("\u2022 Q to quit.");

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
                CourseBuilder courseBuilder = new CourseBuilder();
                delete(courseBuilder);
            } else if (choice.equals("E")) {
                StudentBuilder studentBuilder = new StudentBuilder();
                delete(studentBuilder);
            } else if (choice.equals("F")) {
                FacultyBuilder facultyBuilder = new FacultyBuilder();
                delete(facultyBuilder);
            } else if (choice.equals("G")) {
                CourseBuilder courseBuilder = new CourseBuilder();
                modify(courseBuilder);
            }  else if (choice.equals("H")) {
                StudentBuilder studentBuilder = new StudentBuilder();
                modify(studentBuilder);
            } else if (choice.equals("I")) {
                FacultyBuilder facultyBuilder = new FacultyBuilder();
                modify(facultyBuilder);
            }else if (choice.equals("Q")){
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

        CourseBuilder courseBuilder = new CourseBuilder();

        System.out.println("Please enter a 5 digit course ID:");
        courseBuilder.ID(scan.nextInt());

        scan.nextLine();
        System.out.println("Enter the course name:");
        courseBuilder.course_name("'" + scan.nextLine() + "'");


        System.out.println("Is the course open?: 0 if NO, 1 if YES");
        courseBuilder.isOpen(scan.nextInt());

        scan.nextLine();
        System.out.println("Enter instructor name:");
        courseBuilder.instructor("'" + scan.nextLine() + "'");

        System.out.println("Instructor permission required?: 0 if NO, 1 if YES ");
        courseBuilder.instructor_permission(scan.nextInt());

        System.out.println("Enter course id for prereq1. Enter -1 if no prerequisites.");
        courseBuilder.prereq1(scan.nextInt());

        System.out.println("Enter course id for prereq1. Enter -1 if no prerequisites.");
        courseBuilder.prereq2(scan.nextInt());

        System.out.println("Enter course id for prereq1. Enter -1 if no prerequisites.");
        courseBuilder.prereq3(scan.nextInt());

        Course course = courseBuilder.build();
        boolean success = admin.create(course);

    }

    private void addStudent(){
        Scanner scan = new Scanner(System.in);

        StudentBuilder studentBuilder = new StudentBuilder();

        System.out.println("Please enter a 5 digit student id:");
        studentBuilder.ID(scan.nextInt());

        System.out.println("Enter the student last name:");
        studentBuilder.lastname("'" + scan.next() + "'");

        System.out.println("Enter the student first name:");
        studentBuilder.firstname("'" + scan.next() + "'");

        System.out.println("Enter the enroll year:");
        studentBuilder.enrollDate("'" + scan.next() + "'");

        System.out.println("Enter whether this student has a hold:");
        studentBuilder.isHold(scan.nextInt());

        Student student = studentBuilder.build();
        boolean success = admin.create(student);

    }

    private void addFaculty(){
        Scanner scan = new Scanner(System.in);
        FacultyBuilder facultyBuilder = new FacultyBuilder();

        System.out.println("Please enter a 5 digit faculty id:");
        facultyBuilder.ID(scan.nextInt());

        System.out.println("Enter the faculty last name:");
        facultyBuilder.lastName("'" + scan.next() + "'");

        System.out.println("Enter the faculty first name:");
        facultyBuilder.firstName("'" + scan.next() + "'");

        System.out.println("Enter the faculty email address:");
        facultyBuilder.email("'" + scan.next() + "'");

        Faculty faculty = facultyBuilder.build();
        boolean success = admin.create(faculty);

    }


    private void delete(Builder builder){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a 5 digit ID");
        builder.ID(scan.nextInt());

        Modifiable modifiable = builder.build();
        boolean success = admin.delete(modifiable);

        if (success){
            System.out.println("Delete performed successfully");
        } else{
            System.out.println("Delete unsuccessful.");
        }

    }


    private void modify(Builder builder){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a 5 digit ID");
        builder.ID(scan.nextInt());

        Modifiable modifiable = builder.build();
        String[] modifiableAttributes = modifiable.modifiableAttributes();

        System.out.println("Please select the number associated with the attribute you would like the modify.");
        for (int i = 0; i < modifiableAttributes.length; i++) {
            System.out.print("•" + Integer.toString(i) + ": " + modifiableAttributes[i] + "\n");
        }

        int num = scan.nextInt();
        String[] updateColumn = new String[]{modifiableAttributes[num]};

        System.out.println("Please enter the value you would like to update the field with:");
        String[] updateValue = new String[]{scan.next()};

        boolean success = admin.modify(modifiable, updateColumn, updateValue);

        if (success){
            System.out.println("Modification successful");
        } else{
            System.out.println("Modification failed.");
        }

    }


}
