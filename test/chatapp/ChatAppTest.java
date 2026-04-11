/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package chatapp;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KHUTSO
 */
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
        boolean actual = log.CellphoneNumberIsValidREGEX("+27838968976");
        boolean expected = true;        
        assertEquals("Expect to be true",expected, actual );    
}
}