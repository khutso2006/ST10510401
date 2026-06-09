
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
    sentMessages.add(message);   // 🔥 THIS LINE IS CRITICAL

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
  