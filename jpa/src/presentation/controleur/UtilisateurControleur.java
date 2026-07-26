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
    private final UtilisateurService service;
    private final UtilisateurUI utilisateurUI;
    private final Utilisateur utilisateur = null;
    
    public UtilisateurControleur() throws ObjetNonTrouveException{
        this.service = new UtilisateurService();
        utilisateurUI = new UtilisateurUI(utilisateur);
    }
    
    public void controleurPrincipal(){
        utilisateurUI.afficherSurEcran("Bonjour");
        utilisateurUI.getBoutonEnregistrer().setEnabled(false);
        utilisateurUI.getBoutonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    utilisateurUI.getBoutonEnregistrer().setEnabled(true);
                    ajouter();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        utilisateurUI.getBoutonTrouver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    trouver();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        utilisateurUI.getBoutonModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    utilisateurUI.setEnabled(true);
                    modifier();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        utilisateurUI.getBoutonSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    supprimer();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        utilisateurUI.getBoutonLister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    lister();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void ajouter() throws ObjetNonTrouveException{
//        Utilisateur utilisateur = new utilisateurUI        
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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
        });
    }
    
    public void modifier() throws ObjetNonTrouveException{
//            Utilisateur utilisateur = new Utilisateur();
//            UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur);
            
            utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        utilisateurUI.modifierUtilisateur();
                        Utilisateur u = utilisateurUI.getUtilisateur();
                        u.setId(utilisateurUI.recupererId());
                        service.modifier(u);
                        utilisateurUI.afficherSurEcran("Modification effectuée avec succès.");
                    } catch (ObjetNonTrouveException ex) {
                        JOptionPane.showMessageDialog(utilisateurUI, ex.getMessage());
                    } catch(Exception ex){
                        Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
    }

    
    public void trouver() throws ObjetNonTrouveException{
//        Utilisateur utilisateur = new Utilisateur();
//        UtilisateurUI  utilisateurUI = new UtilisateurUI(utilisateur);
        
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String findedUser = "";
                    int ouiOuNon = JOptionPane.showConfirmDialog(utilisateurUI, """
                                        click Oui pour chercher avec lId 
                                        click Non pour chercher avec l'Identifiant                                       
                                        """);
                    if(ouiOuNon == 0){
                        utilisateur.setId(utilisateurUI.recupererId());
                        findedUser = service.trouver(utilisateur).toString();
                    }
                    if(ouiOuNon == 1){
                        String identifiant = JOptionPane.showInputDialog(utilisateurUI, "Entrer l'identifiant");
                        utilisateur.setIdentifiant(identifiant);
                        findedUser = service.trouver(utilisateur).toString();
                    }
                    
                    if(findedUser.equals("")){
                        utilisateurUI.afficherSurEcran("Aucun utilisateur trouvé");
                    }else{
                        utilisateurUI.afficherSurEcran("Utilisateur trouvé: " + findedUser);
                    }
                } catch (ObjetNonTrouveException ex) {
                    JOptionPane.showMessageDialog(utilisateurUI, ex.getMessage());
                } catch(Exception ex){
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                
                }
            }
        });
    }
    
    public void supprimer() throws ObjetNonTrouveException{
//        Utilisateur utilisateur = new Utilisateur();
//        UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur);
        
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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
        });
    }
    
    public void lister() throws ObjetNonTrouveException{
//        Utilisateur utilisateur = new Utilisateur();
//        UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur);
      
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String message = "Liste des utilisateurs: \n";
                    List<Utilisateur> liste = service.lister();
                    for(Utilisateur l : liste){
                        message += l.toString() + "\n";
                    }
                    utilisateurUI.afficherSurEcran(message);
                } catch (Exception ex) {
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
