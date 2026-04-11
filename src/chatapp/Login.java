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
    //password validation
  public boolean checkPasswordComplexity(String enteredPassword){ 
      String passwordvalidation = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&!+=]).{8,})";//Youtubw
   return enteredPassword.matches(passwordvalidation);   
  }
     //cellphone validation
    public boolean CellphoneNumberIsValidREGEX(String enteredCellphoneNumber){
       String cellphoneValidation = "^$|(\\+27)[1-8][0-9]{8}$"; //research
       
            return enteredCellphoneNumber.matches(cellphoneValidation);
        }
    //checking if ever the entered username martches with validation password
    public String  checkregisterUser(String enteredUsername ,String enteredpassword){
           boolean isCorrect = true;
      if(!checkUserName(enteredUsername)){
            System.out.println("Username is incorrectly formated");
          isCorrect = false;
          
            //stop executing to login
      }
      //checking if ever the entered password martches with validation password
       if(!checkPasswordComplexity(enteredpassword)){   
             System.out.println("password does not meet complexity"); 
          isCorrect = false;
          
           //stop executing to login
            }
          if(isCorrect ){
               System.out.println("the two above conditions have been met,and the user have been registered successfuly");
             //stop executing to login
          }else{
             System.out.println("Registration unsuccessful");
              System.exit(0);
          } 
           System.out.println();
       return"Registration successful";   
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
            return "Welcome "+ firstName + " " + lastName + ", it is great to see you again!";
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


