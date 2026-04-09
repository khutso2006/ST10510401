
package chatapp;
import java.util.Scanner;

public class ChatApp {

    public static void main(String[] args) {
     
     
       //declaring variables
       String firstname;
       String lastname;
       String username;
       String password;
       String cellphoneNumber;
       //Scanner
     
     Scanner scn = new Scanner(System.in);
        //class1 + Class2=Linking classes
        Login login = new Login();
        System.out.println( "(REGISTER)");
        
       System.out.println("please enter firstName");
       firstname = scn.nextLine();
       
       System.out.println("please enter lastName");
       lastname = scn.nextLine();
       
       System.out.println("Enter your username");
       username = scn.nextLine();
       
       if(login.checkUserName(username)){
           System.out.println("Username is succefully captured");
       }else{
           System.out.println("UserName is not correctly formatted, please ensure that user name" 
              + "contains an under score and no more than five characters in length ");
           

       }
       
       
        System.out.println("please enter passWord");
       password = scn.nextLine();
       
       if(login.checkPassword(password)){
           System.out.println("password is succefully captured");
       }else{
           System.out.println("Password is not correctly formated,ensure that password contains at least 8 characteres "
                   +"a capital letter,number and special character");
          

       }
       
        System.out.println("please enter cellphone number");
       cellphoneNumber = scn.nextLine();
       
       if(login.checkCellphone(cellphoneNumber)){
           System.out.println("cellphone number is succefully added");
           
       }else{
          System.out.println("cellphone number is incorrectly formatted or does not contain international code ");
           return;  
       }
     //registration confirmation
     {
      System.out.println(login.checkregisterUser(username ,password));
       
      System.out.println("LOGIN");
      
         System.out.println("Enter username");
         String enteredUsername = scn.nextLine();
        
         System.out.println("Enter password");
         String enteredPassword = scn.nextLine();
        
        boolean loginUser = login.loginUser( password ,username, enteredUsername,enteredPassword);
        
              if(loginUser){
                  System.out.println("Login successful!");
                }else{
                   System.out.println("Login failed"); 
                  
                  
                  
              
    }
    }   
       
    }      
   
}     
      
          
       

        
             



         
       

  
      


       
    
 
  
