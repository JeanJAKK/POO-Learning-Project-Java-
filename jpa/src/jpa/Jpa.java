/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa;

import entite.Groupe;
import entite.Utilisateur;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentation.controleur.GroupeControleur;
import service.GroupeService;
import service.UtilisateurService;

/**
 *
 * @author jakk
 */
public class Jpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        Groupe g1 = new Groupe();
//        Utilisateur grp = new Utilisateur("MONKEY", "Luffy", "MKYDLUFF45", "23324", g1);
//        UtilisateurService service = new UtilisateurService();
//        try {
//            List<Utilisateur> listeGrp = service.lister();
//            for (Utilisateur groupe : listeGrp) {
//                System.out.println(groupe.toString());
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(Jpa.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        Groupe g1 = new Groupe(1, "Groupe 1", "Premier groupe modifié 2");
//        Utilisateur u1 = new Utilisateur(2,"MONKEY", "Luffy", "MKYDLUFF45", "23324modifié", g1);
//        UtilisateurService service = new UtilisateurService();
//            service.modifier(u1);

        GroupeControleur gc = new GroupeControleur();
        gc.lister();
    }

}