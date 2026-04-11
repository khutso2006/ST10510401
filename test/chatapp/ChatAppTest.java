package chatapp;


import org.junit.Test;
import static org.junit.Assert.*;


public class ChatAppTest {
  
    public ChatAppTest() {
    }
 @Test
    public void testUsername(){
        Login login = new Login();
        boolean actual = login.checkUserName("Kyl_l");
         boolean expected = true;        
        assertEquals(expected,actual);        
    }

    @Test
    public void testValidLoginUser() {
        Login login = new Login();
        boolean result = login.loginUser("kyl_1");

        System.out.println(result); // optional

        assertFalse(result);
    }

    @Test
    public void testInvalidUsername() {
        Login login = new Login();
        boolean result = login.checkUserName("kyle!!!!!!");

        System.out.println(result); // optional

        assertFalse(result);
    }
  
       
    
    
     @Test
    public void testUserNameinvaild(){
        Login login = new Login();
        boolean actual = login.checkUserName("Kyl!!!!!");
         System.out.println(actual);
         boolean expected = false;
        assertEquals(expected,actual); 
        
    
    }
    
   @Test
    public void testpasswordvalid(){
        Login login = new Login();
        boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99!");
         System.out.println(actual);
        boolean expected = true;        
        assertEquals(expected,actual);  
        
    }
        @Test
    public void testpasswordinvalid(){
        Login login = new Login();
        boolean actual = login.checkPasswordComplexity("password");
        boolean expected = false;        
        assertEquals("Password successfully captured",expected, actual );  
}
 @Test
    public void testcellphonenumbervalid(){
        Login login = new Login();
        boolean actual = login.CellphoneNumber("+27838968976");
        boolean expected = true;        
        assertEquals("(Password is not correctly formatted; please ensure that the password contains at "
                + "least eight characters, a capital letter, a number, and a special character.",expected, actual);    
}
 @Test   
 public void testcellphonenumberInvaild(){
        Login login = new Login();
        boolean actual = login.CellphoneNumber("08966553");
        boolean expected = false;        
        assertEquals("Expect to be true",expected, actual );       
 }
    @Test
    public void testLoginSuccessful(){
      Login login = new Login();
        boolean actual = login.loginUser("True");
      boolean expected = false;
      assertTrue(expected==actual);
      
 }
}
    