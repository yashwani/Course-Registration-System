package main.AuthenticationBoundedContext;

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

            System.out.println("Please enter your 5 digit id");
            int id = scan.nextInt();

            System.out.println("Please enter your password");
            String password = scan.next();

            String truePassword = passwordsDAL.getPassword(id);
            if (!truePassword.equals(password)){
                System.out.println("Username and/or password entered incorrectly. Please try agaain");
                continue;
            }







        }
    }


}
