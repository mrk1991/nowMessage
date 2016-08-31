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
public class Contact {
    
    private final String email;
    private final Image photo;
    private boolean contactBlocked = false; //di default tutti i contatti non sono bloccati
    private ArrayList<Message> messages;

    /**
     * Constructor
     * @param email indica l'email del contatto da creare
     * @param photo indica la foto del contatto da creare
     */
    public Contact(String email, Image photo) {
        this.email = email;
        this.photo = photo;
        this.messages = new ArrayList<>();
    }
    
    /**
     * Constructor
     * @param email indica l'email del contatto da creare
     * @param photo indica la foto del contatto da creare
     * @param messages indica la lista dei messaggi relativi al contatto da creare
     */
    public Contact(String email, Image photo, ArrayList<Message> messages) {
        this.email = email;
        this.photo = photo;
        this.messages = messages;
    }
    
    //methods
    
    /**
     * Questo metodo permette di conoscere l'email del contatto
     * @return l'email del contatto
     */
    public String getEmail() {
        return email;
    }

    /**
     * Questo metodo permette di conoscere la foto del contatto
     * @return la foto del contatto
     */
    public Image getPhoto() {
        return photo;
    }

    /**
     * Questo metodo permette di sapere se il contatto è bloccato o meno
     * @return lo stato del contatto
     */
    public boolean isContactBlocked() {
        return contactBlocked;
    }

    /**
     * Questo metodo permette di settare lo stato del contatto
     * @param contactBlocked indica il nuovo stato da impostare al contatto
     */
    public void setContactBlocked(boolean contactBlocked) {
        this.contactBlocked = contactBlocked;
    }

    /**
     * Questo metodo permette di conoscere la lista dei messaggi ricevuti/inviati al contatto
     * @return la lista dei messaggi
     */
    public ArrayList<Message> getMessages() {
        return messages;
    }

    /**
     * Questo metodo permette di settare la lista dei messaggi ricevuti/inviati al contatto
     * @param messages indica la nuova lista messaggi ricevuti/inviati
     */
    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
    
    /**
     * Questo metodo permette di avere una rappresentazione testuale dell'oggetto Contact
     * @return la stringa associata
     */
    @Override
    public String toString(){
        int num = 30 - email.length();
        String s="";
        if (num>0){
            for (int n=0 ; n<num;n++ ){
            s=s+" ";}
        }
        return "\tEmail: " + email
                + s
                + "\tFoto: " + photo.getName()
                + "\tStato: " + contactBlocked;
    }
    
    
    
}
