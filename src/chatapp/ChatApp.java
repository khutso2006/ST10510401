package chatapp;

//allows input from user

import java.util.Scanner;





public class ChatApp {
   
    private static Login loginSystem = new Login();
    private static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {
     chatapp.storedMessages.loadMessagesFromJSON();

    
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
       
        System.out.print("please enter passWord:");
       password = scn.nextLine();
       //calling the method of password
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
      
                  System.out.print("Enter username");
         String enteredUsername = scn.nextLine();
        
         System.out.print("Enter password");
         String enteredPassword = scn.nextLine();
        
        boolean loginUser = login.loginUser(username,password,enteredUsername, enteredPassword );
        
              if(loginUser){
                  System.out.println("Login successful!");
                  System.out.println("Welcome " +firstName + ", " +lastName+ " is great to see you again");
                }else{
                   System.out.println("Login failed"); 
                   System.out.println("username or password is incorrect, please try again");
                  System.exit(0);
              
            
        } 
           

             

      ChatApp app = new ChatApp();
      System.out.println("*************************************");
      System.out.println("=======WELCOME TO QUICK CHART APP======");
      System.out.println("*************************************");       
      app.runAppLoop();
    
       
    }
        
      private static void runAppLoop() { 
        while (true) { 
            System.out.println("\nMenu Options:"); 
            System.out.println("1) Send Messages"); 
            System.out.println("2) Show recently sent messages"); 
            System.out.println("3) Quit"); 
             System.out.println("4)stored messages");
            System.out.print("Select an option: "); 
             
            String choice = scanner.nextLine(); 
             
           if (choice.equals("1")) {
    SendMessages();
           }else if (choice.equals("2")) {

    storedMessages sm = new storedMessages();   // create object
    sm.loadMessagesFromJSON();                  // load data
    sm.displayRecentSentMessages();             // show result

} else if (choice.equals("3")) {
    System.out.println("Final total of messages sent: " + Message.returnTotalMessages());
    System.out.println("Exiting QuickChat. Goodbye!");
    System.exit(0);
} else if (choice.equals("4")) {
    
    handleStoredMessages();
} else {
    System.out.println("Invalid choice.");
}


        }
      }
     private static void handleStoredMessages() {

    storedMessages sm = new storedMessages();
    sm.loadMessagesFromJSON();

    String choice;

    do {
        System.out.println("\nStored Messages Menu:");
        System.out.println("1) Display stored messages");
        System.out.println("2) Display longest message");
        System.out.println("3) Search by Message ID");
        System.out.println("4) Search by Recipient");
        System.out.println("5) Delete by Hash");
        System.out.println("6) Full Report");
        System.out.println("7) Back to main menu");

        System.out.print("Select option: ");
         choice = scanner.nextLine();

      }
 
    private static void SendMessages() { 
        
        System.out.print("How many messages would you like to enter? "); 
        String input = scanner.nextLine(); 
        int num; 
        try { 
            num = Integer.parseInt(input); 

 
        } catch (NumberFormatException e) { 
            System.out.println("Invalid number."); 
            return; 
        } 
 
        for (int i = 0; i < num; i++) { 
            String msgID = Message.generateRandomID(); 
            System.out.println("\nProcessing Message " + (i + 1)); 
            System.out.print("Enter Recipient Number (e.g., +2712345678): "); 
            String recipient = scanner.nextLine(); 
             
            // Recipient validation 
            Message temp = new Message(msgID, recipient, ""); 
            String cellStatus = temp.checkRecipientCell(recipient); 
            System.out.println(cellStatus); 
            if (cellStatus.contains("incorrectly")) { i--; continue; } 
             
            System.out.print("Enter Message (max 250 chars): "); 
            String content = scanner.nextLine(); 
            if (content.length() > 250) {  
                System.out.println("Message too long."); 
                i--; continue;  
            } 
 
            // 1. Requirement: Display "Message ready to send" 
                // Create message FIRST
Message message = new Message(msgID, recipient, content);
message.createMessageHash();


System.out.println("\n--- Message Details ---");
System.out.println(message.printMessages());


System.out.println("Message ready to send");


System.out.println("\nChoose one option:");
System.out.println("1) Send Message");
System.out.println("2) Discard Message");
System.out.println("3) Store Message");

System.out.print("Option: ");
String opt = scanner.nextLine();
     
           message = new Message(msgID, recipient, content);

// Create hash FIRST
message.createMessageHash();

// Option 1 (Send)
if (opt.equals("1")) {

    Message.incrementTotalMessages();

    System.out.println("Message successfully sent");
    System.out.println("Total number messages sent: " +
    Message.returnTotalMessages());

    message.storeMessages("SENT");

                 
            } else if (opt.equals("2")) { 
                message.storeMessages("DISCARDED");
                System.out.println("press 0 to delete.");
                
            } else if (opt.equals("3")) { 
                message.storeMessages("STORED"); 
                System.out.println("Message successfully stored in JSON");
            }
        }
    }
}




