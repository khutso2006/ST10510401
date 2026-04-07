
package chatapp;
import java.util.Scanner;

public class ChatApp {

    public static void main(String[] args) {
     
     
       //declaring variables
       String firstname;
       String lastname;
       String Username;
       String Password;
       String cellphoneNumber;
       //Scanner
     Scanner scn = new Scanner(System.in);
             
      } 
    //creating an account  
    public static void register(Scanner scn) {
        //class1 + Class2=Linking classes
         Login login = new Login();           
       System.out.println("please enter firstName");
       String firstname = scn.next();
       
       System.out.println("please enter lastName");
       String lastname = scn.next();
       
       System.out.println("Enter your username");
       String Username = scn.next();
       
       if(login.checkUserName(Username)){
           System.out.println("Username is succefully captured");
       }else{
           System.out.println("UserName is not correctly formatted, please ensure that user name" 
              + "contains an under score and no more than five characters in length ");
       }
       
        System.out.println("please enter passWord");
       String Password = scn.nextLine();
       
       if(login.checkPassword(Password)){
           System.out.println("password is succefully captured");
       }else{
           System.out.println("Password is not correctly formated,ensure that password contains at least 8 characteres "
                   +"a capital letter,number and special character");
          
       }
       
        System.out.println("please enter cellphone number");
       String cellphoneNumber = scn.nextLine();
       
       if(login.checkCellphone(cellphoneNumber)){
           System.out.println("cellphone number is succefully added");
       }else{
          System.out.println("cellphone number is incorrectly formatted or does not contain international code ");
          
    }  
     
    }
           }
         
       

  
      


       
    
 
  
