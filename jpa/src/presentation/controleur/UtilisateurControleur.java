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
    
    public UtilisateurControleur(){
        this.service = new UtilisateurService();
    }
    
    public void ajouter() throws ObjetNonTrouveException{
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur);
        
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    utilisateurUI.modifierUtilisateur();
                    Utilisateur u = utilisateurUI.getUtilisateur();
                    service.ajouter(u);
                    utilisateurUI.dispose();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
                utilisateurUI.dispose();
            }
        });
    }
    
    public void modifier(int id) throws ObjetNonTrouveException{
            Utilisateur utilisateur = new Utilisateur();
            UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur);
            
            utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        utilisateurUI.modifierUtilisateur();
                        Utilisateur u = utilisateurUI.getUtilisateur();
                        service.modifier(u);
                        utilisateurUI.dispose();
                    } catch (ObjetNonTrouveException ex) {
                        JOptionPane.showMessageDialog(utilisateurUI, ex.getMessage());
                    } catch(Exception ex){
                        Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    utilisateurUI.dispose();
                }
            });
    }

    
    public void trouver() throws ObjetNonTrouveException{
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurUI  utilisateurUI = new UtilisateurUI(utilisateur);
        
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String findedUser;
                    utilisateurUI.modifierUtilisateur();
                    Utilisateur u = utilisateurUI.getUtilisateur();
                    findedUser = service.trouver(u).toString();
                    
                    if(findedUser.equals("")){
                        JOptionPane.showMessageDialog(utilisateurUI, "Aucun utilisateur trouvé");
                        return;
                    }
                    JOptionPane.showMessageDialog(utilisateurUI, "Utilisateur trouvé: " + findedUser);
                } catch (ObjetNonTrouveException ex) {
                    JOptionPane.showMessageDialog(utilisateurUI, ex.getMessage());
                } catch(Exception ex){
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                
                }
            }
        });
    }
    
    public void supprimer() throws ObjetNonTrouveException{
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur);
        
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    utilisateurUI.modifierUtilisateur();
                    Utilisateur u = utilisateurUI.getUtilisateur();
                    service.supprimer(u);
                } catch (ObjetNonTrouveException e) {
                    JOptionPane.showMessageDialog(utilisateurUI, e.getMessage());
                } catch(Exception ex){
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
                utilisateurUI.dispose();
            }
        });
    }
    
    public void lister() throws ObjetNonTrouveException{
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur);
        
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String message = "Liste des utilisateurs: \n";
                    List<Utilisateur> liste = service.lister();
                    for(Utilisateur l : liste){
                        message += l.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(utilisateurUI, message);
                } catch (Exception ex) {
                    Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
                utilisateurUI.dispose();
            }
        });
    }
}
