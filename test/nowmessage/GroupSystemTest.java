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
        instance.newGroup(name); //creo nuovo gruppo e lo assegno al groupList del local user
        int expResult = lu.getGroupList().size()-1; //calcolo la lunghezza della lista dei gruppi
        
        assertEquals(lu.getGroupList().get(expResult).getName(),"AMM-2014");//verifico che l'ultimo gruppo si quello appena inserito
        
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
        
        
        instance.newGroup(name, photo);
        int expResult = lu.getGroupList().size()-1; //calcolo la lunghezza della lista dei gruppi
        
        assertEquals(lu.getGroupList().get(expResult).getPhoto(),photo);
        
        //assertEquals(expResult, result);
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
        
        boolean expResult = true;
                
        boolean result = instance.deleteGroup(group);
        assertEquals(expResult, result);
        assertEquals(lu.getGroupList().indexOf(group),-1);
        

    }
   
}
