import chatapp.Login;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChatApp {

}
    public void testpassword(){
        Login log = new Login();
        boolean actual = log.checkPasswordREGEX("Ch&&sec@ke99!");
        boolean expected = true;        
        assertEquals("Expect to be true",expected, actual );  
    
    
    
    }
    
    @Test
    public void testUsername() {
        boolean result = log.
        assertTrue(result);
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        boolean result = user.isValidUsername("kyle!!!!!!");
        assertFalse(result);
    }

    @Test
    public void testUsernameMessageValid() {
        String result = user.registerUser("kyl_1");
        assertEquals("Welcome <user first name> <user last name> it is great to see you.", result);
    }

    @Test
    public void testUsernameMessageInvalid() {
        String result = user.registerUser("kyle!!!!!!");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    // =========================
    // PASSWORD TESTS
    // =========================

    @Test
    public void testPasswordMeetsComplexity() {
        boolean result = user.isValidPassword("Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        boolean result = user.isValidPassword("password");
        assertFalse(result);
    }

    @Test
    public void testPasswordMessageValid() {
        String result = user.registerPassword("Ch&&sec@ke99!");
        assertEquals("Password successfully captured.", result);
    }

    @Test
    public void testPasswordMessageInvalid() {
        String result = user.registerPassword("password");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    // =========================
    // CELL NUMBER TESTS
    // =========================

    @Test
    public void testCellNumberCorrectlyFormatted() {
        boolean result = user.isValidCellNumber("+27838968976");
        assertTrue(result);
    }

    @Test
    public void testCellNumberIncorrectlyFormatted() {
        boolean result = user.isValidCellNumber("08966553");
        assertFalse(result);
    }

    @Test
    public void testCellNumberMessageValid() {
        String result = user.registerCellNumber("+27838968976");
        assertEquals("Cell number successfully captured.", result);
    }

    @Test
    public void testCellNumberMessageInvalid() {
        String result = user.registerCellNumber("08966553");
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.", result);
    }

    // =========================
    // LOGIN TESTS
    // =========================

    @Test
    public void testLoginSuccessful() {
        boolean result = user.login("kyl_1", "Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        boolean result = user.login("wrong", "wrong");
        assertFalse(result);
    }
}
package chatapp;


import org.junit.Test;
import static org.junit.Assert.*;


public class ChatAppTest {
  
    public ChatAppTest() {
    }


   
   
    @Test
    public void testUserName(){
        Login log = new Login();
        boolean actual = log.checkUserName("Kyl_1");
        boolean expected = true;        
        assertEquals("Expect to be true",expected, actual ); 
        
       
    }
   @Test
    public void testpassword(){
        Login log = new Login();
        boolean actual = log.checkPasswordREGEX("Ch&&sec@ke99!");
        boolean expected = true;        
        assertEquals("Expect to be true",expected, actual );  
}
 @Test
    public void testcellphonenumber(){
        Login log = new Login();
        boolean actual = log.Cellphone…
