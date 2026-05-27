/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion.fichiers;

import gestion.fichiers.cli.Commande;
import gestion.fichiers.cli.Navigateur;
import gestion.fichiers.cli.ParseurCommande;
import gestion.fichier.metier.Fichier;
import java.util.Scanner;

/**
 *
 * @author jakk
 */
public class Main {

    private static Scanner clavier = new Scanner(System.in);
    private static ParseurCommande parseur = new ParseurCommande();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("\nBonjour !!! Que le code soit... ");
        System.out.println("\nTaper votre commande : ");
        try {
            Fichier.restaurer();
        } catch(Exception e) {
            e.printStackTrace();
        }
        Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
        while (true) {
            String chemin = "\njakk@jakk-Latitude-5480:~"
                    + Navigateur.getInstance().getRepertoireCourant().getNomComplet()
                    + "$ ";
            System.out.print(chemin);
            String strCmde = clavier.nextLine();
            Commande commande = parseur.parser(strCmde);
            commande.executer();
        }
    }

}