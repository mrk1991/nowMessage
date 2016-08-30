/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nowmessage;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anto
 */
public class MessageSystemTest {
    
    
    
    
    public MessageSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class MessageSystem.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MessageSystem expResult = MessageSystem.getInstance();
        MessageSystem result = MessageSystem.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of newMessage method, of class MessageSystem.
     */
    @Test
    public void testNewMessage_Group_String() {
        System.out.println("newMessage");
        
        ServerCommunicationSystem server = ServerCommunicationSystem.getInstance();
        LocalUser lu = server.getLocalUser();
        
        Group receivers = lu.getGroupList().get(0);
        String text = "Ciao";
        MessageSystem instance = MessageSystem.getInstance();
        String expResult = "Ciao";
        Sending result = instance.newMessage(receivers, text);
        assertEquals(expResult, result.getMessage().getText());
        
    }

    /**
     * Test of newMessage method, of class MessageSystem.
     */
    @Test
    public void testNewMessage_ArrayList_String() {
        System.out.println("newMessage");
        
        ServerCommunicationSystem server = ServerCommunicationSystem.getInstance();
        LocalUser lu = server.getLocalUser();
        
        ArrayList<Contact> receivers = lu.getContactList();
        String text = "Prova";
        MessageSystem instance = MessageSystem.getInstance();
        Sending expResult = new Sending(lu.getContactList(),new Message("Prova"));
        Sending result = instance.newMessage(receivers, text);
        assertEquals(expResult.toString(), result.toString());
        
        
    }

    /**
     * Test of newMessage method, of class MessageSystem.
     */
    @Test
    public void testNewMessage_3args_1() {
        System.out.println("newMessage");
        
        ServerCommunicationSystem server = ServerCommunicationSystem.getInstance();
        LocalUser lu = server.getLocalUser();
        
        Group receivers = lu.getGroupList().get(1);
        String text = "Prova2";
        Media attachment = new Image("Foto",100.0,100.0);
        MessageSystem instance = MessageSystem.getInstance();
        Sending expResult = new Sending(receivers.getContactList(),new Message("Prova2",attachment));
        Sending result = instance.newMessage(receivers, text, attachment);
        
    }

  

    /**
     * Test of sendMessage method, of class MessageSystem.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        
        ServerCommunicationSystem server = ServerCommunicationSystem.getInstance();
        LocalUser lu = server.getLocalUser();
        MessageSystem instance = MessageSystem.getInstance();
        
        String text="Ciao ISW 2016";
        Sending sending = instance.newMessage(lu.getGroupList().get(1).getContactList(), text);
        
        Boolean expResult = true;
        Boolean result = instance.sendMessage(sending);
        assertEquals(expResult, result);
        
        
        for (Contact contact: lu.getGroupList().get(1).getContactList()){
            assertEquals(contact.getMessages().get(contact.getMessages().size()-1).getText(),text);
        }
        
    }
    
}
