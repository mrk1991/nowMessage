/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nowmessage;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author Mrk
 */
public class GroupViewer {
    
    private Scanner input = new Scanner(System.in);
    
    /**
     * Questo metodo permette di mostrare all'utente un gruppo
     * @param group indica il gruppo da mostrare
     */
    public void showGroup(Group group){
        System.out.println(group);
    }
    
    /**
     * Questo metodo permette di mostrare all'utente la propria lista gruppi
     * @param list indica la lista gruppi da mostrare
     */
    public void showGroupList(ArrayList<Group> list){
        int num=1;
        System.out.println("\n**Gruppi**");
        for(Group group : list) {
            System.out.print("n. "+num+" ");
            num+=1;
            showGroup(group);
        }
    }
    
    /**
     * Questo metodo permette all'utente di selezionare un gruppo dalla lista
     * @param list indica la lista dei gruppi dell'utente
     * @return la posizione, all'interno della lista, del gruppo selezionato
     */
    public Integer showGroupSelector(ArrayList<Group> list){
        Integer num;
        
        System.out.println("\n**Seleziona Gruppo**");
        showGroupList(list);
        System.out.print("\nInserisci il numero del gruppo da selezionare: ");
        
        num = input.nextInt();
        while(num > list.size()){
            System.out.print("Selezione non valida, reinserisci: ");
            num = input.nextInt();
        }
        
        return num;
    }
    
}
