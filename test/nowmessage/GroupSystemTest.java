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
 * @author Mrk
 */
public class GroupSystemTest {
    
    public GroupSystemTest() {
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
     * Test of getInstance method, of class GroupSystem.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        GroupSystem expResult = GroupSystem.getInstance();
        GroupSystem result = GroupSystem.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of newGroup method, of class GroupSystem.
     */
    @Test
    public void testNewGroup_String() {
        System.out.println("newGroup");
        
        ServerCommunicationSystem server = ServerCommunicationSystem.getInstance();
        LocalUser lu = server.getLocalUser();
        
        String name = "AMM-2014"; //nome del nuovo gruppo
        GroupSystem instance = GroupSystem.getInstance(); //richiamo istanza di GroupSystem
        
        ArrayList<Group> expResult = lu.getGroupList(); //carico i gruppi dell'utente corrente
        expResult.add(new Group(name)); /*aggiungo manualmente al risultato atteso, il nuovo gruppo
                                          che voglio creare*/
        ArrayList<Group> result = instance.newGroup(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of newGroup method, of class GroupSystem.
     */
    @Test
    public void testNewGroup_String_Image() {
        System.out.println("newGroup");
        
        ServerCommunicationSystem server = ServerCommunicationSystem.getInstance();
        LocalUser lu = server.getLocalUser();
        
        String name = "AMM-2014"; //nome del nuovo gruppo
        Image photo = new Image("AMM-2014",200.0,200.0); //foto del nuovo gruppo
        GroupSystem instance = GroupSystem.getInstance(); //richiamo istanza di GroupSystem
        
        ArrayList<Group> expResult = lu.getGroupList(); //carico i gruppi dell'utente corrente
        expResult.add(new Group(name, photo)); /*aggiungo manualmente al risultato atteso,
                                                 il nuovo gruppo che voglio creare*/
        ArrayList<Group> result = instance.newGroup(name, photo);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteGroup method, of class GroupSystem.
     */
    @Test
    public void testDeleteGroup() {
        System.out.println("deleteGroup");
        
        ServerCommunicationSystem server = ServerCommunicationSystem.getInstance();
        LocalUser lu = server.getLocalUser();
        
        Group group = lu.getGroupList().get(0); //gruppo da eliminare
        
        GroupSystem instance = GroupSystem.getInstance();
        
        ArrayList<Group> expResult = lu.getGroupList(); //carico i gruppi dell'utente corrente
        expResult.remove(group); //elimino manualmente il gruppo
        
        ArrayList<Group> result = instance.deleteGroup(group);
        assertEquals(expResult, result);

    }
   
}
