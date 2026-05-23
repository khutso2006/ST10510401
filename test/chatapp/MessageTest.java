package Chatapp;

import chatapp.ChatApp
import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    public MessageTest() {
    }

     @Test
    public void testMessageCreation() {
       Message msg = new Message("1234567890", "+27123456789", "Hello world");

        assertEquals("1234567890", msg.getMessageID());
        assertEquals("+27123456789", msg.getRecipient());
        assertEquals("Hello world", msg.getMessageContent());
    }

    // Test valid recipient
    @Test
    public void testValidRecipient() {
       Message msg = new Message("1234567890", "+27831234567", "Test message");

        String result = msg.checkRecipientCell("+27831234567");

        assertEquals("cellphone number successfully captured", result);
    }

    // Test invalid recipient
    @Test
    public void testInvalidRecipient() {
        Message msg = new Message("1234567890", "0831234567", "Test message");

        String result = msg.checkRecipientCell("0831234567");

        assertTrue(result.contains("incorrectly formatted"));
    }

    // Test message hash creation
    @Test
    public void testCreateMessageHash() {
        Message msg = new Message("12ABC", "+27831234567", "Hello Chat App");

        String hash = msg.createMessageHash();

        // Expected: first 2 chars + count + first word + last word
        assertTrue(hash.startsWith("12:"));
        assertTrue(hash.contains("HELLO"));
        assertTrue(hash.contains("APP"));
    }

    // Test total messages counter
    @Test
    public void testMessageCounter() {
        int before = Message.returnTotalMessages();

        Message.incrementTotalMessages();
        Message.incrementTotalMessages();

        int after = Message.returnTotalMessages();

        assertEquals(before + 2, after);
    }

    // Test random ID generation
    @Test
    public void testGenerateRandomID() {
        String id = Message.generateRandomID();

        assertEquals(10, id.length());
        assertTrue(id.matches("\\d{10}")); // must be 10 digits
    }

    // Test printMessages method
    @Test
    public void testPrintMessages() {
        Message msg = new Message("1234567890", "+27831234567", "Hello world");
        msg.createMessageHash();

        String output = msg.printMessages();

        assertTrue(output.contains("Message ID: 1234567890"));
        assertTrue(output.contains("Recipient: +27831234567"));
        assertTrue(output.contains("Hello world"));
    }
}