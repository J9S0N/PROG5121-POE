/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package MethodTesting;

import com.mycompany.login.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author USER
 */
public class LoginTest {
    
  Login login = new Login();

    // assertEquals 

    @Test
    public void testUserNameCorrect() {

        assertEquals("Username successfully captured.", login.checkUserName("kyl_1"));
    }

    @Test
    public void testUserNameIncorrect() {

        assertEquals("Username is not correctly formatted, please ensure it contains an underscore and is no more than five characters in length.", login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordCorrect() {

        assertEquals("Password successfully captured.", login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    
    @Test
    public void tsetPasswordIncorrect(){
        assertEquals("Password is not correctly formatted, please ensure it contains at least 8 characters, a capital letter, a number and a special character.", login.checkPasswordComplexity("Password"));
    }

    @Test
    public void testPhoneCorrect() {

        assertEquals("Cellphone number successfully added.", login.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test
    public void testPhoneIncorrect(){
        assertEquals("Cellphone number incorrectly formatted or does not contain international code.", login.checkCellPhoneNumber("08966553"));
    }

    // assertTrue / False LOGIN

    @Test
    public void testLoginSuccess() {

        login.registerUser( "Jay_", "Jason@123", "+27831234567");

        assertTrue(
            login.loginUser("Jay_", "Jason@123")
        );
    }

    @Test
    public void testLoginFail() {

        login.registerUser("Jay_", "Jason@123", "+27831234567");

        assertFalse(
            login.loginUser("Jay_", "wrong123")
        );
    }
}