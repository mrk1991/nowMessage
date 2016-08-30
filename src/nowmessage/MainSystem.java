/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nowmessage;

import java.util.ArrayList;

/**
 *
 * @author Mrk
 */
public class MainSystem {
    
    private static MainSystem mainController;
    
    private final ContactSystem contactController = ContactSystem.getInstance();
    private final GroupSystem groupController = GroupSystem.getInstance();
    private final MessageSystem msgController = MessageSystem.getInstance();
    
    private final MainViewer mainView = new MainViewer();
    
    /**
     * Costructor
     */
    private MainSystem (){
        
    }
    
    /**
     * Questo metodo permette di creare l'istanza del controller qualora non sia già stata creata
     * @return l'istanza del controller
     */
    public static MainSystem getInstance(){
        if(MainSystem.mainController == null){
            MainSystem.mainController = new MainSystem();
        }
        return MainSystem.mainController;
    }
    
    /**
     * Questo metodo permette di lanciare l'esecuzione del programma
     */
    public void startSystem(){
        
        Integer input;
        boolean exit = true;
        
        //CARICAMENTO PROFILO UTENTE
        ServerCommunicationSystem server = ServerCommunicationSystem.getInstance();
        LocalUser lu = server.getLocalUser();
        //FINE CARICAMENTO
        
        /*ArrayList<Contact> contactList =lu.getContactList();
        ArrayList<Group> groupList = lu.getGroupList();*/
        
        do{
            input = mainView.showFunction();
        
            switch(input){
                case 1: //RICHIAMA CONTROLLER CONTATTI PER STAMPARNE LA LISTA
                        //System.out.println(contactList);
                        contactController.showContactList();
                        break;
                case 2: //RICHIAMA CONTROLLER GRUPPI PER STAMPARNE LA LISTa
                        //System.out.println(groupList);
                        groupController.showGroupList();
                        break;
                case 3: //RICHIAMA CONTROLLER MESSAGGI PER CREARNE E POI INVIARNE UNO;
                        switch(msgController.selectTypeOfReceiver()){
                            case 1: //uno o più contatti
                                    ArrayList<Contact> contactReceivers = contactController.selectContact();
                                    String text = msgController.writeMsgText();
                                    Sending sending = msgController.newMessage(contactReceivers, text);
                                    msgController.showSendResult(msgController.sendMessage(sending));
                                    break;
                            case 2: //un gruppo
                                    Group groupReceiver = groupController.selectGroup();
                                    String text2 = msgController.writeMsgText();
                                    Sending sending2 = msgController.newMessage(groupReceiver, text2);
                                    msgController.showSendResult(msgController.sendMessage(sending2));
                                    break;
                        }
                        break;
                case 0: System.out.println("\n**Esci**");
                        exit = false;
                        break;
            }
        }while(exit);
        
    }
}
