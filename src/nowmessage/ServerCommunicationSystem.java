package nowmessage;

import java.util.ArrayList;

/**
 *
 * @author anto
 * Classe contenente tutta la logica che simula il comportamento del server
 * per poter effettuare i test dell'applicazione nowMessage
 */
public class ServerCommunicationSystem {
    
    private static ServerCommunicationSystem server;


    private ServerCommunicationSystem() {
    }
    
    
    /**
     * Questo metodo permette di creare l'istanza del controller qualora non sia già stata creata.
     * @return l'istanza del controller
     */
    public static ServerCommunicationSystem getInstance(){
        if (ServerCommunicationSystem.server == null){
            ServerCommunicationSystem.server = new ServerCommunicationSystem();
        }
        return ServerCommunicationSystem.server;
    }
    
    public LocalUser getLocalUser (){
        
        String name = "Mirko";
        String surname = "Fadda";
        String email = "mrk1991@gmail.com";
        String password = "mrk1991";
        ArrayList<Contact> contactList=this.getContactList();
        ArrayList<Group> groupList = this.getGroupList();
        ArrayList<Media> mediaList = this.getMediaList();
        
        LocalUser lu = new LocalUser(name,surname,email,password,contactList,groupList,mediaList);
        return lu;
    }
    
    private ArrayList<Contact> getContactList(){
        ArrayList<Contact> contactList=new ArrayList();
        contactList.add(new Contact("infovillasimius@gmail.com",new Image("Foto",100.0,100.0)));
        contactList.add(new Contact("cecchetto90@gmail.com",new Image("checco",120.0,100.0)));
        contactList.add(new Contact("moreddu@gmail.com",new Image("Giova",200.0,150.0)));
        contactList.add(new Contact("stef@live.it",new Image("Foto",100.0,150.0)));
        contactList.add(new Contact("daniel14@hotmail.com",new Image("Foto",100.0,100.0)));
        contactList.add(new Contact("alex92@hotmail.com",new Image("Alex",100.0,100.0)));
        return contactList;
    }
    
    private ArrayList<Group> getGroupList(){
        
        ArrayList<Contact> contactList=new ArrayList();
        contactList.add(new Contact("infovillasimius@gmail.com",new Image("Foto",100.0,100.0)));
        contactList.add(new Contact("cecchetto90@gmail.com",new Image("checco",120.0,100.0)));
        contactList.add(new Contact("moreddu@gmail.com",new Image("Giova",200.0,150.0)));
        ArrayList<Group> groupList = new ArrayList();
        groupList.add(new Group("IUM-2015",new Image("IUM-2015",200.0,200.0),contactList));
        contactList.add(new Contact("stef@live.it",new Image("Foto",100.0,150.0)));
        contactList.add(new Contact("daniel14@hotmail.com",new Image("Foto",100.0,100.0)));
        contactList.add(new Contact("alex92@hotmail.com",new Image("Alex",100.0,100.0)));
        groupList.add(new Group("ISW-2016",new Image("ISW-2016",200.0,200.0),contactList));
        return groupList;
    }
    
    private ArrayList<Media> getMediaList(){
        ArrayList<Media> mediaList = new ArrayList();
        mediaList.add(new Image("me",200.0,200.0));
        return mediaList;
    }
    
}
