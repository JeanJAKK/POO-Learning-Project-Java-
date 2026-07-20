/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Groupe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentation.vue.GroupeUI;
import service.GroupeService;

/**
 *
 * @author jakk
 */
public class GroupeControleur {
    private final GroupeService service;
    
    public GroupeControleur(){
        this.service = new GroupeService();
    }
    
    public void ajouter(){
        Groupe groupe = new Groupe();
        GroupeUI groupeUI = new GroupeUI(groupe);
        
        groupeUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                groupeUI.modifierGroupe();
                Groupe g = groupeUI.getGroupe();
                service.ajouter(g);
                groupeUI.dispose();
            }
        });
    }
    
    public void modifier(){
        Groupe groupe = new Groupe();
        GroupeUI groupeUI = new GroupeUI(groupe);
        
        groupeUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    groupeUI.modifierGroupe();
                    Groupe g = groupeUI.getGroupe();
                    service.bestModifier(g);
                } catch (Exception ex) {
                    Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
                groupeUI.dispose();
            }
        });
    }
    
    public void supprimer(){
        Groupe groupe = new Groupe();
        GroupeUI groupeUI = new GroupeUI(groupe);
        
        groupeUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    groupeUI.modifierGroupe();
                    Groupe g = groupeUI.getGroupe();
                    service.supprimer(g.getId());
                } catch (Exception ex) {
                    Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
                groupeUI.dispose();
            }
        });
    }
    
    public JOptionPane trouver(){
        String grpFinded;
        Groupe groupe = new Groupe();
        GroupeUI groupeUI = new GroupeUI(groupe);
        
        groupeUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    groupeUI.modifierGroupe();
                    Groupe g = groupeUI.getGroupe();
                    grpFinded = service.trouver(g.getId()).toString();
                } catch (Exception ex) {
                    Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return Jo
    }
}
