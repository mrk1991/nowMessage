/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nowmessage;

import java.util.Scanner;

/**
 *
 * @author Mrk
 */
public class MessageViewer {
    
    private Scanner input = new Scanner(System.in);
    
    /**
     * Questo metodo permette all'utente di scegliere il tipo di destinatario di un messaggio
     * @return il tipo di destinatario scelto
     */
    public Integer showTypeOfReceiverSelector(){
        System.out.println("\n**Scegli destinatario**");
        System.out.print("\nInserisci:\n"
                + "1) Per uno o piu' contatti\n"
                + "2) Per un gruppo di contatti\n"
                + "Input: ");
        
        return input.nextInt();
    }
    
    /**
     * Questo metodo permette di mostrare all'utente il textBox dove scrivere il testo del messaggio
     * @return il testo del messaggio
     */
    public String showTextBox(){
        System.out.println("\n**Scrivi testo**");
        System.out.print("\nInput: ");
        
        input.nextLine(); //usato per svuotare il buffer, se non lo si fa l'input viene saltato

        //System.out.println(input.nextLine());
        return input.nextLine();
    }
    
    /**
     * Questo metodo permette di mostrare all'utente l'esito dell'invio di un messaggio
     * @param result indica il risultato d'invio
     */
    public void showSendResult(boolean result){
        if(result){
            System.out.println("\nMessaggio inviato!");
        } else {
            System.out.println("\nMessaggio non inviato!");
        }
    }
    
}
