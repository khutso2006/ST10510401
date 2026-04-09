/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package chatapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author KHUTSO
 */
public class ChatAppTest {
  
    public ChatAppTest() {
    }
   
   
    @Test
    public void testMain(){
        Login log = new Login();
        boolean actual = log.checkUserName("Kyl_1");
        boolean expected = true;        
        assertEquals(expected, actual ,"Expect to be true "); 
        
       
    }
    
}
