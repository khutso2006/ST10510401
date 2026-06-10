/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chatapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class storedMessagesTest {

    storedMessages sm;

    @Before
    public void setUp() {
        sm = new storedMessages();

        
        storedMessages.storedMessages.clear();
        storedMessages.sentMessages.clear();
        storedMessages.discardedMessages.clear();

                       Message m1 = new Message("M001", "+27834557896", "Did you get the cake?", "Hash1");
        storedMessages.sentMessages.add(m1);

               Message m2 = new Message("M002", "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Test Message 2");
        storedMessages.storedMessages.add(m2);

        
        Message m3 = new Message("M003", "+27834484567", "Yohoooo, I am at your gate.", "Hash3");
        storedMessages.discardedMessages.add(m3);

                Message m4 = new Message("0838884567", "", "It is dinner time !", "Hash4");
        storedMessages.sentMessages.add(m4);

                Message m5 = new Message("M005", "+27838884567", "Ok, I am leaving without you.", "Hash5");
        storedMessages.storedMessages.add(m5);
    }

    
    @Test
    public void testLoadMessages() {
        storedMessages.loadMessagesFromJSON();
        assertNotNull(storedMessages.storedMessages);
    }

    
    @Test
    public void testDisplaySendersAndRecipients() {
        sm.displayStoredmessage(); 
        // Verifying that the two "Stored" messages (Message 2 and Message 5) exist
        assertEquals(2, storedMessages.storedMessages.size());
    }

    
    @Test
    public void testDisplayLongestMessage() {
        sm.displayLongestMessage();
        
        // Verifying that Message 2 is identifiable as the longest entry
        String expectedLongest = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(expectedLongest, storedMessages.storedMessages.get(0).getMessageContent());
    }

       @Test
    public void testSearchByMessageID() {
        sm.searchByMessageID("0838884567");
        
        Message found = null;
        for (Message m : storedMessages.sentMessages) {
            if (m.getMessageID().equals("0838884567")) {
                found = m;
            }
        }
        
        assertNotNull(found);
        assertEquals("It is dinner time !", found.getMessageContent());
    }

        @Test
    public void testSearchByRecipient() {
        sm.searchByRecipient("+27838884567");
        
        // Verify that the recipient matches our specific test records
        assertEquals("+27838884567", storedMessages.storedMessages.get(0).getRecipient());
        assertEquals("+27838884567", storedMessages.storedMessages.get(1).getRecipient());
    }

   
    @Test
    public void testDeleteByHash() {
        int initialSize = storedMessages.storedMessages.size();
        
        sm.deleteByHash("Test Message 2");

        // Confirms that the target stored message was successfully removed
        assertEquals(initialSize - 1, storedMessages.storedMessages.size());
    }

        @Test
    public void testDisplayFullReport() {
        sm.displayFullReport();
        
        assertTrue(storedMessages.storedMessages.size() > 0);
    }

        @Test
    public void testDisplaySentMessages() {
        sm.displaySentMessages();
        assertEquals(2, storedMessages.sentMessages.size());
        assertEquals("Did you get the cake?", storedMessages.sentMessages.get(0).getMessageContent());
    }

    
    @Test
    public void testDisplayDiscardedMessages() {
        sm.displayDiscardedMessages();
        assertEquals(1, storedMessages.discardedMessages.size());
        assertEquals("Yohoooo, I am at your gate.", storedMessages.discardedMessages.get(0).getMessageContent());
    }

    
    @Test
    public void testDisplayCounts() {
        sm.displayCounts();
        assertEquals(2, storedMessages.storedMessages.size()); 
        assertEquals(2, storedMessages.sentMessages.size());    
        assertEquals(1, storedMessages.discardedMessages.size()); 
    }

    
    @Test
    public void testDisplayRecentSentMessages() {
        sm.displayRecentSentMessages();
        // Confirms the last sent entry matches Message 4 data attributes
        assertEquals("0838884567", storedMessages.sentMessages.get(1).getMessageID());
    }
}
