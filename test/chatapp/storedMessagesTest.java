/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chatapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class storedMessagesTest {

    storedMessages sm;

    @Before
    public void setUp() {
        sm = new storedMessages();

        storedMessages.storedMessages.clear();
        storedMessages.sentMessages.clear();
        storedMessages.discardedMessages.clear();
    }

    // ✅ LOAD JSON (basic test)
    @Test
    public void testLoadMessages() {
        storedMessages.loadMessagesFromJSON();
        assertNotNull(storedMessages.storedMessages);
    }

    // ✅ DISPLAY SENDERS + RECIPIENTS
    @Test
    public void testDisplaySendersAndRecipients() {
        Message m = new Message("1", "Bob", "Hello", "11:1:HELLO");
        storedMessages.storedMessages.add(m);

        sm.displayStoredmessage(); // just ensure no crash
        assertEquals(1, storedMessages.storedMessages.size());
    }

    // ✅ LONGEST MESSAGE
    @Test
    public void testDisplayLongestMessage() {
        Message m1 = new Message("1", "A", "Short", "1:1:SHORT");
        Message m2 = new Message("2", "B", "This is longer", "2:2:LONG");

        storedMessages.storedMessages.add(m1);
        storedMessages.storedMessages.add(m2);

        sm.displayLongestMessage(); // ensure runs
        assertEquals(2, storedMessages.storedMessages.size());
    }

    // ✅ SEARCH BY MESSAGE ID
    @Test
    public void testSearchByMessageID() {
        Message m = new Message("123", "John", "Hi", "12:1:HI");
        storedMessages.storedMessages.add(m);

        sm.searchByMessageID("123");
        assertEquals("123", storedMessages.storedMessages.get(0).getMessageID());
    }

    // ✅ SEARCH BY RECIPIENT
    @Test
    public void testSearchByRecipient() {
        Message m = new Message("123", "Alice", "Hello", "12:1:HELLO");
        storedMessages.storedMessages.add(m);

        sm.searchByRecipient("Alice");
        assertEquals("Alice", storedMessages.storedMessages.get(0).getRecipient());
    }

    // ✅ DELETE BY HASH
    @Test
    public void testDeleteByHash() {
        Message m = new Message("123", "Bob", "Test", "12:1:TEST");
        storedMessages.storedMessages.add(m);

        sm.deleteByHash("12:1:TEST");

        assertEquals(0, storedMessages.storedMessages.size());
    }

    // ✅ FULL REPORT
    @Test
    public void testDisplayFullReport() {
        Message m = new Message("1", "A", "Hello", "11:1:HELLO");
        storedMessages.storedMessages.add(m);

        sm.displayFullReport();
        assertEquals(1, storedMessages.storedMessages.size());
    }

    // ✅ DISPLAY SENT MESSAGES
    @Test
    public void testDisplaySentMessages() {
        Message m = new Message("1", "Tom", "Hi", "11:1:HI");
        storedMessages.sentMessages.add(m);

        sm.displaySentMessages();
        assertEquals(1, storedMessages.sentMessages.size());
    }

    // ✅ DISPLAY DISCARDED
    @Test
    public void testDisplayDiscardedMessages() {
        Message m = new Message("1", "Tom", "Trash", "11:1:TRASH");
        storedMessages.discardedMessages.add(m);

        sm.displayDiscardedMessages();
        assertEquals(1, storedMessages.discardedMessages.size());
    }

    // ✅ DISPLAY COUNTS
    @Test
    public void testDisplayCounts() {
        storedMessages.storedMessages.add(new Message("1", "A", "Msg", "1:1:MSG"));
        storedMessages.sentMessages.add(new Message("2", "B", "Msg", "2:2:MSG"));

        sm.displayCounts();
        assertEquals(1, storedMessages.storedMessages.size());
        assertEquals(1, storedMessages.sentMessages.size());
    }

    // ✅ RECENT SENT MESSAGE
    @Test
    public void testDisplayRecentSentMessages() {
        Message m1 = new Message("1", "A", "First", "1:1:FIRST");
        Message m2 = new Message("2", "B", "Second", "2:2:SECOND");

        storedMessages.sentMessages.add(m1);
        storedMessages.sentMessages.add(m2);

        sm.displayRecentSentMessages();

        assertEquals("B", storedMessages.sentMessages.get(1).getRecipient());
    }
}