
package chatapp;
//allows input from user
import java.util.Scanner;

public class ChatApp {

    public static void main(String[] args) {
     
     
       //declaring variables
       String firstName;
       String lastName;
       String username;
       String password;
       String cellphoneNumber;
       
       //Scanner
     Scanner scn = new Scanner(System.in);
        //class1 + Class2=Linking classes
        
        Login login = new Login();
        
        System.out.println( "(====REGISTER====)");
        //prompt the user to register
        
       System.out.print("please enter firstName:");
       firstName = scn.nextLine();
       
       System.out.print("please enter lastName:");
       lastName = scn.nextLine();
       
       System.out.print("Enter your username:");
       username = scn.nextLine();
       
       //calling the method of username
       if(login.checkUserName(username)){
           System.out.println("Username is succefully captured");
       }else{
           System.out.println("UserName is not correctly formatted, please ensure that username" 
              + " contains an under score and no more than five characters in length ");
       }
       //calling the method of password
        System.out.print("please enter passWord:");
       password = scn.nextLine();
       
       if(login.checkPasswordComplexity(password)){
           System.out.println("password is succefully captured");
       }else{
           System.out.println("Password is not correctly formated,ensure that password contains at least 8 characteres "
                   +"a capital letter,number and special character");
       }
       
        System.out.print("please enter South African cellphone number:");
       cellphoneNumber = scn.nextLine();
       //calling the method of cellphone number
       if(login.CellphoneNumber(cellphoneNumber)){
           System.out.println("cellphone number is succefully added");   
       }else{
          System.out.println("cellphone number is incorrectly formatted or does not contain international code ");
          
       }
     //registration confirmation
     
      
      System.out.println(login.checkregisterUser(username, password));
     
   
      //prompt the user to Login with the previous registration details
      System.out.println("(===LOGIN===)");
      
         System.out.println("Enter username");
         String enteredUsername = scn.nextLine();
        
         System.out.println("Enter password");
         String enteredPassword = scn.nextLine();
        
        boolean loginUser = login.loginUser(username,password,enteredUsername, enteredPassword );
        
              if(loginUser){
                  System.out.println("Login successful!");
                  System.out.println("Welcome " +firstName + ", " +lastName+ " is great to see you again");
                }else{
                   System.out.println("Login failed"); 
                   System.out.println("username or password is incorrect, please try again");
                  
                  
              }          
    }
    }   
       
          
   
     
      
          
       

        
             



         
       

  
      


       
    
 
  
