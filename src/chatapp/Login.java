package chatapp;

  import java.util.Scanner;


/**
 *
 * @author KHUTSO
 */
public class Login {

        private String enteredfirstName;
        private String enteredlastName;
        private String enteredUsername;
        private String enteredpassWord;
        private String enteredcellphoneNumber;
       
        
      boolean isLoggedIn = false;
       
    //userName validation
    public boolean checkUserName(String enteredUsername){
    
            //password validation
            return enteredUsername.contains("_") && enteredUsername.length() <=5;
     
    }
    
  public boolean checkPassword(String enteredPassword){ 
      String passwordValidation = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
      
            return enteredPassword.matches(passwordValidation);   
  }  
   //cellphone validation
   
  
    public boolean checkCellphone(String enteredCellphoneNumber){
       String cellphoneValidation = "^(\\+27)[6-8][0-9]{1}[- ]?[0-9]{3}[- ]?[0-9]{4}$"; 
       
            return enteredCellphoneNumber.matches(cellphoneValidation);
        }
    public String checkregisterUser(String enteredUsername,String enteredpassword){
       
      if(!checkUserName(enteredUsername)){
          return "Username is incorrectly formated";
      }
      if(!checkPassword(enteredpassword)){    
          return "password does not meet complexity"; 
   
      }
      return "the two above conditions have been met, and the user has been registered successfully. ";
    }

    public Login(){
        this.enteredfirstName = enteredfirstName;
        this.enteredlastName = enteredlastName;
        this.enteredUsername = enteredUsername;
        this.enteredpassWord = enteredpassWord;
        this.enteredcellphoneNumber = enteredcellphoneNumber;
        
       
    }
   
}    
 
  