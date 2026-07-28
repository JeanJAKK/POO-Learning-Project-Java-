/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentation.vue;

import entite.Utilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class AccueilUI extends JFrame{
    private final JButton boutonEnregistrer;
    private final JButton boutonUsr;
    private final JButton boutonGrp;
    private final JButton boutonAnnuler;
    private JButton boutonAjouter;
    private JButton boutonModifier;
    private JButton boutonSupprimer;
    private JButton boutonTrouver;
    private final JPanel panelEst; 
    private final JPanel panelOuest;
   
   
    public AccueilUI() throws ObjetNonTrouveException{
        Utilisateur utilisateur = new Utilisateur();
        new UtilisateurUI(utilisateur);
        boutonEnregistrer = new JButton("Enregistrer");
        boutonAnnuler = new JButton("Annuler");
        boutonUsr = new JButton("Utilisateur");
        boutonGrp = new JButton("Groupe");
        
        // panel pour bouton et formulaire
        panelOuest = creerPanel();
        
        // Panel pour bouton crud et tableau
        panelEst = new JPanel();
        panelEst.setLayout(new BorderLayout());
        panelEst.add(creerBtnCrud(), BorderLayout.SOUTH);
        
        
        // Désactiver les boutons
        boutonAnnuler.setEnabled(false);
        boutonEnregistrer.setEnabled(false);
        boutonAjouter.setEnabled(false);
        boutonModifier.setEnabled(false);
        boutonSupprimer.setEnabled(false);
        boutonTrouver.setEnabled(false);
        
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(panelOuest, BorderLayout.CENTER);
        this.add(panelEst , BorderLayout.EAST);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    private JPanel creerPanel() {
        JPanel p = new JPanel(new BorderLayout());

        JPanel panelNord = new JPanel(new FlowLayout());
        // panel Nord pour bouton utilisateur et groupe
        panelNord.add(boutonUsr);
        panelNord.add(boutonGrp);
        p.add(panelNord, BorderLayout.NORTH);
        
        // panel centre pour formulaire
        JPanel formulaire = new JPanel(new BorderLayout());
        p.add(formulaire, BorderLayout.CENTER);
        
        // panel sud pour bouton Enregistrer et Annuler
        JPanel panelSud = new JPanel(new FlowLayout());
        panelSud.add(boutonEnregistrer);
        panelSud.add(boutonAnnuler);
        p.add(panelSud, BorderLayout.SOUTH);

    return p;
}
    
    public final JPanel creerBtnCrud(){
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipadx = 0;
        gbc.ipady = 5;
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Action sur utilisateur"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        boutonAjouter = new JButton("Ajouter");
        inputPanel.add(boutonAjouter, gbc);
        gbc.gridx = 1;
        boutonTrouver = new JButton("Trouver");
        inputPanel.add(boutonTrouver, gbc);
        gbc.gridx = 2;
        boutonModifier = new JButton("Modifier");
        inputPanel.add(boutonModifier, gbc);
        gbc.gridx = 3;
        boutonSupprimer = new JButton("Supprimer");
        inputPanel.add(boutonSupprimer, gbc);
        
        inputPanel.setBackground(Color.lightGray);
        panel.add(inputPanel, BorderLayout.SOUTH);
        panel.setVisible(true);
        
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
    
    public JPanel getPanelESt(){
        return panelEst;
    }
    
    public JPanel getPanelOuest(){
        return panelOuest;
    }
    
    public JButton getBoutonAjouter(){
        return boutonAjouter;
    }
    
    public JButton getBoutonModifier(){
        return boutonModifier;
    }

    public JButton getBoutonSupprimer(){
        return boutonSupprimer;
    }
    
    public JButton getBoutonTrouver(){
        return boutonTrouver;
    }
    
}
