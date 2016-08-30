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
public class MainViewer {
    
    private Scanner input = new Scanner(System.in);
    
    /*metodi Scanner:
    - nextLine()
    - nextInt()
    - nextDouble()
    */
    
    /**
     * Questo metodo permette di mostrare all'utente il menu principale
     * @return la selezione dell'utente
     */
    public Integer showFunction(){
        System.out.println("\n**NowMessage**");

        System.out.print("\nInserisci:\n"
                + "1) Per visualizzare la tua rubrica\n"
                + "2) Per visualizzare i gruppi salvati\n"
                + "3) Per creare ed inviare un nuovo messaggio\n"
                + "0) Per uscire\n"
                + "Input: ");
        
        return input.nextInt();
    }
}
