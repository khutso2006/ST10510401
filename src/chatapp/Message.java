
package chatapp;

import java.io.File;
import java.util.Random;

/**
 * The Message class manages the message details, validation, and hashing.
 */
    // Attributes
 import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * The Message class manages message details and JSON database storage.
 */
public class Message {
    private String messageID;
    private String recipient;
    private String messageContent;
    private String messageHash;
    private static int totalMessagesCount = 0;

    // Constructor
    public Message(String messageID, String recipient, String messageContent) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.messageContent = messageContent;
    }

    // Getters and Setters
    public String getMessageID() { return messageID; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public String getMessageContent() { return messageContent; }
    public void setMessageContent(String messageContent) { this.messageContent = messageContent; }
    public String getMessageHash() { return messageHash; }

    public String checkRecipientCell(String recipient) {
        if (recipient.startsWith("+") && recipient.length() >= 3 && recipient.length() <= 13) {
            return "cellphone number successfully captured";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String createMessageHash() {
        String firstTwo = messageID.substring(0, Math.min(messageID.length(), 2));
        String[] words = messageContent.trim().split("\\s+");
         String firstWord = words[0].toUpperCase();

        String lastWord = words[words.length-1 ].toUpperCase();
        
        // Hash includes the ID prefix, the count at creation, and the last word
        this.messageHash = firstTwo + ":" + (totalMessagesCount + 1) + ":" +firstWord+ lastWord;
        return this.messageHash;
    }

    /**
     * Stores the message details in a JSON-formatted text file (Database).
     * Saves both "Sent" and "Stored" messages with all their details.
     */
    public void storeMessages(String status) {
        String jsonEntry = "{\n" +
                "  \"status\": \"" + status + "\",\n" +
                "  \"messageID\": \"" + messageID + "\",\n" +
                "  \"recipient\": \"" + recipient + "\",\n" +
                "  \"messageContent\": \"" + messageContent + "\",\n" +
                "  \"messageHash\": \"" + messageHash + "\",\n" +
                "  \"timestamp\": \"" + new java.util.Date() + "\"\n" +
                "},\n";
        
        try (FileWriter file = new FileWriter("messages_db.json", true)) {
            file.write(jsonEntry);
        } catch (IOException e) {
            System.err.println("Database Error: " + e.getMessage());
            System.out.println(new File("messages.json").getAbsolutePath());
        }
        
    }

    public String printMessages() {
        return "Message ID: " + messageID + "\n" +
               "Message Hash: " + messageHash + "\n" +
               "Recipient: " + recipient + "\n" +
               "Message: " + messageContent;
    }

    public static void incrementTotalMessages() { totalMessagesCount++; }
    public static int returnTotalMessages() { return totalMessagesCount; }
    
    public static String generateRandomID() {
        Random rand = new Random();
        String id = "";
        for (int i = 0; i < 10; i++) id += rand.nextInt(10);
        return id;
    }
}
