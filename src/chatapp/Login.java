package chatapp;

 

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
      // if (enteredUsername.contains("_")  && enteredUsername.length()<=5){
        //return true;
     // }else{ 
       //return false;        
       return(enteredUsername.contains("_") && enteredUsername.length() <=5);
    }
    //password validation
  public boolean checkPasswordComplexity(String enteredPassword){ 
      String passwordvalidation = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&!+=*]).{8,})";
      //codeLucky(2 january 2025)Password Strength Validation with RegEx.Available at:https://youtu.be/voK2yiWD-XY?si=ngXdQMA0Mavfn-1e (Accessed :12 April 2026)
   return enteredPassword.matches(passwordvalidation);   
  }
     //cellphone validation
    public boolean CellphoneNumber(String enteredCellphoneNumber){
       String cellphoneValidation = "^$|(\\+27)[1-8][0-9]{8}$"; 
       //NumberCrunchProgrammers(27 Dec 2014)Java program to validate South African phone number.Available at:https://youtu.be/2M1CpEJZ6rk?si=xrV9ryWft3ARxHoB
       //(Accessed:12 April 2026)
       
          
          boolean isCorrect = enteredCellphoneNumber.matches(cellphoneValidation);

            return isCorrect;
             
          
             
        }
    //checking if ever the entered username martches with validation username
    public String  checkregisterUser(String enteredUsername ,String enteredpassword){
           boolean isCorrect = true;
      if(!checkUserName(enteredUsername)){
            System.out.println("Username is incorrectly formated");
          isCorrect = false;
          
            
      }
      //checking if ever the entered password martches with validation password
       if(!checkPasswordComplexity(enteredpassword)){   
             System.out.println("password does not meet complexity"); 
          isCorrect = false;
          
           
            }
          if(isCorrect ){
               System.out.println("the two above conditions have been met,and the user have been registered successfuly");
             
          }else{
             System.out.println("Registration unsuccessful");
              System.exit(0);// It stop the program from executing if the registration is unsuccessful
          } 
           System.out.println();
       return"Registration successful"; 
       
    }      
    
  public boolean loginUser(String username,String password,String enteredusername,String enteredpassword) {
            //Compare entered details with stored ones
       // Compare entered details with stored ones
       // if (username.equals(enteredusername) && password.equals(enteredpassword)){
          //return true;
     // }else{ 
          //return false;        
            return username.equals(enteredusername) && password.equals(enteredpassword);
            
  }
    // METHOD: Return login status message
   public String returnLoginStatus(boolean loginSuccess){
        if (loginSuccess) {
            return "Welcome "+ firstName + " " + lastName + ", it is great to see you again!";
        } else {
            return "Username or password incorrect, please try again.";
        
    }
}   

         
   //constractor 

    public Login() {
        this.firstName = enteredfirstName;
        this.lastName = enteredlastName;
        this.username = enteredusername;
        this.password = enteredpassword;
        this.cellphoneNumber = enteredcellphoneNumber;
    }

      
   
   }



