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
 * Classe che fungerà da controllore per la gestione dei media.
 * Sara' una classe singleton, in modo da avere un unico controller per i
 * media all'interno del programma
 */
public class MediaSystem {
    
    private static MediaSystem mediaController;
    
    private final MediaViewer mediaView = new MediaViewer();
    
    /**
     * Constructor
     */
    private MediaSystem(){
        
    }
    
    //methods
    
    /**
     * Questo metodo permette di creare l'istanza del controller qualora non sia già stata creata.
     * @return l'istanza del controller
     */
    public static MediaSystem getInstance(){
        if(MediaSystem.mediaController == null){
            MediaSystem.mediaController = new MediaSystem();
        }
        return MediaSystem.mediaController;
    }
    
    /**
     * Questo metodo permette di importare un media dal disco
     */
    public void importMedia(){
        
    }
    
    /**
     * Questo metodo permette di esportare un media su disco
     */
    public void exportMedia(){
        
    }
    
    /**
     * Questo metodo permette di prelevare la lista dei media dal LocalUser
     * @return la lista media del LocalUser
     */
    public ArrayList<Media> getMediaList(){
        LocalUser user = LocalUser.getInstance();
        return user.getMediaList();
    }
    
    /**
     * Questo metodo richiama la vista dei media per permetterne di visualizzarne la lista
     */
    public void showMediaList(){
        mediaView.showMediaList(getMediaList());
    }
}
