/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

import java.util.Scanner;

/**
 *
 * @author jakk
 */
public class CmQuitter extends Commande {

    @Override
    public void executer() {
        Scanner clavier = new Scanner(System.in);
        System.out.print("\nQuitter le programme ? [o/N] : ");
        String reponse = clavier.next().toUpperCase();
        if (reponse.equals("O")){
            System.out.println("\nA bientot");
            System.exit(0);
        }
    }

    @Override
    public void setPararmetres(String[] parametres) {
        
    }
    
}