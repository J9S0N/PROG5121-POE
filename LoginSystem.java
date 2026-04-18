/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem;

/**
 *
 * @author USER
 */
import java.util.Scanner;

public class LoginSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        String firstName;
        String lastName;
        String username;
        String password;
        String phoneNumber;

        // Registration Inputs
        System.out.print("Enter your First Name: ");
        firstName = input.nextLine();

        System.out.print("Enter your Last Name: ");
        lastName = input.nextLine();

        System.out.print("Enter username (must not be more than 5 characters and must have a '_'): ");
        username = input.nextLine();

        System.out.print("Enter password (must have 8 characters or more, at least 1 number and a special character): ");
        password = input.nextLine();

        System.out.print("Enter cellphone number (must have a South African international code '+27'): ");
        phoneNumber = input.nextLine();
        
        //show userfeedback
        System.out.println(login.checkUserName(username));
        System.out.println(login.checkPasswordComplexity(password));
        System.out.println(login.checkCellPhoneNumber(phoneNumber));

        // Register Outcome
        boolean registered = login.registerUser(username, password, phoneNumber);

        if (registered) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed.");
        }

        if (registered){
        // Login Stage
        System.out.println("\n--- Login ---");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean authenticated = login.loginUser( loginUser, loginPass);

        System.out.println(login.returnLoginStatus( firstName, lastName, authenticated));
        }
        input.close();
    }
}

class Login {

    //Storing Established LogIn Credentials
    private String savedUsername;
    private String savedPassword;

    // Username Formatting Check
    public String checkUserName(String username) {

        if(username.contains("_") && username.length() <= 5){
            return "Username successfully captured.";
        }else{
            return "Username is not correctly formatted, please ensure it contains an underscore and is no more than five characters in length.";
        }
    }

    // Password Fomatting Check
    public String checkPasswordComplexity(String password) {

        boolean properLength = password.length() >= 8;
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean capitalLetter = password.matches(".*[A-Z].*");
        boolean specialChar = false;

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (!Character.isLetterOrDigit(ch)) {
                specialChar = true;
            }
        }

        if(properLength && hasNumber && capitalLetter && specialChar){
            return "Password successfully captured.";
        }else {
             return "Password is not correctly formatted, please ensure it contains at least 8 characters, a capital letter, a number and a special character.";
        }
    }

    // Cellphone Check
    public String checkCellPhoneNumber(String phoneNumber) {

        if(phoneNumber.matches("^\\+27[0-9]{9}$")){
            return "Cellphone number successfully added.";
        }else{
            return "Cellphone number incorrectly formatted or does not contain international code.";
        }
    }

    // Register User
    public boolean registerUser(String username, String password, String phoneNumber) {
        
         boolean validUser = checkUserName(username).equals("Username successfully captured.");

        boolean validPass = checkPasswordComplexity(password).equals("Password successfully captured.");

        boolean validPhone = checkCellPhoneNumber(phoneNumber).equals("Cellphone number successfully added.");

        if (validUser && validPass && validPhone) {
             
            savedUsername = username;
            savedPassword = password;

            return true;
        }
        return false;
    }

    // Login Authenticator
    public boolean loginUser(String username, String password) {

        return username.equals(savedUsername) && password.equals(savedPassword);
    }

    // Login Message
    public String returnLoginStatus(String firstName, String lastName, boolean validLogIN) {

        if (validLogIN) {
            return "Welcome " + firstName + " " + lastName +
                   ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}