
package chatapp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;


public class storedMessages {
    

    // Arrays (ArrayLists)
        
public static ArrayList<Message> storedMessages = new ArrayList<>();
public static ArrayList<Message> sentMessages = new ArrayList<>();
public static ArrayList<Message> discardedMessages = new ArrayList<>();


    
   public static void loadMessagesFromJSON() {
       storedMessages.clear();
sentMessages.clear();
discardedMessages.clear();
    try {
        File file = new File("messages_db.json");
        Scanner reader = new Scanner(file);

        String id = "", rec = "", msg = "", hash = "", status = "";

        while (reader.hasNextLine()) {

            String line = reader.nextLine().trim();

            if (line.contains("\"status\""))
                status = line.split(":")[1].replace("\"", "").replace(",", "").trim();

            if (line.contains("\"messageID\""))
                id = line.split(":")[1].replace("\"", "").replace(",", "").trim();

            if (line.contains("\"recipient\""))
                rec = line.split(":")[1].replace("\"", "").replace(",", "").trim();

            if (line.contains("\"messageContent\""))
                msg = line.split(":")[1].replace("\"", "").replace(",", "").trim();

            if (line.contains("\"messageHash\"")) {
    hash = line.substring(line.indexOf(":") + 1)
               .replace("\"", "")
               .replace(",", "")
               .trim();
}
            if (line.contains("},")) {

                Message message = new Message(id, rec, msg, hash);

                if (status.equalsIgnoreCase("STORED")) {
    storedMessages.add(message);

} else if (status.equalsIgnoreCase("SENT")) {
    sentMessages.add(message);   // 

} else if (status.equalsIgnoreCase("DISCARDED")) {
    discardedMessages.add(message);
}

                id = rec = msg = hash = status = "";
            }
        }

        reader.close();

    } catch (Exception e) {
        System.out.println("Error loading JSON.");
    }
}

    private void saveToJSON() {

    try (FileWriter file = new FileWriter("messages_db.json")) {

        // STORED
        for (Message m : storedMessages) {
            writeMessage(file, m, "STORED");
        }

        // SENT
        for (Message m : sentMessages) {
            writeMessage(file, m, "SENT");
        }

        // DISCARDED
        for (Message m : discardedMessages) {
            writeMessage(file, m, "DISCARDED");
        }

    } catch (IOException e) {
        System.out.println("Error saving.");
    }
}

private void writeMessage(FileWriter file, Message m, String status) throws IOException {

    file.write("{\n");
    file.write("\"status\": \"" + status + "\",\n");
    file.write("\"messageID\": \"" + m.getMessageID() + "\",\n");
    file.write("\"recipient\": \"" + m.getRecipient() + "\",\n");
    file.write("\"messageContent\": \"" + m.getMessageContent() + "\",\n");
    file.write("\"messageHash\": \"" + m.getMessageHash() + "\"\n");
    file.write("},\n");
}

    // a. DISPLAY SENDER + RECIPIENT
    public void displayStoredmessage() {
    for (Message m : storedMessages) {
        System.out.println("Sender: Quick chartApp user " );
         System.out.println("Message: " + m.getMessageContent());
         System.out.println("Recipient: " + m.getRecipient());
    }
}
    // b. LONGEST MESSAGE
   public void displayLongestMessage() {

    Message longest = null;

    for (Message m : storedMessages) {
        if (longest == null || m.getMessageContent().length() > longest.getMessageContent().length()) {
            longest = m;
        }
    }

    if (longest != null)
        System.out.println("Longest: " + longest.getMessageContent());
}
    // c. SEARCH BY MESSAGE ID
        // c. SEARCH BY MESSAGE ID
    public void searchByMessageID(String id) {
        for (Message m : storedMessages) {
            if (m.getMessageID().equals(id)) {
                System.out.println("ID: " + m.getMessageID());
                System.out.println("Recipient: " + m.getRecipient());
                System.out.println("Message: " + m.getMessageContent());
                return;
            }
        }
        System.out.println("Message ID not found.");
    }

    // d. SEARCH BY RECIPIENT
        // d. SEARCH BY RECIPIPIENT
    public void searchByRecipient(String rec) {
        boolean found = false;
        
        for (Message m : storedMessages) {
            if (m.getRecipient().equalsIgnoreCase(rec)) {
                System.out.println("Message: " + m.getMessageContent());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No messages found for this recipient.");
        }
    }

    // e. DELETE USING HASH
     
   public void deleteByHash(String hash) {

    hash = hash.trim();   

    System.out.println("INPUT: [" + hash + "]");
    boolean found = false;

    for (int i = 0; i < storedMessages.size(); i++) {

        String storedHash = storedMessages.get(i).getMessageHash().trim();

        System.out.println("STORED: [" + storedHash + "]");

        if (storedHash.equalsIgnoreCase(hash)) {
            storedMessages.remove(i);
            System.out.println("Deleted successfully.");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Hash not found.");
    }
}
    //
       // f. FULL REPORT
  public void displayFullReport() {

    if (storedMessages.isEmpty()) {
        System.out.println("No stored messages.");
        return;
    }

    System.out.println("\n--- Message Report ---");

    for (Message m : storedMessages) {

        System.out.println("Hash: " + m.getMessageHash());
        System.out.println("Recipient: " + m.getRecipient());
        System.out.println("Message: " + m.getMessageContent());
        System.out.println("----------------------------");
    }
}
    public void displaySentMessages() {
    for (Message m : sentMessages) {
        System.out.println("Sent " + m.getRecipient() + ": " + m.getMessageContent());
    }
}
    public void displayDiscardedMessages() {
    for (Message m : discardedMessages) {
        System.out.println("Discarded -> " + m.getMessageContent());
    }
}
  
    

