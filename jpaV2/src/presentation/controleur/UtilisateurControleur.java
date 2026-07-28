/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Utilisateur;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentation.vue.AccueilUI;
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
    private final AccueilUI accuielUI;
    
    public UtilisateurControleur() throws ObjetNonTrouveException{
        this.service = new UtilisateurService();
        this.utilisateur = new Utilisateur();
        this.accuielUI = new AccueilUI();
        this.utilisateurUI = new UtilisateurUI(utilisateur);
        
        ajouterEcouteur();
        
    }
    
    private void ajouterEcouteur(){
        // Acceder à l'interface de Groupe à partir de celui d'Utilisateur
        accuielUI.getBoutonGrp().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new GroupeControleur();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        accuielUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                executerAction();
            }
        });
        
        accuielUI.getBoutonAnnuler().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                utilisateurUI.viderFormulaire();
            }
        });
        
        accuielUI.getBoutonUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                // Désactiver les boutons
                accuielUI.getBoutonAjouter().setEnabled(true);
                accuielUI.getBoutonModifier().setEnabled(true);
                accuielUI.getBoutonTrouver().setEnabled(true);
                accuielUI.getBoutonSupprimer().setEnabled(true);

                try {
                    accuielUI.getPanelOuest().add(utilisateurUI.creerFormulaire(), BorderLayout.WEST);
                    accuielUI.getPanelESt().add(utilisateurUI.chargerJTable(), BorderLayout.CENTER);

                    accuielUI.getPanelESt().revalidate();
                    accuielUI.getPanelESt().repaint();

                    accuielUI.getPanelOuest().revalidate();
                    accuielUI.getPanelOuest().repaint();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(AccueilUI.class.getName()).log(Level.SEVERE, null, ex);
                }
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
            utilisateurUI.modifierUtilisateur();
            Utilisateur u = utilisateurUI.getUtilisateur();
            service.ajouter(u);
            utilisateurUI.viderFormulaire();
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
        } catch (ObjetNonTrouveException ex) {
        } catch(Exception ex){
            Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void trouver() throws ObjetNonTrouveException{
        try {
           Utilisateur findedUser = null;
           int ouiOuNon = JOptionPane.showConfirmDialog(utilisateurUI, """
                                    click Oui pour chercher avec lId
                                    click Non pour chercher avec l'Identifiant
                                    """);
           if(ouiOuNon == JOptionPane.YES_OPTION){
               utilisateur.setId(utilisateurUI.recupererId());
               findedUser = service.trouver(utilisateur);
           }else if(ouiOuNon == JOptionPane.NO_OPTION){
               String identifiant = JOptionPane.showInputDialog(utilisateurUI, "Entrer l'identifiant");
               utilisateur.setIdentifiant(identifiant);
               findedUser = service.trouver(utilisateur);
           }

           if(findedUser == null){
               JOptionPane.showMessageDialog(accuielUI, "Aucun utilisateur trouvé");
               return;
           }
           
           utilisateurUI.remplirFormulaire(findedUser);
           
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
