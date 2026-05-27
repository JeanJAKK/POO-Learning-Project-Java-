/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author jakk
 */
public class CmCP extends Commande {
    
    private String source;     
    private String destination; 
    
    @Override
    public void executer() {
        try{
            String[] tb = source.split("/");
            String moveElement = tb[tb.length-1];
            String[] sourceParentTb = Arrays.copyOfRange(tb, 0, tb.length-1);
            String sourceParent = String.join("/", sourceParentTb);

            Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();
            Fichier.getRoot();
            try {
                Navigateur.getInstance().changerRepertoire(sourceParent);
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
            }

            // Trouver la source
            Fichier cible = null;     //la ciible ici c'est la source
            for (Fichier f : repertoireCourant.getFichier()) {
                if (f.getNom().equals(moveElement)) {
                    cible = f;
                    break;
                }
            }

            if (cible == null) {
                System.err.println("Source introuvable : " + moveElement);
                return;
            }
            
            if (destination == null) {
                destination = repertoireCourant.getNomComplet();
            
            }
            // Copier
            try {
                cible.copie(destination);
            } catch (FileNotFoundException e) {
                System.err.println("Destination introuvable : " + e.getMessage());
            } catch (FileAlreadyExistsException e) {
                System.err.println("Conflit : " + e.getMessage());
            } catch (Exception e) {
                // lorsqu'on se trouve deja dans le dossier du fichier à copier 
                Navigateur.getInstance().setRepertoireCourant(repertoireCourant);
                for(Fichier f : Navigateur.getInstance().getRepertoireCourant().getFichier()){
                    if (f.getNom().equals(source)){
                        try {
                            System.out.println("fffffcp ");
                            f.copie(destination);
                            break;
                        } catch (FileNotFoundException ex) {
                            System.err.println(e.getMessage());
                        } catch (FileAlreadyExistsException ex) {
                            System.err.println(e.getMessage());
                        }
                    }
                }
                
            }finally{
                Navigateur.getInstance().setRepertoireCourant(repertoireCourant);
            }

        }catch(NullPointerException e){ // cp sans rien de plus 
            System.err.println(e.getMessage());
        }
        
    }
    @Override
    public void setPararmetres(String[] parametres) {
        if (parametres.length > 1){
            try{
                this.source = parametres[0];
                this.destination = parametres[1];
        }catch(Exception e){
            System.err.println("cp <source> <destination>" + e.getMessage());
        }
       }
    }
}
