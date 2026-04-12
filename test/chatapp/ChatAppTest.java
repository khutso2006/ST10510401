package chatapp;


import org.junit.Test;
import static org.junit.Assert.*;


public class ChatAppTest {
  
    public ChatAppTest() {
    }
 @Test
    public void testValidUsername(){
       Login login = new Login();
        boolean existent = login.checkUserName("Kyl_l");
        boolean expected = true;        
        assertEquals("Username successfuly Captured",expected,existent); 
         System.out.println("Welcome <user firstname>,<user lastname>it is great to see you.");
    }
     @Test
   public void testUserNameinvaild(){
        Login login = new Login();
      boolean existent = login.checkUserName("Kyl!!!!!");
         
        boolean expected = false;
       assertEquals("Username is incorrectly formated",expected,existent); 
        System.out.println("Username is not formatted please ensure that your username contains an underscore and no more that five character in length " );
       }
    
   @Test
   public void testpasswordvalid(){
   Login login = new Login();
   boolean existent = login.checkPasswordComplexity("Ch&&sec@ke99!");
        boolean expected = true;        
     assertEquals("Password is successfuly captured",expected,existent);  
     System.out.println("Username successfully captured");

   }  
    
     @Test
    public void testpasswordinvalid(){
    Login login = new Login();
      boolean existent = login.checkPasswordComplexity("password");
        boolean expected = false;
        assertEquals("Password is not correctly formatted; please ensure that"
                       + " the password contains at least eight characters, capital letter, a number, and a special character. ",expected,existent);
        System.out.println("Password is not correctly formatted; please ensure that"
                       + " the password contains at least eight characters, capital letter, a number, and a special character. "); 
    }
 @Test
 public void testcellphonenumbervalid(){
 Login login = new Login();
 boolean existent = login.CellphoneNumber("+27838968976");
   boolean expected = true;
        assertEquals("Cell Phone Number successfully added",expected,existent);
        System.out.println("Cell Phone Number successfully added");
 }
    @Test   
     public void testcellphonenumberInvaild(){
       Login login = new Login();
       boolean existent = login.CellphoneNumber("0866655398");
        boolean expected = false;
        assertEquals("Cell Phone Number is incorrectly or does not contain an international code;please correct the number and try again",expected,existent);
         System.out.println("Cell Phone Number is incorrectly or does not "
                 + "contain an international code;please correct the number and try again");
        
 }
      
     
      @Test
    public void testLoginSuccessful() {
        Login login = new Login();
        String username ="kyl_1";
        String password = "Ch&&sec@ke99!";
       boolean result = login.loginUser(username, password, username, password);
        assertTrue(result);
    System.out.println("true");
    
        
    }
    @Test
    public void testLoginUser_invalid() {
        Login myobject = new Login();
        String username ="kyl_1";
        String password = "Ch&&sec@ke99!";
        String incorrectPassword= "password";
        boolean result = myobject.loginUser(username, password, username, incorrectPassword);
        assertFalse(result); 
        System.out.println("false");

}
    @Test
     public void testLoginUser_failed() {
        Login myobject = new Login();
        String username ="kyl_1";
        String password = "Ch&&sec@ke99!";
        String incorectUsername= "password";
        boolean result = myobject.loginUser(username, password, username, incorectUsername);
        assertFalse(result); 
        System.out.println("false");
}
}