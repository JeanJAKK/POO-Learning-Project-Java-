/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Groupe;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentation.vue.AccueilUI;
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
        MODIFIER,
        TROUVER,
        SUPPRIMER,
        LISTER
    }
    private Crud crudEnCours;
    private final GroupeService service;
    private final GroupeUI groupeUI;
    private final Groupe groupe;
    private final AccueilUI accuielUI;
    
    public GroupeControleur() throws ObjetNonTrouveException{
        this.service = new GroupeService();
        this.groupe = new Groupe();
        this.accuielUI = new AccueilUI();
        this.groupeUI = new GroupeUI(groupe);
        
        ajouterEcouteur();
        
    }
    
    private void ajouterEcouteur(){
        accuielUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                executerAction();
            }
        });
        
        accuielUI.getBoutonAnnuler().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                groupeUI.viderFormulaire();
            }
        });
        
        accuielUI.getBoutonGrp().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                // Désactiver les boutons
                accuielUI.getBoutonAjouter().setEnabled(true);
                accuielUI.getBoutonModifier().setEnabled(true);
                accuielUI.getBoutonTrouver().setEnabled(true);
                accuielUI.getBoutonSupprimer().setEnabled(true);

                accuielUI.getPanelOuest().add(groupeUI.creerFormulaire(), BorderLayout.WEST);
                accuielUI.getPanelESt().add(groupeUI.chargerTable(), BorderLayout.CENTER);
                
                accuielUI.getPanelESt().revalidate();
                accuielUI.getPanelESt().repaint();
                accuielUI.getPanelOuest().revalidate();
                accuielUI.getPanelOuest().repaint();
            }
        });
        
        accuielUI.getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.AJOUTER;
                accuielUI.getBoutonEnregistrer().setEnabled(true);
                accuielUI.getBoutonAnnuler().setEnabled(true);
            }
        });
        
        accuielUI.getBoutonTrouver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.TROUVER;
                accuielUI.getBoutonEnregistrer().setEnabled(true);
                accuielUI.getBoutonAnnuler().setEnabled(true);

            }
        });
        
        accuielUI.getBoutonModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.MODIFIER;
                accuielUI.getBoutonEnregistrer().setEnabled(true);
                accuielUI.getBoutonAnnuler().setEnabled(true);

            }
        });
        
        accuielUI.getBoutonSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudEnCours = Crud.SUPPRIMER;
                accuielUI.getBoutonEnregistrer().setEnabled(true);
                accuielUI.getBoutonAnnuler().setEnabled(true);

            }
        });
    }
    
    
    public void ajouter() throws ObjetNonTrouveException{
        try {
            groupeUI.modifierGroupe();
            Groupe g =  groupeUI.getGroupe();
            service.ajouter(g);
            groupeUI.viderFormulaire();
        } catch (Exception ex) {
            Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifier() throws ObjetNonTrouveException{
        try {
            groupeUI.modifierGroupe();
            Groupe g = groupeUI.getGroupe();
            g.setId (groupeUI.recupererId());
            service.modifier(g);
        } catch (Exception ex) {
            Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void trouver() throws ObjetNonTrouveException{
        try {
           Groupe findedGrp = null;
           int ouiOuNon = JOptionPane.showConfirmDialog(groupeUI, """
                                    click Oui pour chercher avec lId
                                    click Non pour chercher avec l'Identifiant
                                    """);
           if(ouiOuNon == JOptionPane.YES_OPTION){
               groupe.setId(groupeUI.recupererId());
               findedGrp = service.trouver(groupe);
           }else if(ouiOuNon == JOptionPane.NO_OPTION){
               String nom = JOptionPane.showInputDialog(groupeUI, "Entrer l'identifiant");
               groupe.setNom(nom);
               findedGrp = service.trouver(groupe);
           }

           if(findedGrp == null){
               JOptionPane.showMessageDialog(accuielUI, "Aucun utilisateur trouvé");
               return;
           }
           
           groupeUI.remplirFormulaire(findedGrp);
           
       } catch (ObjetNonTrouveException ex) {
           JOptionPane.showMessageDialog(groupeUI, ex.getMessage());
       } catch(Exception ex){
           Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);

       }
    }
    
    public void supprimer() throws ObjetNonTrouveException{
        try {
            groupe.setId(groupeUI.recupererId());
            service.supprimer(groupe);
        } catch (ObjetNonTrouveException e) {
            JOptionPane.showMessageDialog(groupeUI, e.getMessage());
        } catch(Exception ex){
            Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lister() throws ObjetNonTrouveException{
        try {
            String message = "Liste des utilisateurs: \n";
            List<Groupe> liste = service.lister();
            for(Groupe l : liste){
                message += "\n" + l.toString() + "\n";
                message += "_".repeat(30) + "\n";
            }
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
                    JOptionPane.showMessageDialog(groupeUI, "Veuillez choisir une action");
            }
        } catch (ObjetNonTrouveException ex) {
            JOptionPane.showMessageDialog(groupeUI, ex.getMessage());
        }
    }
}
