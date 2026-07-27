/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Utilisateur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentation.vue.UtilisateurUI;
import service.UtilisateurService;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class UtilisateurControleur {
    private enum Crud{
        AJOUTER,
        MODIFIER,
        TROUVER,
        SUPPRIMER,
        LISTER
    }
    private Crud crudEnCours;
    private final UtilisateurService service;
    private final UtilisateurUI utilisateurUI;
    private final Utilisateur utilisateur;
    
    public UtilisateurControleur() throws ObjetNonTrouveException{
        this.service = new UtilisateurService();
        this.utilisateur = new Utilisateur();
        this.utilisateurUI = new UtilisateurUI(utilisateur);
        this.utilisateurUI.afficherSurEcran("Bonjour");
        this.utilisateurUI.getBoutonEnregistrer().setEnabled(false);
        
        ajouterEcouteur();
    }
    
    private void ajouterEcouteur(){
        utilisateurUI.getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.AJOUTER;
                utilisateurUI.afficherSurEcran("Mode AJOUT");
                utilisateurUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        utilisateurUI.getBoutonModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.MODIFIER;
                utilisateurUI.afficherSurEcran("Mode MODIFICATION");
                utilisateurUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        utilisateurUI.getBoutonTrouver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.TROUVER;
                utilisateurUI.afficherSurEcran("Mode TROUVER");
                utilisateurUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        utilisateurUI.getBoutonSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.SUPPRIMER;
                utilisateurUI.afficherSurEcran("Mode SUPPRESSION");
                utilisateurUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        utilisateurUI.getBoutonLister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.LISTER;
                utilisateurUI.afficherSurEcran("Mode LISTER");
                utilisateurUI.getBoutonEnregistrer().setEnabled(true);
            }
        });
        
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                executerAction();
            }
        });
    }
    
    public void ajouter() throws ObjetNonTrouveException{
        try {
            utilisateurUI.modifierUtilisateur();
            Utilisateur u = utilisateurUI.getUtilisateur();
            service.ajouter(u);
            utilisateurUI.viderFormulaire();
            utilisateurUI.afficherSurEcran("Ajout effectué avec succès.");
        } catch (ObjetNonTrouveException ex) {
            Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifier() throws ObjetNonTrouveException{
        try {
            utilisateurUI.modifierUtilisateur();
            Utilisateur u = utilisateurUI.getUtilisateur();
            u.setId(utilisateurUI.recupererId());
            service.modifier(u);
            utilisateurUI.afficherSurEcran("Modification effectuée avec succès.");
        } catch (ObjetNonTrouveException ex) {
        } catch(Exception ex){
            Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void trouver() throws ObjetNonTrouveException{
        try {
           String findedUser = "";
           int ouiOuNon = JOptionPane.showConfirmDialog(utilisateurUI, """
                                    click Oui pour chercher avec lId
                                    click Non pour chercher avec l'Identifiant
                                    """);
           if(ouiOuNon == JOptionPane.YES_OPTION){
               utilisateur.setId(utilisateurUI.recupererId());
               findedUser = service.trouver(utilisateur).toString();
           }else if(ouiOuNon == JOptionPane.NO_OPTION){
               String identifiant = JOptionPane.showInputDialog(utilisateurUI, "Entrer l'identifiant");
               utilisateur.setIdentifiant(identifiant);
               findedUser = service.trouver(utilisateur).toString();
           }

           if(findedUser.equals("")){
               utilisateurUI.afficherSurEcran("Aucun utilisateur trouvé");
               return;
           }
           utilisateurUI.afficherSurEcran("Utilisateur trouvé: " + findedUser);
           
       } catch (ObjetNonTrouveException ex) {
           JOptionPane.showMessageDialog(utilisateurUI, ex.getMessage());
       } catch(Exception ex){
           Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);

       }
    }
    
    public void supprimer() throws ObjetNonTrouveException{
        try {
            utilisateur.setId(utilisateurUI.recupererId());
            service.supprimer(utilisateur);
            utilisateurUI.afficherSurEcran("Suppression effectuée avec succès.");
        } catch (ObjetNonTrouveException e) {
            JOptionPane.showMessageDialog(utilisateurUI, e.getMessage());
        } catch(Exception ex){
            Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lister() throws ObjetNonTrouveException{
        try {
            String message = "Liste des utilisateurs: \n";
            List<Utilisateur> liste = service.lister();
            for(Utilisateur l : liste){
                message += "\n" + l.toString() + "\n";
                message += "_".repeat(30) + "\n";
            }
            utilisateurUI.afficherSurEcran(message);
        } catch (Exception ex) {
            Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void executerAction(){
        try {
            switch(crudEnCours){
                case AJOUTER:
                    ajouter();
                    break;
                case TROUVER:
                    trouver();
                    break;
                case MODIFIER:
                    modifier();
                    break;
                case SUPPRIMER:
                    supprimer();
                    break;
                case LISTER:
                    lister();
                    break;
                default:
                    JOptionPane.showMessageDialog(utilisateurUI, "Veuillez choisir une action");
            }
        } catch (ObjetNonTrouveException ex) {
            JOptionPane.showMessageDialog(utilisateurUI, ex.getMessage());
        }
    }
}
