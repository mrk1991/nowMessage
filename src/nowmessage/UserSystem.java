/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nowmessage;

/**
 *
 * @author Mrk
 * Classe che fungerà da controllore per la gestione del profilo utente.
 * Sara' una classe singleton, in modo da avere un unico controller per il
 * profilo utente all'interno del programma
 */
public class UserSystem {
    
    private static UserSystem userController;
    
    private final UserViewer userView = new UserViewer();
    
    /**
     * Constructor
     */
    private UserSystem(){
        
    }
    
    //methods
    
    /**
     * Questo metodo permette di creare l'istanza del controller qualora non sia già stata creata.
     * @return l'istanza del controller
     */
    public static UserSystem getInstance(){
        if(UserSystem.userController == null){
            UserSystem.userController = new UserSystem();
        }
        return UserSystem.userController;
    }
    
    /**
     * Questo metodo permette all'utente di effettuare il login
     */
    public void login(){
        
    }
    
    /**
     * Questo metodo permette all'utente di registrarsi
     */
    public void registration(){
        
    }
    
    /**
     * Questo metodo permette di modificare il profilo utente
     */
    public void editProfile(){
        
    }
    
    /**
     * Questo metodo permette di eliminare il profilo utente
     */
    public void deleteProfile(){
        
    }
    
    /**
     * Questo metodo richiama la vista dello user per poterne visualizzare le informazioni del profilo
     */
    public void showUser(){
        LocalUser user = LocalUser.getInstance();
        userView.showUser(user);
    }
}
