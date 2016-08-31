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
 * Classe che fungerà da controllore per la gestione dei messaggi.
 * Sara' una classe singleton, in modo da avere un unico controller per i
 * messaggi all'interno del programma
 */
public class MessageSystem {
    
    private static MessageSystem messageController;
    
    private final MessageViewer msgView = new MessageViewer();
    
    /**
     * constructor
     */
    private MessageSystem(){
        
    }
    
    //methods
    
    /**
     * Questo metodo permette di creare l'istanza del controller qualora non sia già stata creata.
     * @return l'istanza del controller
     */
    public static MessageSystem getInstance(){
        if(MessageSystem.messageController == null){
            MessageSystem.messageController = new MessageSystem();
        }
        return MessageSystem.messageController;
    }
    
    /**
     * Questo metodo permette di creare un messaggio di testo legato ad un elenco di destinatari a partire da un gruppo
     * @param receivers indica il destinatario
     * @param text indica il testo del messaggio
     * @return il messaggio creato
     */
    public Sending newMessage(Group receivers, String text){
        
        return new Sending(receivers.getContactList(),new Message(text));
    }
    
    /**
     * Questo metodo permette di creare un messaggio di testo legato ad un elenco di destinatari
     * @param receivers indica i destinatari
     * @param text indica il testo del messaggio
     * @return il messaggio creato
     */
    public Sending newMessage(ArrayList<Contact> receivers, String text){
    
        return new Sending(receivers,new Message(text));
    }
    
    
    /**
     * Questo metodo permette di creare un messaggio multimediale legato ad un elenco di destinatari a partire da un gruppo
     * @param receivers indica il destinatario
     * @param text indica il testo del messaggio
     * @param attachment indica il media allegato
     * @return il messaggio creato
     */
    public Sending newMessage(Group receivers, String text, Media attachment){
        
        Sending sending = this.newMessage(receivers, text);
        sending.getMessage().setAttachment(attachment);
        return sending;
    }
    
    /**
     * Questo metodo permette di creare un messaggio multimediale legato ad un elenco di destinatari
     * @param receivers indica i destinatari
     * @param text indica il testo del messaggio
     * @param attachment indica il media allegato
     * @return il messaggio creato
     */
    public Sending newMessage(ArrayList<Contact> receivers, String text, Media attachment){
        
        Sending sending = this.newMessage(receivers, text);
        sending.getMessage().setAttachment(attachment);
        return sending;
    }
    
    
    /**
     * Questo metodo permette di eliminare un messaggio
     */
    public void deleteMessage(){
        
    }
    
    /**
     * Questo metodo permette di inviare un messaggio precedentemente creato
     * @param sending contiene il messaggio da inviare ed i destinatari
     * @return boolean 
     */
    public Boolean sendMessage(Sending sending){
        ServerCommunicationSystem server = ServerCommunicationSystem.getInstance();
        
        return server.sendMsg(sending);
    }
    
    /**
     * Questo metodo permette di ricevere un messaggio
     */
    public void receiveMessage(){
        
    }
    
    /**
     * Questo metodo permette di archiviare un messaggio
     */
    public void archiveMessage(){
        
    }
    
    /**
     * Questo metodo permette di esportare un messaggio su disco
     */
    public void exportMessage(){
        
    }
    
    /**
     * Questo metodo permette di importare un messaggio dal disco
     */
    public void importMessage(){
        
    }
    
    /**
     * Questo metodo permette di selezionare il tipo di destinatario di un messaggio
     * @return il tipo selezionato
     */
    public Integer selectTypeOfReceiver(){
        return msgView.showTypeOfReceiverSelector();
    }
    
    /**
     * Questo metodo richiama la vista dei messaggi per permettere all'utente di scrivere il testo
     * di un messaggio
     * @return il testo scritto
     */
    public String writeMsgText(){
        return msgView.showTextBox();
    }
    
    /**
     * Questo metodo richiama la vista dei messaggi in modo da mostrare il risultato dell'invio
     * @param result indica il risultato d'invio
     */
    public void showSendResult(boolean result){
        msgView.showSendResult(result);
    }
}
