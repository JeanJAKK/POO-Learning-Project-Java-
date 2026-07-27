/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import presentation.controleur.GroupeControleur;
import presentation.controleur.UtilisateurControleur;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class Jpa extends JFrame{
    /**
     * @param args the command line arguments
     */
    
    public Jpa(){
        this.add(creerPanel(), BorderLayout.CENTER);
        this.setTitle("Gestionnaire d'inscription");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    public static void main(String[] args) throws Exception{
        new Jpa();
    }
    
    private JPanel creerPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JButton btnUser = new JButton("Utilisateur");
        JButton btnGrp = new JButton("Groupe");
        
        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new UtilisateurControleur();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(Jpa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnGrp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new GroupeControleur();
                } catch (ObjetNonTrouveException ex) {
                    Logger.getLogger(Jpa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.ipadx = 5;
        gbc.ipady = 5;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("""
                             Bienvenue dans votre gestionnaire d'inscription...
                             Veuillez choisir l\'entit\u00e9 sur
                             lequel vous voulez travailler
                             """), gbc);
        
        gbc.gridy = 1;
        panel.add(btnUser, gbc);
        gbc.gridy = 2;
        panel.add(btnGrp, gbc);
        
        return panel;
    }
}
