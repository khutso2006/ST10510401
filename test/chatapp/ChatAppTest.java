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
        assertEquals("Password is not correctly formatted; please ensure that the password"
                + " contains at least eight characters, a capital letter, a number, and a special character.",expected, actual ); 
        
    
    }
    
   @Test
    public void testpassword(){
        Login log = new Login();
        boolean actual = log.checkPasswordREGEX("Ch&&sec@ke99!");
        boolean expected = true;        
        assertEquals("Expect to be true",expected, actual );  
        
    }
        @Test
    public void testpasswordinvalid(){
        Login log = new Login();
        boolean actual = log.checkPasswordREGEX("password");
        boolean expected = false;        
        assertEquals("Expect to be true",expected, actual );  
}
 @Test
    public void testcellphonenumber(){
        Login log = new Login();
        boolean actual = log.CellphoneNumberIsValidREGEX("+27838968976");
        boolean expected = true;        
        assertEquals("Expect to be true",expected, actual );    
}
 @Test   
 public void testcellphonenumberinvaild(){
        Login log = new Login();
        boolean actual = log.CellphoneNumberIsValidREGEX("08966553");
        boolean expected = false;        
        assertEquals("Expect to be true",expected, actual );       
    
    
 }
    }