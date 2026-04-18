/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author USER
 */
public class Login {

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