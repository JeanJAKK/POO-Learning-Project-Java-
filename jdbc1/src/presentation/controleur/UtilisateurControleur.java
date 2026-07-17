/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Utilisateur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentation.vue.UtilisateurUI;
import service.UtilisateurService;
import util.ObjetNonTrouveException;

/**
 *
 * @author Aude
 */
public class UtilisateurControleur {

    private final UtilisateurService service;

    public UtilisateurControleur() {
        this.service = new UtilisateurService();
    }

    public void ajouter() {
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur);
        utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utilisateurUI.modifierUtilisateur();
                Utilisateur u = utilisateurUI.getUtilisateur();
                service.ajouter(u);
                utilisateurUI.dispose();
            }
        });
        utilisateurUI.setVisible(true);
    }

    public void modifier(int id) throws Exception {
        try {
            Utilisateur utilisateur = service.trouver(id);
            UtilisateurUI utilisateurUI = new UtilisateurUI(utilisateur);
            utilisateurUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    utilisateurUI.modifierUtilisateur();
                    Utilisateur u = utilisateurUI.getUtilisateur();
                    try {
                        service.modifier(u);
                    } catch (Exception ex) {
                        Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    utilisateurUI.dispose();
                }
            });
            utilisateurUI.setVisible(true);
        } catch (ObjetNonTrouveException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}