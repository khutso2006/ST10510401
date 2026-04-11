package chatapp;


import org.junit.Test;
import static org.junit.Assert.*;


public class ChatAppTest {
  
    public ChatAppTest() {
    }
 @Test
    public void testUserNamevalid(){
        Login log = new Login();
        boolean actual = log.checkUserName("Kyl_1");
        boolean expected = true;        
        assertEquals("Welcome <user first name> <user last name> it is great to see you.",expected, actual ); 
        
       
    }
    
     @Test
    public void testUserNameinvaild(){
        Login log = new Login();
        boolean actual = log.checkUserName("Kyl!!!!!");
        boolean expected = false;        
        assertEquals("Username is not correctly formatted; please"
                + " ensure that your username contains an underscore and is no more than five characters in length.",expected, actual ); 
        
    
    }
    
   @Test
    public void testpassword(){
        Login log = new Login();
        boolean actual = log.checkPasswordComplexity("Ch&&sec@ke99!");
        boolean expected = true;        
        assertEquals("Expect to be true",expected, actual );  
        
    }
        @Test
    public void testpasswordinvalid(){
        Login log = new Login();
        boolean actual = log.checkPasswordComplexity("password");
        boolean expected = false;        
        assertEquals("Password successfully captured",expected, actual );  
}
 @Test
    public void testcellphonenumber(){
        Login log = new Login();
        boolean actual = log.CellphoneNumber("+27838968976");
        boolean expected = true;        
        assertEquals("(Password is not correctly formatted; please ensure that the password contains at "
                + "least eight characters, a capital letter, a number, and a special character.",expected, actual );    
}
 @Test   
 public void testcellphonenumberinvaild(){
        Login log = new Login();
        boolean actual = log.CellphoneNumber("08966553");
        boolean expected = false;        
        assertEquals("Expect to be true",expected, actual );       
    
    
 }
    }