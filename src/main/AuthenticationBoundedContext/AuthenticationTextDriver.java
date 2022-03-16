package main.AuthenticationBoundedContext;

import main.AdminBoundedContext.Admin;
import main.AdminBoundedContext.AdminTextDriver;
import main.FacultyBoundedContext.Faculty;
import main.FacultyBoundedContext.FacultyTextDriver;
import main.StudentBoundedContext.Student;
import main.StudentBoundedContext.StudentTextDriver;

import java.util.Scanner;

public class AuthenticationTextDriver {
    PasswordsDataAccessLayer passwordsDAL;

    public AuthenticationTextDriver(){
        passwordsDAL = new PasswordsDataAccessLayer();
    }


    public void execute(){
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("LOG IN PAGE: Please enter your 5 digit id");
            int id = scan.nextInt();

            System.out.println("LOG IN PAGE: Please enter your password");
            String password = scan.next();

            String truePassword = passwordsDAL.getPassword(id);
            if (!truePassword.equals(password)){
                System.out.println("Username and/or password entered incorrectly. Please try agaain");
                continue;
            }

            String position =  passwordsDAL.getPosition(id);
            if (position.equals("s")) {
                Student student = new Student(id);
                StudentTextDriver driver = new StudentTextDriver(student);
                driver.execute();
            } else if (position.equals("f")){
                Faculty faculty = new Faculty(id);
                FacultyTextDriver driver = new FacultyTextDriver(faculty);
                driver.execute();
            } else if (position.equals("a")){
                Admin admin = new Admin();
                AdminTextDriver driver = new AdminTextDriver(admin);
                driver.execute();
            }


        }
    }


}
