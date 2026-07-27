/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa;

import entite.Groupe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import presentation.controleur.GroupeControleur;
import presentation.controleur.UtilisateurControleur;
import presentation.vue.UtilisateurDashboard;
import service.GroupeService;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class Jpa extends JFrame{
    private JButton boutonEnregistrer;
    private JButton boutonUsr;
    private JButton boutonGrp;
    private JButton boutonAnnuler;
    private UtilisateurDashboard userUI;
   
    /**
     * @param args the command line arguments
     */
    public Jpa() throws ObjetNonTrouveException{
        userUI = new UtilisateurDashboard();
    }
    public static void main(String[] args) throws Exception {
        new UtilisateurDashboard();
    }
    
    public JPanel creerPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        
        boutonEnregistrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        boutonAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        boutonUsr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel.add(userUI, BorderLayout.CENTER);
            }
        });
        
        boutonGrp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        return panel;
    }
    
    public JButton getBoutonEnregistrer(){
        return boutonEnregistrer;
    }
    
    public JButton getBoutonAnnuler(){
        return boutonAnnuler;
    }
    
    public JButton getBoutonGrp(){
        return boutonGrp;
    }
    
    public JButton getBoutonUser(){
        return boutonUsr;
    }
}
