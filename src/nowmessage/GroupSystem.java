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
 * Classe che fungerà da controllore per la gestione dei gruppi.
 * Sara' una classe singleton, in modo da avere un unico controller per i
 * gruppi all'interno del programma
 */
public class GroupSystem {
    
    private static GroupSystem groupController; //indica una istanza della stessa classe GroupSystem
    
    private final LocalUser user = LocalUser.getInstance();
    
    private final GroupViewer groupView = new GroupViewer();
    
    /**
     * Constructor
     */
    private GroupSystem() {
        
    }
    
    //methods
    
    /**
     * Questo metodo permette di creare l'istanza del controller qualora non sia già stata creata.
     * @return l'istanza del controller
     */
    public static GroupSystem getInstance(){
        if (GroupSystem.groupController == null){
            GroupSystem.groupController = new GroupSystem();
        }
        return GroupSystem.groupController;
    }
    
    /**
     * Questo metodo permette di aggiungere un gruppo nella lista gruppi dell'utente
     * @param name indica il nome del gruppo
     * @param photo indica la foto del gruppo
     * @return la lista dei gruppi aggiornata
     */
    public ArrayList newGroup(String name, Image photo){
        Group newGroup;
        //1- richiamerà il costruttore di Group
        //2- aggiornerà la groupList del LocalUser
        //3- renderà la lista aggiornata dei gruppi
        return null; //giusto per indicare qualcosa
    }
    
    /**
     * Questo metodo permette di modificare un gruppo
     */
    public void updateGroup(){
        
    }
    
    /**
     * Questo metodo permette di rimuovere un gruppo tra quelli salvati dall'utente
     * @param group indica il gruppo da eliminare
     * @return la lista gruppi aggiornata
     */
    public ArrayList<Group> deleteGroup(Group group){
        //1- si cerca il gruppo nella groupList del LocalUser
        //2- lo si rimuove
        //3- si rende la lista gruppi aggiornata
        return null; //giusto per indicare qualcosa
    }
    
    /**
     * Questo metodo permette di inserire uno o più contatti in un gruppo
     * @param group indica il gruppo in cui inserire i contatti
     * @param list indica la lista dei contatti da aggiungere al gruppo
     */
    public void groupContact(Group group, ArrayList<Contact> list){
        
    }
    
    /**
     * Questo metodo permette di rimuovere uno o piu' contatti da un gruppo
     * @param group indica il gruppo da cui eliminare il o i contatti
     * @param list indica la lista dei contatti da rimuovere dal gruppo
     */
    public void ungroupContact(Group group, ArrayList<Contact> list){
        
    }
    
    /**
     * Questo metodo permette di prelevare la lista dei gruppi dal LocalUser
     * @return la lista gruppi del LocalUser
     */
    public ArrayList<Group> getGroupList(){
        return user.getGroupList();
    }
    
    /**
     * Questo metodo richiama la vista dei gruppi per permetterne di visualizzarne la lista
     */
    public void showGroupList(){
        groupView.showGroupList(getGroupList());
    }
    
    /**
     * Questo metodo permette di selezionare un gruppo dalla lista
     * @return il gruppo selezionato
     */
    public Group selectGroup(){
        ArrayList<Group> list = user.getGroupList(); //contiene la lista gruppi
        Integer positionSelectedGroup; //conterrà la posizione del gruppo selezionato
        
        positionSelectedGroup = groupView.showGroupSelector(list);
              
        return list.get(positionSelectedGroup-1);
    }
    
    
}
