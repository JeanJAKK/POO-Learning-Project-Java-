/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.controleur;

import entite.Groupe;
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
                try {
                    groupeUI.modifierGroupe();
                    Groupe g = groupeUI.getGroupe();
                    service.ajouter(g);
                } catch (ObjetNonTrouveException ex) {
                    JOptionPane.showMessageDialog(groupeUI, ex.getMessage());
                } catch (Exception ex) {
                    Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                    service.modifier(g);
                } catch (ObjetNonTrouveException e) {
                    JOptionPane.showMessageDialog(groupeUI, e.getMessage());
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
                    service.supprimer(g);
                } catch (ObjetNonTrouveException ex) {
                    JOptionPane.showMessageDialog(groupeUI, ex.getMessage());
                } catch (Exception ex) {
                    Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
                groupeUI.dispose();
            }
        });
    }
    
    public void trouver(){
        Groupe groupe = new Groupe();
        GroupeUI groupeUI = new GroupeUI(groupe);
        
        groupeUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String grpFinded;
                try {
                    groupeUI.modifierGroupe();
                    Groupe g = groupeUI.getGroupe();
                    grpFinded = service.trouver(g).toString();
                    
                    if(grpFinded.equals("")){
                        JOptionPane.showMessageDialog(groupeUI, "Aucun groupe trouvé");
                        return;
                    }
                    JOptionPane.showMessageDialog(groupeUI, "Groupe trouvé: " + grpFinded);
                    
                } catch (ObjetNonTrouveException ex) {
                    JOptionPane.showMessageDialog(groupeUI, ex.getMessage());
                } catch (Exception ex) {
                    Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
                groupeUI.dispose();
            }
        });
    }
    
    public void lister(){
        Groupe groupe = new Groupe();
        GroupeUI groupeUI = new GroupeUI(groupe);
        
        groupeUI.getBoutonEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<Groupe> liste;
                try {
                    liste = service.lister();
                    
                    if(liste.isEmpty()){
                        JOptionPane.showMessageDialog(groupeUI, "Aucun groupe trouvé");
                    }
                    
                    String message = "Liste des groupes: \n"; 
                    for(Groupe l : liste){
                        message += l.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(groupeUI, message);
                } catch (Exception ex) {
                    Logger.getLogger(GroupeControleur.class.getName()).log(Level.SEVERE, null, ex);
                }
                groupeUI.dispose();
            }
        });
    }
}
