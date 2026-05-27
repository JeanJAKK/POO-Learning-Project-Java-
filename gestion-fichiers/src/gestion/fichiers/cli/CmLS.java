/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;

/**
 *
 * @author jakk
 */
public class CmLS extends Commande {

    private String chemin;

    @Override
    public void executer() {
        //recuperer le repertoire courant
        Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();

        if (chemin != null) { 
            try {
                Navigateur.getInstance().changerRepertoire(chemin);
                Repertoire r = Navigateur.getInstance().getRepertoireCourant();
                if (r != null){
                     r.afficherContenu();
                }else{
                    System.err.println(r + "Non trouvé");
                }
            } catch (FileNotFoundException e) {
                 System.err.println(e.getMessage());
            }catch(Exception e ){
                System.err.println(e.getMessage());
            }
               
            
        }if (chemin == null){
            try {
                Navigateur.getInstance().getRepertoireCourant().afficherContenu();
                
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
//       

        // REVENIR AU DEPART
        Navigateur.getInstance().setRepertoireCourant(repertoireCourant);

    }

    @Override
    public void setPararmetres(String[] parametres) {
        this.chemin = parametres[0];
    }
}
