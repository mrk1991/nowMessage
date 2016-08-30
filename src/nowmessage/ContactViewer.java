/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nowmessage;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 *
 * @author Mrk
 */
public class ContactViewer {
    
    private Scanner input = new Scanner(System.in);
    
    /**
     * Questo metodo permette di mostrare all'utente un contatto
     * @param contact indica il contatto da mostrare
     */
    public void showContact(Contact contact){
        System.out.println(contact);
    }
    
    /**
     * Questo metodo permette di mostrare all'utente la propria rubrica
     * @param list indica la lista di contatti da mostrare
     */
    public void showContactList(ArrayList<Contact> list){
        int num=1;
        System.out.println("\n**Rubrica**");
        for(Contact contact : list){
            System.out.print("n. "+num+" ");
            num+=1;
            showContact(contact);
        }
    }
    
    /**
     * Questo metodo permette all'utente di selezionare uno o più contatti dalla rubrica
     * @param list indica la rubrica
     * @return la lista delle posizioni occupate in rubrica dai contatti selezionati
     */
    public ArrayList<Integer> showContactSelector(ArrayList<Contact> list){
        ArrayList<Integer> positionList = new ArrayList();
        Integer num;
        
        System.out.println("\n**Seleziona contatti**");
        showContactList(list);
        System.out.print("\nInserisci i numeri dei contatti da selezionare separati da uno spazio: ");
        
        //serve per dividere l'input in token, così si possono estrarre i numeri inseriti dall'utente.
        StringTokenizer st = new StringTokenizer(input.nextLine()," ");

        do{
            num = Integer.parseInt(st.nextToken()); //estrae dal token il numero intero inserito dall'utente
            if(num <= list.size()){ //se il numero corrisponde alla posizione di un contatto in rubrica...
                positionList.add(num); //...allora lo aggiunge alla selezione, altrimenti lo scarta
            }
        }while(st.hasMoreTokens()); //continua fino a che ci sono token da controllare
        
        return positionList;
    }
    
}
