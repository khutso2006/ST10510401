package chatapp;

 


/**
 *
 * @author KHUTSO
 */
public class Login {
     
        private String enteredfirstName;
        private String enteredlastName;
        private String enteredusername;
        private String enteredpassword;
        private String enteredcellphoneNumber;
       
        
      boolean isLoggedIn = false;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String cellphoneNumber;
       
    //userName validation
    public boolean checkUserName(String enteredUsername){
    
            //password validation
            return(enteredUsername.contains("_") && enteredUsername.length() <=5);
            
   
    }
  public boolean checkPassword(String enteredPassword){ 
      String passwordValidation =( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
      
  
   return enteredPassword.matches(passwordValidation);   
  
   //cellphone validation
  }
     
     
    public boolean checkCellphone(String enteredCellphoneNumber){
       String cellphoneValidation = "^(\\+27)[6-8][0-9]{1}[- ]?[0-9]{3}[- ]?[0-9]{4}$"; 
       
            return enteredCellphoneNumber.matches(cellphoneValidation);
        }
    
     
       public String  checkregisterUser(String enteredUsername ,String enteredpassword){
      if(!checkUserName(enteredUsername)){
            System.out.println( "Username is incorrectly formated");
        
      }
       if(!checkPassword(enteredpassword)){   
             System.out.println("password does not meet complexity"); 
          
       }
       else{
             System.out.println ("the two above conditions have been met,and the user have been registered successfuly");
       }
      
       return"";
       }
       
            
  public boolean loginUser(String username, String password,String enteredUsername,String enteredPassword) {
        // Compare entered details with stored ones
        if (username.equals(enteredUsername) && password.equals(enteredPassword)){
        return true;
      }else{
       return false;
    }
  }
    // METHOD: Return login status message
    public String returnLoginStatus(boolean loginSuccess) {

        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again!";
        } else {
            return "Username or password incorrect, please try again.";
        
    }
}  
         
   //constractor 
   public Login(){
        this.firstName = enteredfirstName;
        this.lastName = enteredlastName;
        this.username = enteredusername;
        this.password = enteredpassword;
        this.cellphoneNumber = enteredcellphoneNumber;
   }
}


