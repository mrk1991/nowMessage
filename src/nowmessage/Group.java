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
public class Group {
    
    private String name;
    private Image photo;
    private ArrayList<Contact> contactList;
    
    /**
     * Constructor
     * @param name indica il nome del gruppo da creare
     */
    public Group(String name) {
        this.name = name;
        this.contactList = new ArrayList<>();
    }
    
    /**
     * Constructor
     * @param name indica il nome del gruppo da creare
     * @param photo  indica la foto del gruppo da creare
     */
    public Group(String name, Image photo) {
        this.name = name;
        this.photo = photo;
        this.contactList = new ArrayList<>();
    }
    
    //methods

    /**
     * Questo metodo permette di conoscere il nome del gruppo
     * @return il nome del gruppo
     */
    public String getName() {
        return name;
    }

    /**
     * Questo metodo permette di settare il nome del gruppo
     * @param name indica il nuovo nome da dare al gruppo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Questo metodo permette di conoscere la foto del gruppo
     * @return la foto del gruppo
     */
    public Image getPhoto() {
        return photo;
    }

    /**
     * Questo metodo permette di settare la foto del gruppo
     * @param photo indica la nuova foto del gruppo da impostare
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    /**
     * Questo metodo permette di conoscere la lista dei contatti assegnati al gruppo
     * @return la lista dei contatti assegnati al gruppo
     */
    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    /**
     * Questo metodo permette di settare la lista contatti assegnati al gruppo
     * @param contactList indica la nuova lista contatti assegnati al gruppo
     */
    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }
    
    /**
     * Questo metodo permette di avere una rappresentazione testuale dell'oggetto Group
     * @return la stringa associata
     */
    @Override
    public String toString(){
        return "\tNome: " + name
                + "\tFoto: " + photo.getName();
    }
    
}
