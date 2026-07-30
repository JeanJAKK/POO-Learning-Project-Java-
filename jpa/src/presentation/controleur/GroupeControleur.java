/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Groupe;
import entite.Utilisateur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentation.vue.GroupeUI;
import service.GroupeService;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class GroupeControleur {
    private enum Crud{
        AJOUTER,
        TROUVER,
        MODIFIER,
        SUPPRIMER,
        LISTER
    }
    private Crud crudEnCours;
    private final GroupeService service;
    private final Groupe groupe;
    private final GroupeUI groupeUI;
    
    public GroupeControleur() throws ObjetNonTrouveException{
        this.groupe = new Groupe();
        this.groupeUI = new GroupeUI(groupe);
        this.service = new GroupeService();
        this.groupeUI.afficherSurEcran("Bonjour...");
        this.groupeUI.getBoutonEnregistrer().setEnabled(false);
        
        ajouterEcouteur();
    }
    
    private void ajouterEcouteur(){
        groupeUI.getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.AJOUTER;
                groupeUI.afficherSurEcran("Mode AJOUT");
                groupeUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        groupeUI.getBoutonModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.MODIFIER;
                groupeUI.afficherSurEcran("Mode MODIFICATION");
                groupeUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        groupeUI.getBoutonTrouver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.TROUVER;
                groupeUI.afficherSurEcran("Mode TROUVER");
                groupeUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        groupeUI.getBoutonSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.SUPPRIMER;
                groupeUI.afficherSurEcran("Mode SUPPRESSION");
                groupeUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        groupeUI.getBoutonLister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.LISTER;
                groupeUI.afficherSurEcran("Mode LISTER");
                groupeUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        groupeUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                executerAction();
            }
        });    
    }
    
    public void ajouter() throws ObjetNonTrouveException{
        try {
            groupeUI.modifierGroupe();
            Groupe g = groupeUI.getGroupe();
            service.ajouter(g);
            groupeUI.afficherSurEcran("Ajout effectué avec succès");
        } catch (ObjetNonTrouveException ex) {
            JOptionPane.showMessageDialog(groupeUI, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifier(){
        try {
            groupeUI.modifierGroupe();
            Groupe g = groupeUI.getGroupe();
            service.modifier(g);
            groupeUI.afficherSurEcran("Modification effectué avec succès");
        } catch (ObjetNonTrouveException e) {
            JOptionPane.showMessageDialog(groupeUI, e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimer(){
        try {
            groupe.setId(groupeUI.recupererId());
            service.supprimer(groupe);
            groupeUI.afficherSurEcran("Suppression effectué avec succès");
        } catch (ObjetNonTrouveException ex) {
            JOptionPane.showMessageDialog(groupeUI, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void trouver(){
        try {
            String grpFinded = "";
            
            int ouiOuNon = JOptionPane.showConfirmDialog(groupeUI, """
                                    click Oui pour chercher avec lId
                                    click Non pour chercher avec le nom
                                    """);
            if(ouiOuNon == JOptionPane.YES_OPTION){
                groupe.setId(groupeUI.recupererId());
                grpFinded = service.trouver(groupe).toString();
            }else if(ouiOuNon == JOptionPane.NO_OPTION){
                String nom = JOptionPane.showInputDialog(groupeUI, "Entrer le nom");
                groupe.setNom(nom);
                grpFinded = service.trouver(groupe).toString();
            }


            if(grpFinded.equals("")){
                groupeUI.afficherSurEcran("Aucun groupe trouvé");
                return;
            }
            groupeUI.afficherSurEcran("Groupe trouvé: \n" + grpFinded);
        } catch (ObjetNonTrouveException ex) {
            JOptionPane.showMessageDialog(groupeUI, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lister(){
        try {
            String message = "Liste des utilisateurs: \n";
            List<Groupe> liste = service.lister();
            for(Groupe l : liste){
                message += "\n" + l.toString() + "\n";
                message += "_".repeat(30) + "\n";
            }
            groupeUI.afficherSurEcran(message);
        } catch (Exception ex) {
            Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void executerAction(){
        try {
            switch(crudEnCours){
                case AJOUTER:
                    ajouter();
                    break;
                case MODIFIER:
                    modifier();
                    break;
                case TROUVER:
                    trouver();
                    break;
                case SUPPRIMER:
                    supprimer();
                    break;
                case LISTER:
                    lister();
                    break;
                default:
                    JOptionPane.showMessageDialog(groupeUI, "Veuillez choisir une action");
            }
            
        } catch (ObjetNonTrouveException ex) {
            JOptionPane.showMessageDialog(groupeUI, ex.getMessage());
        }
    }
}
